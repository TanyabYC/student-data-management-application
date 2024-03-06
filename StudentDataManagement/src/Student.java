
// Student class
public class Student {

	public int id;	// declare a variable for the student's id number
	
	public String firstName, lastName;	// declare variables for the student's first name and last name	
	
	public AssignmentMarks mathMarks;	// declare a mathMarks object for AssignmentMarks class
	
	public AssignmentMarks englishMarks;	// declare an englishMarks object for AssignmentMarks class
	
	
	// Constructor of the class with parameters to initiate the student object
	public Student(int id, String firstName, String lastName) {
		
		this.id = id;	// set the parameter id number to this student's id number
		
		this.firstName = firstName;	// set the parameter firstName to this student's first name
		
		this.lastName = lastName;	// set the parameter lastName to this student's last name
		
	}	// end of method
	
	// Method to return the full name of the student
	public String getFullName() {
		
		return this.firstName + " " + this.lastName;	// return this student's full name with the first name and last name with a space in between
		
	}	// end of method
	
}	// end of Student class
