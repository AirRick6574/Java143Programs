package uncheckedExceptions;


import java.util.NoSuchElementException;

public class PerformanceAnalysisIntro {
	/*
	 * sum(int[] a) returns the sum of the elements in a
	 * 
	 */
	
	//Non-Constant Time
	public static int sum(int[] a) {
		int sum = 0;
		for(int i = 0; i < a.length; i++) {
			sum = sum + a[i];
		}
		return sum;
	}
	
	/*
	 * find(int[] a, int x)
	 * 
	 * find([2,4,6,8], 6) -> 2
	 * find([2,4,6,8], 20) -> -1 (none exists) 
	 */
	
	public static int find(int[] a, int x) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == x) {
				return i;
			}
		}
		return -1;
	}
	
	//Method using for each loop (for each element in loop
	public static int find2(int[] a, int x) {
		for(int i : a) {
			if(i == x) {
				return i;
			}
		}
		return -1;
	}
	
	/*
	 * head(int[] a) returns the first element in the array a
	 * 
	 */
	public static int head(int[] a) {
		if(a.length < 1) {
			throw new NoSuchElementException("Index "
					+ "0 is undefined for an array of size 0");
		}
		return a[0];
	}
	
	/*
	 * containsDuplicates(int[] a) returns true if any element in a
	 * occurs more than once
	 * 
	 * returns false if all elements in a are unique
	 * 
	 * THIS METHOD IS O(n^2) due to get larger every single loop!!!!!!!!!
	 * THIS WILL GROW QUADRATICALLY (VERY BAD, VERY TIME CONSUMING)
	 * this has two a.length making it a.length^2
	 */
	public static boolean containsDuplicates(int[] a) {
		// outer loop that goes through the array element by element
		for(int i = 0; i < a.length; i++) {
			// inner loop that goes through the rest of the array
			// looking for a duplicate of that element
			for(int j = i + 1; j < a.length; j++) {
				if(a[i] == a[j]) {
					return true;
				}
			}
		}
		return false;
		
	}
	
	//Constant Time loop due to being fixed iterations. 
		public static void printTo10() {
			for(int i = 1; i <= 10; i++) {
				System.out.println(i);
			}
		}
	
		
	/*
	 * print1ToN prints the values from 1 TO N each on their own line
	 * 
	 * Non-constant Time
	 */
		public static void print1ToN(int n) {
			for(int i = 1; i <= n; i++) {
				System.out.println(i);
			}
		}
		
		
	
	public static void main(String[] args) {
		/*
		 * test each of the above 3 methods on arrays of sizes
		 * 1000, 2000, 4000, 8000, 16_000 to see what effect
		 * doubling the size of the array has on time
		 */
		for(int size = 1000; size <= 16_000; size = size * 2) {
			// create an array of the current size
			int[] a = new int[size];
			// initialize the array elements to their index
			// index 0 contains 0, index 1 contains 1, ....
			for(int i = 0; i < a.length; i++) {
				a[i] = i;
			}
			// repeat the experiment 1000 times
			int trials = 1000;
			// tracks totalTime of 1000 trials
			long totalTime = 0;
			// repeat "trials" times
			for(int i = 0; i < trials; i++) {
				// get the computer's time before calling the method
				long start = System.nanoTime();
				// run the method
				//head(a);
				//sum(a);
				containsDuplicates(a);
				// get the computer's time after calling the method
				long end = System.nanoTime();
				
				totalTime = totalTime + (end - start);
			}
			double average = (double) totalTime / trials;
			
			System.out.println(size + ": " + average);
		}
	}
}
