import java.util.Arrays;


//Treat 0 as special symbol for an empty space in the warehouse
/*
 * Example:
 * (99, 99, 0, 0, 101, 101}
 * 2 boxes of item 99
 * 2 boxes of item 101
 * 2 empty spaces
 */


public class SimpleWarehouse {
	
	//max total number of items in the warehouse
	private int size;
	
	//Integer array to store the ID's of the items in the warehouse
	private int[] warehouse; 
	
	
	
	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int[] getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(int[] warehouse) {
		this.warehouse = warehouse;
	}

	/*
	 * Constructor for an empty warehouse
	 * no items re currently stored
	 */
	public SimpleWarehouse(int size){
		if(size < 1) {
			throw new IllegalArgumentException("Size must be more than 1");
		}
		this.size = size; //change included parameter to public global int
		this.warehouse = new int[size]; //This will change warehouse array to be size of int size

	}
	
	
	/*
	 * stock(int itemCode) returns the number of occurrences
	 * of itemCode in the warehouse
	 * 
	 * returns 0 for non-existance items
	 */
	public int stock(int Itemcode) {
		//variable ot track how many times we have seen "itemCode"
		int stock = 0;
		//loop thru the array, counting up how many times
		//we see "itemcode"
		
		for(int i = 0; i < warehouse.length; i++) {
			if (warehouse[i] == Itemcode) {
				stock++;
			}
		}
		return stock;
	}
	
	/*
	 * contians (int ItemCode) returns true if the warehouse contains
	 * at least one of the specified itemCode
	 * 
	 * returns false if the itemCount if the itemCode does not exist
	 */
	//if stock method contains stock by calling contains
	public boolean contains (int itemCode) {
		return stock(itemCode) != 0; //check if stock returns 0, return 0 if 0
	}
	
	
	@Override
	public String toString() {
		return "SimpleWarehouse [size=" + size + 
				", warehouse=" + Arrays.toString(warehouse) + "]";
	}
	
	/*
	 * receive(int itemcode, int itemcount);
	 * Item code: type of item we are receiving 
	 * Item count: how many of them
	 * 
	 * [0,0,0,0,0]
	 * receive(101,2)
	 * [101,101,0,0,0]
	 * receive(99,2)
	 * [101,101,99,99,0]
	 */
	
	//Return how many boxes were not received (left over)
	//Assume the user does not enter negative numbers
	public int receive(int itemCode, int itemCount) {
		/*
		 * receive(int itemcode, int itemcount);
		 * Item code: type of item we are receiving 
		 * Item count: how many of them
		 * 
		 * for loop that scans the array searching
		 * for empty spaces to fill in with ItemCode
		 */
		
		//tally how many empty space we have filled
		int numReceived = 0;
		//for loop that scans the array searching
		//for empty spaces to fill in with itemCode
		
		for(int i = 0; i < warehouse.length; i++) {
			if (numReceived == itemCount) {
				break;
			}
			if (warehouse[i] == 0) {
				//fill it in with the itemCode
				warehouse[i] = itemCode;
				//tally onto numRecieved
				numReceived++;
			}
		}
		//Return the number of output;
		return itemCount - numReceived;
	}
	
}
