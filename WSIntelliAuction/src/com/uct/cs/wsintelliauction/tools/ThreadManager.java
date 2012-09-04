package com.uct.cs.wsintelliauction.tools;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ThreadManager {

	public static final int THREAD_POOL_SIZE = 32;
	private static final long SHUTDOWN_TIMEOUT_SECONDS = 8;
	public static ExecutorService universalThreadPool;

	static {
		universalThreadPool = Executors.newFixedThreadPool(THREAD_POOL_SIZE);	
	}

	public static void submitTask(Runnable r) {
		universalThreadPool.submit(r);
	}

	public static <E> Future<E> submitTask(Callable<E> r) {
		return universalThreadPool.submit(r);
	}
	
	public static void closeThreads(){
		universalThreadPool.shutdown();
		try {
			universalThreadPool.awaitTermination(SHUTDOWN_TIMEOUT_SECONDS, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			ErrorLogger.submitError(e.getMessage());
		}
	}

}
