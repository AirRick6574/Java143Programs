package cs143Recursion;

public class Fibonacci {
	public static void main(String[] args) {
		System.out.println(fib(0));
		System.out.println("Log = " + log);
		//System.out.println(fib(1));
		
		System.out.println(fib(10));
		System.out.println("Log = " + log);
		
		System.out.println(fib(15));
		System.out.println("Log = " + log);
		//System.out.println(fib(100));
	}
	
	
	//Log the number of recursive calls needed to compute 
	//A fibonacci number
	private static int log = 0;
	
	
	/*
	 * fib (int n) computes the nth term of the fibonacci sequence
	 * recursively 
	 * 
	 * fib(0) = fib(1) = 1
	 * fib(a) = fib(n - 1) = fib(n - 2) for n >= 2
	 * 
	 * THIS PROGRAM IS O(2^N)
	 */
	public static long fib(int n) {
		log++;
		//base case: first two numbers are always 1
		if(n == 0 || n == 1) {
			return 1;
		}
		
		//recursive case: the nth term is the sum of
		//n-1 and n-2 terms
		else {
			return fib(n - 1) + fib(n - 2);
		}
		
		
	}
	
	private static long[] fibA = new long[1000];
	
	//Faster O(N) approach
	public static long fibFast(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		//second base case: if we have already calculated the nth Term,
		//We will just grab it from the array 
		//This will significantly make program faster
		else if(fibA[n] > 0) {
			return fibA[n];
		}
		else {
			//calculate the fibonacci number, store it
			// in the array for future access 
			fibA[n] = fib(n - 1) + fib(n - 2);
			return fibA[n];
		}
		
		
		
	}
}
