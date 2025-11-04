import java.awt.print.Printable;
import java.util.EmptyStackException;

public class StringStack {
	//Inner class that represents a single item
	//in the stack
	
	//Private Class
	private class Node{
		
		//pancake flavor
		private String data; 
		
		//link to the node below this node
		private Node below;
	}
	
	//keep track of Which Node is the top of the Stack
	private Node overallTop;
	
	/*
	 * Constructor for an empty stack with nothing
	 * on top. Nothing on top equals nothing in stack
	 */
	public StringStack() {
		overallTop = null; //nothing on top
	}
	
	/*
	 * push(String e) puts the String e on top of the stack
	 * above everything already in the stack
	 * 
	 * O(I) Constant Time
	 */
	public void push(String e) {
		//1. Create a new node
		Node newTop = new Node(); //empty box
		
		//2. Put our data inside it
		newTop.data = e;
		
		//3. Set its below to the overallTop
		newTop.below = overallTop; //new Top
		
		//4. update Overall Top (point new top
		overallTop = newTop;
	}
	
	/*
	 * Pop Removes the top of the stack and 
	 * returns what it removes
	 * 
	 * O(1) Constant Time
	 */
	public String pop() {
		//Check if the stack is emptu
		if(overallTop == null) {
			throw new EmptyStackException();
		}
		else {
			//1. Save the current Top's data
			String oldTop = overallTop.data;
			
			//2. Move overallTop down
			overallTop = overallTop.below;
			
			//3. Return saved data
			return oldTop;
		}
	}
	
	
	@Override
	public String toString() {
		return "StringStack [overallTop=" + overallTop + "]";
	}

	/*
	 * peek() returns but does not remove the top of the stack
	 * 
	 * O(1) constant time
	 */
	public String peek() {
		// check if the stack is empty
		if(empty()) {
			// nothing to pop, throw an exception
			throw new EmptyStackException();
		}
		else {
			return overallTop.data;
		}
	}
	
	/*
	 * empty() returns true if the stack is empty
	 * otherwise, returns false
	 * 
	 * O(1) constant time
	 */
	public boolean empty(){
		return overallTop == null;
	}
	
	public static void main(String[] args) {
		StringStack pancakes = new StringStack();
		pancakes.push("Banana"); //At Bottom
		pancakes.push("Cookie Dough");
		pancakes.push("Smores");
		pancakes.push("Peach");
		System.out.println(pancakes);
		System.out.println(pancakes.toString());
		System.out.println(pancakes.peek());
	}
	
	
}
