import java.util.NoSuchElementException;

public class SinglyLinkedList {
	// inner class representing a single node in the list
	private static class ListNode{
		private int data;
		private ListNode next;

		public ListNode(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// reference to the first node in the list
	private ListNode front;

	// constructor for an empty list
	public SinglyLinkedList() {
		front = null;
	}

	// adds a new element to the end of the list
	// if the list is empty, assigns front to the new node
	public void add(int data) {
		if(front == null) {
			front = new ListNode(data);
		}
		else {
			// walk from head to tail
			ListNode walker = front;
			while(walker.next != null) {
				walker = walker.next;
			}
			// now walker is the tail, place a new node after walker
			walker.next = new ListNode(data);
		}
	}

	@Override
	public String toString() {
		String res = "";
		ListNode walker = front;
		while(walker != null) {
			res = res + walker.data + " -> ";
			walker = walker.next;
		}
		return res + "null";
	}
	/*
	 * removeLast removes and returns the last element of a list
	 * of integers
	 * 
	 * 
	 */
	public int removeLast(){
		// if the list is empty, throw exception
		if(front == null) {
			throw new NoSuchElementException("List is empty.");
		}
		// does the list have size 1?
		else if(front.next == null) {
			int res = front.data;
			front = null;
			return res;
		}
		// case for list with size > 1
		else {
			// use the "walker" approach to move a variable
			// though the list
			ListNode walker = front;
			while(walker.next.next != null) {
				walker = walker.next;
			}
			// now walker sits on the second to last node
			// save the last node's data
			int res = walker.next.data;
			// break the link between the second to last
			// and last node
			walker.next = null;
			return res;
		}
	}

	public static void main(String[] args) {
		SinglyLinkedList list = new SinglyLinkedList();
		for(int x : new int[] {2, 4, 6, 8, 10}) {
			list.add(x);
		}
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
		list.removeLast();
		System.out.println(list);
	}
}

