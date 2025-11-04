import java.util.Stack;

public class Parentheses {
	/*
	 * isBalanced(String expr) returns true if expr
	 * represents a math expression with balanced
	 * parentheses. 
	 * 
	 * Every opening paren has a matching closing paren.
	 * 
	 * Broken solution. Works sometimes, but not on exprs
	 * like )) 1 + 2 ((
	 */
//	public static boolean isBalanced(String expr) {
//		int openCount = 0; // how many (
//		int closeCount = 0;// how many )
//		// use a loop to count up how many "(" and ")"
//		// exist in the string
//		for(int i = 0; i < expr.length(); i++) {
//			// does index i in the string contain a "("
//			if(expr.charAt(i) == '(') {
//				 openCount++;
//			}
//			else if(expr.charAt(i) == ')') {
//				closeCount++;
//			}
//		}
//		return openCount == closeCount;
//	}
	
	/*
	 * () [] {} <>
	 */
	public static boolean isBalanced(String expr) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i < expr.length(); i++) {
			// does index i in the string contain a "("
			if(expr.charAt(i) == '(') {
				// push the opening paren to the stack
				stack.push('(');
			}
			// does index i in the string contain a ")"
			else if(expr.charAt(i) == ')') {
				// if the stack is empty, there is
				// no opening paren to match this closing
				// paren to

				if(stack.empty()) {
					return false;
				}
				// match it to the opening paren
				// on top of the stack by doing a pop
				stack.pop();
			}
		}
		
		// at the end, if the stack is empty, balanced
		// parens
		return stack.empty();
	}
	
	public static void main(String[] args) {
		System.out.println(isBalanced("(1 + 2) * (2 + 3)"));
		System.out.println(isBalanced("((1 + 2) * 3)"));
		
		System.out.println(isBalanced("(( 1 + 2 ))"));
		System.out.println(isBalanced(")) 1 + 2 (("));
	}
}
