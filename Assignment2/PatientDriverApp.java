/*
 * Class: CMSC203 40438
 * Instructor: Grigoriy Grinberg
 * Description: The PatientDriverApp class is responsible for creating and initializing instances of Patient and Procedure with user-provided data. 
 * It uses display methods to output this data by calling each instance's toString method. 
 * The class includes a method to calculate the total charges of the procedures. 
 * All functionality is cited within the main method, which prompts for keyboard input and then displays the information.
 * Due: 07/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

import java.util.Scanner;

public class PatientDriverApp 
{
	// Constructor
	public PatientDriverApp()
	{
	}
	
	// Instances
	private Patient patient;
	private Procedure procedure1;
	private Procedure procedure2;
	private Procedure procedure3;
	
	// Initialize Patient
	/**
	 * initializes patient info by prompting user to enter in their information,
	 * then initializes patient instance with this collected information.
	 */
	public void initializePatient()
	{
		// User Input
		Scanner keyboard = new Scanner(System.in);
		
		System.out.print("Enter First Name: ");
		String firstName = keyboard.nextLine();
		
		System.out.print("Enter Middle Name: ");
		String middleName = keyboard.nextLine();
		
		System.out.print("Enter Last Name: ");
		String lastName = keyboard.nextLine();
		
		System.out.print("Enter Phone Number: ");
		String phoneNum = keyboard.nextLine();
		
		System.out.print("\nEnter Address: ");
		String streetAddress = keyboard.nextLine();
		
		System.out.print("Enter City: ");
		String city = keyboard.nextLine();
		
		System.out.print("Enter State: ");
		String state = keyboard.nextLine();
		
		System.out.print("Enter Zip Code: ");
		String zipCode = keyboard.nextLine();
		
		System.out.print("\nEnter Emergency Contact Name: ");
		String emerName = keyboard.nextLine();
		
		System.out.print("Enter Emergency Contact Number: ");
		String emerNumber = keyboard.nextLine();
		
		// Initialize Patient
		patient = new Patient(firstName, middleName, lastName, streetAddress, city, state, zipCode, phoneNum, emerName, emerNumber);
		keyboard.close();
	}
	
	// Initialize Procedures
	
	/**
	 * initializes procedures with pre-made information
	 */
	public void initializeProcedures()
	{	
		procedure1 = new Procedure("Physical Exam", "07/01/2024", "Dr. Irvine", 3250.0);
		procedure2 = new Procedure("X-Ray", "07/01/2024", "Dr. Jamison", 5500.43);
		procedure3 = new Procedure("Blood Test", "07/01/2024", "Dr. Smith", 1400.75);
	}
	
	// Display Patient Method (toString method)
	/**
	 * displays patient instance information through toString method
	 */
	public void displayPatient()
	{
		System.out.println(patient.toString());
	}
	
	// Display Procedure Method (all 3 instances through toString method)
	/**
	 * displays procedural instance information through toString method
	 */
	public void displayProcedure()
	{
		System.out.println(procedure1.toString());
		System.out.println(procedure2.toString());
		System.out.println(procedure3.toString());
	}
	
	// Calculate Total Charges Method (using getProcedureCost method)
	/** 
	 * 
	 * @return returns a double of sum of the charges
	 */
	public double calculateTotalCharges()
	{
		return procedure1.getProCost() + procedure2.getProCost() + procedure3.getProCost(); 
	}
	
	public static void main(String[] args) 
	{
		// Creates Driver Object
		PatientDriverApp app = new PatientDriverApp();
		
		// Calls initialize methods
		app.initializePatient();
		app.initializeProcedures();

		// Calls Display Patient Method
		app.displayPatient();
		
		// Calls Display Procedure Method
		System.out.println("\t");
		app.displayProcedure();
		
		// Calculates and prints total charges
		double totalCharges = app.calculateTotalCharges();
		System.out.printf("\nTotal Charges: $%,.2f\n", totalCharges);		
		
		// Programmer Information
		System.out.println("\nStudent Name: Inshaal Chaudhury");
		System.out.println("MC#: M21117800");
		System.out.println("Due Date: 07/01/2024");
	}
}
