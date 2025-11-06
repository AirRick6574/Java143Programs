/**
 * @Author Erick Ruiz
 * Class is a set of recursive methods that will all later be tested 
 * using a tester to determine if the function acts properly as expected
 * Some of these methods also include helper methods to assist or are dependent
 * on other functioning methods.
 */
public class RecursionIntroWComments {
	
	//Part 1: Even digits up, odd digits down
	/*
	 * Function is based on the midterm practice paper assignment in class.
	 * The original function was a reclusive function that added 1 to every single digit.
	 * This function includes additional checks to determine if digit (odd or even) will 
	 * go down or up 1. 
	 * (I feel like the additional check in the end makes the program feel redundant :/ )
	 */
	public static long eduodd(long n) {
		//Base Case: Flip Digit from negative to positive and then return negative
		if (n < 0){
			return -eduodd(-n);
		//Base Case: If digit is less than 10, enter Nested Loop
		//to determine if digit is odd or even
		} else if (n < 10) {
			if (n % 2 == 0) { //if digit is even, 1
				return (n + 1) % 10;
			} else { //if digit is odd, -1
				return (n + 9) % 10;
			}
		//Recursive Case: Will function different based on being odd or even 
		//to adjust the final digit
		} else {
			if (n % 2 == 0) {
				return 10 * eduodd(n / 10) + (n + 1) % 10;
			} else {
				return 10 * eduodd(n / 10) + (n + 9) % 10;
			}
			
		}
	}
	
	//Part 2: Fibby
	/*
	 * The Fibby method is based on the (slow O^N) fibonacci sequence (and method)
	 * that was shown in class. Fibby(n) is determined by N/3 + 2N / 3
	 */
	public static int fibby(int n) {
				//Base case: 0 will always be 1
				if(n == 0) {
					return 1;
				} 
			
				//Recursive Case: Began looping till all fibbys have been found
				//Function will keep looping until base case is reached: Fibby(0) = 1
				else {
					return fibby(n / 3) + fibby((2 * n) / 3);
				}
	}
	
	//Part 3: Sparse table generation
	/* Goal of method is to parse fibby method from start point to end point. 
	 * Will print out in order of N, fibby(N).
	 * Method will also not print out a sequence if the Fibby(N) matches the previous Fibby(N)
	 * 									Fibby(N) != Fibby(N-1)
	 * Method will call the helper method with the same name.
	 * This helper method will have an additional parameter known as previous.
	 * Helper method will be called with previous parameter being unusable (will not pass).
	 */
	public static void printSparseTable(int start, int end) {
		printSparseTable(start, end, -1);
	}
	
	//Helper Method
	private static void printSparseTable(int start, int end, int prev) {
		//Base Case: Ensure Start and End are valid. If not valid, end loop
		if (start > end) {
			return;
		}
		//Find First Fibby from start
		int fibbyVar = fibby(start);
		
		//Ensure Fibby is not same as previous, if not same,
		//Print out sequence
		if (fibbyVar != prev) {
			System.out.println(start + " " + fibbyVar);
		}
		
		//Begin Loop until loop has ended by Base Case
		printSparseTable(start + 1, end, fibbyVar);
	}
	
	//Part 3: Largest power of two less than
	/*
	 * Based off of the exponent method, it behaves very similar to the function apart 
	 * from a few checks that will calculate the next power to determine if it will be 
	 * larger than n. If larger than n, function will end loop and return highest power 
	 * before greater than N.
	 */
	public static int lp2lt(int n) {
				//base case 1
				if(n == 0) {
					return 1;
				}
				
				//Base case 2
				else if(n==1) {
					return 2;
				} 
				
				//Base Case 3
				else if (n == 2) {
					return 1;
				}
				
				//Reclusive Case: 
				//- Find Current Power
				//- Determine if next power is larger than n, if greater than N,
				//  end loop and return 
				//- Continue loop if current power is still less than N
				else {
					//save currentPower as variable;
					int currentPower = lp2lt(n - 1);
						//Check if doing next power will violate condition (less than n)
						//If condition will be violated, return current power
						if ((currentPower * 2) >= n) { 
							return (int) currentPower;
						//If condition is not violated continue power. 
						} else {
							//return (int) (2 * lp2lt(n - 1));
							return currentPower * 2;
						}
				}
	}
	
	//Part 3B: There can be only one
	/*
	 * Based off of Binary Search, this method will utilize a helper method that 
	 * will also utilize the lp2lt method. Method will take an array of boolean 
	 * which will represent two sides of a coin. The array will then be split into 
	 * pairs that will compare each other to determine the true champion. 
	 */
	public static int champion(boolean[] a) {
		return champion(a, 0, a.length - 1);
	}
	
	//Helper Method that will call itself
	private static int champion(boolean[] a, int start, int end) {
		//Base case: List is pair 
		if (start + 1 == end) {
			if (a[start] == a[end]){
				return end;
			} else {
				return start;
			}
		//Base Case: Check if pair even exists, if no pair exists, advance player. 
		} else if (start == end) {
			return start;
			
		//Begin Cycle: Find Mid, then use to split tournament based on output from
		//lp2lt. Will then find left and right side of champions and then will 
		//perform a final comparison to find the champion between the split sides. 
		} else {
			int mid = lp2lt(end - start + 1); 
			int leftChamp = champion(a, start, start + mid - 1);
			int rightChamp = champion(a, start +  mid, end);
			
			//After Cycle Complete, begin final compare to 
			//determine finalist winner (champion) 
			if (a[leftChamp] == a[rightChamp]) {
				return rightChamp;
			} else {
				return leftChamp;
			}
		}
	}
	
	//Debug/Test Code
	public static void main(String[] args) {
		printSparseTable(4, 10);
		
		System.out.println();
		
		printSparseTable(10, 10);
		
		System.out.println();
		System.out.println(lp2lt(0)); //should be 1
		System.out.println(lp2lt(2)); //should be 1
		System.out.println(lp2lt(5)); //should be 4
		System.out.println(lp2lt(8)); //should be 4
		System.out.println(lp2lt(3)); //should be 2
		System.out.println(lp2lt(4)); //should be 2
		
		System.out.println();
		
		boolean[] a = {false, false}; 
		System.out.println(champion(a)); //should have returned 1
		
		boolean[] b = {false, false, false, false}; 
		System.out.println(champion(b)); //should have returned 3
		
		boolean[] c = {false, false, false, false, false}; 
		System.out.println(champion(c)); //should have returned 4
		
		boolean[] d = {false, false, false, false, false, false}; 
		System.out.println(champion(d)); //should have returned 5
	}
}
