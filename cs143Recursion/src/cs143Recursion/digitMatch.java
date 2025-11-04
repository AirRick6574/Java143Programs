package cs143Recursion;

public class digitMatch {
	/*
	 * digitMatch will get two parameters (int m, int n) and return the number of digits
	 * that matches between n and m. A digit is matched if it is the same value in the 
	 * same position in the numbers
	 * 
	 * Example: 
	 * 	38
	 * 	58
	 * 
	 * 	 8
	 * 1 Match (8)
	 * 
	 * 	123426789
	 * 	   222222
	 * 		
	 * 		2
	 * 1 Match (2)
	 */
	public static int digitMatch(int n, int m) {
		//CASE 0:
		// if either n or m (or both) are negative,
		// throw exception
		if(n < 0 || m < 0) {
			throw new IllegalArgumentException();
		}
		
		//CASE 1: SINGLE DIGITS
		// is either n or m a single digit number?
		else if(n < 10 || m < 10) {
			// does the single digit number match the rightmost
			// digit of the other number?
			//Using mod (%) 10 will always return rightmost digit of n
			if(n % 10 == m % 10) {
				return 1;
			}
			else {
				return 0;
			}
		}
		
		//Case 2: Multiple digits
		else {
			
			//CASE 2A: 
			// both n and m have more than one digit
			// compare their rightmost digits with the mod operator
			// divide by 10 to move on to the next digits
			if(n % 10 == m % 10) {
				return 1 + digitMatch(n / 10, m / 10);
			}
			else {
				return digitMatch(n / 10, m / 10);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(digitMatch(1234, 1344));
		System.out.println(digitMatch(123456, 12345678));
		System.out.println(digitMatch(12345600, 12345678));
		System.out.println(digitMatch(-1, 12345678));
	}
}
