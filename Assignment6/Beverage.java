/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Beverage is an abstract super class class  
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/
import java.util.Objects;

public abstract class Beverage 
{
	// Instance Variables
	private final double basePrice = 2.0;
	private String bevName;
	private Type type;
	private Size size;
	private Day day;
	
	/**
	 * Constructor
	 * @param bevName Beverage name
	 * @param type Bev type
	 * @param size Bev Size
	 */
	public Beverage(String bevName, Type type, Size size)
	{
		this.bevName = bevName;
		this.type = type;
		this.size = size;
	}
	
	/**
	 * Accessor Base Price method
	 * @return Base price
	 */
	public double getBasePrice()
	{
		return basePrice;
	}
	
	/**
	 * Gets beverage type
	 * @return Bev Type
	 */
	public Type getType()
	{
		return type;
	}
	
	/**
	 * Returns name of beverage
	 * @return String
	 */
	public String getBevName()
	{
		return bevName;
	}
	
	/**
	 * Returns size of beverage
	 * @return Size
	 */
	public Size getSize()
	{
		return size;
	}
	
	/**
	 * Add size price method
	 * @return Returns a double containing full price
	 */
	public double addSizePrice()
	{
		double small_extraPrice = 0.0;
		double medium_extraPrice = 0.5;
		double large_extraPrice = 1.0;
		double newPrice = basePrice;
		
		if (size == Size.SMALL)
		{
			newPrice += small_extraPrice;
		}
		else if (size == Size.MEDIUM)
		{
			newPrice += medium_extraPrice;
		}
		else if (size == Size.LARGE)
		{
			newPrice += large_extraPrice; 
		}
		
		return newPrice;
	}
	
	/**
	 * toString method
	 * @return String concantenation
	 */
	public String toString()
	{
		return bevName + ", " + size;
	}
	
	/**
	 * Equals method
	 * @param anotherBev Beverage object
	 * @return boolean value declaring whether it is equal or not
	 */
	@Override
	public boolean equals(Object anotherBev) 
	{
	    if (this == anotherBev) 
	    {
	        return true;
	    }
	    
	    if (anotherBev == null || getClass() != anotherBev.getClass()) 
	    {
	        return false;
	    }
	    
	    Beverage beverage = (Beverage) anotherBev;
	    return Objects.equals(bevName, beverage.bevName) && type == beverage.type && size == beverage.size;
	}

	// Abstract Calculate Price method
	public abstract double calcPrice();
}
