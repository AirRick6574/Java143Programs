
public class LargestDigit {
	public static void main(String[] args) {
		System.out.println(largestDigit(8345965));
		System.out.println(largestDigit(-645));
	}
	
	/*
	 * largestDigit(int n) returns the largest digit
	 * in the parameter integer n
	 */
	public static int largestDigit(int n) {
		// negative case
		if(n < 0) {
			return largestDigit(-n);
		}
		return largestDigit(n, 0);
	}
	// helper method that uses an extra parameter
	// to track the largest digit seen so far
	private static int largestDigit(int n, int largestSoFar) {
		// base case: when n is 0, we are done with
		// all the digits, result is largestSoFar
		if(n == 0) {
			return largestSoFar;
		}
		else {
			// extract the rightmost digit
			int digit = n % 10;
			// is that digit bigger than the largest
			// digit seen so far?
			if(digit > largestSoFar) {
				// update
				return largestDigit(n / 10, digit);
			}
			else {
				// keep the same largestSoFar
				return largestDigit(n / 10, largestSoFar);
			}
		}
	}
	
}
