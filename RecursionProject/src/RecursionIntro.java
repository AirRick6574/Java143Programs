
public class RecursionIntro {
	
	//Part 1:
	public static long eduodd(long n) {
		if (n < 0){
			return -eduodd(-n);
		} else if (n < 10) {
			if (n % 2 == 0) { //if digit is even, 1
				return (n + 1) % 10;
			} else { //if digit is odd, -1
				return (n + 9) % 10;
			}
		} else {
			if (n % 2 == 0) {
				return 10 * eduodd(n / 10) + (n + 1) % 10;
			} else {
				return 10 * eduodd(n / 10) + (n + 9) % 10;
			}
			
		}
	}
	
	//Part 2:
	public static int fibby(int n) {
		//base case: first two numbers are always 1
				if(n == 0) {
					return 1;
				} 
				
				//recursive case: the nth term is the sum of
				//n-1 and n-2 terms
				else {
					return fibby(n / 3) + fibby((2 * n) / 3);
				}
	}
	
	
	public static void printSparseTable(int start, int end) {
		printSparseTable(start, end, -1);
	}
	
	private static void printSparseTable(int start, int end, int prev) {
		if (start > end) {
			return;
		} 
		int fibbyVar = fibby(start);
		
		if (fibbyVar != prev) {
			System.out.println(start + " " + fibbyVar);
		}
		
		printSparseTable(start + 1, end, fibbyVar);
	}
	
	//Part 3:
	public static int lp2lt(int n) {
		return 0; //TODO implement
	}
	
	public static int champion(boolean[] a) {
		return 0; //TODO implement
	}
	
	public static void main(String[] args) {
		printSparseTable(4, 10);
		
		System.out.println();
		
		printSparseTable(10, 10);
	}
}
