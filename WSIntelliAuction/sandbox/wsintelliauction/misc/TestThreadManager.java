package wsintelliauction.misc;

public class TestThreadManager {

	public static void main(String[] args) {

		Runnable r = new Runnable() {

			@Override
			public void run() {
				System.out.println(">>BEFORE DELAY 1<<");

				ThreadManager.pauseThisForSeconds(5);

				System.out.println(">>AFTER DELAY 1<<");
			}
		};
		Runnable r2 = new Runnable() {

			@Override
			public void run() {
				System.out.println(">>BEFORE DELAY 2<<");

				ThreadManager.pauseThisForSecondsIgnoreInterupt(10);

				System.out.println(">>AFTER DELAY 2<<");
			}
		};

		/**
		 * The first runnable should throw an error and not delay, since
		 * it is interrupted.
		 * The second runnable should ignore the interupt and delay for 10 seconds.
		 */
		
		ThreadManager.assignThread(r);
		ThreadManager.assignThread(r2);
		ThreadManager.killThreads(); 
	}

}
