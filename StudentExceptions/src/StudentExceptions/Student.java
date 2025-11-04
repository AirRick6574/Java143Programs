package StudentExceptions;


import java.util.Arrays;
import java.util.List;

/**
 * @author Erick Ruiz
 * This Java class is a simplified representation of Student at TCC. 
 * The class will be filled with variables such as age, name and major. 
 * This class will also perform checks to verify each variable has passed certain conditions.
 * If conditions were not passed (IE name is null), then an exception will be throw. 
 */
public class Student {
    private String name;
    private int age;
    private String major;

    public static final String[] MAJORS = {
            "Computer Science", "Mechanical Engineering", "Electrical Engineering", "Biomedical Engineering",
            "Chemical Engineering", "Aerospace Engineering", "Civil Engineering", "Physics", "Mathematics",
            "Biology", "Chemistry", "Environmental Science", "Robotics Engineering", "Materials Science",
            "Nuclear Engineering", "Biochemistry", "Geology", "Astronomy", "Statistics", "Computer Engineering"
    };

    /*
     Throws exception when constructing a student when the name and majors null. 
     Also throws if The age is not at least 13 (inclusive).
     Additionally, Also throws if the major is not within the above array of valid majors.
    */
    public Student(String name, int age, String major){
    	this.name = name;
    	this.age = age;
    	this.major = major;
    	
    	if (name == null) {
    		throw new NullPointerException("Name Cannot Be Null!");
    	}
    	if (major == null) {
    		throw new NullPointerException("Major Cannot Be Null!");
    	}
    	if (age < 13) {
    		throw new ArithmeticException("Age Must Be Over 13!");
    	}
    	//Convert to list for comparison 
    	List<String> majorsList = Arrays.asList(MAJORS);
    	if (!majorsList.contains(major)) {
    		throw new IllegalArgumentException("Major Input Was Not Accepted");
    	}
    	
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getMajor() {
        return major;
    }

    /*
        Increases the age of a student by the specified amount.
        Throws exception if student number is not positive
     */
    public void increaseAge(int amount){
    	if (amount <= 0) {
			throw new IllegalArgumentException("Increase Age Amount Cannot Be Negative");
		}
        this.age = this.age + amount;
    }

    /*
        Changes the major of a student to the specified String.
        Throws Exception if Major is not in Array
     */
    public void changeMajor(String major){
    	//Convert to list for comparison 
    	List<String> majorsList = Arrays.asList(MAJORS);
    	if (!majorsList.contains(major)) {
    		throw new ArithmeticException("Major Input Was Not Accepted");
    	}
        this.major = major;
    }

    /*
        Given an array of students, returns the average age.
     */
    public static double averageAge(Student[] students){
    	
    	int totalAge = 0 ;
    	int numberOfStudents = students.length;
    	int numOfNullStudents = 0;
    	
    	
    	for (int i = 0; i < numberOfStudents; i++) {
    		try {
    			totalAge = totalAge + students[i].getAge();
				
			} catch (NullPointerException e) {
				System.out.println("Student " + i + " is null! Skipping Student");
				numOfNullStudents++;
			}
    	}
        
    	//Account for Null Students
        return totalAge / (numberOfStudents - numOfNullStudents);
    }
}
