package uncheckedExceptions;

import java.nio.channels.AcceptPendingException;
import java.util.concurrent.ExecutionException;

/*
 * Exceptions that occurs due to programmer error are called RuntimeExceptions. 
 * They can be avoided by writing code that causes them
 */
public class uncheckedExceptions {
	public static void main(String[] args) {
		int[] a = {2, 4, 6, 8};
		
		//if we call the get method on an in bounds
		//index. the method will return a value to us
		System.out.println(get(a, 0));
		System.out.println("==============================");
		System.out.println(get(a, 100)); //Array index out of bounds exceptions
		System.out.println("Test");
		
		System.out.println("==============================");
		int[] b = null; //non existent array
		System.out.println(get(b, 100));
	}
	
	
	/*
	 * get (int[] a, int i) returns the elements at index i
	 */
	public static int get(int[] a, int i ) {
		try {
			//line that could cause an exception
			return a[i]; //Finally will run first because it will always run finally methods before exiting, such as the return example
		} catch (ArrayIndexOutOfBoundsException e) { //You can have as many catch blocks as you want.
			System.out.println("\nIndex " + i + " is out of bounds.");
			System.out.println(e);
			return 0;
		} catch (NullPointerException e) {
			System.out.println("Null Pointer Exception");
			System.out.println(e);
			return 0;
		} catch (AcceptPendingException | ArithmeticException e) {
			System.out.println("Accept Pending Exception or Arithmetic Exception");
			System.out.println(e);
			return 0;
		} catch (Exception e) { //Generally not preferred to use generic exception
			System.out.println("Generic unexpected error occured"); 
			System.out.println(e);
			return 0;
		} //Best way is to have multiple catch blocks for each error
		finally {
			System.out.println("finally");
		}
	}
}
