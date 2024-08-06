/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Alcohol class is a subclass of beverage that passes information 
 * Due: 08/04/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

public class Alcohol extends Beverage 
{
	// Instance variable
	private boolean isWeekend;
	private double drinkCost = 0.60;
	
	/**
	 * Constructor
	 * @param bevName Beverage name
	 * @param size Size of bev
	 * @param isWeekend boolean variable 
	 */
	public Alcohol(String bevName, Size size, boolean isWeekend)
	{
		super(bevName, Type.ALCOHOL, size);
		this.isWeekend = isWeekend;
	}
	
	/**
	 * Returns true if it is the weekend
	 * @return boolean value
	 */
	public boolean isWeekend()
	{
		return isWeekend;
	}

	/** 
	 * Calculate price method 
	 * @return double value which is total calculation
	 */
	@Override
	public double calcPrice() 
	{
		double price = super.getBasePrice();
		
		if (super.getSize() == Size.SMALL)
		{
			price += 0;
		}
		else if (super.getSize() == Size.MEDIUM)
		{
			price += 0.5;
		}
		else if (super.getSize() == Size.LARGE)
		{
			price += 1;
		}
		
		if (isWeekend())
		{
			price  += drinkCost;
		}
		
		return price;
	}
	
	/**
	 * @return returns string concatenation
	 */
	@Override
	public String toString()
	{
		return super.toString() + ", " + "Weekend? : " + isWeekend + ", Price: " + calcPrice();
	}
	
	/**
	 * @return returns boolean variable determining whether two objects are equal
	 */
	@Override
	public boolean equals(Object anotherBev)
	{
		if (!(anotherBev instanceof Alcohol))
		{
			return false;
		}
		
		Alcohol alcohol = (Alcohol) anotherBev;
		
		if (super.equals(alcohol) && getBasePrice() == alcohol.getBasePrice() && isWeekend == alcohol.isWeekend)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
}
