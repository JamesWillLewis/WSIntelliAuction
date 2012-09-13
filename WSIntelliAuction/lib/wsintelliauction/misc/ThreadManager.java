package wsintelliauction.misc;

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
	public static final int THREAD_POOL_SIZE = 32;
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

}
