package uncheckedExceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Checked exceptions are exceptions that may occur for reasons other than programmer error. 
 * Java forces us to check for them
 * 
 * Example: FileNotFoundException
 */
public class CheckedExpcetions {
	
	public static void main(String[] args) throws FileNotFoundException {
		//saying the main method throws the FileNotFoundException
		//is basically like saying "I know a FileNotFoundException could occur
		//but i don't want to do anything about it
		
		try {
			//Code that could cause an exception
			Scanner s = new Scanner(new File("testFiles.txt"));
			while(s.hasNextLine()) {
				System.out.println(s.nextLine());
			}
		} catch (FileNotFoundException exception) {
			System.out.println("File does not exist");
			System.out.println(exception);
		} //finally block (run code no matter whether an exception has occurred or not
		//always executes right before we leave a try catch
		finally {
			System.out.println("Finally This is Done");
		}
	
	}
}
