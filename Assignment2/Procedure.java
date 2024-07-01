/*
 * Class: CMSC203 40438
 * Instructor: Grigoriy Grinberg
 * Description: Procedure Class has fields for specific attributes/characteristics regarding the procedure,
 * no arg constructor, parametrized constructors (procedure name & date, then all attributes, 
 * accessor and mutator methods, and finally a toString method displaying all this procedural information.
 * Due: 07/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

public class Procedure 
{
	// Fields
	private String procedureName;
	private String procedureDate;
	private String practitionerName;
	private double procedureCost;
	
	// No-Arg Constructor
	public Procedure()
	{
	}
	
	// Parameterized Constructor (procedure name & date)
	public Procedure(String name, String date)
	{
		procedureName = name;
		procedureDate = date;
	}
	
	// Parameterized Constructor (all attributes)
	public Procedure(String name, String date, String practitioner, double cost)
	{
		procedureName = name;
		procedureDate = date;
		practitionerName = practitioner;
		procedureCost = cost;
	}
	
	// Accessor Methods
	/**
	 * 
	 * @return procedure name
	 */
	public String getProName()
	{
		return procedureName;
	}
	
	/**
	 * 
	 * @return procedure date
	 */
	public String getProDate()
	{
		return procedureDate;
	}
	
	/**
	 * 
	 * @return practitioner name
	 */
	public String getPractName()
	{
		return practitionerName;
	}
	
	/**
	 * 
	 * @return procedure cost
	 */
	public double getProCost()
	{
		return procedureCost;
	}
	
	// Mutator Methods
	/**
	 * 
	 * @param name name of practitioner
	 */
	public void setProName(String name)
	{
		procedureName = name;
	}
	
	/**
	 * 
	 * @param date date of procedure
	 */
	public void setProDate(String date)
	{
		procedureDate = date;
	}
	
	/**
	 * 
	 * @param practitioner name of practitioner
	 */
	public void setPractName(String practitioner)
	{
		practitionerName = practitioner;
	}
	
	/**
	 * 
	 * @param cost cost of procedure
	 */
	public void setProCost(double cost)
	{
		procedureCost = cost;
	}
	
	// toString method (displaying all attributes)
	/**
	 * @return returns string of entire procedure information
	 */
	public String toString()
	{
		return "\n\tProcedure: " + procedureName +
				"\n\tProcedure Date: " + procedureDate +
				"\n\tPractitioner: " + practitionerName +
				"\n\tCharge: " + procedureCost;
	}
}
