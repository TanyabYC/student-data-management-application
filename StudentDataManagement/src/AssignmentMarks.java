
// AssignmentMarks class
public class AssignmentMarks {
	
	private String courseName = "";	// declare and initialise a variable to hold the course name
	
	private int assignment1, assignment2, assignment3;	// declare variables to hold the student's assignment marks 1, 2, and 3


	// Constructor that assigns class variables to the values passed in the parameters
	public AssignmentMarks(String name, int mark1, int mark2, int mark3) {
				
		this.courseName = name;		// set the parameter course name to this student's course name
		
		this.assignment1 = mark1;	// set the parameter assignment 1 mark to this student's assignment 1 mark
		
		this.assignment2 = mark2;	// set the parameter assignment 2 mark to this student's assignment 2 mark
		
		this.assignment3 = mark3;	// set the parameter assignment 3 mark to this student's assignment 3 mark
		
	}	// end of method

	// Method to set the mark of the assignment based on the parameters passed within the method
	public void setMark(int assignmentNumber, int mark) {
		
		// if the assignment number passed in the parameter is equal to 1, execute this block of code
		if (assignmentNumber == 1) {
			
			this.assignment1 = mark;	// set the mark passed in the parameter to the mark for assignment 1
			
		}	// end of if statement
		
		// if the assignment number passed in the parameter is equal to 2, execute this block of code
		else if (assignmentNumber == 2) {
			
			this.assignment2 = mark;	// set the mark passed in the parameter to the mark for assignment 2
			
		}	// end of else if statement
		
		// if the assignment number passed in the parameter is equal to 3, execute this block of code
		else if (assignmentNumber == 3) {
			
			this.assignment3 = mark;	// set the mark passed in the parameter to the mark for assignment 3
			
		}	// end of else statement
		
	}	// end of method
	
	// Method to return the mark for the assignment number passed in the parameter
	public int getMark(int assignmentNumber) {
		
		int mark = -1;	// declare and initialise a variable to hold the assignment mark
		
		// if the assignment number passed in the parameter is equal to 1, execute this block of code
		if (assignmentNumber == 1) {
			
			mark = assignment1;	// set mark to assignment 1 mark
			
		}	// end of if statement
		
		// if the assignment number passed in the parameter is equal to 2, execute this block of code
		else if (assignmentNumber == 2) {
			
			mark = assignment2;	// set mark to assignment 2 mark
			
		}	// end of else if statement

		// if the assignment number passed in the parameter is not equal to 1 or 2 then it is 3, therefore execute this block of code
		else if (assignmentNumber == 3)  {
			
			mark = assignment3;	// set mark to assignment 3 mark
			
		}	// end of else statement
		
		return mark;	// return the mark for the assignement number passed in the parameter
		
	}	// end of method
		
	// Method to return the average marks for the course based on all three assignment marks
	public int getAverageMark() {
		
		return (this.assignment1 + this.assignment2 + this.assignment3) / 3;	// return the average mark by adding all three assignment marks and dividing it by 3
		
	}	// end of method
	
	// Method to return the grade for the assignment number passed in the parameter
	public String getGrade(int assignmentNumber) {
		
		int mark = getMark(assignmentNumber);	// declare and initialise a variable that holds the mark for the assignment number passed in the parameter
		
		String grade = markToGrade(mark);	// declare and initialise a variable that holds the grade for the mark passed in the method's parameter
		
		return grade;	// return the grade for the assignment number passed in the parameter of this method
		
	}	// end of method

	// Method to return the average grade for the course
	public String getAverageGrade() {
		
		int averageMark = getAverageMark();	// declare and initialise a variable that holds the average mark for the course
		
		String averageGrade = markToGrade(averageMark);	// declare and initialise a variable that holds the average grade for the average mark passed in the method's parameter
		
		return averageGrade;	// return the average grade for the course
		
	}	// end of method
	
	// Method to return the grade based on the mark passed in the parameter
	public String markToGrade(int mark) {
		
		String grade = "";	// declare and initialise a variable for the grade that will be returned by this method
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 95, execute this block of code
		if (mark >= 95 && mark <= 100) {
			
			grade = "A+";	// set the grade
			
		}	// end of if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 90, execute this block of code
		else if (mark >= 90) {
			
			grade = "A";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 85, execute this block of code
		else if (mark >= 85) {
			
			grade = "A-";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 80, execute this block of code
		else if (mark >= 80) {
			
			grade = "B+";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 75, execute this block of code
		else if (mark >= 75) {
			
			grade = "B";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 70, execute this block of code
		else if (mark >= 70) {
			
			grade = "B-";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 60, execute this block of code
		else if (mark >= 60) {
			
			grade = "C+";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 50, execute this block of code
		else if (mark >= 50) {
			
			grade = "C";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than 40, execute this block of code
		else if (mark > 40) {
			
			grade = "C-";	// set the grade
			
		}	// end of else if statement
		
		// if the mark for the assignment number passed in the parameter is higher than or equal to 0, execute this block of code
		else if (mark >= 0) {
			
			grade = "D";	// set the grade
			
		}	// end of else if statement
					
		return grade;	// return the grade
		
	}	// end of method
	
	// Method to set the name of the course to the name passed in the parameter
	public void setCourseName(String name) {
		
		this.courseName = name;	// set the name of the course to the name passed in the parameter
		
	}	// end of method
	
	// Method to return the name of the course
	public String getCourseName() {
		
		return this.courseName;	// return the name of the course
		
	}	// end of method

}	// end of AssignmentMarks class
