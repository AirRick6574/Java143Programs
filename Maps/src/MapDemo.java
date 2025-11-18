import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/*
 * HashMaps support all basic operations in O(1) constant
 * time but do not guarantee any ordering of pairs.
 * 
 * TreeMaps order their pairs alphabetically by key,
 * all basic operations are O(log n) logarithmic time.
 */
public class MapDemo {
	public static void main(String[] args) {
		Map<String, Integer> phonebook = new TreeMap<>();
		// add a pair/mapping from David to 111
		phonebook.put("Alex", 111);
		phonebook.put("David", 111);
		phonebook.put("Dakota", 151);
		phonebook.put("Sophie", 171);
		phonebook.put("Sophia", 200);
		phonebook.put("Sam", 300);
		phonebook.put("Fela", 400);
		System.out.println(phonebook);
		// if we do a put on a key that already exists,
		// overrides that key's value with the new value
		phonebook.put("Sam", 500);
		System.out.println(phonebook);
		phonebook.remove("Alex");
		System.out.println(phonebook);
		// what is the value that Fela maps to?
		// what is Fela's phone number?
		System.out.println(phonebook.get("Fela"));
		System.out.println(phonebook.get("David"));
		// null because Paul is not a key
		// if the key exits, getOrDefault returns its value
		// if the key does not exist, getOrDefault returns
		// its second parameter
		System.out.println(phonebook.getOrDefault("Paul", 0));
		
		// looping through a map
		// we loop through the set of keys, use
		// the get method to get the value from each of those
		// keys
		Set<String> keys = phonebook.keySet();
		System.out.println(phonebook.get("David"));
		
		for(String k : keys) {
			System.out.println(k + "\t" + phonebook.get(k));
		}
	}
}
