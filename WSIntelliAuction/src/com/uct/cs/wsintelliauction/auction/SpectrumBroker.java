package com.uct.cs.wsintelliauction.auction;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JOptionPane;

import com.uct.cs.wsintelliauction.database.persistent.tables.Lease;
import com.uct.cs.wsintelliauction.database.persistent.tables.Segment;
import com.uct.cs.wsintelliauction.network.message.AuctionClosureMessage;
import com.uct.cs.wsintelliauction.network.message.AuctionMessage;
import com.uct.cs.wsintelliauction.network.message.LeaseMessage;
import com.uct.cs.wsintelliauction.server.backend.ServerResourceContainer;
import com.uct.cs.wsintelliauction.server.backend.network.Client;
import com.uct.cs.wsintelliauction.utility.EventLogger;
import com.uct.cs.wsintelliauction.utility.ThreadHandler;

/**
 * Handles auction management and client bid submissions, as well as final
 * allocation of leases for winning bids using an algorithm which selects the
 * optimal combination maximizing spectrum usage and profit.
 */
public class SpectrumBroker {

	/**
	 * The current auction taking place.
	 */
	private Auction currentAuction;

	/**
	 * Mutex to provide synchronized access.
	 */
	private ReentrantLock auctionGuard;

	/**
	 * Clients connected to server
	 */
	private List<Client> clients;

	/**
	 * Server resource aggregator.
	 */
	private ServerResourceContainer serverResourceContainer;

	/**
	 * Construct the spectrum broker.
	 * @param serverResourceContainer
	 */
	public SpectrumBroker(ServerResourceContainer serverResourceContainer) {
		this.serverResourceContainer = serverResourceContainer;
		this.clients = serverResourceContainer.getClients();
		currentAuction = null;
		auctionGuard = new ReentrantLock(true);
	}

	/**
	 * Return the current auction.
	 * @return Auction
	 */
	public Auction getCurrentAuction() {
		try {
			auctionGuard.lock();
			return currentAuction;
		} finally {
			auctionGuard.unlock();
		}
	}

	/**
	 * Submit a new auction to the spectrum broker.
	 * 
	 * @param newAuction
	 *            Auction to submit.
	 */
	public void submitNewAuction(Auction newAuction) {
		if (currentAuction == null) {
			startNewAuction(newAuction);
		} else {
			int choice = JOptionPane
					.showConfirmDialog(
							null,
							"Initiating a new auction will cancel the current auction.\n Are you sure you want to continue?",
							"Warning", JOptionPane.YES_NO_OPTION,
							JOptionPane.WARNING_MESSAGE);
			if (choice == JOptionPane.YES_OPTION) {
				cancelCurrentAuction();
				startNewAuction(newAuction);
			}
		}
	}

	/**
	 * Begin a new auction.
	 * 
	 * @param newAuction
	 *            Auction to begin.
	 */
	private void startNewAuction(Auction newAuction) {
		try {
			auctionGuard.lock();
			this.currentAuction = newAuction;
			newAuction.startAuction();
			informClientsOfAuction();
			startTheClock();
		} finally {
			auctionGuard.unlock();
		}
	}

	/**
	 * Begin the clock which periodically checks for end-of-auction time.
	 */
	private void startTheClock() {
		Runnable clockWatch = new Runnable() {
			@Override
			public void run() {
				checkTimeLoop();
			}
		};
		ThreadHandler.assignThread(clockWatch);
	}

	/**
	 * Informs all clients that auction has started.
	 */
	private void informClientsOfAuction() {
		AuctionMessage m = currentAuction.getAuctionMessage();
		for (Client c : clients) {
			EventLogger.log("Announcing auction to client: "
					+ c.getConnection().getRecipientAddress().getHostName());
			c.getConnection().enqueueMessage(m);
		}
	}

	/**
	 * Informs all clients that auction has closed.
	 */
	private void informClientsOfAuctionClosure() {
		AuctionClosureMessage m = currentAuction.getClosureMessage();
		for (Client c : clients) {
			EventLogger.log("Announcing auction closure to client: "
					+ c.getConnection().getRecipientAddress().getHostName());
			c.getConnection().enqueueMessage(m);
		}
	}

	private void checkTimeLoop() {
		Date endTime = currentAuction.getAuctionEndTime();

		while (currentAuction.getAuctionOn().get()) {
			ThreadHandler.pauseThisForSeconds(5);

			if (Calendar.getInstance().getTime().after(endTime)) {
				EventLogger.log("Auction is over");
				JOptionPane.showMessageDialog(null,
						"The auction has now finished."

						, "Auction Closed", JOptionPane.INFORMATION_MESSAGE);
				currentAuction.concludeAuction();
				informClientsOfAuctionClosure();
				calculateBidWinners(currentAuction);
			}
		}
	}

	/**
	 * Cancel the current auction.
	 */
	private void cancelCurrentAuction() {
		try {
			auctionGuard.lock();
			if (currentAuction != null)
				currentAuction.getAuctionOn().set(false);
		} finally {
			auctionGuard.unlock();
		}
	}

	/**
	 * Shut down the spectrum broker.
	 */
	public void close() {
		cancelCurrentAuction();
	}

	// Auction optimization code ------------------------

	public void calculateBidWinners(Auction auction) {

		List<Segment> segments = auction.getAvailableSegments();
		List<Bid> bids = auction.getSubmittedBids();

		segmentListContainer = new SegmentListContainer();

		// initialize the segment lists
		for (Segment segment : segments) {
			segmentListContainer.addSegmentList(new SegmentList(segment
					.getSegmentSize()));
		}

		segmentListContainer.sort();

		// add the bids to the correct list
		for (Bid b : bids) {
			segmentListContainer.insertBid(b);
		}

		// sort the bid lists
		for (SegmentList sl : segmentListContainer.segmentLists) {
			sl.sort();
		}

		int currentList = 0;
		highestProfit = 0;

		branchAndCut(currentList, auction.getLocation().getAvailableSpectrum(),
				0.0);

		assignLeases();

	}

	private void assignLeases() {
		ArrayList<Lease> leases = new ArrayList<Lease>();
		ArrayList<Bid> winningBids = new ArrayList<Bid>();

		// aggregate winning bids
		for (SegmentList list : segmentListContainer.getSegmentLists()) {
			for (int i = 0; i < list.getOptimalNumberOfBids(); i++) {
				winningBids.add(list.get(i));
			}
		}

		// shuffle the winning bids randomly, for purpose of fair final spectrum
		// channel allocation.
		Collections.shuffle(winningBids);

		int lowerBound = currentAuction.getLocation().getLowerBound();

		for (Bid b : winningBids) {
			Lease l = new Lease();
			l.setLeaseStartDate(currentAuction.getLeaseStartDate());
			l.setLeaseEndDate(currentAuction.getLeaseExpireDate());
			l.setLocation(currentAuction.getLocation());
			l.setLowerBound(lowerBound);
			l.setUpperBound(lowerBound + b.getSegment().getSegmentSize());
			l.setSecondaryUserID(b.getClientAddress().getHostAddress());
			l.setSegment(b.getSegment());
			lowerBound += b.getSegment().getSegmentSize();
			serverResourceContainer.getDatabaseDriver().saveOrUpdate(l);
			LeaseMessage message = new LeaseMessage(l);
			for (Client c : clients) {
				if (c.getConnection().getRecipientAddress()
						.equals(b.getClientAddress()))
					c.getConnection().enqueueMessage(message);
			}
		}

	}

	/**
	 * For purpose of branch-and-cut algorithm.
	 */
	private SegmentListContainer segmentListContainer;

	/**
	 * Highest profit yet obtained from branch-and-cut.
	 */
	private double highestProfit;

	/**
	 * Branch-and-cut algorithm.
	 * 
	 * @param currentList
	 *            Nth highest segment-size list.
	 * @param remainingSpectrum
	 *            Spectrum remaining for this combination.
	 * @param totalProfit
	 *            Total profit summation for this combination.
	 * @return True if this 'path' through the tree to the leaves (combination)
	 *         improved the max profit.
	 */
	private boolean branchAndCut(int currentList, double remainingSpectrum,
			double totalProfit) {
		// the segment which represents this level
		SegmentList list = segmentListContainer.get(currentList);

		// maximum number of bids allowable for this segment (total segment
		// spectrum summation can't exceed total auction spectrum
		int maxBids = (int) ((remainingSpectrum) / list.getSegmentWidth());

		// maximum number of bids obviously can't be more than the actual
		// number of bids received
		maxBids = maxBids > list.numberOfBids() ? list.numberOfBids() : maxBids;

		// if this particular combination yielded an improved total earning
		boolean hadImprovement = false;

		/*
		 * For each top 1, top 2, ...top N bid winners for this segment, where
		 * the total sum of the bid segments don't exceed the total spectrum
		 * allocation:
		 */
		for (int i = 0; i <= maxBids; i++) {
			// determine the profit which this combination of bids would produce
			double profitAdd = list.sumProfitForTop(i);
			// if not a leaf
			if (currentList < segmentListContainer.size() - 1) {
				/*
				 * Call this method again, modifying parameters are required:
				 * Subtract from the remaining spectrum how much these N
				 * segments would occupy. Increment current list (to next
				 * smallest segment) Add the profit gain of this selection to
				 * the total profit
				 */
				boolean improved = branchAndCut(currentList + 1,
						remainingSpectrum - (i * list.segmentWidth), profitAdd
								+ totalProfit);
				// if this particular combination yielded an improvement
				if (improved) {
					// set this segments optimal bid selection (the top N which
					// produced the improvement)
					list.setOptimalNumberOfBids(i);
					hadImprovement = true;
				}
			}
			// if a leaf
			else {
				/*
				 * If this selection yields a superior profit.
				 */
				if (profitAdd + totalProfit > highestProfit) {
					highestProfit = profitAdd + totalProfit;
					list.setOptimalNumberOfBids(i);
					return true;
				} else {
					return false;
				}
			}

		}
		return hadImprovement;
	}

	/**
	 * 
	 * Contains list of segment lists.
	 * 
	 */
	private class SegmentListContainer {

		private ArrayList<SegmentList> segmentLists;

		public SegmentListContainer() {
			segmentLists = new ArrayList<SegmentList>();
		}

		public void insertBid(Bid b) {
			for (SegmentList list : segmentLists) {
				if (list.getSegmentWidth() == b.getSegment().getSegmentSize()) {
					list.add(b);
				}
			}
		}

		public void addSegmentList(SegmentList l) {
			segmentLists.add(l);
		}

		/**
		 * Sort the lists in order of segment size, descending.
		 */
		public void sort() {
			for (int i = 0; i < segmentLists.size() - 1; i++) {
				for (int j = i + 1; j < segmentLists.size(); j++) {
					if (segmentLists.get(i).getSegmentWidth() < segmentLists
							.get(j).getSegmentWidth()) {
						SegmentList temp = segmentLists.get(i);
						segmentLists.set(i, segmentLists.get(j));
						segmentLists.set(j, temp);
					}
				}
			}

		}

		public SegmentList get(int i) {
			if (i < segmentLists.size()) {
				return segmentLists.get(i);
			} else {
				return null;
			}
		}

		public int size() {
			return segmentLists.size();
		}

		public ArrayList<SegmentList> getSegmentLists() {
			return segmentLists;
		}

	}

	/**
	 * 
	 * Sorted list of bids for a particular segment.
	 * 
	 */
	private class SegmentList {

		private ArrayList<Bid> segmentList;

		private double segmentWidth;

		private int optimalNumberOfBids;

		public SegmentList(double segmentWidth) {
			segmentList = new ArrayList<Bid>();
			this.segmentWidth = segmentWidth;
			this.optimalNumberOfBids = 0;
		}

		public double sumProfitForTop(int n) {
			double sum = 0.0;
			for (int i = 0; i < n; i++) {
				sum += segmentList.get(i).getBidAmount();
			}
			return sum;
		}

		public void add(Bid b) {
			segmentList.add(b);
		}

		public double getSegmentWidth() {
			return segmentWidth;
		}

		/**
		 * Sort the bids in order of segment size, descending.
		 */
		public void sort() {
			for (int i = 0; i < segmentList.size() - 1; i++) {
				for (int j = i + 1; j < segmentList.size(); j++) {
					if (segmentList.get(i).getBidAmount() < segmentList.get(j)
							.getBidAmount()) {
						Bid temp = segmentList.get(i);
						segmentList.set(i, segmentList.get(j));
						segmentList.set(j, temp);
					}
				}
			}
		}

		public int numberOfBids() {
			return segmentList.size();
		}

		public void setOptimalNumberOfBids(int optimalNumberOfBids) {
			this.optimalNumberOfBids = optimalNumberOfBids;
		}

		public int getOptimalNumberOfBids() {
			return optimalNumberOfBids;
		}

		public Bid get(int i) {
			return segmentList.get(i);
		}

	}

}
