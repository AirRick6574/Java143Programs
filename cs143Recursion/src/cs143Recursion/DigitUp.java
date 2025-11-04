package cs143Recursion;

public class DigitUp {
	public static int mystery(int n) {
		if (n < 0){
			return -mystery(-n);
		} else if (n < 10) {
			return (n + 1) % 10;
		} else {
			return 10 * mystery(n / 10) + (n + 1) % 10;
		}
	}
	
	public static int DigitupDigitDown(int n) {
		if (n < 0){
			return -DigitupDigitDown(-n);
		} else if (n < 10) {
			if (n % 2 == 0) { //if digit is even, 1
				return (n + 1) % 10;
			} else { //if digit is odd, -1
				return (n + 9) % 10;
			}
		} else {
			if (n % 2 == 0) {
				return 10 * DigitupDigitDown(n / 10) + (n + 1) % 10;
			} else {
				return 10 * DigitupDigitDown(n / 10) + (n + 9) % 10;
			}
			
		}
	}
	
	public static void main(String[] args) {
//		System.out.println(mystery(7)); //8
//		System.out.println(mystery(42)); //53
//		System.out.println(mystery(385)); //496
//		System.out.println(mystery(-790)); //-801
//		System.out.println(mystery(89294)); //90305
//		System.out.println(42/10); //90305
		
		System.out.println();
		System.out.println(DigitupDigitDown(7)); //6
		System.out.println(DigitupDigitDown(42)); //53
		System.out.println(DigitupDigitDown(385)); //294
		System.out.println(DigitupDigitDown(-790)); //-681
		System.out.println(DigitupDigitDown(89294)); //98385
	}
}
