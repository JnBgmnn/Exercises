public class Sync1 {
	int x = 0; int y = 0;

	class MyThread1 extends Thread{
		public void run() {
			x = 1;
			System.out.println("y = "+y);
		}
	}
	
	class MyThread2 extends Thread{
		public void run() {
			y = 1;
			System.out.println("x = "+x);
		}
	}

	public void execute() throws InterruptedException {
		MyThread1 thread1 = new MyThread1();
		MyThread2 thread2 = new MyThread2();
		thread1.start(); thread2.start();
		thread1.join(); thread2.join();
	}
	
	public static void main(String[] args){
		Sync1 sync = new Sync1();
		for(int i = 0; i < 1000; i++){
			try {
				sync.execute();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

