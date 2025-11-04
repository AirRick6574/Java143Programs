package binaryLinearSearching;



public class binarySearch {
	//Assume array is always sorted
	
	/*
	 * binarySearch(int[] a, int x) searches for the value x in the array a
	 * using the binary search algorithm
	 * 
	 * O (log n)
	 */
	public static int binarySearchNOTNAME(int[] a, int x) {
		return binarySearchNOTNAME(a, x, 0, a.length - 1);
	}
	
	//private helper method with extra parameters to keep track
	//of the start and end of the current range
	private static int binarySearchNOTNAME(int[] a, int x, int start, int end) {

		//Case 0: If end < start, we have number that does not exist
		if (end < start) {
			return -1;
		}
		
		//calculate the middle index between start
		//and end using (start + end) / 2
		int mid = (start + end) / 2;
		int midVal = a[mid]; //Whats in middle index
	
		//Case 1: Value we are looking for is greater than midVal
		if (x > midVal) {
			//Range is now mid + 1 to end
			//Redo search by searching upper half
			return binarySearchNOTNAME(a, x, mid + 1, end);
		}
		
		//Case 2: Value we are looking for is less than midVal
		else if (x < midVal) {
			//Redo search by searching lower half
			//Range is now start, midVal - 1
			return binarySearchNOTNAME(a, x, start, mid - 1);
		}
		
		//Case 3: Number found because it cannot be smaller or larger
		else { //x == midVal
			return mid;
		}
		
	}
	
	public static void main(String[] args) {
		
//		
//		int[] a = {-8, -4, -2, 0, 1, 5, 7, 17, 21};
//		int[] b = {-8, -3, 5, 6, 10, 12};
//		System.out.println(binarySearchNOTNAME(a, 1));
//		System.out.println(binarySearchNOTNAME(a, 17));
//		System.out.println(binarySearchNOTNAME(a, 5));
		//System.out.println(binarySearchNOTNAME(a, -1));
		//System.out.println(binarySearchNOTNAME(a, 199));
		//System.out.println(binarySearchNOTNAME(a, 21313131));
	
		int[] a = {-8, -4, -2, 0, 1, 5, 7, 17, 21, 25};
		
		
		System.out.println(binarySearchNOTNAME(a, 0));
		System.out.println(binarySearchNOTNAME(a, 17));
		System.out.println(binarySearchNOTNAME(a, 21));
		System.out.println(binarySearchNOTNAME(a, -6));
		System.out.println(binarySearchNOTNAME(a, 100));
	}
	
}
