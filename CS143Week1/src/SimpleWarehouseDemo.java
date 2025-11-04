
public class SimpleWarehouseDemo {
	public static void main(String[] args) {
		SimpleWarehouse SW = new SimpleWarehouse(5); //create new object with warehouse size at 5
		
		System.out.println(SW.getSize() + " Fortnite"); //method used that was created by source to access private variables
		
		System.out.println(SW);
		System.out.println(SW.toString());
		
		
		System.out.println(SW.receive(101, 2)); //cntl shift b to toggle breakpoint, 
		System.out.println(SW);
		
		System.out.println(SW.receive(99, 2));
		System.out.println(SW);
		
		System.out.println(SW.receive(88, 3));
		System.out.println(SW);
		
		System.out.println("Stock Count: " + SW.stock(15));
		System.out.println("Stock Count: " + SW.stock(88));
		
		System.out.println();
		
		SimpleWarehouse SW2 = new SimpleWarehouse(5); //create new object with warehouse size at 5
		System.out.println(SW2.receive(101, 2)); //cntl shift b to toggle breakpoint, 
		System.out.println(SW2);
		System.out.println(SW2.receive(101, 2)); //cntl shift b to toggle breakpoint, 
		System.out.println(SW2);
		System.out.println(SW2.receive(101, 2)); //cntl shift b to toggle breakpoint, 
		System.out.println(SW2);
		
		SimpleWarehouse SW3 = new SimpleWarehouse(0); //create new object with warehouse size at 5
		
		//finally block (run code no matter whether an exception has occurred or not
		//always executes right before we leave a try catch
	}
}
