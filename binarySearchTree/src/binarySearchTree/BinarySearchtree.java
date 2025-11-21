package binarySearchTree;


/*
 * We can make out BST generic, but T should only be substituted with types of objects
 * we can compare to each other
 */
public class BinarySearchtree<T extends Comparable<T>> {
	//inner node class that represents a single item
	//in the tree
	private class Node<T>{
		private T data;
		private Node<T> left;
		private Node<T> right;
		
		//constructor for a leaf
		public Node(T data) {
			this.data = data;
			left = right = null;
		}
	}
	
	//track the overall root of the tree
	private Node<T> overallRoot;
	
	//track the size of the bst
	int size;
	
	/*
	 * Constructor for an empty binary search tree
	 * Set Root to Null
	 */
	public BinarySearchtree(){
		overallRoot = null;
		size = 0;
	}
	
	/*
	 * size() returns the number of nodes in the BST
	 */
	public int size() {
		return size;
	}
	
	/*
	 * Add(T data) adds a leaf with specific data to 
	 * the binary search tree
	 * 
	 * if data is already in the tree, do nothing and 
	 * return false (not successful)
	 * 
	 * If data is not in the tree, add it
	 */
	public boolean add(T data) {
		//empty case:
		if(overallRoot == null) {
			overallRoot = new Node<>(data);
			size++;
			return true;
		} else {
			return add(data, overallRoot);
		}
	}
	
	//helper method with an extra param to keep track
	//of which node each recursive call is examining
	private boolean add(T data, Node<T> node) {
		int comparison = data.compareTo(node.data);
		
		if(comparison < 0) {
			//before going left, if nothing is there, placement found
			//we found the place for our data
			if(node.left == null) {
				node.left = new Node<T>(data);
				size++;
				return true;
			}
			
			//go left
			return add(data, node.left);
			
		} else if(comparison > 0) {
			//go right
			//before going right, if nothing is there, placement found
			//we found the place for our data
			if(node.right == null) {
				node.right = new Node<T>(data);
				size++;
				return true;
			}
			
			//go right
			return add(data, node.right);
			
		} else { //means comparison equals 0
			//trying to add a duplicate
			return false;
		}
	}
	
	public static void main(String[] args) {
		String[] names = {
				"Martin", "Grover", "Zeke", "Alice", 
				"Hoover", "Morton", "Zorro", "Charlise",
				"Zach", "Charlie"
		};
		BinarySearchtree<String> bst = new BinarySearchtree<String>();
		for (String name : names) {
			bst.add(name);
		}
		
		bst.add("David");
		System.out.println(bst.size());
		
		
	}
	
}
