import java.util.InputMismatchException;	// used for error checking
import java.util.LinkedList;	// used to create a LinkedList abstract data type
import java.io.File;			// used to access a text file
import java.util.Scanner;		// used to receive user input

// Main Class - StudentDataManagement
public class StudentDataManagement {
	
	private static LinkedList<Student> allStudents;	// declare a variable to hold the list for all students
	
	private static Scanner userInput;	// declare a scanner object as a class field so that it and the connection to the user's computer can be closed once the user exits the program
	

	// Method 'main' to be executed at runtime of the program
	public static void main(String[] args) {
		
		System.out.println("Student Data Management Program\n\n");	// display menu heading to the user
		
		allStudents = new LinkedList<Student>();	// initialise the list for all students
		
		String studentDataFile = "C:/Temp/studentdata.txt";	// declare the path to the student data file on a Microsoft computer
		
				
		// if student data file passed in the parameter of the readFile method was read successfully, execute this block of code
		if (readFile(studentDataFile)) {			

			boolean tasksCompleted = false;	// declare and initialise a variable to indicate whether the user has completed their task
			
			
			// loop to continue until the user has completed all tasks and want to exit the program
			while (!tasksCompleted) {

				displayMenu();	// call a method to display the menu to the user

				int menuOption = selectMenuOption();	// declare and initialise a variable to hold the menu option entered by the user
				
				
				// switch between the menu options entered by the user
				switch (menuOption) {

					// display individual student marks, if menu number option entered by the user is 1
					case 1: {

						displayStudentMarks();	// call a method to display individual student marks
						
						System.out.println();	// add program spacing
						
						System.out.println();	// add program spacing
						
						continue;	// break the switch statement and continue with the while loop
						
					}	// end of case 1
					
					// display a table of all student marks, including marks and average grade for each course, if menu number option entered by the user is 2
					case 2: {

						displayReportByMarks();	// call a method to display a list of all students with their student marks
						
						System.out.println();	// add program spacing
						
						System.out.println();	// add program spacing

						continue;	// break the switch statement and continue with the while loop
						
					}	// end of case 2
					
					// display individual student grades, if menu number option entered by the user is 3
					case 3: {
						
						displayStudentGrades();	// call a method to display individual student grades
						
						System.out.println();	// add program spacing
						
						System.out.println();	// add program spacing

						continue;	// break the switch statement and continue with the while loop
						
					}	// end of case 3
					
					// display a table of all student grades, including marks and average grade for each course, if menu number option entered by the user is 4
					case 4: {

						displayReportByGrades();	// call a method to display a list of all the students with their student letter grades
						
						System.out.println();	// add program spacing
						
						System.out.println();	// add program spacing

						continue;	// break the switch statement and continue with the while loop
						
					}	// end of case 4
					
					// add new student, if menu number option entered by the user is 5
					case 5: {
						
						addNewStudent();	// call a method to add a student to the list of students
						
						System.out.println("\nThe student has been successfully added to the list of students!");	// notify the user that they have successfully added a student to the list
						
						System.out.println();	// add program spacing
						
						System.out.println();	// add program spacing

						continue;	// break the switch statement and continue with the while loop
						
					}	// end of case 5
					
					// remove student, if menu number option entered by the user is 6
					case 6: {

						removeStudent();	// call a method to remove a student from the list of students
						
						System.out.println();	// add program spacing
						
						System.out.println();	// add program spacing

						continue;	// break the switch statement and continue with the while loop
						
					}	// end of case 6
					
					// exit the program, if menu number option entered by the user is 7
					case 7: {
						
						userInput.close();	// close the connection to the user's system and the scanner object

						System.out.println("\nThe connection to your computer has been closed.");	// display operations completed by the program to the user
						
						tasksCompleted = true;	// exit the while loop
						
					}	// end of case 7
					
					// exit the program, if the menu option returns -1
					default: {
						
						tasksCompleted = true;	// exit the while loop
												
					}	// end of default
					
				}	// end of switch statement
				
			}	// end of while loop
			
			
			// The user has decided to end the program, therefore, execute the following lines of code
			
			System.out.println("\nThe program will now exit!");	// inform the user that the program will exit
			
			System.exit(0);	// exit the program				
			
		}	// end of if statement
		
		// the student data file could not be read, therefore, execute this block of code
		else {

			System.err.println("Error found: The text file 'C:\\Temp\\studentdata.txt' could not be read.");	// display error message to the user confirming the file name and path the program is trying to read
			
			System.out.println("\nBefore running this program again, please ensure:\n\n\t1.)\tthe file is accessible\n\n\t2.)\tthe file is saved in the correct location\n\n\t3.)\teach data element is separated with a comma (,)\n");	// display instruction to the user to help troubleshoot the issue

			System.out.println("The program will now exit...");	// inform the user that the program will exit
			
			System.exit(0);	// exit the program
			
		}	// end of else statement
		
	}	// end of the main method
	
	// Method to read the text file passed in the parameter
	public static boolean readFile(String fileName) {
		
		File file = new File(fileName);	// declare and initialise a File object by accessing the file "studentdata.txt" in the "Temp" folder on the "C:" drive
		
		
		/* try statement to declare and initialise a Scanner object that scans the "studentdata.txt" file
		 * and to declare and initialise a string array of data, read from the "studentdata.txt" file, separated by a comma (,)			
		 */
		try {
			
			Scanner scanner = new Scanner(file);	// scan through the "studentdata.txt" file as an input


			// whilst scanning the "studentdata.txt" file and there is another line of data in the file, execute this block of code
			while (scanner.hasNextLine()) {

					String[] words = scanner.nextLine().split(",");	// save the words found in the student data file into a string array, separated by a comma (,)

					// declare and initialise student variables				
					int id = Integer.parseInt(words[0]);	// declare and initialise a variable to hold the student's id	
					
					String firstName = words[1];			// declare and initialise a variable to hold the student's first name	
					
					String lastName = words[2];				// declare and initialise a variable to hold the sudent's last name				
					
					int mathMark1 = Integer.parseInt(words[3]);		// declare and initialise a variable to hold the student's Mathematics mark for assignment 1	
					
					int mathMark2 = Integer.parseInt(words[4]);		// declare and initialise a variable to hold the student's Mathematics mark for assignment 2	
					
					int mathMark3 = Integer.parseInt(words[5]);		// declare and initialise a variable to hold the student's Mathematics mark for assignment 3	
					
					int englishMark1 = Integer.parseInt(words[6]);	// declare and initialise a variable to hold the student's English mark for assignment 1	
					
					int englishMark2 = Integer.parseInt(words[7]);	// declare and initialise a variable to hold the student's English mark for assignment 2	
					
					int englishMark3 = Integer.parseInt(words[8]);	// declare and initialise a variable to hold the student's English mark for assignment 3
					
					
					// call a method to add this student to the list of students by passing the values of student variables in the method parameters
					addStudent(id, firstName, lastName, mathMark1, mathMark2, mathMark3, englishMark1, englishMark2, englishMark3);
				
				
			}	// end of while loop
			
			
			/* scanning of the "studentdata.txt" file was completed successfully
			 * and the words found in the student data file, separated by a comma (,), was successfully saved into a string array,
			 * exectue the following lines of code
			 */
			
			scanner.close();	// close the Scanner object and the connection to the "studentdata.txt" file
			
		}	// end of try statement
		
		/* catch statement to handle errors when reading the student data file
		 * and the file was not found 
		 * or could not be read successfully because data elements in the file were not separated with a comma (,), 
		 * execute this block of code
		 */
		catch (Exception e) {
			
			return false;	// the file could not be read successfully, therefore return false to the main menu 
			
		}	// end of catch statement
		
		
		// the file was read successfully, execute the following lines of code
		
		return true;	// return true to the main menu 
		
	}	// end of method
	
	// Method to add a new student to the list of students with the values in the parameters
	private static void addStudent(int id, String firstName, String lastName, int mathsMark1, int mathsMark2, int mathsMark3, int englishMark1, int englishMark2, int englishMark3) {
		
		Student student = new Student(id, firstName, lastName);	// create a new Student object and assign the object with values from the method parameters
		
		AssignmentMarks mathsMark = new AssignmentMarks("Mathematics", mathsMark1, mathsMark2, mathsMark3);	// create and initialise a new AssignmentMarks object for the Mathematics marks with values from the method's parameters 
		
		AssignmentMarks englishMark = new AssignmentMarks("English", englishMark1, englishMark2, englishMark3);	// create and initialise a new AssignmentMarks object for the English marks with values from the method's parameters 
		
		student.mathMarks = mathsMark;	// assign the AssignmentMarks object for the maths mark to the Student object
		
		student.englishMarks = englishMark;	// assign the AssignmentMarks object for the english mark to the Student object	
		
		allStudents.add(student);	// add the student to the list of students
		
	}	// end of method

	// Method to add a new student to the list of students as specified by the user
	private static void addNewStudent() {
		
		System.out.println("\n\nAdd New Student:");	// display a heading
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");	// display a line underneath the heading
		
		int lastID = 0;	// declare and initialise a variable to hold the last student id number
		

		// if the list of students has entries and is not empty, execute this block of code
		if (!allStudents.isEmpty()) {			
			
			// loop through the list of students
			for (Student s : allStudents) {
				
				lastID = s.id;	// assign the student's id number to the lastID variable
				
			}	// end of enhanced for loop
			
			
			// once the loop exits the lastID variable holds the id number for the last student in the list
			
			System.out.println("The last ID number in the list of students is '" + lastID + "'.");	// notify the user of the status of the last id number in the list
			
		}	// end of if statement
		
		// else the list of students has no entries and is empty, execute this block of code
		else {
			
			System.out.println("The students' list has no entries.");	// notify the user of the status of the student list
			
		}	// end of else statement
		
	
		// try statement to initialise a Scanner object and open a connection to the user's system/computer
		try {
			
			userInput = new Scanner(System.in);	// initialise the scanner object and open a connection to the user's system/computer to receive user input
			
			
			// run checks on the number entered by the user before assigning it to the following id number
			
			int id = -1;	// declare a variable to hold the student's id number
			
			boolean validInt = false;	// declare and initialise a variable to indicate whether the id number entered by the user is a valid integer number
			
			
			// loop while id number entered by the user is not a valid integer number
			do {

				// try statement to test the input from the user			
				try {
					
					int nextAvailableID = lastID + 1;	// declare and initialise a variable to hold the next available id number
					
					
					// if the list of students has entries and is not empty, execute this block of code
					if (!allStudents.isEmpty()) {

						// loop while the input from the user matches an id number in the list of students, execute this block of code
						do {

							// initial input from the user
							System.out.print("\nPlease enter the next available ID number '" + nextAvailableID + "' to add the student: ");	// ask the user to enter the next available id number to add a student
							
							id = userInput.nextInt();	// initialise the student's id number with the input from the user
							
							boolean idFoundInList = false;	// declare and initialise a variable to indicate whether the id number entered by the user is found in the list of students

							
							// loop through the list of students to compare the valid integer number entered by the user to the list of students
							for (Student s : allStudents) {
								
								// if the id number entered by the user is found in the list of students, execute this block of code
								if (id == s.id) {
									
									System.err.print("The entered ID number '" + id + "' is already added to the list of students. ");	// show error message to the user that the id number they entered is invalid
									
									System.out.println("Let's try again...");	// inform the user about the next step the program is taking
									
									idFoundInList = true;	// id number entered by the user is found in the list of students
									
									break;	// break the for loop
									
								}	// end of if statement
							
							}	// end of for loop		
							
							
							// if the id number entered by the user is not found in the list of students and is not the next available id number, execute this block of code
							 if (!idFoundInList && id != nextAvailableID) {
								
								System.err.print("The entered ID number '" + id + "' is not the \"next available ID number\" in the list of students. ");	// show error message to the user that the id number they entered is invalid
							
								System.out.println("Let's try again...");	// inform the user about the next step the program is taking
								
							}	// end of if statement							 
								
						} while (id != nextAvailableID);	// end of do while loop
						
					}	// end of if statement
					
					// else the list of students has no entries and is empty, execute this block of code
					else {
						
						System.out.print("\nPlease enter the ID number '" + nextAvailableID + "' to add the first student to the list: ");	// ask the user to enter the student's id number
						
						id = userInput.nextInt();	// initialise the student's id number with the input from the user
						
						
						// loop while the input from the user is not the next available id number in the list of students
						do {
							
							// if the id number entered by the user is not the next available id number, execute this block of code
							if (id != nextAvailableID) {
								
								System.err.print("The entered ID number '" + id + "' is not the \"first available ID number\" in the list of students. ");	// show error message to the user that the id number they entered is invalid
							
								System.out.println("Let's try again...");	// inform the user about the next step the program is taking
								
								System.out.print("\nPlease enter the ID number '" + nextAvailableID + "' to add the first student to the list: ");	// ask the user to enter the student's id number
								
								id = userInput.nextInt();	// initialise the student's id number with the input from the user
								
							}	// end of if statement
							
						} while (id != nextAvailableID);	// end of do while loop						

					}	// end of else statement
					
					
					System.out.println("\nThank you! The ID number will now be added to the list.");	// inform the user about the next step the program is taking
					
					validInt = true;	// entry from the user is a valid integer number, exit the while loop
					
				}	// end of try statement

				// catch statement to handle errors found with the user input (i.e. not an integer number), execute this block of code				
				catch (InputMismatchException i) {

					String invalidEntry = userInput.nextLine();	// retrieve the invalid characters or string entered by the user

					System.err.print("Your entry '"+ invalidEntry + "' is not a valid number! ");	// show an error message to the user

					System.out.println("Let's try again...");	// inform the user about the next step the program is taking
					
				}	// end of catch statement
				
			} while (!validInt);	// end of do while loop
			
			
			// checks have been completed; it is now save to add the id number entered by the user to the list of students
			
			
			// further input from the user			
			System.out.print("\nPlease enter the student's first name: ");	// ask the user to enter the student's first name
			
			String firstName = userInput.next();	// declare and initialise the student's first name with the input from the user	
			
			
			// further input from the user			
			System.out.print("\nPlease enter the student's last name: ");	// ask the user to enter the student's last name
			
			String lastName = userInput.next();		// declare and initialise the student's last name with the input from the user	
			
			
			// Run checks on marks entered by the user before assigning them to the following maths or english marks variables

			int mathsMark1 = validCourseMark("Mathematics", 1);	// declare and assign a valid mark for Mathematics, assignment 1
			
			int mathsMark2 = validCourseMark("Mathematics", 2);	// declare and assign a valid mark for Mathematics, assignment 2
			
			int mathsMark3 = validCourseMark("Mathematics", 3);	// declare and assign a valid mark for Mathematics, assignment 3
			
			int englishMark1 = validCourseMark("English", 1);	// declare and assign a valid mark for English, assignment 1
			
			int englishMark2 = validCourseMark("English", 2);	// declare and assign a valid mark for English, assignment 2
			
			int englishMark3 = validCourseMark("English", 3);	// declare and assign a valid mark for English, assignment 3
			
			
			// checks have been completed; it is now save to add the numbers entered by the user for maths and english marks to the list of students
			
			// call a method to add a new student to the list of students with parameter values specified by the user			
			addStudent(id, firstName, lastName, mathsMark1, mathsMark2, mathsMark3, englishMark1, englishMark2, englishMark3);	
					
		}	// end of try statement
		
		// catch statement to handle errors if they occur when reading the user's system whilst creating the Scanner object, execute this block of code
		catch (Exception e) {

			System.err.println("\nAn error has occured when trying to connect to your computer!");	// display error message to the user
			
		}	// end of catch statement
					
	}	// end of method
	
	// Method that checks the user enters a valid integer number for a course mark and then returns the valid course mark entered by the user
	private static int validCourseMark(String courseName, int assignmentNumber) {

		int courseMark = -1;		// declare and initialise the student's course marks

		String invalidEntry = "";	// declare and initialise a variable to hold the invalid entry characters

		boolean validInt = false;	// reset the variable to indicate whether the id number entered by the user is a valid integer number
		

		// loop while the input from the user is not a valid integer number
		do {
						
			// try statement to test the input from the user
			try {					
							
				// loop while the number entered by the user is not between 0 to 100
				do {

					// further input from the user
					System.out.print("\nPlease enter the student's " + courseName + " mark for assignment " + assignmentNumber + ": ");	// ask the user to enter the student's mathematics mark for assignment 2
								
					courseMark = userInput.nextInt();	// declare and initialise the student's mathematics mark for assignment 2 with the input from the user
					
								
					// if the number entered by the user is less than 1 or higher than 100, execute this block of code
					if (courseMark < 0 || courseMark > 100) {
									
						System.err.print("Your entry '"+ courseMark + "' is not a valid mark! ");	// show an error message to the user

						System.out.println("Let's try again...");	// inform the user about the next step the program is taking
									
					}	// end of if statement
								
				} while (courseMark < 0 || courseMark > 100);	// end of do while loop

							
				validInt = true;	// entry from the user is a valid integer number, exit the while loop
							
			}	// end of try statement

			// catch statement to handle errors found with the user input (i.e. not an integer number), execute this block of code				
			catch (InputMismatchException i) {

				invalidEntry = userInput.nextLine();	// retrieve the invalid characters or string entered by the user and assign it to the invalidEntry variable

				System.err.print("Your entry '"+ invalidEntry + "' is not a valid number! ");	// show an error message to the user

				System.out.println("Let's try again...");	// inform the user about the next step the program is taking
							
			}	// end of catch statement
						
		} while (!validInt);	// end of do while loop
		

		return courseMark;	// return the valid course mark

	}	// end of method
		
	// Method to display individual student marks
	private static void displayStudentMarks() {
		
		System.out.println("\n\nIndividual Student Marks:");	// display a heading
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");	// display a line underneath the heading
		

		// if the list of students has entries and is not empty, execute this block of code
		if (!allStudents.isEmpty()) {			
			
			// try statement to initialise a Scanner object and open a connection to the user's system/computer
			try {
				
				userInput = new Scanner(System.in);	// initialise the scanner object and open a connection to the user's system/computer to receive user input
				
				
				int id = -1;	// declare a variable to hold the student's id number				
				
				String studentName = "";	// declare and initialise a variable to hold the student's full name				

				int mathsMark1 = -1;	// declare and assign a variable to hold a mark for Mathematics, assignment 1
				
				int mathsMark2 = -1;	// declare and assign a variable to hold a mark for Mathematics, assignment 2
				
				int mathsMark3 = -1;	// declare and assign a variable to hold a mark for Mathematics, assignment 3
				
				int averageMathsMark = -1;	// declare and assign a variable to hold a mark for Mathematics, assignment 3
				
				int englishMark1 = -1;	// declare and assign a variable to hold a mark for English, assignment 1
				
				int englishMark2 = -1;	// declare and assign a variable to hold a mark for English, assignment 2
				
				int englishMark3 = -1;	// declare and assign a variable to hold a mark for English, assignment 3
				
				int averageEnglishMark = -1;	// declare and assign a variable to hold a mark for Mathematics, assignment 3
				
				
				// run checks on the number entered by the user before assigning it to the student's id number
				
				boolean validInt = false;	// declare and initialise a variable to indicate whether the id number entered by the user is a valid integer number
				
				
				// loop while id number entered by the user is not a valid integer number
				do {

					// try statement to test the input from the user			
					try {
						
						boolean idFoundInList = false;	// declare and initialise a variable to indicate whether the id number entered by the user is found in the list of students
						

						// loop while the id number entered by the user is not found in the list of students, execute this block of code
						do {

							// initial input from the user
							System.out.print("\nPlease enter the ID number for the student you would like to display: ");	// ask the user to enter the next available id number to add a student
							
							id = userInput.nextInt();	// initialise the student's id number with the input from the user

							
							// loop through the list of students to compare the valid integer number entered by the user to the list of students
							for (Student s : allStudents) {
								
								// if the id number entered by the user is found in the list of students, execute this block of code
								if (id == s.id) {
									
									System.out.println("\nThank you! The ID number '" + id + "' was found. See the student's marks below:\n");	// inform the user that the id number was found
									
									
									// Assign student details to their variables
									
									studentName = s.getFullName();	// get this student's full name and assign it to the studentName variable
										
									mathsMark1 = s.mathMarks.getMark(1);	// get this student's Mathematics mark for assignment 1 and assign it to the mathsMark1 variable
									
									mathsMark2 = s.mathMarks.getMark(2);	// get this student's Mathematics mark for assignment 2 and assign it to the mathsMark2 variable
									
									mathsMark3 = s.mathMarks.getMark(3);	// get this student's Mathematics mark for assignment 3 and assign it to the mathsMark3 variable
									
									averageMathsMark = s.mathMarks.getAverageMark();	// get this student's average Mathematics mark and assign it to the averageMathsMark variable
									
									englishMark1 = s.englishMarks.getMark(1);	// get this student's English mark for assignment 1 and assign it to the englishMark1 variable
									
									englishMark2 = s.englishMarks.getMark(2);	// get this student's English mark for assignment 2 and assign it to the englishMark2 variable
									
									englishMark3 = s.englishMarks.getMark(3);	// get this student's English mark for assignment 3 and assign it to the englishMark3 variable
									
									averageEnglishMark = s.englishMarks.getAverageMark();	// get this student's average English mark and assign it to the averageMathsMark variable
									
									
									idFoundInList = true;	// id number entered by the user is found in the list of students
									
									break;	// break the for loop
									
								}	// end of if statement
							
							}	// end of for loop		
							
							
							// if the id number entered by the user is not found in the list of students, execute this block of code
							 if (!idFoundInList) {
								
								System.err.print("The entered ID number '" + id + "' is not in the list of students. ");	// show error message to the user that the id number they entered is invalid
							
								System.out.println("Let's try again...");	// inform the user about the next step the program is taking
								
							}	// end of if statement							 
								
						} while (!idFoundInList);	// end of do while loop		
						
						
						validInt = true;	// entry from the user is a valid integer number, exit the while loop
						
					}	// end of try statement

					// catch statement to handle errors found with the user input (i.e. not an integer number), execute this block of code				
					catch (InputMismatchException i) {

						String invalidEntry = userInput.nextLine();	// retrieve the invalid characters or string entered by the user

						System.err.print("Your entry '"+ invalidEntry + "' is not a valid number! ");	// show an error message to the user

						System.out.println("Let's try again...");	// inform the user about the next step the program is taking
						
					}	// end of catch statement
					
				} while (!validInt);	// end of do while loop
				
				
				// checks have been completed; it is now save to use the id number entered by the user to display the student's marks
				
				
				// display line above column headings
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
				
				// display column headings
				System.out.println("Student ID\tName\t\t\t    Mathematics\t\t\tAverage\t\t      English\t\t\tAverage"		// display top row of column heading
						+ "\n\t\t\t\t\t\t\t\t\tMark\t\t\t\t\t\tMark"														// display 2nd row of column heading
						+ "\n---------------------------------------------------------------------------------------------------------------------------------"		// display a line underneath top headings
						+ "\n\t\t\t\t\tA1\tA2\tA3\t\t\t\tA1\tA2\tA3");														// display sub heading
				
				// display line underneath column headings
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				
				// display the student's id, full name and marks			
				System.out.println("     " + id + "\t\t" + studentName + "\t\t" + 	// display id and full name
				
									mathsMark1 + "\t" + mathsMark2 + "\t" + mathsMark3 + "\t\t" + 				// display mathematics marks
									
									averageMathsMark + "\t\t" + 	// display average mathematics mark
									
									englishMark1 + "\t" + englishMark2 + "\t" + englishMark3 + "\t\t" + " " + 	// display english marks
									
									averageEnglishMark);			// display average english mark
				
				// display line underneath student record and table
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
				
				
			}	// end of try statement
			
			// catch statement to handle errors if they occur when reading the user's system whilst creating the Scanner object, execute this block of code
			catch (Exception e) {

				System.err.println("\nAn error has occured when trying to connect to your computer!");	// display error message to the user
				
			}	// end of catch statement				
			
		}	// end of if statement
		
		// else the list of students has no entries and is empty, execute this block of code
		else {
			
			System.out.println("\nThe students' list has no entries and is empty.");	// notify the user of the status of the student list
			
			System.out.println("\nPlease first add new students to the list.");	// show instruction to the user to first add students to the list
			
			System.out.println("\nYou are being taken to the main menu...");	// inform the user about the next step the program is taking
			
		}	// end of else statement		
		
	}	// end of method
	
	// Method to display a list of all students with their student marks
	private static void displayReportByMarks() {
		
		System.out.println("\n\nAll Student Marks:");	// display a heading
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");	// display a line underneath the heading		
		
		// display line above column headings
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
		
		// display column headings
		System.out.println("Student ID\tName\t\t\t    Mathematics\t\t\tAverage\t\t      English\t\t\tAverage"		// display top row of column heading
				
				+ "\n\t\t\t\t\t\t\t\t\tMark\t\t\t\t\t\tMark"														// display 2nd row of column heading
				
				+ "\n---------------------------------------------------------------------------------------------------------------------------------"		// display a line underneath top headings
				
				+ "\n\t\t\t\t\tA1\tA2\tA3\t\t\t\tA1\tA2\tA3");														// display sub heading
		
		// display line underneath column headings
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
		
		
		// loop through the list of students to display their marks		
		for (Student s : allStudents) {
			
			// display a list of all students with their student marks
			System.out.print("     " + s.id + "\t\t" + s.getFullName() + "\t\t" + 	// display id and full name
			
								s.mathMarks.getMark(1) + "\t" + s.mathMarks.getMark(2) + "\t" + s.mathMarks.getMark(3) + "\t\t" + 					// display mathematics marks
								
								s.mathMarks.getAverageMark() + "\t\t" + 			// display average mathematics mark
								
								s.englishMarks.getMark(1) + "\t" + s.englishMarks.getMark(2) + "\t" + s.englishMarks.getMark(3) + "\t\t" + " " + 	// display english marks
								
								s.englishMarks.getAverageMark() + "\n");			// diplay average english mark
			
		}	// end of enhanced for loop
		
		
		// display line underneath student records and table
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
		
	}	// end of method

	// Method to display individual student grades
	private static void displayStudentGrades() {
		
		System.out.println("\n\nIndividual Student Grades:");	// display a heading
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");	// display a line underneath the heading
		
		
		// if the list of students has entries and is not empty, execute this block of code
		if (!allStudents.isEmpty()) {			
			
			// try statement to initialise a Scanner object and open a connection to the user's system/computer
			try {
				
				userInput = new Scanner(System.in);	// initialise the scanner object and open a connection to the user's system/computer to receive user input
				
				
				int id = -1;	// declare a variable to hold the student's id number				
				
				String studentName = "";	// declare and initialise a variable to hold the student's full name				

				String mathsGrade1 = "";	// declare and assign a variable to hold a grade for Mathematics, assignment 1
				
				String mathsGrade2 = "";	// declare and assign a variable to hold a grade for Mathematics, assignment 2
				
				String mathsGrade3 = "";	// declare and assign a variable to hold a grade for Mathematics, assignment 3
				
				String averageMathsGrade = "";	// declare and assign a variable to hold a grade for Mathematics, assignment 3
				
				String englishGrade1 = "";	// declare and assign a variable to hold a grade for English, assignment 1
				
				String englishGrade2 = "";	// declare and assign a variable to hold a grade for English, assignment 2
				
				String englishGrade3 = "";	// declare and assign a variable to hold a grade for English, assignment 3
				
				String averageEnglishGrade = "";	// declare and assign a variable to hold a grade for Mathematics, assignment 3
				
				
				// run checks on the number entered by the user before assigning it to the student's id number
				
				boolean validInt = false;	// declare and initialise a variable to indicate whether the id number entered by the user is a valid integer number
				
				
				// loop while id number entered by the user is not a valid integer number
				do {

					// try statement to test the input from the user			
					try {
						
						boolean idFoundInList = false;	// declare and initialise a variable to indicate whether the id number entered by the user is found in the list of students
						

						// loop while the id number entered by the user is not found in the list of students, execute this block of code
						do {

							// initial input from the user
							System.out.print("\nPlease enter the ID number for the student you would like to display: ");	// ask the user to enter the next available id number to add a student
							
							id = userInput.nextInt();	// initialise the student's id number with the input from the user

							
							// loop through the list of students to compare the valid integer number entered by the user to the list of students
							for (Student s : allStudents) {
								
								// if the id number entered by the user is found in the list of students, execute this block of code
								if (id == s.id) {
									
									System.out.println("\nThank you! The ID number '" + id + "' was found. See the student's grades below:\n");	// inform the user that the id number was found
									
									
									// Assign student details to their variables
									
									studentName = s.getFullName();	// get this student's full name and assign it to the studentName variable
										
									mathsGrade1 = s.mathMarks.getGrade(1);	// get this student's Mathematics grade for assignment 1 and assign it to the mathsGrade1 variable
									
									mathsGrade2 = s.mathMarks.getGrade(2);	// get this student's Mathematics grade for assignment 2 and assign it to the mathsMark2 variable
									
									mathsGrade3 = s.mathMarks.getGrade(3);	// get this student's Mathematics grade for assignment 3 and assign it to the mathsGrade2 variable
									
									averageMathsGrade = s.mathMarks.getAverageGrade();	// get this student's average Mathematics grade and assign it to the averageMathsGrade variable
									
									englishGrade1 = s.englishMarks.getGrade(1);	// get this student's English grade for assignment 1 and assign it to the englishGrade1 variable
									
									englishGrade2 = s.englishMarks.getGrade(2);	// get this student's English grade for assignment 2 and assign it to the englishGrade2 variable
									
									englishGrade3 = s.englishMarks.getGrade(3);	// get this student's English grade for assignment 3 and assign it to the englishGrade3 variable
									
									averageEnglishGrade = s.englishMarks.getAverageGrade();	// get this student's average English grade and assign it to the averageEnglishGrade variable
									
									
									idFoundInList = true;	// id number entered by the user is found in the list of students
									
									break;	// break the for loop
									
								}	// end of if statement
							
							}	// end of for loop		
							
							
							// if the id number entered by the user is not found in the list of students, execute this block of code
							 if (!idFoundInList) {
								
								System.err.print("The entered ID number '" + id + "' is not in the list of students. ");	// show error message to the user that the id number they entered is invalid
							
								System.out.println("Let's try again...");	// inform the user about the next step the program is taking
								
							}	// end of if statement							 
								
						} while (!idFoundInList);	// end of do while loop		
						
						
						validInt = true;	// entry from the user is a valid integer number, exit the while loop
						
					}	// end of try statement

					// catch statement to handle errors found with the user input (i.e. not an integer number), execute this block of code				
					catch (InputMismatchException i) {

						String invalidEntry = userInput.nextLine();	// retrieve the invalid characters or string entered by the user

						System.err.print("Your entry '"+ invalidEntry + "' is not a valid number! ");	// show an error message to the user

						System.out.println("Let's try again...");	// inform the user about the next step the program is taking
						
					}	// end of catch statement
					
				} while (!validInt);	// end of do while loop
				
				
				// checks have been completed; it is now save to use the id number entered by the user to display the student's grades
				
				
				// display line above column headings
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
				
				// display column headings
				System.out.println("Student ID\tName\t\t\t    Mathematics\t\t\tAverage\t\t      English\t\t\tAverage"		// display top row of column heading
						+ "\n\t\t\t\t\t\t\t\t\tGrade\t\t\t\t\t\tGrade"														// display 2nd row of column heading
						+ "\n---------------------------------------------------------------------------------------------------------------------------------"		// display a line underneath top headings
						+ "\n\t\t\t\t\tA1\tA2\tA3\t\t\t\tA1\tA2\tA3");														// display sub heading
				
				// display line underneath column headings
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");
				
				// display the student's id, full name and grades			
				System.out.println("     " + id + "\t\t" + studentName + "\t\t" + 	// display id and full name
				
									mathsGrade1 + "\t" + mathsGrade2 + "\t" + mathsGrade3 + "\t\t" + 				// display mathematics grade
									
									averageMathsGrade + "\t\t" + 	// display average mathematics grade
									
									englishGrade1 + "\t" + englishGrade2 + "\t" + englishGrade3 + "\t\t" + " " + 	// display english marks
									
									averageEnglishGrade);			// display average english mark
				
				// display line underneath student record and table
				System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
				
				
			}	// end of try statement
			
			// catch statement to handle errors if they occur when reading the user's system whilst creating the Scanner object, execute this block of code
			catch (Exception e) {

				System.err.println("\nAn error has occured when trying to connect to your computer!");	// display error message to the user
				
			}	// end of catch statement				
			
		}	// end of if statement
		
		// else the list of students has no entries and is empty, execute this block of code
		else {
			
			System.out.println("\nThe students' list has no entries and is empty.");	// notify the user of the status of the student list
			
			System.out.println("\nPlease first add new students to the list.");	// show instruction to the user to first add students to the list
			
			System.out.println("\nYou are being taken to the main menu...");	// inform the user about the next step the program is taking
			
		}	// end of else statement		
		
	}	// end of method
	
	// Method to display a list of all students with their student letter grades
	private static void displayReportByGrades() {
		
		System.out.println("\n\nAll Student Grades:");	// display a heading
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");	// display a line underneath the heading
		
		// display line above column headings
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
		
		// display column headings
		System.out.println("Student ID\tName\t\t\t    Mathematics\t\t\tAverage\t\t      English\t\t\tAverage"		// display top row of column heading
				
				+ "\n\t\t\t\t\t\t\t\t\tGrade\t\t\t\t\t\tGrade"														// display 2nd row of column heading
				
				+ "\n---------------------------------------------------------------------------------------------------------------------------------"		// display a line underneath top headings
				
				+ "\n\t\t\t\t\tA1\tA2\tA3\t\t\t\tA1\tA2\tA3");														// display sub heading
		
		// display line underneath column headings
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");			
		
		
		// loop through the list of students to display their grades
		for (Student s : allStudents) {
			
			// display a list of all students with their student grades	
			System.out.print("     " + s.id + "\t\t" + s.getFullName() + "\t\t" + 	// display id and full name
			
								s.mathMarks.getGrade(1) + "\t" + s.mathMarks.getGrade(2) + "\t" + s.mathMarks.getGrade(3) + "\t\t" + " " + 				// display mathematics grades
								
								s.mathMarks.getAverageGrade() + "\t\t" + 			// display average mathematics grade
								
								s.englishMarks.getGrade(1) + "\t" + s.englishMarks.getGrade(2) + "\t" + s.englishMarks.getGrade(3) + "\t\t" + " " + 	// display english grades
								
								s.englishMarks.getAverageGrade() + "\n");			// diplay average english grade
			
		}	// end of enhanced for loop
		
		
		// display line underneath student record and table
		System.out.println("---------------------------------------------------------------------------------------------------------------------------------");	
		

	}	// end of method
	
	// Method to only display the menu to the user
	private static void displayMenu() {
		
		System.out.println("MAIN MENU:");	// display a heading
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");	// display a line underneath the heading
		
		// declare and initialise a String array of menu options		
		String[] menuOption = {	
								"1. Display individual student marks\t",	// menu option 1
								
								"2. Display all student marks\t\t", 		// menu option 2
								
								"3. Display individual student grades\t", 	// menu option 3
								
								"4. Display all student grades\t\t", 		// menu option 4
								
								"5. Add new student\t\t\t", 				// menu option 5
								
								"6. Remove student\t\t\t", 					// menu option 6
								
								"7. Exit the program\t\t\t"					// menu option 7
								
								};	// end of array
		
		// loop through the menu options		
		for (int i = 0; i < menuOption.length; i++) {
			
			System.out.println(menuOption[i]);	// display the menu options to the user
			
		}	// end of for loop	
		
	}	// end of method

	// Method to help the user select a valid menu option and returns this to the main method
	private static int selectMenuOption() {		

		int menuOption = -1;	// declare and initialise a variable to hold the user's menu option
		
		
		// try statement to create a Scanner object and open a connection to the user's system/computer
		try {
		
			userInput = new Scanner(System.in);	// initialise the scanner object and open a connection to the uesr's system/computer to receive user input
			

			// error checking - loop while user entry is invalid (i.e. smaller than 1 or larger than 7)
			do {

				// try statement to test the input from the user 
				try {

					System.out.print("\nPlease enter a number (from 1 to 7) to perform a function as shown in the main menu: ");	// ask the user to enter a menu option
					
					menuOption = userInput.nextInt();	// try to retrieve an integer number from the user
					
						
					// if the number is incorrect (i.e. smaller than 1 or larger than 7), execute this block of code
					if (menuOption < 1 || menuOption > 7) {

						System.err.print("Your entry '" + menuOption + "' is not an option in the main menu! ");	// show an error message to the user
						
						System.out.println("Let's try again...");	// inform the user about the next step the program is taking

					}	// end of if statement
					
					// else if the number entered by the user is 7, confirm with the user before exiting
					else if (menuOption == 7) {
						
						System.out.println("\nExit The Program:");	// display a heading
						
						System.out.println("~~~~~~~~~~~~~~~~~~~~~~~\n");	// display a line underneath the heading
						
						int subMenuOption = 0;	// declare and initialise a variable to hold the user's submenu option 
						
						System.out.println("Do you want to continue to exit the program?");	// ask the user whether they want to exit the program
						
						
						// error checking - loop while user entry is invalid (i.e. a number less than 1 or higher than 7)
						do {
							
							System.out.println("\nTo exit the program, enter the number '7'");	// show instruction to the user to confirm exiting the program
							
							System.out.print("\nTo cancel, enter a number (from 1 to 6) to perform a function as shown in the main menu: ");	// show instruction to the user to cancel exiting the program and display the menu

							
							// try statement to test the input from the user 
							try {
								
								subMenuOption = userInput.nextInt();	// try to retrieve an integer number from the user
								
								
								// if the number is incorrect (i.e. smaller than 1 or larger than 7), execute this block of code
								if (subMenuOption < 1 || subMenuOption > 7) {

									System.err.print("Your entry '" + subMenuOption + "' is not an option in the main menu! ");	// show an error message to the user
									
									System.out.println("Let's try again...");	// inform the user about the next step the program is taking

								}	// end of if statement
								
								// if the number entered by the user is 7 again, execute this block of code
								else if (subMenuOption == 7) {
									
									menuOption = subMenuOption;	// assign the submenu option entered by the user to the menu option
									
									break;	// break the loop
									
								}	// end of else if statement
								
								// otherwise, the number entered by the user is a valid menu option (i.e. a number from 1 to 6), therefore execute this block of code
								else {
									
									menuOption = subMenuOption;	// assign the submenu option entered by the user to the menu option
									
								}	// end of else statement
								
							}	// end of try statement
							
							// catch statement to handle errors found with the user input (i.e. not an integer number), execute this block of code	
							catch (InputMismatchException i) {

								String invalidEntry = userInput.nextLine();	// retrieve the invalid characters or string entered by the user

								System.err.print("Your entry '"+ invalidEntry + "' is not a valid number! ");	// show an error message to the user

								System.out.println("Let's try again...");	// inform the user about the next step the program is taking

							}	// end of catch statement
							
						} while (subMenuOption < 1 || subMenuOption > 7);	// end of do while loop
						
					}	// end of else if statement
					
				}	// end of try statement

				// catch statement to handle errors found with the user input (i.e. not an integer number), execute this block of code				
				catch (InputMismatchException i) {

					String invalidEntry = userInput.nextLine();	// retrieve the invalid characters or string entered by the user

					System.err.print("Your entry '"+ invalidEntry + "' is not a valid number! ");	// show an error message to the user

					System.out.println("Let's try again...");	// inform the user about the next step the program is taking

				}	// end of catch statement

			} while (menuOption < 1 || menuOption > 7);	// end of do while loop
					
		}	// end of try statement 
		
		// catch statement to handle errors if they occur when reading the user's system/computer whilst creating the Scanner object, execute this block of code
		catch (Exception e) {

			// the menu option remains the initial value of -1
			
			System.err.println("\nAn error has occured when trying to connect to your computer!");	// display error message to the user

		}	// end of catch statement
		
		
		return menuOption;	// return the menu option the user has entered, or -1 if the program could not connect to the user's system/computer
		
	}	// end of method
	
	// Method to remove a student from the list of students as specified by the user
	private static void removeStudent() {
		
		System.out.println("\n\nRemove Student:");	// display a heading
		
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");	// display a line underneath the heading

		// if the list of students has entries and is not empty, execute this block of code
		if (!allStudents.isEmpty()) {
			
			
			// try statement to initialise a Scanner object and open a connection to the user's system/computer
			try {
				
				userInput = new Scanner(System.in);	// initialise the scanner object and open a connection to the user's system/computer to receive user input
				
				
				// run checks on the number entered by the user before assigning it to the following id number
				
				int id = -1;	// declare a variable to hold the student's id number
				
				String studentName = "";	// declare and initialise a variable to hold the student's full name
				
				boolean validInt = false;	// declare and initialise a variable to indicate whether the id number entered by the user is a valid integer number
				
				
				// loop while id number entered by the user is not a valid integer number
				do {

					// try statement to test the input from the user			
					try {
						
						boolean idFoundInList = false;	// declare and initialise a variable to indicate whether the id number entered by the user is found in the list of students
						

						// loop while the id number entered by the user is not found in the list of students, execute this block of code
						do {

							// initial input from the user
							System.out.print("\nPlease enter the ID number for the student you would like to remove: ");	// ask the user to enter the next available id number to add a student
							
							id = userInput.nextInt();	// initialise the student's id number with the input from the user

							
							// loop through the list of students to compare the valid integer number entered by the user to the list of students
							for (Student s : allStudents) {
								
								// if the id number entered by the user is found in the list of students, execute this block of code
								if (id == s.id) {
									
									System.out.println("\nThe entered ID number '" + id + "' was found in the list of students. ");	// inform the user that the id number was found
									
									studentName = s.getFullName();	// get this student's full name and assign it to the studentName variable
									
									allStudents.remove(s);	// remove the student object from the list of students
									
									idFoundInList = true;	// id number entered by the user is found in the list of students
									
									break;	// break the for loop
									
								}	// end of if statement
							
							}	// end of for loop		
							
							
							// if the id number entered by the user is not found in the list of students, execute this block of code
							 if (!idFoundInList) {
								
								System.err.print("The entered ID number '" + id + "' is not in the list of students. ");	// show error message to the user that the id number they entered is invalid
							
								System.out.println("Let's try again...");	// inform the user about the next step the program is taking
								
							}	// end of if statement							 
								
						} while (!idFoundInList);	// end of do while loop		
						
						
						validInt = true;	// entry from the user is a valid integer number, exit the while loop			
						
					}	// end of try statement

					// catch statement to handle errors found with the user input (i.e. not an integer number), execute this block of code				
					catch (InputMismatchException i) {

						String invalidEntry = userInput.nextLine();	// retrieve the invalid characters or string entered by the user

						System.err.print("Your entry '"+ invalidEntry + "' is not a valid number! ");	// show an error message to the user

						System.out.println("Let's try again...");	// inform the user about the next step the program is taking
						
					}	// end of catch statement
					
				} while (!validInt);	// end of do while loop	
				
				
				System.out.println("\nThis student '" + studentName + "' has now successfully been removed from the list of students.");	// notify the user that removing the student was successful
				
			}	// end of try statement
			
			// catch statement to handle errors if they occur when reading the user's system whilst creating the Scanner object, execute this block of code
			catch (Exception e) {

				System.err.println("\nAn error has occured when trying to connect to your computer!");	// display error message to the user
				
			}	// end of catch statement				
			
		}	// end of if statement
		
		// else the list of students has no entries and is empty, execute this block of code
		else {
			
			System.out.println("\nThe students' list has no entries and is empty.");	// notify the user of the status of the student list
			
			System.out.println("\nPlease first add new students to the list.");	// show instruction to the user to first add students to the list
			
			System.out.println("\nYou are being taken to the main menu...");	// inform the user about the next step the program is taking
			
		}	// end of else statement		

	}	// end of method
	
}	// end of StudentDataManagement class