import java.util.LinkedList;

//Iteriert die Zahlen n mit 0 < n < 2^64 und printet alle Primzahlen

public class PrimeNumberChecker {
	
	private LinkedList<Long> primeNumbers;
	
	public PrimeNumberChecker(){
		primeNumbers = new LinkedList<Long>();
	}
	
	private boolean checkIfPrime(long number) {
		for(long prime : primeNumbers){
			if(prime <= number / 2 && number % prime == 0){
				return false;
			}
		}
		return number > 1;
	}
	
	private void start(){
		for(long i = 0; i <= Long.MAX_VALUE; i++){
			if(checkIfPrime(i)){
				primeNumbers.add(i);
				System.out.println(i);
			}
		}
	}

	public static void main(String[] args) {
		PrimeNumberChecker checker = new PrimeNumberChecker();
		checker.start();		
	}
}
