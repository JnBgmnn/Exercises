import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SingerExecutor {
	
	public static void main(String[] args){
		int threadNummer = Integer.parseInt(args[0]);
		ExecutorService e = Executors.newFixedThreadPool(threadNummer);
		for(int i = 0; i < threadNummer; i++){
			e.execute(new SingerExecutorExecutor(i));
		}
		e.shutdown();
		try {
			e.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
	}
	
	public static class SingerExecutorExecutor implements Runnable{

		private int id;
		
		public SingerExecutorExecutor(int id){
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
