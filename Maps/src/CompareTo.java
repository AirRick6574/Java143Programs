
public class CompareTo {
	/*
	 * compareTo is a method in java that we can use
	 * to compare two objects to each other.
	 * 
	 * compareTo gives us a negative number when the 
	 * first object is less than the second object
	 * 
	 * compareTo gives us a positive number when
	 * the first object is greater than the second object
	 * 
	 * compareTo gives us zero when the two objects
	 * are equal.
	 */
	public static void main(String[] args) {
		String a = "cat";
		String b = "dog";
		String c = "zebra";
		String d = "car";
		System.out.println(a.compareTo(d));
		System.out.println(a.compareTo(b)); // a < b
		System.out.println(c.compareTo(b)); // c > b
		System.out.println(a.compareTo("cat"));
	}
}
