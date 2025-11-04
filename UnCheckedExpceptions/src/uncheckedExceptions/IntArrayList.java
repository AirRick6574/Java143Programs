package uncheckedExceptions;

import java.util.Arrays;

/*
 * To better understand ArrayLists, custom ArrayList implementation
 * specific to Integers
 */

public class IntArrayList {
	//underlying array that the list will automatically
	//expand when it needs to
	private int[] a;
	// how much of the array is occupied by actual data
	private int length;
	
	
	//Constant Time Method
	public IntArrayList() {
		//INtialize a to have an initial size of 4
		a = new int[4];
		//set length to 0
		length = 0;
	}
	
	/*
	 * add(int e) adds a new elemen to the end of the list
	 * 
	 *  (after all the existing data)
	 * 
	 */
	
	//Non Constant Time 
	public void add(int e) {
		//Super Slow Code
		
		if(length == a.length) {
			//Check if array is at max space
			// try to create a bigger array with previous content of array (double the size of array)
			
			//slow part
			//This is slow and non constant due to relying on the length of a.length
			//Worst case, it is incredibly slow due to running constantly till a,length
			//Best case this is constant time
			int[] b = new int[a.length * 2];
			//copy all of the existing data over
			for (int i = 0; i < a.length; i++) {
				b[i]= a[i]; 
				
			}
			//reassign our array property to point to the bigger array
			a = b;
		}
		
		//fast part
		a[length] = e;
		length++;
	}
	
	/*
	 * size() returns the number of elements in the list
	 */
	public int size() {
		return length;
	}
	
	/*
	 * get(int i) returns the ith element in the list
	 */
	
	//Constant time since it takes two steps to complete function
	public int get(int i) {
		if (i < 0 || i >= length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		return a[i];
	}
	
	
	/*
	 * set(int i, int e) sets index i in the list to be the 
	 * the new value e
	 */
	
	public void set(int i, int e) {
		if (i < 0 || i >= length) {
			throw new ArrayIndexOutOfBoundsException();
		}
		a[i] = e; 
	}
	
	
	//NON CONSTANT TIME SINCE IT CALLS ARRAYS.TOSTRING
	@Override
	public String toString() {
		return "IntArrayList [a=" + Arrays.toString(a) + ", length=" + length + "]";
	}

	public static void main(String[] args) {
		IntArrayList ial = new IntArrayList();
		System.out.println(ial);
		ial.add(5);
		System.out.println(ial);
		ial.add(10);
		System.out.println(ial);
		ial.add(15);
		System.out.println(ial);
		ial.add(20);
		System.out.println(ial);
		ial.add(25);
		System.out.println(ial);
		ial.add(30);
		System.out.println(ial);
		ial.add(35);
		System.out.println(ial);
		ial.add(40);
		System.out.println(ial);
		ial.add(45);
		System.out.println(ial);
		ial.add(50);
		System.out.println(ial);
		
				
		/*
		 * Time how long it takes to add 1000 vs 2000 vs 4000 .... 8192000 
		 * elements to our list 
		 * 
		 * to determine the relationship between the number of adds and time
		 */
		
		//n represents the number of things we are adding
//		for(int n = 1000; n <= 8_192_000; n = n * 2) {
//			IntArrayList ial = new IntArrayList();
//			
//			//get the computers time before adding n things
//			long start = System.currentTimeMillis();
//			//call the add method n times
//			
//			for (int i = 1; i <= n; i++) {
//				ial.add(i);
//			}
//			
//			//Get the computers time before adding n things
//			long end = System.currentTimeMillis();
//			
//			System.out.println(n + ": " + (end - start));
//		}
	}
}
