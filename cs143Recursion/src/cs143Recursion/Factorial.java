package cs143Recursion;

public class Factorial {
	public static void main(String[] args) {
		System.out.println(fact(5));
		System.out.println(fact(10));
	}
	
	/*
	 * fact(int n) computes n! recursively 
	 * 
	 * Base Case: 1! - 1
	 * Recursice case: n! = n * (n-1)!
	 */
	public static int fact(int n) {
		if (n == 1) {
			return 1;
		}
		else {
			//for n > , apply the recursive defination: n! = n * (n-1)
			return n * fact(n-1);
		}
	}
}
