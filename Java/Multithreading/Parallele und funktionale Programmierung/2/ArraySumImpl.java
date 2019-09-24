import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class ArraySumImpl implements ArraySum {

	@Override
	public long sum(long[] array, int threads) {
		ExecutorService e = Executors.newFixedThreadPool(threads);
		Future<Long>[] futures = new Future[threads];
		for(int i = 0; i < threads; i++){
			futures[i] = e.submit(new ArraySumImplCallable(i, threads, array));
		}
		e.shutdown();
		try {
			e.awaitTermination(5000, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		long result = 0;
		for(int i = 0; i < futures.length; i++){
			try {
				result += futures[i].get();
			} catch (InterruptedException | ExecutionException e1) {
				e1.printStackTrace();
			}
		}
		return result;
	}

	public static class ArraySumImplCallable implements Callable<Long>{
		
		private int id;
		private int threads;
		private long[] array;
		
		public ArraySumImplCallable(int id, int threads, long[] array){
			this.id = id;
			this.threads = threads;
			this.array = array;
		}

		@Override
		public Long call() throws Exception {
			long sum = 0;
			for(int i = id; i < array.length; i += threads){
				sum += array[i];
			}
			return sum;
		}
	}
}
