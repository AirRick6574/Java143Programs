import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class QueueString {
	//inner node class that represents a single item
	//in the queue
	private class Node{
		private String data; //name of the person in line
		private Node next; //link to the next person in line
		
	}

	//Keep track of which Node is the front of the queue 
	private Node front;
	//Keep track of which Node is the end of the queue 
	private Node end;

	/*
	 * Constructor for an empty queue with nobody in line
	 */
	public QueueString() {
		front = end = null;
	}
	
	/*
	 * empty() returns true if the stack is empty
	 * otherwise, returns false
	 * 
	 * O(1) constant time
	 */
	public boolean empty(){
		return front == null && end == null;
	}

	
	/*
	 * addC(String e) adds e to the end of the queue.
	 * 
	 * Runs in constant time
	 * O(1) constant time
	 */
	public void addC(String e) {
		//special case for an empty queue
		if(empty()) {
			Node newNode = new Node();
			newNode.data = e;
			front = end = newNode;
		} else {
			/*
			 * New constant time approach
			 */
			Node newEnd = new Node();
			newEnd.data = e;
			end.next = newEnd;
			end = newEnd;
		}

	}
	
	/*
	 * add(String e) adds e to the end of the queue.
	 * 
	 * O(N) linear time
	 * 
	 * NEEDS SOME REVISION
	 */
	public void add(String e) {
		//special case for an empty queue
		if(front == null) {
			Node newNode = new Node();
			newNode.data = e;
			front = newNode;
		} else {
			//since we only have access to the front
			//use a variable to loop through the queue 
			//until we find the end
			Node walker = front;

			//while loop to move walker to he end of the queue
			while (walker.next != null) {

				//move walker forwards
				walker = walker.next;
			}

			Node newEnd = new Node(); //empty box
			newEnd.data = e; // place our string Int he node
			end.next = newEnd;
			end = newEnd;
		}

	}
	
	/*
	 * Remove() removes and returns the front element
	 * of the queue
	 * 
	 * throws a NoSuchElementExcepton when the queue
	 * is empty
	 */
	public String remove() {
		//Case 1: empty queue
		if(empty()) {
			throw new NoSuchElementException();
		}
		//Case 2: queue with one element in it 
		else if(front == end) {
			String res = front.data;
			front = end = null;
			return res;
		}
		else {
			String res = front.data;
			front = front.next;
			return res;
		}
	}
	
	/*
	 * peek() returns but does not remove the top of the QUeue
	 * 
	 * O(1) constant time
	 */
	public String peek() {
		// check if the queue is empty
		if(empty()) {
			// nothing to pop, throw an exception
			throw new NoSuchElementException();
		}
		else {
			return front.data;
		}
	}
	
	/*
	 * O(N) Linear Time
	 */
	@Override
	public String toString() {
		String res = "";
		Node walker = front;
		while (walker != null) {
			res = res + walker.data + " ";
			walker = walker.next;
		}
		return "[" + res.trim() + "]";
	}
	
	public static void main(String[] args) {
		QueueString queue = new QueueString();
		queue.addC("Sam");
		queue.addC("Sophie");
		queue.addC("Erick");
		System.out.println(queue);
		System.out.println(queue.peek());
		System.out.println(queue);
		queue.addC("David");
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
		System.out.println(queue.remove());
		System.out.println(queue);
	}
}






