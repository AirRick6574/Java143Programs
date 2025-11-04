package cs143Recursion;

public class Exponent {

	//There is no reason to do math exponent work.
	//It is included, we will do it anyway lol :D
	public static void main(String[] args) {
		System.out.println(Math.pow(2, 4));
		System.out.println(pow(2, 4));
	}
	
	/*
	 * pow(int a, int b) computes a^b recursively
	 * 
	 * pow(3,3) => 27
	 */
	
	public static int pow(int a, int b) {
		
		//base case 1
		if(b == 0) {
			return 1;
		}
		
		//Base case 2
		else if(b==1) {
			return a;
		}
		
		else {
			return (int) (a * pow(a, b - 1));
		}
	}
}
