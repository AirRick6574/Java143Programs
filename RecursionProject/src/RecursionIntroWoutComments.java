
public class RecursionIntroWoutComments {
	
	
	public static long eduodd(long n) {
		
		if (n < 0){
			return -eduodd(-n);
		
		} else if (n < 10) {
			if (n % 2 == 0) { 
				return (n + 1) % 10;
			} else { 
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
	
	
	public static int fibby(int n) {
				
				if(n == 0) {
					return 1;
				} 
			
				
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
	
	
	public static int lp2lt(int n) {
				
				if(n == 0) {
					return 1;
				}
				
				
				else if(n==1) {
					return 2;
				} 
				
				
				else if (n == 2) {
					return 1;
				}
				
				else {
					
					int currentPower = lp2lt(n - 1);
						
						if ((currentPower * 2) >= n) { 
							return (int) currentPower;
						
						} else {
							
							return currentPower * 2;
						}
				}
	}
	
	
	public static int champion(boolean[] a) {
		return champion(a, 0, a.length - 1);
	}
	
	
	private static int champion(boolean[] a, int start, int end) {
		
		if (start + 1 == end) {
			if (a[start] == a[end]){
				return end;
			} else {
				return start;
			}
		
		} else if (start == end) {
			return start;
			
		
		} else {
			int mid = lp2lt(end - start + 1); 
			int leftChamp = champion(a, start, start + mid - 1);
			int rightChamp = champion(a, start +  mid, end);
			
			
			if (a[leftChamp] == a[rightChamp]) {
				return rightChamp;
			} else {
				return leftChamp;
			}
		}
	}
	
	
	public static void main(String[] args) {
		printSparseTable(4, 10);
		
		System.out.println();
		
		printSparseTable(10, 10);
		
		System.out.println();
		System.out.println(lp2lt(0)); 
		System.out.println(lp2lt(2)); 
		System.out.println(lp2lt(5)); 
		System.out.println(lp2lt(8)); 
		System.out.println(lp2lt(3)); 
		System.out.println(lp2lt(4)); 
		
		System.out.println();
		
		boolean[] a = {false, false}; 
		System.out.println(champion(a)); 
		
		boolean[] b = {false, false, false, false}; 
		System.out.println(champion(b)); 
		
		boolean[] c = {false, false, false, false, false}; 
		System.out.println(champion(c)); 
		
		boolean[] d = {false, false, false, false, false, false}; 
		System.out.println(champion(d)); 
	}
}
