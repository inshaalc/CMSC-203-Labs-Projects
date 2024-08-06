/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Subclass of Beverage
 * Due: 08/04/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

public class Coffee extends Beverage
{
	// Instance variables
	private boolean extraShot;
	private boolean extraSyrup;
	private double additionalShotPrice = 0.50;
	private double additionalSyrupPrice = 0.50;
	
	/**
	 * Constructor
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public Coffee(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		super(bevName, Type.COFFEE, size);
		this.extraShot = extraShot;
		this.extraSyrup = extraSyrup;
	}
	
	/**
	 * Returns true/false if extra shot is added to coffee
	 * @return boolean
	 */
	public boolean getExtraShot()
	{
		return extraShot;
	}
	
	/**
	 * Returns true/false if extra syrup is added to coffee
	 * @return boolean
	 */
	public boolean getExtraSyrup()
	{
		return extraSyrup;
	}
	
	/**
	 * Returns a double of price
	 * @return double
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
		
		if (extraShot == true)
		{
			price += additionalShotPrice;
		}
		if (extraSyrup == true)
		{
			price += additionalSyrupPrice;
		}
		
		return price;
	}
	
	/**
	 * Returns true/false value if bev object equals other bev object
	 * @return boolean
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
	    
	    Coffee other = (Coffee) anotherBev;
	    return super.equals(other) && extraShot == other.extraShot && extraSyrup == other.extraSyrup;
	}
	
	/**
	 * toString method
	 * @return String concantenation
	 */
	public String toString()
	{
		return super.toString() + ", " + "Extra Shot: " + extraShot + 
				", Extra Syrup: " + extraSyrup + ", " + "Price: " + calcPrice();
	}
}
