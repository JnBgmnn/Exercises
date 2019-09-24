import java.util.LinkedList;

//Iteriert die Zahlen n mit 0 < n < 2^64 und printet alle Primzahlen

public class PrimNumberChecker {
	
	private LinkedList<Long> primNumbers;
	
	public PrimNumberChecker(){
		primNumbers = new LinkedList<Long>();
	}
	
	private boolean checkIfPrim(long number) {
		for(long prim : primNumbers){
			if(prim <= number / 2 && number % prim == 0){
				return false;
			}
		}
		return number > 1;
	}
	
	private void start(){
		for(long i = 0; i <= Long.MAX_VALUE; i++){
			if(checkIfPrim(i)){
				primNumbers.add(i);
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		PrimNumberChecker checker = new PrimNumberChecker();
		checker.start();		
	}
}
