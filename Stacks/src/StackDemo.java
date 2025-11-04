import java.util.Stack;

public class StackDemo {
	public static void main(String[] args) {
		Stack<String> pancakes = new Stack<>();
		// trying to pop before doing a push
		// causes an EmptyStackException
		//System.out.println(pancakes.pop());
		pancakes.push("Blueberry");
		pancakes.push("Chocolate Chip");
		pancakes.push("Original");
		pancakes.push("Marionberry");
		System.out.println(pancakes);
		System.out.println(pancakes.pop());
		System.out.println(pancakes);
		System.out.println(pancakes.pop());
		System.out.println(pancakes);
		System.out.println(pancakes.peek());
		System.out.println(pancakes);
	}
}
