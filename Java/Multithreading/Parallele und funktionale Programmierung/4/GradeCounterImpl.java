import java.util.concurrent.ConcurrentHashMap;

public class GradeCounterImpl implements GradeCounter{
	
	private static String[] grades;
	private static int nThreads;
	private static ConcurrentHashMap<String, Integer> map;

	@Override
	public GradeCount[] count(String[] grades, int nThreads) {
		GradeCounterImpl.grades = grades;
		GradeCounterImpl.nThreads = nThreads;
		GradeCounterImpl.map = new ConcurrentHashMap<>();
		Thread[] threads = new Thread[nThreads];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(new GradeCounterRunner(i));
			threads[i].start();
		}
		for(int i = 0; i < threads.length; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		GradeCount[] result = new GradeCount[map.size()];
		int iterator = 0;
		for(String key : map.keySet()){
			result[iterator++] = new GradeCount(key, map.get(key));
		}
		return result;
	}
	
	static class GradeCounterRunner implements Runnable{
		
		private int id;
		
		public GradeCounterRunner(int id){
			this.id = id;
		}

		@Override
		public void run() {
			for(int i = id; i < grades.length; i += nThreads){
//				map.putIfAbsent(grades[i], new AtomicInteger(map.getOrDefault(grades[i], new AtomicInteger(0)).incrementAndGet()));
				map.compute(grades[i], (k, v) -> v == null ? 1 : v + 1);
			}			
		}		
	}
}
