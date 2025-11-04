package cs143Recursion;

public class RecursivePrinting {
	public static void main(String[] args) {
		printNTo0(5);
		
		System.out.println();
		
		printNTo0R(5);
	}
	
	/*
	 * printNTo0 prints the numbers from n down to 0
	 * each on their own line
	 * 
	 * 5
	 * 4
	 * 3
	 * 2
	 * 1
	 * 0
	 */
	
	public static void printNTo0(int n) {
		for (int i = n; i > 0; i--) {
			System.out.println(i);
		}
	}
	
	/*
	 * Recursive Version
	 * 
	 */
	
	public static void printNTo0R(int n) {
		//Step 0: stop if n becomes negative
		if (n < 0) {
			return;
		}
		
		//Step 1: print out N
		System.out.println(n);
		
		//Step 2: repeat step 1 on the next number 
		printNTo0R(n-1);
	}
}
