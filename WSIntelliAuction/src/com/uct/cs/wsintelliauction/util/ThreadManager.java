package com.uct.cs.wsintelliauction.util;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * Global thread manager and allocater. Thread pool is initialized prior to
 * execution of other applications. Thread assignment and other functions are
 * all statically accessed. This class cannot be constructed or inherited.
 * 
 * @author James Lewis
 * 
 */
public final class ThreadManager {

	/**
	 * Number of worker threads in the thread pool.
	 */
	public static final int THREAD_POOL_SIZE = 128;
	/**
	 * Maximum shutdown time allowed for global thread shutdown.
	 */
	private static final long SHUTDOWN_TIMEOUT_SECONDS = 8;
	/**
	 * Thread pool consisting of worker threads allocated for all concurrent
	 * tasks.
	 */
	private static final ExecutorService universalThreadPool;

	/**
	 * Number of milliseconds per second.
	 */
	public static final long MILLIS_PER_SECONDS = 1000;

	/**
	 * Prevent construction of this class.
	 */
	private ThreadManager() {
	}

	/**
	 * Static constructor. Initializes thread pool prior to execution of
	 * specified application. Guarenteed HAPPENS-BEFORE relationship with
	 * respect to any other methods being invoked.
	 */
	static {
		universalThreadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
	}

	/**
	 * Assign a runnable a worker thread from the thread pool.
	 * 
	 * @param r
	 *            Runnable instance
	 */
	public static void assignThread(Runnable r) {
		universalThreadPool.submit(r);
	}

	/**
	 * Assign a callable a worker thread from the thread pool. Returns a future
	 * object, allow for access to a result after completion.
	 * 
	 * @param r
	 *            Callable instance.
	 * @return Future result.
	 */
	public static <E> Future<E> assignThread(Callable<E> r) {
		return universalThreadPool.submit(r);
	}

	/**
	 * Begin orderly shutdown of all threads in the thread pool. Will block for
	 * a specified time period waiting for all previously submitted tasks to
	 * complete.
	 * 
	 * @return Boolean True if able to shutdown threads, false if failed.
	 */
	public static boolean closeThreads() {
		universalThreadPool.shutdown();
		try {
			universalThreadPool.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS,
					TimeUnit.SECONDS);
			return true;
		} catch (InterruptedException e) {
			ErrorLogger.log(e.getMessage());
		}
		return false;
	}

	/**
	 * Begin immediate shutdown of all threads in thread pool. Will block for a
	 * specified time period waiting for all previously submitted tasks to
	 * complete. If a thread is blocked and does not respond to an interrupt, it
	 * may not be possible to terminate.
	 * 
	 * @return Boolean True if able to shutdown threads, false if failed.
	 */
	public static boolean killThreads() {
		universalThreadPool.shutdownNow();
		try {
			universalThreadPool.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS,
					TimeUnit.SECONDS);
			return true;
		} catch (InterruptedException e) {
			ErrorLogger.log(e.getMessage());
		}
		return false;
	}

	/**
	 * Pauses the thread which calls this method for a certain length of time.
	 * The pause may be interrupted if another thread calls an interrupt on the
	 * thread being paused.
	 * 
	 * @param milliseconds
	 *            Length of time in MILLISECONDS to pause.
	 * @return True if the pause was successful, false if interrupted.
	 */
	public static boolean pauseThisForMillis(long milliseconds) {
		try {
			Thread.sleep(milliseconds);
			return true;
		} catch (InterruptedException e) {
			ErrorLogger.log("Thread " + Thread.currentThread().toString()
					+ " failed to sleep for " + milliseconds
					+ " milliseconds because of an interruption.");
			return false;
		}
	}

	/**
	 * Pauses the thread which calls this method for a certain length of time.
	 * The pause may be interrupted if another thread calls an interrupt on the
	 * thread being paused.
	 * 
	 * @param seconds
	 *            Length of time in SECONDS to pause.
	 * @return True if the pause was successful, false if interrupted.
	 */
	public static boolean pauseThisForSeconds(int seconds) {
		return pauseThisForMillis(seconds * MILLIS_PER_SECONDS);
	}

	/**
	 * Pauses the thread which calls this method for a certain length of time.
	 * The pause may be interrupted if another thread calls an interrupt on the
	 * thread being paused.
	 * 
	 * @param seconds
	 *            Length of time in SECONDS to pause.
	 * @param millis
	 *            Additional milliseconds to pause.
	 * @return True if the pause was successful, false if interrupted.
	 */
	public static boolean pauseThisForSecondsAndMillis(int seconds, long millis) {
		return pauseThisForMillis((seconds * MILLIS_PER_SECONDS) + millis);
	}

	/**
	 * Pauses the thread which calls this method for a certain length of time.
	 * The pause ignores all interrupts. This method guarantees that the delay
	 * time will not be interrupted, and will delay >= delay time specified.
	 * 
	 * @param millis
	 *            Length of time in MILLISECONDS to pause.
	 */
	public static void pauseThisForMillisIgnoreInterupt(long millis) {
		long start = System.currentTimeMillis();
		long delayedTotal = 0;
		while (delayedTotal < millis) {
			try {
				Thread.sleep(millis - delayedTotal);
			} catch (InterruptedException e) {
				// ignore interupt
			} finally {
				delayedTotal = System.currentTimeMillis() - start;
			}
		}
	}

	/**
	 * Pauses the thread which calls this method for a certain length of time.
	 * The pause ignores all interrupts. This method guarantees that the delay
	 * time will not be interrupted, and will delay >= delay time specified.
	 * 
	 * @param seconds
	 *            Length of time in SECONDS to pause.
	 */
	public static void pauseThisForSecondsIgnoreInterupt(int seconds) {
		pauseThisForMillisIgnoreInterupt(seconds * MILLIS_PER_SECONDS);
	}

	/**
	 * Pauses the thread which calls this method for a certain length of time.
	 * The pause ignores all interrupts. This method guarantees that the delay
	 * time will not be interrupted, and will delay >= delay time specified.
	 * 
	 * @param seconds
	 *            Length of time in SECONDS to pause.
	 * @param millis
	 *            Additional milliseconds to pause.
	 */
	public static void pauseThisForSecondsAndMillisIgnoreInterupt(int seconds,
			long millis) {
		pauseThisForMillisIgnoreInterupt((seconds * MILLIS_PER_SECONDS)
				+ millis);
	}
	

}
