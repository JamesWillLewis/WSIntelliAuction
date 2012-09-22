package com.uct.cs.wsintelliauction.net;

import java.io.Serializable;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Represents a recipient of messages in the network communication link, i.e.
 * the destination for a message sent from the initialiser of this object, which
 * is the source for all messages sent. If the initialiser sends a message, this
 * recipient object defines the destination for that message, where the host is
 * the source.
 * 
 * @author James Lewis
 * @see InetAddress
 */
public class Recipient implements Serializable {

	/**
	 * Serial key
	 */
	private static final long serialVersionUID = 4168758408299185596L;
	/**
	 * Host name of the recipient
	 */
	private String hostName;
	/**
	 * Textual representation of the IP address of this recppient
	 */
	private String ipAddressString;
	/**
	 * Raw IP address of this recipient (array of signed bytes)
	 */
	private byte[] ipAddressRaw;
	/**
	 * Port number to which packets are sent to the recipient
	 */
	private int portNumber;
	/**
	 * Used for resolving DNS requests (mapping IP address -> hostname and vica
	 * versa)
	 */
	private InetAddress inetAddress;

	/**
	 * Constructs a new recipient given the host address and port number. Host
	 * address can be either the host name (i.e. "nightmare.cs.uct.ac.za") or
	 * textual representation of an IP address (i.e. "137.158.59.46").
	 * 
	 * @param hostAddress
	 *            Host name or IP address.
	 * @param portNumber
	 *            Port number.
	 * @throws UnknownHostException
	 *             If unable to locate the host.
	 */
	public Recipient(String hostAddress, int portNumber)
			throws UnknownHostException {
		this.portNumber = portNumber;
		this.inetAddress = InetAddress.getByName(hostAddress);
		this.hostName = inetAddress.getHostName();
		this.ipAddressString = inetAddress.getHostAddress();
		this.ipAddressRaw = inetAddress.getAddress();
	}

	/**
	 * Constructs a new recipient given the host IP address and port number.
	 * Host IP address must be a raw address as an array of bytes (signed).
	 * 
	 * @param hostAddress
	 *            Raw IP address.
	 * @param portNumber
	 *            Port number.
	 * @throws UnknownHostException
	 *             If unable to locate the host.
	 */
	public Recipient(byte[] ipAddress, int portNumber)
			throws UnknownHostException {
		this.portNumber = portNumber;
		this.inetAddress = InetAddress.getByAddress(ipAddress);
		this.hostName = inetAddress.getHostName();
		this.ipAddressString = inetAddress.getHostAddress();
		this.ipAddressRaw = inetAddress.getAddress();
	}

	/**
	 * @return Host name.
	 */
	public String getHostName() {
		return hostName;
	}

	/**
	 * @return IP address as a string.
	 */
	public String getIPAddressString() {
		return ipAddressString;
	}

	/**
	 * @return IP address as an array of signed bytes.
	 */
	public byte[] getIPAddressRaw() {
		return ipAddressRaw;
	}

	/**
	 * @return Port number.
	 */
	public int getPortNumber() {
		return portNumber;
	}

	/**
	 * @return InetAddress object for the host address.
	 */
	public InetAddress getInetAddress() {
		return inetAddress;
	}

}
