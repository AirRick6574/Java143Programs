import java.util.Iterator;

//implements will grab and implement an interface (Iterable interface)
//implementing something may require writing needed requirements
public class DoublyLinkedList implements Iterable<String>{
	// inner class that represents a single item
	// in the DLL
	private class Node {
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
	private int size;  // number of elements in the list

	/*
	 * Constructor for an empty list where head and tail are both null
	 */
	public DoublyLinkedList() {
		head = tail = null;
		size = 0;
	}
	
	/*
	 * size() returns the number of elements stored in
	 * the doubly linked list
	 * 
	 * O(1) constant time
	 */
	public int size() {
//		int size = 0;
//		Node walker = head;
//		while(walker != null) {
//			walker = walker.next;
//			size++;
//		}
		return size;
	}

	/*
	 * add(String e) adds the element e to the end of the Doubly Linked list
	 * 
	 * O(1) constant time
	 */
	public void add(String e) {
		// special case: adding to an empty list
		if (head == null && tail == null) {
			head = tail = new Node(null, e, null);
		} 
		else {
			Node newTail = new Node(tail, e, null);
			// link between the current tail and the new tail
			tail.next = newTail;
			tail = newTail;
		}
		size++;
	}

	/*
	 * addBefore(String e) adds the element e to the beginning of the Doubly Linked
	 * list
	 * 
	 * O(1) constant time
	 */
	public void addBefore(String e) {
		// special case: adding to an empty list
		if (head == null && tail == null) {
			head = tail = new Node(null, e, null);
		}
		else {
			Node newHead = new Node(null, e, head);
			head.prev = newHead;
			head = newHead;
		}
		size++;
	}
	
	/*
	 * get(int i) returns the ith element in the list
	 * 
	 * O(N) linear time
	 */
	public String get(int i) {
		// out of bounds case
		if(i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			// start a variable at the head,
			Node walker = head;
			// loop it forwards "i" times
			for(int j = 0; j < i; j++) {
				walker = walker.next;
			}
			// walker rests on the ith node, return
			// its data
			return walker.data;
		}
	}
	
	/*
	 * O(N) linear time
	 */
	@Override
	public String toString() {
		String res = "";
		Node walker = head;
		while(walker != null) {
			res = res + walker.data + " ";
			walker = walker.next;
		}
		return "[" + res.trim() + "], size=" + size();
	}
	
	// iterators are classes that are designed to
	// iterate through a data structure in linear time
	private class ListIterator implements Iterator<String>{
		// current keeps track of where the iterator
		// currently is in the list
		private Node current;
		// constructor that allows us to tell the iterator
		// where to start
		public ListIterator(Node start) {
			current = start;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public String next() {
			String res = current.data;
			current = current.next;
			return res;
		}
		
	}
	
	@Override
	public Iterator<String> iterator() {
		return new ListIterator(head);
	}
	public static void main(String[] args) {
		DoublyLinkedList dll = new DoublyLinkedList();
		dll.add("A");
		dll.add("B");
		dll.add("C");
		dll.add("D");
		System.out.println(dll);
		dll.addBefore("Z");
		System.out.println(dll);
		System.out.println(dll.get(0));
		System.out.println(dll.get(3));
		//System.out.println(list.get(5));
		System.out.println("===================");
		// foreach loop
		// "for each String s in the list, print s"
		for(String s : dll) {
			System.out.println(s);
		}
		System.out.println("===================");
		
		// test how long it takes to call the get method
		// on 1000 things vs 2000 things vs 4000 things
		for(int size = 1000; size < 10_000_000; size = size * 2) {
			DoublyLinkedList list = new DoublyLinkedList();
			// add "size" things to the list
			for(int i = 0; i < size; i++) {
				list.add(""+i);
			}
			
	
			
			long start = System.currentTimeMillis();
			// call the get method on all the elements
			// in the list
			
			// N times, overall O(N^2)
//			for(int i = 0; i < list.size; i++) {
//				list.get(i); // O(N)
//			}
			
			// O(N) 
//			Iterator<String> iter = list.iterator();
//			while(iter.hasNext()) {
//				iter.next();
//			}
			for(String s : list) {
				
			}
			
			long end = System.currentTimeMillis();
			
			System.out.println(size + ": " + (end - start));
		}
	}
}
