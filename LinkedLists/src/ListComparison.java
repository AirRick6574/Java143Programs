import java.util.ArrayList;
import java.util.LinkedList;

/*
 * Both ArrayLists and LinkedLists are tools in Java
 * that can be used to solve the same type of problem
 * 
 * ArrayLists are faster at getting back data
 * 
 * LinkedLists are faster at adding data
 */
public class ListComparison {
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(1);
		al.add(2);
		al.add(3);
		al.add(4);
		System.out.println(al);
		al.add(5);
		System.out.println(al);
		System.out.println(al.get(4));
		System.out.println("==============");
		LinkedList<Integer> ll = new LinkedList<>();
		ll.add(1);
		ll.add(2);
		ll.add(3);
		ll.add(4);
		System.out.println(ll);
		ll.add(5);
		System.out.println(ll);
		System.out.println(ll.get(4));
	}
}
