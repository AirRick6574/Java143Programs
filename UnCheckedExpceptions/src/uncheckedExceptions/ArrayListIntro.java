package uncheckedExceptions;


import java.util.ArrayList;
import java.util.Arrays;
/*
 * When to use Arrays
 * 		-> We know exactly how much data we will be working with
 * 		-> low memory
 * 		-> Warehouse
 * 
 * 
 * When to use ArrayList
 * 		-> We do not know how much data we will be working with
 * 		-> need to be able to expand the amount of data
 */
public class ArrayListIntro {
	public static void main(String[] args) {

		/*
		 * What if we wanted to add a 6th element after the 5?
		 * 
		 * Short answer: we cannot because arrays are fixed-size
		 * 
		 * Long answer: we sort of can by making a bigger array
		 */
		//         0  1  2  3  4
		int[] a = {8, 1, 4, 2, 5};
		System.out.println(Arrays.toString(a));
		// make a new array with space for one more element
		int[] b = new int[a.length+1];
		// use a loop to copy the elements from a into b
		for(int i = 0; i < a.length; i++) {
			b[i] = a[i];
		}
		// set index 5 (b.length - 1) to a 6
		b[b.length - 1] = 6;
		// make our variable "a" refer to the bigger array
		a = b;
		System.out.println(Arrays.toString(a));
		System.out.println(a[0]);
		a[2] = 9; // replace the 4 with a 9
		System.out.println(Arrays.toString(a));
		System.out.println(a.length);
		System.out.println("===========================");
		/*
		 * Java has ArrayLists which can automatically 
		 * resize for us without us the programmer needing to
		 * do it manually
		 * 
		 * Has an array behind the scenes and when it runs out
		 * of space, automatically creates a bigger array
		 * 
		 * Initially, ArrayList has an array behind the scenes of
		 * size 10, meaning we can add 10 things before Java needs
		 * to create a bigger array
		 * 
		 * ArrayLists are generic, in the angle brackets <>
		 * we can only specify types of objects
		 * 
		 * int -> Integer
		 * double -> Double
		 * boolean -> Boolean
		 * float -> Float
		 * char -> Character
		 */
		//int[] a = {8, 1, 4, 2, 5};
		ArrayList<Integer> list = new ArrayList<>();
		list.add(8);
		list.add(1);
		list.add(4);
		list.add(2);
		list.add(5);
		System.out.println(list);
		list.add(6);
		System.out.println(list);
		list.add(200);
		list.add(150);
		list.add(399);
		list.add(149);
		System.out.println(list);
		System.out.println(list.get(0)); // similar to a[0]
		list.set(2, 9); // similar to a[2] = 9
		System.out.println(list);
		System.out.println(list.size()); // similar to a.length

	}
}
