
//For loop
//This method uses a for each loop
public class ForEach {
	public static void main(String[] args) {
		int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		int sum = 0;
		for(int x : a) {
			sum = sum + x;
		}
		System.out.println(sum);
	}
}
