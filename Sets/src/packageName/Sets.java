package packageName;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

//-------------------SETS DO NOT HAVE INDEXES, CAN ONLY USE FOR EACH LOOP-----------------

//Sets are unordered and only care that the item is there
//Not position (no indexes)

//Sets do not allow duplicates
//Sets is an interface because there are multiple different types of interfaces

/*
 * HashSets
 * - Biggest benefit is that they are super fast.
 * -support adding, removing, and checking  for members
 * - in O(1) constant time.
 * - Do not guarantee any particular ordering
 * 
 * TreeSets
 */
public class Sets {
	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
		set.add("David");
		set.add("Pizza");
		set.add("Coffee");
		set.add("Chair");
		System.out.println(set); //Sets are unordered, Not same as entered.
		
		set.add("Pizza");  //DOES NOT ALLOW DUPLICATES
		System.out.println(set); //WILL IGNORE SECOND PIZZA
		
		System.out.println(set.remove("Coffee")); //True if removed, false if cannot remove (does not exists)
		System.out.println(set);
		
		System.out.println(set.remove("Mouse")); //True if removed, false if cannot remove (does not exists)
		System.out.println(set);
		
		System.out.println(set.contains("David")); //True
		System.out.println(set.contains("Mouse")); //false
		
		
		System.out.println();
		System.out.println();
		
		
		//----------------------------------------------------------------------------
		
		//TREE SET
		//Order their data alphabetically/numerically
		//Support adding, removing and checking for members
		//in O(Log N) log time
		Set<String> set2 = new TreeSet<>();
		set2.add("David");
		set2.add("Pizza");
		set2.add("Coffee");
		set2.add("Chair");
		System.out.println(set2); //Sets are ordered alphabetically
		
		set2.add("Pizza");  //DOES NOT ALLOW DUPLICATES
		System.out.println(set2); //WILL IGNORE SECOND PIZZA
		
		System.out.println(set2.remove("Coffee")); //True if removed, false if cannot remove (does not exists)
		System.out.println(set2);
		
		System.out.println(set2.remove("Mouse")); //True if removed, false if cannot remove (does not exists)
		System.out.println(set2);
		
		System.out.println(set2.contains("David")); //True
		System.out.println(set2.contains("Mouse")); //false
		
		System.out.println();
		
		//Sets can do this but not normal loops cuz they have an iterator
		for(String s : set2) {
			System.out.println(s);
		}
	}
}
