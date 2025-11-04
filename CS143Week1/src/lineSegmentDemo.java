
public class lineSegmentDemo {
	public static void main(String[] args) {
		lineSegment l1 = new lineSegment(0, 0, 50, 100);
		System.out.println(l1);
		System.out.println(l1.length());
		System.out.println(l1.slope());
		
		lineSegment l2 = new lineSegment(1, 2, 3, 4);
		System.out.println(l2);
		System.out.println(l2.length());
		System.out.println(l2.slope());
		
		lineSegment l3 = new lineSegment(51, 22, 43, 41);
		System.out.println(l3);
		System.out.println(l3.length());
		System.out.println(l3.slope());
		
		lineSegment l4 = new lineSegment(5, 10, 15, 20);
		System.out.println(l4);
		System.out.println(l4.length());
		System.out.println(l4.slope());
		
		lineSegment l5 = new lineSegment(10, 10, 10, 20);
		System.out.println(l5);
		System.out.println(l5.length());
		System.out.println(l5.slope());
	}
}
