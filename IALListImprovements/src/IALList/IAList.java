package IALList;

import java.util.Arrays;

/**
 * @author Erick Ruiz
 * Class will manipulate main array by adding numbers at the end or beginning of array. 
 * If needed, program will also increase array size to accommodate add request while 
 * maintaining peak speed. Program will run at O(N) in worse case scenario
 */
public class IAList {
	
	// Underlying array
	private int[] a; 
	
	//Add before array
	private int start; 
	
	// Number of added elements in a
	private int length; 
	
	
	
	public IAList() {
		length = 0; // Start with no added elements in a
		a = new int[4]; // A little room to grow
	}

	public int get(int i) { // Retrieve an added element, O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY GET WORKS.
		if (i < 0 || i >= length) {
			throw new IndexOutOfBoundsException(i+"");
		}
		return a[i + start]; // Retrieve the element at position i
	}

	public int size() { // Number of added elements, O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SIZE WORKS.
		return length; // The number of added elements
	}

	public void set(int i, int x) { // Modify an existing element, O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SET WORKS.
		if (i < 0 || i >= length) {
			throw new IndexOutOfBoundsException(i+"");
		}
		a[i + start] = x; // Change the existing element at position i to x
	}

	public void add(int x) { // Add an element to the end, O(n) for n
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY ADD WORKS.
		if (length + start >= a.length) {
			
			//Update length as doubled, also use to create new array.
			int newLength = a.length * 2;
			
			// Create new array of double the length
			int[] b = new int[newLength];
			
			/*
			*Create start by determining center. Constantly updated by recalculating  
			*/
			int newStart = (newLength - length) / 2;
			// Copy the elements of a to the corresponding indexes of b
			for (int i = 0; i < length; i++) {
				//Make sure they are each using their respected spacing from each array 
				//b = [0,0,2,3,0,0] start = 2
				//a =  0[0,2,3,0]0 start = 1
				b[newStart + i] = a[i + start];
				
			}
			// Reassign a reference to b
			a = b;
			//Update old start to align with new array
			start = newStart;
		}
		// Place x at the end of the IAList
		a[length + start] = x;
		// Increase length by 1
		length = length + 1;	
	}

	public void addBefore(int x) {
		//Updated from add method to instead check if start (beginning) has any space. 
		//If no space is available, begin array increase. 
		if (start == 0) {
			//Update length as doubled
			int newLength = a.length * 2;
			
			// Create new array of double the length
			int[] b = new int[newLength];
			
			//Create start by being in center. Constantly updated by 
			int newStart = (newLength - length) / 2;
			// Copy the elements of a to the corresponding indexes of b
			for (int i = 0; i < length; i++) {
				//System.out.println(a[i + (start - ((a.length / 2) / 2) - 1 )]);
				b[newStart + i] = a[i + start];
				//System.out.println(Arrays.toString(a));
			}
			// Reassign a reference to b
			a = b;
			start = newStart;
		}
		
		// Place x at the end of the IAList
		a[start - 1] = x;
		
		// Increase length by 1
		length = length + 1;
		
		//Lower Start by 1 for every number added before array 
		start--;
		
		//-----DEBUG PRINT STATEMENTS--------
		//System.out.println(Arrays.toString(a));
		//System.out.println(start);
		//System.out.println(length);
		//System.out.println(a.length);
	}
}
