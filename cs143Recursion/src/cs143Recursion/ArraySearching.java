package cs143Recursion;

import java.util.Arrays;

public class ArraySearching {
	/*
	 * find(int[] a, int x) returns the index of x in the array a
	 * 
	 * if x does not occur in a, return -1
	 * 
	 * Assume that the array will always be sorted
	 * 
	 * Old loop version of linear search
	 * O(N)
	 */
//	public static int find(int[] a, int x) {
//		for(int i = 0; i < a.length; i++) {
//			// does index i contain x
//			if(a[i] == x) {
//				return i;
//			}
//			// does index i contain a value
//			// greater than x?
//			if(a[i] > x) {
//				// x can't occur after values
//				// that are greater than it
//				return -1;
//			}
//		}
//		return -1;
//	}
	
	/*
	 * New recursive version of linear search
	 * 
	 * Assume that the array will always be sorted
	 * 
	 * O(N)
	 */
	public static int find(int[] a, int x) {
		return find(a, x, 0);
	}
	
	// helper method that has an extra parameter
	// which tracks which array index this recursive
	// call is responsible for
	// a: {-8, -3, 5, 6, 10, 12}
	// find(a, x, 1}
	private static int find(int[] a, int x, int i) {
		// case 0: check for out of bounds i
		if(i >= a.length) {
			return -1;
		}
		// case 1: index i contains x
		else if(a[i] == x) {
			// we found it!
			return i;
		}
		// case 2: index i contains a value greater
		// than x, x does not exist
		else if(a[i] > x) {
			// x can't occur after values
			// that are greater than it
			return -1;
		}
		else {
			// call the method again on the next index
			return find(a, x, i+1);
		}
	}
	
	/*
	 * binarySearch(int[] a, int x) searches for
	 * the value x in the array a using the
	 * binary search algorithm.
	 * 
	 * Assume that the array will always be sorted.
	 * 
	 * O(log n)
	 */
	public static int binarySearch(int[] a, int x) {
		return binarySearch(a, x, 0, a.length - 1);
	}
	// private helper method with extra parameters
	// to keep track of the start and end of the current
	// range
	private static int binarySearch(int[] a, int x, 
			int start, int end) {
		
		// if end < start, invalid range, x does not
		// exist
		if(end < start) {
			return -1;
		}
		
		// calculate the middle index between start
		// and end using (start + end)/2
		int mid = (start + end) / 2; // the middle index
		int midVal = a[mid]; // what's stored at mid
		
		// Case 1: x > midVal, go right
		// new range becomes [mid+1, end]
		if(x > midVal) {
			return binarySearch(a, x, mid + 1, end);
		}
		// Case 2: x < midVal, go left
		// new range becomes [start, mid - 1]
		else if(x < midVal) {
			return binarySearch(a, x, start, mid - 1);
		}
		else {// x == midVal
			return mid;
		}
	}
	
	public static void main(String[] args) {
//		int[] a = {-8, -4, -2, 0, 1, 5, 7, 17, 21, 25};
//		System.out.println(find(a, 0));
//		System.out.println(find(a, -6));
//		System.out.println(find(a, 100));
//		
//		System.out.println(binarySearch(a, 0));
//		System.out.println(binarySearch(a, 17));
//		System.out.println(binarySearch(a, -6));
//		System.out.println(binarySearch(a, 100));
		
		/*
		 * timing experiment to determine how long it
		 * takes to find 10,000 things in an array
		 * of size 1 million.
		 * 
		 * For linear search it took ~100ms to find
		 * 10,000 elements
		 * 
		 * For linear search it took ~3ms to find
		 * 10,000 elements
		 */
		int[] a = new int[1_000_000];
		// each element in b will be equal to
		// the previous element plus either 1, 2, or 3
		for(int i = 1; i < a.length; i++) {
			a[i] = a[i - 1] + (int) (Math.random() * 3) + 1;
		}
		//System.out.println(Arrays.toString(a));
		
		// time how long it takes to find 0 to 9999
		// in that array of size 1 million
		long start = System.currentTimeMillis();
		// search for 0, 1, 2, .... 9999
		for(int i = 0; i < 10_000; i++) {
			//find(a, i); // linear search
			binarySearch(a, i); // binary search
		}
		long end = System.currentTimeMillis();
		System.out.println(end-start);
	}
}
