import java.util.Iterator;

/**
 * @Author Erick Ruiz 
 * This class is designed to act as a fully functioning doubly linked list. 
 * There are also methods included to alter the lists in different ways, such as 
 * - Removing 
 * - Adding 
 * - Reversing 
 * - and more! 
 * (Some comments are comments writen when DoublyLinkedList was being written)
 * 
 * implements will grab and implement an interface (Iterable interface)
 * implementing something may require writing needed requirements
 */
public class DLList<T> implements Iterable<T> {
	// ===== inner Node class ======
	// inner class that represents a single item
	// in the DLL
	private static class Node<T> {
		private Node<T> prev; // link to the previous node in the list
		private T data;  // data in this node
		private Node<T> next; // link to the next node in the list
		
		// constructor that allows us to create a new node
		// and specify what comes before it, what is in it
		// and what comes after it
		public Node(Node<T> prev, T data, Node<T> next) {
			this.prev = prev; // tracks the first node
			this.data = data; // tracks the last node
			this.next = next;  // number of elements in the list
		}
	}
	
	// iterators are classes that are designed to
	// iterate through a data structure in linear time
	private static class Conductor<T> implements Iterator<T> {
		// current keeps track of where the iterator
		// currently is in the list
		private Node<T> current;
		
		// constructor that allows us to tell the iterator
		// where to start
		public Conductor(Node<T> start) {
			current = start;
		}
		
		/*
		 * has next method will check if the next link is existing or null
		 * returns true or false
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}

		/*
		 * next() will update current node to next node 
		 * as well as return the data of current node
		 */
		@Override
		public T next() {
			T res = current.data;
			current = current.next;
			return res;
		}

	}
	
	//reverse conductor behaves very similarly to the already existing conductor except 
	//it will cycle to the previous node, acting as a reverse interator
	private static class reverseConductor<T> implements Iterator<T> {
		// current keeps track of where the iterator
		// currently is in the list
		private Node<T> current;

		// constructor that allows us to tell the iterator
		// where to start
		public reverseConductor(Node<T> start) {
			current = start;
		}
		
		/*
		 * has next method will check if the next link is existing or null
		 * returns true or false
		 */
		@Override
		public boolean hasNext() {
			return current != null;
		}
		
		//Part that is different, current will update to 
		//the previous node
		@Override
		public T next() {
			T res = current.data;
			current = current.prev;
			return res;
		}

	}

	@Override
	public Iterator<T> iterator() {
		return new Conductor<T>(head);
	}
	
	public Iterator<T> descendingIterator() {
		return new reverseConductor<T>(tail);
	}

	// ===== properties of the DoublyLinkedList class ======
	private Node<T> head; // the first node in the list
	private Node<T> tail; // the last node in the list
	private int size;     // number of elements in the listr 

	/*
	 * Constructor method:
	 * Set tail and head to null
	 */
	public DLList() {
		head = tail = null;
	}
	
	/*
	 * isEmpty() will return true if head and tail are null
	 */
	public boolean isEmpty() {
		return head == null && tail == null;
	}
	
	/*
	 * add(String e) adds the element e to the end of the Doubly Linked list
	 * 
	 * O(1) constant time
	 */
	public void add(T data) {
		// special case: adding to an empty list
		if (isEmpty()) {
			head = tail = new Node<>(null, data, null);
		} else {
			// 1. Create a new node
			// 2. Make the tail come before it
			// 3. Make nothing come after it as it is the new 
			// end of the list
			Node<T> newTail = new Node<>(tail, data, null);
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
	public void addBefore(T data) {
		// special case: adding to an empty list
		if (isEmpty()) {
			head = tail = new Node<>(null, data, null);
		} else {
			//Create new node containing data and link next to head
			Node<T> newHead = new Node<>(null, data, head);
			//Relink existing nodes to include new node 
			head.prev = newHead;
			head = newHead;
		}
		size++;
	}

	/*
	 * size() returns the number of elements stored in
	 * the doubly linked list
	 * 
	 * O(1) constant time
	 */
	public int size() {
		return size; 
	}

	/*
	 * get(int i) returns the ith element in the list
	 * (Updated version includes split feature where it will determine
	 * if index is in the upper half of the list or lower half and 
	 * will increment upwards or downwards based on the condition.)
	 * 
	 * O(N) linear time
	 */
	public T get(int index) {
		// out of bounds case
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		//create new walker node
		Node<T> walker;
		//Determine if index is in upper or lower half
		//If condition is true, start at head and increment normally
		if(index <= (size / 2)) {
			// start a variable at the head,
			walker = head;
			// loop it forwards "i" times
			for (int i = 0; i < index; i++) {
				walker = walker.next;
			}
			//return data
			return walker.data;
		//If condition is false, index is in other half, set walker to tail
		} else {
			walker = tail; 
			//set for loop to increment based on size and index (account for 0 index)
			for (int i = 0; i < (size - 1) - index; i++) {
				walker = walker.prev;
			}
			return walker.data;
		}
		
	}
	
	/*
	 * Remove(int i) removes the element at index i
	 * in the the list. Returns the string that is removed.
	 */
	public T remove(int index) {
		// out of bounds case
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException();
		}
		
		//Walker cycle 
		Node<T> walker = head;
		for (int i = 0; i < index; i++) {
			walker = walker.next;
		}
		//Case 1: list with size 1 (Both are same things)
		if(head == tail) {
			head = tail = null;
		}
		// CASE 2: Removing the first element (index == 0)
		else if(walker == head) {
			head = head.next;
			head.prev = null;
		}
		
		// CASE 3: Removing the last element 
		else if(walker == tail) {
			tail = tail.prev;
			tail.next = null;
		}
		//case 4: removing center:
		else {
			//Remove links to ignore node being removed
			(walker.prev).next = walker.next;
			(walker.next).prev = walker.prev;
		}

		size--;
		return walker.data;
	}
	
	/*
	 * Public void reverse() that reverses the list. 
	 * Example: The list A-B-C-D would become D-C-B-A
	 * Set loop to be half of the linked list size and set 
	 * node data to be the opposite of the split (Set First to Last 
	 * and move inwards till center is reached)
	 */
	public void reverse() {
		//Set head and tails
		Node<T> first = head;
		Node<T> last = tail;
		
		//For loop to swap out data
		for (int i = 0; i < size / 2; i++) {
			T tempData = first.data;
			first.data = last.data;
			last.data = tempData; 
				
			first = first.next;
			last = last.prev;
		}
	}

	/*
	 * Unique version of already existing add method where it will add a node based
	 * parameter i (index location). Since the add method already exists that adds a 
	 * method at the end, this method will return false if I is out of bounds or 
	 * at end.
	 */
	public boolean add(int i, T data) {
		
		//SPECIAL CASE: Out of Bounds Condition
		//Includes tail as well in out of bounds condition
		if (i < 0 || i > size() - 1) {
			return false;
		}
		
		//Special Case: if index is at 0.
		if (i == 0) {
			//Create new node with node.prev set to null and 
			// node.head set to current head
			Node<T> dataNode = new Node<>(null, data, head);
			
			//Set current head prev to new node
			head.prev = dataNode;
			//Update head
			head = dataNode;
			
			size++;
			return true; 
		}
		
		//Else Case: Insert at middle (Create walker and iterate to index)
		Node<T> walker = head;
		for (int j = 0; j < i; j++) {
			walker = walker.next;
		}
		
		//Create node with walker previous being new node previous
		//and node head being walker 
		Node<T> dataNode = new Node<>(walker.prev, data, walker);

		//Adjust current links to include new node
		(walker.prev).next = dataNode;
		walker.prev = dataNode;
		
		size++;
		return true; 
	}
}

