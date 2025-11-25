package binarySearchTree;


/*
 * We can make out BST generic, but T should only be substituted with types of objects
 * we can compare to each other
 * 
 * T extends Comparable<T> makes sure that only objects
 * with a compareTo method can be substituted for T
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
	 *  O(1) constant time
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
	
	/*
	 * recursiveSize returns the number of nodes in the
	 * BST utilizing recursion
	 * 
	 * O(N)
	 */
	public int recursiveSize() {
		return recursiveSize(overallRoot);
	}
	
	// private helper method with an extra parameter
		// "which subtree is this recursive call responsible
		// for?"
	private int recursiveSize(Node<T> subtree) {
		// base case 1: size of an empty tree is 0
		if(subtree == null) {
			return 0;
		}
		// base case 2: size of a leaf is 1
		else if(subtree.left == null 
				&& subtree.right == null) {
			return 1;
		}
		else {
			return recursiveSize(subtree.left) +
					recursiveSize(subtree.right) +
					1; // for the root
		}
	}
		
	/*
	 * recursiveHeight returns the number of levels 
	 * of nodes in the tree
	 */
	public int recursiveHeight() {
		return recursiveHeight(overallRoot);
	}
	
	// private helper method with an extra parameter
	// "which subtree is this recursive call responsible
	// for?"
	private int recursiveHeight(Node<T> subtree) {
		// base case 1: size of an empty tree is 0
		if(subtree == null) {
			return 0;
		}
		// base case 2: size of a leaf is 1
		else if(subtree.left == null 
				&& subtree.right == null) {
			return 1;
		}
		else {
			return Math.max(recursiveHeight(subtree.left),
					recursiveHeight(subtree.right))
					+ 1; // for the root
		}
	}
		

	// helper method with an extra param to keep track
	// of which node each recursive call is examining
	private boolean add(T data, Node<T> node) {
		int comparison = data.compareTo(node.data);
		if(comparison < 0) {
			// before going left, if there is nothing there,
			// we found the place for our data
			if(node.left == null) {
				node.left = new Node<T>(data);
				size++;
				return true;
			}
			// go left
			return add(data, node.left);
		}
		else if(comparison > 0) {
			// before going right, if there is nothing there,
			// we found the place for our data
			if(node.right == null) {
				node.right = new Node<T>(data);
				size++;
				return true;
			}
			// go right
			return add(data, node.right);
		}
		else { // comparison == 0
			// trying to add a duplicate
			return false;
		}
	}
		
	
	/*
	 * printInOrder prints out all the data in the BST
	 * each on their own line using in order tree transversal
	 * 
	 * left root right
	 */
	public void printInOrder() {
		printInOrder(overallRoot);
	}
	
	private void printInOrder(Node<T> subtree) {
		//If we ever see an empty subtree, 
		//nothing to print, terminate the recursion
		
		if(subtree == null) {
			return;
		}
		
		//recursive call
		else {
			//1. print out everything in the left subtree
			printInOrder(subtree.left);
			//2. Print out the root
			System.out.println(subtree.data);
			//3. print out everything in the right subtree
			printInOrder(subtree.right);
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
		System.out.println(bst.recursiveSize());
		System.out.println(bst.recursiveHeight());
		bst.printInOrder();
	}
	
}
