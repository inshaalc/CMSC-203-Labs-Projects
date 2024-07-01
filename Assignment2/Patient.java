/*
 * Class: CMSC203 40438
 * Instructor: Grigoriy Grinberg
 * Description: Patient Class has fields for attributes in addition to constructors (no-arg, parametrized),
 * accessor and mutator methods, and build methods to concatenate these attributes and to return them as a String. 
 * Due: 07/01/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

public class Patient 
{
	// Fields
	private String firstName; 
	private String middleName;
	private String lastName;
	private String streetAddress;
	private String city;
	private String state;
	private String zipCode;
	private String phoneNum;
	private String emerName;
	private String emerNumber;
		
	// No-arg constructor
	public Patient()
	{
	}
	
	// Parameterized Constructor (for first, middle, last name)
	public Patient(String first, String middle, String last)
	{
		firstName = first;
		middleName = middle;
		lastName = last;
	}
	
	// Parameterized Constructor (for all attributes)
	public Patient(String first, String middle, String last, String street, 
			String city1, String state1, String zip, String phone, String emerNam, String emerNum)
	{
		firstName = first;
		middleName = middle;
		lastName = last;
		streetAddress = street;
		city = city1;
		state = state1;
		zipCode = zip;
		phoneNum = phone;
		emerName = emerNam;
		emerNumber = emerNum;
	}
	
	// Accessor Methods
	
	/**
	 * @return the First Name of a person
	 */
	public String getFirstName()
	{
		return firstName;
	}
	
	/**
	 * @return the Middle Name of a person
	 */
	public String getMiddleName()
	{
		return middleName;
	}
	
	/**
	 * @return the Middle Name of a person
	 */
	public String getLastName()
	{
		return lastName;
	}
	
	/**
	 * @return the Street Address of a person
	 */
	public String getStreetAddress()
	{
		return streetAddress;
	}
	
	/**
	 * @return the State of a person
	 */
	public String getState()
	{
		return state;
	}
	
	/**
	 * @return the City of a person
	 */
	public String getCity()
	{
		return city;
	}
	
	/**
	 * @return the Zip Code of a person
	 */
	public String getZipCode()
	{
		return zipCode;
	}
	
	/**
	 * @return the Phone Number of a person
	 */
	public String getPhoneNum()
	{
		return phoneNum;
	}
	
	/**
	 * @return the Emergency Contact Name of a person
	 */
	public String getEmerName()
	{
		return emerName;
	}
	
	/**
	 * @return the Emergency Contact Number of a person
	 */
	public String getEmerNumber()
	{
		return emerNumber;
	}	
	
	// Mutator methods
	/**
	 * @param first the First name of a Person
	 */
	public void setFirstName(String first)
	{
		firstName = first;
	}
	
	/**
	 * @param middle the middle name of a Person
	 */
	public void setMiddleName(String middle)
	{
		middleName = middle;
	}
	
	/**
	 * @param last the last name of a Person
	 */
	public void setLastName(String last)
	{
		lastName = last;
	}
	
	/**
	 * @param street the street address of a Person
	 */
	public void setStreetAddress(String street)
	{
		streetAddress = street;
	}
	
	/**
	 * @param city1 the city address of a Person
	 */
	public void setCity(String city1)
	{
		city = city1;
	}
	
	/**
	 * @param state1 the street address of a Person
	 */
	public void setState(String state1)
	{
		state = state1;
	}
	
	/**
	 * @param zip the zip code of a Person
	 */
	public void setZipCode(String zip)
	{
		zipCode = zip;
	}
	
	/**
	 * @param phone the street address of a Person
	 */
	public void setPhoneNum(String phone)
	{
		phoneNum = phone;
	}
	
	/**
	 * @param emerNam the name of the emergency Contact of a Person
	 */
	public void setEmerName(String emerNam)
	{
		emerName = emerNam;
	}
	
	/**
	 * @param emerNum the number of the emergency Contact of a Person
	 */
	public void setEmerNum(String emerNum)
	{
		emerNumber = emerNum; 
	}
	
	// Build Full Name Method
	/**
	@return the full name of a person
	*/
	public String buildFullName()
	{
		return firstName + " " + middleName + " " + lastName;
	}
	
	// Build Address Method
	/**
	@return the full address of a person
	*/
	public String buildAddress()
	{
		return streetAddress + " " + city + " " + state + " " + zipCode;
	}
	
	// Build Emergency Contact Method
	/**
	@return the full emergency contact of a person
	*/
	public String buildEmergencyContact()
	{
		return emerName + " " + emerNumber;
	}
	
	// toString method 
	/**
	@return the complete Patient Info 
	*/
	public String toString()
	{
		return "\nPatient Info: " + 
				"\nName: " + buildFullName() +
				"\nAddress: " + buildAddress() +
				"\nEmergency Contact: " + buildEmergencyContact();
	}
}
