package packageName;

import java.util.HashSet;
import java.util.Set;


public class SetsExamples {
	
	//new approach to contains duplicates
	//O(1) linear time, since we are going through the array only once without a nested loop
	//More memory tho :(
	public static boolean containsDuplicates(int[] a) {
		//set to hold the unique values in a
		Set<Integer> set = new HashSet<>();
		//loop through the array, add each element 
		//to the set
		for (int s : a) {
			set.add(s);
		}
		// compare the set length to the array length
		// different, there was a duplicate
		// same, no duplicate
		return a.length != set.size();
	}
	
	public static void main(String[] args) {
		int[] a = {8,10,12,15,2,6,8,5};
		System.out.println(containsDuplicates(a));
		int[] b = {1, 2, 3, 4, 5};
		System.out.println(containsDuplicates(b));
	}
}
