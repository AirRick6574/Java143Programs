import java.util.Iterator;


//GENERIC VERSION OF DOUBLYLINKEDLIST

//implements will grab and implement an interface (Iterable interface)
//implementing something may require writing needed requirements
public class DoublyLinkedListGeneric<T> implements Iterable<T>{
	// inner class that represents a single item
	// in the DLL
	private static class Node<T> {
		private Node<T> prev; // link to the previous node
		private T data; // data in this node
		private Node<T> next; // link to the next node

		// constructor that allows us to create a new node
		// and specify what comes before it, what is in it
		// and what comes after it
		public Node(Node<T> prev, T data, Node<T> next) {
			this.prev = prev;
			this.data = data;
			this.next = next;
		}
	}

	private Node<T> head; // tracks the first node
	private Node<T> tail; // tracks the last node
	private int size;  // number of elements in the list

	/*
	 * Constructor for an empty list where head and tail are both null
	 */
	public DoublyLinkedListGeneric() {
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
	public void add(T e) {
		// special case: adding to an empty list
		if (head == null && tail == null) {
			head = tail = new Node<T>(null, e, null);
		} 
		else {
			// 1. Create a new node
			// 2. Make the tail come before it
			// 3. Make nothing come after it as it is the new 
			// end of the list
			Node<T> newTail = new Node<T>(tail, e, null);
			// 4. make the current tails next the newTail
			// link between the current tail and the new tail
			tail.next = newTail;
			// 5. update the tail
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
	public void addBefore(T e) {
		// special case: adding to an empty list
		if (head == null && tail == null) {
			head = tail = new Node<T>(null, e, null);
		}
		else {
			Node<T> newHead = new Node<T>(null, e, head);
			head.prev = newHead;
			head = newHead;
		}
		size++;
	}
	
	/*
	 * Remove(int i) removes the element at index i
	 * in the the list. Returns the string that is removed.
	 * 
	 */
	public T remove(int i) {
		// out of bounds case
		if(i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		//Case 1: list with size 1 (Both are same things)
		else if(head == tail) {
			T results = head.data;
			head = tail = null;
			size--;
			return results;
		} 
		//Case 2: Removing the head (index = 0)
		else if(i == 0) {
			T results = head.data;
			head = head.next;
			//Make sure link is broken and nothing comes before the head
			head.prev = null;
			size--;
			return results;
		}
		//case 3: removing the tail
		else if (i == size - 1) {
			T results = tail.data;
			tail = tail.prev;
			//Make sure link is broken and nothing comes after the tail
			tail.next = null;
			size--;
			return results;
		}
		//case 4: removing center:
		else {
			//loop to position i in the list
			//start a variable at the head,
			Node walker = head;
			//loop it forwards in "i" times
			for(int j = 0; j < i; i++) {
				walker = walker.next;
			}
			
			size--;
			T res = (T) walker.data;
			(walker.prev).next = walker.next;
			(walker.next).prev = walker.prev;
			return res;
		}
		
					
	}
	
	/*
	 * get(int i) returns the ith element in the list
	 * 
	 * O(N) linear time
	 */
	public T get(int i) {
		// out of bounds case
		if(i < 0 || i >= size) {
			throw new IndexOutOfBoundsException();
		}
		else {
			// start a variable at the head,
			Node<T> walker = head;
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
		Node<T> walker = head;
		while(walker != null) {
			res = res + walker.data + " ";
			walker = walker.next;
		}
		return "[" + res.trim() + "], size=" + size();
	}
	
	// iterators are classes that are designed to
	// iterate through a data structure in linear time
	private class ListIterator<T> implements Iterator<T>{
		// current keeps track of where the iterator
		// currently is in the list
		private Node<T> current;
		// constructor that allows us to tell the iterator
		// where to start
		public ListIterator(Node<T> start) {
			current = start;
		}
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T res = (T) current.data;
			current = current.next;
			return res;
		}
		
	}
	
	@Override
	public Iterator<T> iterator() {
		return new ListIterator(head);
	}
	public static void main(String[] args) {
		DoublyLinkedListGeneric<String> dll = new DoublyLinkedListGeneric<>();
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
			DoublyLinkedListGeneric<String> list = new DoublyLinkedListGeneric<>();
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
			
			
			//----------------------------------------------------------------------------------------------------
		}
		System.out.println("===================");
		
		DoublyLinkedListGeneric<Integer> dll2 = new DoublyLinkedListGeneric<>();
		dll2.add(2);
		
		dll2.add(2131);
		dll2.add(31);
		dll2.add(543);
		dll2.add(312);
		dll2.add(6);
		System.out.println(dll2);
	}
}
