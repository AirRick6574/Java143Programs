/*
 * Simple java program that uses maps to analyze data from united states 2010 census
 */
import java.awt.image.DataBufferByte;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;


public class census {
	
	public static void main(String[] args) throws FileNotFoundException {
		//Attach scanner to csv
		Scanner s = new Scanner(new File("census.csv"));
		
		
		//Tree set containing all names
		Set<String> name = new TreeSet<String>();
		
		//Map from Last Names(String) to Data Objects
		//allow the user to look up information for a given value
		//last Name
		Map<String, censusData> namesToRecords 
			= new TreeMap<>(String.CASE_INSENSITIVE_ORDER); //case_Insesitive_Order will make it case insensitive
		
		//Map with int 
		Map<Integer, censusData> ranksToRecords = new TreeMap<>();
		
		
		//Move scanner to second line below the header
		s.nextLine(); //skip the line (header line)
		
		/*
		 * Index 0: name
		 * Index 1: Rank
		 * Index 2: count (number of people with this name)
		 * Index 3: prop100k (proportion per 100k people)
		 */
		while(s.hasNextLine()) {
			String[] row = s.nextLine().split(",");
			
			String names = row[0];
			
			//Parse Type will convert from String to its primitive type
			int rank = Integer.parseInt(row[1]);
			int count = Integer.parseInt(row[2]);
			Double prop100k = Double.parseDouble(row[3]);
			
			//Create data object for each row
			censusData d = new censusData(names, rank, count, prop100k);
			
			name.add(row[0]);
			
			namesToRecords.put(names, d);
			ranksToRecords.put(rank, d);
			//System.out.println(row[1]);
		}
		
		//System.out.println(names);
//		System.out.println(name.size());
//				
//		System.out.println(namesToRecords.get("WILSON"));
//		System.out.println(namesToRecords.get("anderson"));
//		System.out.println(namesToRecords.get("rios"));
//		
//		System.out.println(ranksToRecords.get(100));
		
		//System.out.println(name);
		//System.out.println(name.size());
		
		//Test scanner to see if file is attached
//		while(s.hasNextLine()) {
//			System.out.println(s.nextLine());
//		}
		
		//Second Scanner to read from Console
		Scanner in = new Scanner(System.in);
		while(in.hasNextLine()) {

			//did the user type an int?
			if(in.hasNextInt()) {
				System.out.println(ranksToRecords.get(in.nextInt()));
			}
			
			else {
				//assume they typed a name, grab the data
				//from the names map
				System.out.println(namesToRecords.get(in.next()));
			}
		}
		
	}
}
