package warehouse;

/**
 * The @code Warehouse class will mimic a simple inventory . It will utilize multiple 
 * functions such to constantly manipulative warehouse stock as well as receiving and shipping.  
 * It will store item codes in a fixed-sized array upon creation while enforcing a limit 
 * on the amount of stock of an item code that will be allowed. 
 * @author Erick Ruiz
 */
public class Warehouse {
	//max total number of items in the warehouse
	private int size;
	
	//limit per item code
	private int limitPerItem;
	
	//Integer array to store the ID's of the items in the warehouse
	private int[] warehouse; 
	
	
	/**
	 * Constructor method that will utilize the two int parameters to create 
	 * a empty warehouse with size based on Int Size and limit per item based on
	 * Int limitPerItem. 
	 * @param size Int parameter that is used to define size of warehouse
	 * @param limitPerItem Int Parameter that is used to define limit of each item Code
	 */
	public Warehouse(int size, int limitPerItem) {
		this.size = size;
		this.limitPerItem = limitPerItem;
		this.warehouse = new int[size]; 
	}
	
	/**
	 * returns the current size of the warehouse object, gets size variable.
	 * @return size of warehouse
	 */
	public int getSize() {
		return size;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getLimitPerItem() {
		return limitPerItem;
	}
	
	/**
	 * Receives stocks of specific item and updates to warehouse storage.
	 * Method will also consider limit of items per item code when updating.
	 * 
	 * @param itemCode Parameter that defines the specific item the warehouse is receiving. 
	 * @param itemCount Parameter that defines the amount of items the warehouse is receiving. 
	 * @return Amount that the warehouse cannot receive. 
	 */
	public int receive(int itemCode, int itemCount) {
		
		//tally how many empty space we have filled
		int numReceived = 0;
		int limitCounter = 0;
		
		for (int j = 0; j < warehouse.length; j++) {
			if (warehouse[j] == itemCode) {
				limitCounter++;
			}
		}
		
		//for loop that scans the array searching
		//for empty spaces to fill in with itemCode
		for(int i = 0; i < warehouse.length; i++) {
			if (numReceived == itemCount) {
				break;
			}
			
			if (warehouse[i] == 0 && !(limitCounter == limitPerItem)) {
				
				warehouse[i] = itemCode;
				//tally onto numRecieved
				numReceived++;
				limitCounter++;
			}
		}
		//Return the number of output;
		return itemCount - numReceived;
	}
	
	/**
	 * Method that will ship out specific amount of itemCode and will update
	 * in the warehouse array.
	 * @param itemCode Specific item to be shipped. 
	 * @param itemCount Requested amount shipped.
	 * @return Amount of items shipped.
	 */
	public int ship(int itemCode, int itemCount) {

		//tally how many empty space we have filled
		int numReceived = 0;
		int itemShipped = 0; 
		
		
		for(int i = 0; i < warehouse.length; i++) {
			if (numReceived == itemCount) {
				break;
			}
					
			if (warehouse[i] == itemCode && !(itemShipped == itemCount)) {
				warehouse[i] = 0;
				itemShipped++;
			}
		}
		//Return the number of shipped items;
		return itemShipped;
	}
}
