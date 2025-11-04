import java.awt.Point;

public class StaticVsNonStatic {
	public static void main(String[] args) {
		/*
		 * static methods behave like mathematical functions
		 * receive an input and produce an output.
		 * 
		 * Static methods do not need an object to call an method
		 * 
		 * Result we get back depends only on the value we give it
		 * GEnerally called with ClassName.method
		 */
		System.out.println(square(4));
		System.out.println(square(8));
		System.out.println(square(16));
		System.out.println(square(2));
		System.out.println(Math.ceil(2.5));
		System.out.println(Math.ceil(4.5));
		
		/*
		 * non-static methods: 
		 * - need to create an object before we can call them
		 * -results we get back depends on which object we call the method on
		 * 
		 * called with variableName.method
		 * 
		 */
		
		Point point = new Point();
		System.out.println(point);
		
		Point secondPoint = new Point(5, 10);
		System.out.println(secondPoint);
		
		System.out.println(point.getX());
		System.out.println(secondPoint.getX());
		
		
	}
	
	/*
	 * square(int x) returns x^2
	 * 
	 * square(4) => 16
	 */
	
	public static int square(int x) {
		return x * x;
		
	}
}
