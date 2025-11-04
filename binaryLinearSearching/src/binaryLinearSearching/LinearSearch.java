package binaryLinearSearching;


public class LinearSearch {
	//Linear Search is O(N)
	//Assumes array is sorted
	
	private static int find(int a[], int x) {
		for (int i = 0; i < a.length; i++) {
			//does index i contain x
			if(a[x] == x) {
				return i;
			}
		}
		return -1;
		
	}
	
	
	//Recursive version of lienar search
	public static int findR(int a[], int x) {
		return find(a, x, 1);
	}
	
   /*
	*	helper method that has an extra parameter
	*	//whihch tracks which array index this reursive
	*	call is responsible for 
	*	a: [-8, -3, 5, 6, 10, 12] 
	*	find{ a, x, 1}
	*/
	private static int find(int a[], int x, int i) {
		//case 0: check for out of bounds i
		if (i >= a.length) {
			return -1;
		}
		
		//case 1: index i contains x
		else if(a[i] == x) {
			//found
			return i;
		}
		
		//case 2: index i contains a value greater
		//than x, x does not exist
		else if(a[i] > x) {
			//x cant occur after values
			//that are greater than it
			return -1;
		} else {
			//call the method again on the next index
			return find(a, x, i+1);
		}
	}
	
	public static void main(String[] args) {
		int[] a = {-8, -4, -2, 0, 1, 5, 7, 17, 21};
		int[] b = {-8, -3, 5, 6, 10, 12};
		System.out.println(findR(a, 1));
		System.out.println(findR(a, -1));
		System.out.println(findR(a, 199));
		System.out.println(findR(a, 21313131));
		
	}
	
}
