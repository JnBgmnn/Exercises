public class Sync2 {
	Object lock = new Object();
	int counter = 0;

	class MyThread1 extends Thread{
		public void run() {
			Object myLock = lock;
			for (int i = 0; i < 2; i++) {
				synchronized(myLock) {
					counter++;
					myLock = new Object();
				}
			}
		}
	}

	class MyThread2 extends Thread{
		public void run() {
			synchronized(lock) {
				counter++;
			}
		}
	}

	public void output() {
		System.out.println("counter = " + counter);
	}

	public void execute() throws InterruptedException {
		MyThread1 thread1 = new MyThread1();
		MyThread2 thread2 = new MyThread2();
		 thread2.start();
		thread1.start();
		thread1.join(); thread2.join();
		output();
	}
	
	public static void main(String[] args){
		Sync2 sync = new Sync2();
		for(int i = 0; i < 1000; i++){
			try {
				sync.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

