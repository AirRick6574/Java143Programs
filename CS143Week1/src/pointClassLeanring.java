import java.awt.Point;

public class pointClassLeanring {
	public static void main(String[] agrs) {
		Point point = new Point();
		System.out.println(point);
		
		Point secondPoint = new Point(5, 10);
		System.out.println(secondPoint);
		
		Point p3 = new Point(5, 10);
		System.out.println(p3);
		
		Point p4 = new Point(5, 10);
		System.out.println(p4);
		
		//Not equal, while content may be equal they are different objects and are not the SAME OBJECT
		//OBJECT IS NOT P3
		System.out.println(p3 == p4);
		
		System.out.println(p4.equals(p3)); //Method checks if point contains same values
		
		int[] a = {1,2,3};
		int[] b = {1,2,3};
		
		System.out.println(a.equals(b));
	}
}
