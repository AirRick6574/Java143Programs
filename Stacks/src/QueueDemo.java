import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
	public static void main(String[] args) {
		
		/*
		 * Lined up to get coffee at the Titan Cafe
		 * 
		 */
		Queue<String> line = new LinkedList<>();
		line.add("Kyle");
		line.add("Sophie");
		line.add("Sam");
		line.add("Dakota");
		line.add("Erick");
		line.add("Justin");
		line.add("David");
		System.out.println(line);
		System.out.println("Was Removed: " +line.remove()); //Removes First Person that was added, returns first removed element
		System.out.println(line);
		System.out.println("Was Removed: " + line.remove());
		System.out.println(line);
		System.out.println("Was Peeked: " + line.peek()); //Peaks into most recent without removing and returns element
		System.out.println(line);
	}
	
}
