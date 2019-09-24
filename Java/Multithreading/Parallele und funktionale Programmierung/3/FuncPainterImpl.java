import java.util.Random;

public class FuncPainterImpl implements FuncPainter {
	
	private static Screen screen;
	private static Function func;
	
	/**
	 * Helper method for setting the value of the screen.
	 *
	 * @param screen
	 *    The screen
	 * @param func
	 *    The function to evaluate
	 * @param x
	 *    x component of the point to color (in range [ 0; screen.getWidth() ))
	 * @param y
	 *    y component of the point to color (in range [ 0; screen.getHeight() ))
	 */
	private void setValue(Screen screen, Function func, int x, int y) {
		screen.setValue(x, y, func.evaluate(x, y));
	}

	public void randomPaint(Screen screen, Function func, int nThreads) {
		FuncPainterImpl.screen = screen;
		FuncPainterImpl.func = func;
		Thread[] threads = new Thread[nThreads];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(new RandomPaintRunner());
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

	public void synchronizedPaint(Screen screen, Function func, int nThreads) {
		FuncPainterImpl.screen = screen;
		FuncPainterImpl.func = func;
		Thread[] threads = new Thread[nThreads];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(new SynchronizedPaintRunner());
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

	public void syncFreePaint(Screen screen, Function func, final int nThreads) {
		FuncPainterImpl.screen = screen;
		FuncPainterImpl.func = func;
		Thread[] threads = new Thread[nThreads];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(new SyncFreePaintRunner(i, nThreads));
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
	
	class RandomPaintRunner implements Runnable{

		@Override
		public void run() {
			Random rng = new Random();
			while(!screen.finished()){
				int x = rng.nextInt(screen.getWidth());
				int y = rng.nextInt(screen.getHeight());
				if(!screen.hasValue(x, y)){
					setValue(screen, func, x, y);
				}
			}
		}		
	}
	
	class SynchronizedPaintRunner implements Runnable{
		
		@Override
		public void run() {	
			Random rng = new Random();
			while(!screen.finished()){				
				int x = rng.nextInt(screen.getWidth());
				int y = rng.nextInt(screen.getHeight());
				synchronized(SynchronizedPaintRunner.class){
					if(!screen.hasValue(x, y)){
						setValue(screen, func, x, y);
					}
				}
			}
		}	
	}
	
	class SyncFreePaintRunner implements Runnable{
	
		private int id;
		private int nThreads;
	
		public SyncFreePaintRunner(int id, int nThreads){
			this.id = id;
			this.nThreads = nThreads;
		}
		
		@Override
		public void run() {	
			for(int i = id; i < screen.getWidth(); i += nThreads){
				for(int j = 0; j < screen.getHeight(); j++){
					setValue(screen, func, i, j);
				}
			}
		}	
	}

	public static void main(String[] args) {
		FuncPainter p = new FuncPainterImpl();
		int width = 70;
		int height = 70;

		Screen randomScreen = new PainterScreen(width, height);
		Screen synchronizedScreen = new PainterScreen(width, height);
		Screen syncFreeScreen = new PainterScreen(width, height);
		p.randomPaint(randomScreen, new ExampleFunction(), 4);
		p.synchronizedPaint(synchronizedScreen, new ExampleFunction(), 4);
		p.syncFreePaint(syncFreeScreen, new ExampleFunction(), 4);
	}
}

