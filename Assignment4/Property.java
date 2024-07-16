/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents a real estate property with various attributes such as the name, city, rent amount, owner, and plot type. 
 * This class specifically provides methods to manipulate and retrieve information about the property. 
 * Due: 07/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Inshaal Chaudhury
*/

import java.lang.Object;

public class Property extends Object
{
	// Instances
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	// Constructors
	public Property()
	{
		propertyName = "";
		city = "";
		rentAmount = 0.0;
		owner = "";
		plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot();
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int width, int depth)
	{
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, width, depth);
	}
	
	public Property(Property otherProperty)
	{
		this.propertyName = otherProperty.propertyName;
		this.city = otherProperty.city;
		this.rentAmount = otherProperty.rentAmount;
		this.owner = otherProperty.owner;
		this.plot = new Plot(otherProperty.plot);
	}
	
	
	// Accessor Methods
	public String getCity()
	{
		return city;
	}
	
	public String getOwner()
	{
		return owner;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public String getPropertyName()
	{
		return propertyName;
	}
	
	public double getRentAmount()
	{
		return rentAmount;
	}
	
	// toString method
	public String toString()
	{
		return propertyName + "," + city + "," + owner + "," + rentAmount;
	}
}
