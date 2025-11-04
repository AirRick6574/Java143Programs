
public class DoublyLinkedList {
	// inner class that represents a single item
	// in the DLL
	private class Node{
		private Node prev; // link to the previous node
		private String data; // data in this node
		private Node next; // link to the next node
		
		// constructor that allows us to create a new node
		// and specify what comes before it, what is in it
		// and what comes after it
		public Node(Node prev, String data, Node next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}

	private Node head; // tracks the first node
	private Node tail; // tracks the last node
	
	/*
	 * Constructor for an empty list where
	 * head and tail are both null
	 */
	public DoublyLinkedList() {
		head = tail = null;
	}
	
	/*
	 * add(String e) adds the element e to the end
	 * of the Doubly Linked list
	 * 
	 * O(1) constant time
	 */
	public void add(String e) {
		// special case: adding to an empty list
		if(head == null && tail == null) {
			head = tail = new Node(null, e, null);
		}
		else {
			Node newTail = new Node(tail, e, null);
			// link between the current tail and the new tail
			tail.next = newTail;
			tail = newTail;
		}
	}
}
