import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

//Printet alle aktuell geöffneten Ports

public class PortScanner {
	
	private final static int PORTS = 65535;
	private final static int THREAD_NUMBER = 5;
	
	private static void runThreads(){
		Thread[] threads = new Thread[THREAD_NUMBER];
		for(int i = 0; i < threads.length; i++){
			threads[i] = new Thread(new ThreadRunner(i));
			threads[i].start();
		}
		for(int i = 0; i < threads.length; i++){
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("All ports scanned");
	}

	public static void main(String[] args){
		runThreads();
	}
	
	private static class ThreadRunner implements Runnable{
		
		private int id;
		
		private ThreadRunner(int id){
			this.id = id;
		}

		@Override
		public void run() {
			for(int i = id; i <= PORTS; i += THREAD_NUMBER){
				Socket socket = new Socket();
				InetSocketAddress localHost = null;
				try {
					localHost = new InetSocketAddress(InetAddress.getLocalHost(), i);
				} catch (UnknownHostException e) {
					e.printStackTrace();
				}
				try {
					socket.connect(localHost, 2000);
					String message = String.format("Port %s is open", i);				
					System.out.println(message);
					
				} catch (IOException e) {
					
				}finally{
					try {
						socket.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}	
	}
}
