package wsintelliauction.misc;

import java.util.concurrent.Callable;

import com.uct.cs.wsintelliauction.util.ThreadHandler;


public class TestThreadManager {

	public static void main(String[] args) {

		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println(">>BEFORE DELAY 1<<");

				ThreadHandler.pauseThisForSeconds(5);

				System.out.println(">>AFTER DELAY 1<<");
			}
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				System.out.println(">>BEFORE DELAY 2<<");

				ThreadHandler.pauseThisForSecondsIgnoreInterupt(10);

				System.out.println(">>AFTER DELAY 2<<");
			}
		};
		

		/**
		 * The first runnable should throw an error and not delay, since
		 * it is interrupted.
		 * The second runnable should ignore the interupt and delay for 10 seconds.
		 */
		
		ThreadHandler.assignThread(r);
		ThreadHandler.assignThread(r2);
		ThreadHandler.killThreads(); 
	}

}
