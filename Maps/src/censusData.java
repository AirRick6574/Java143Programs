//Object that represents the first four columns from census data in a row
public class censusData {
	/*
	 * Index 0: name
	 * Index 1: Rank
	 * Index 2: count (number of people with this name)
	 * Index 3: prop100k (proportion per 100k people)
	 */
	
	private String names;
	
	//Parse Type will convert from String to its primitive type
	private int rank;
	private int count;
	private Double prop100k;
	
	
	
	public censusData(String names, int rank, int count, Double prop100kDouble) {
		this.names = names;
		this.rank = rank;
		this.count = count;
		this.prop100k = prop100kDouble;
	}
	
	@Override
	public String toString() {
		return "Data [name=" + names + ", rank=" + rank + ", count=" + count + ", prop100k=" + prop100k + "]";
	}



	public static void main(String[] args) {
		
	}
}
