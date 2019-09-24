
public class SingerThread {

	public static void main(String[] args) {
		int threadNummer = Integer.parseInt(args[0]);
		Thread[] threads = new Thread[threadNummer];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new SingerThreadThread(i);
			threads[i].start();
		}
		for(int i = 0; i < threads.length; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static class SingerThreadThread extends Thread{
		
		private int id;
		
		public SingerThreadThread(int id){
			this.id = id;
		}
		
		@Override
		public void run() {
			switch(id){
			case 0:
				System.out.println("No more bottles of beer on the wall, no more bottles of beer. Go to the store and buy some more, 99 bottles of beer on the wall.");
				break;
			case 1:
				System.out.println("1 bottle of beer on the wall, 1 bottle of beer. Take one down and pass it around, no more bottles of beer on the wall.");
				break;
			default:
				String message = String.format("%d bottles of beer on the wall, %d bottles of beer. Take one down and pass it around, %d bottles of beer on the wall"
						, id, id, id - 1);
				System.out.println(message);
				break;
			}
		}
	}
}
