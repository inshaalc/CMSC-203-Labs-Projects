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

public class Smoothie extends Beverage
{
	// Instance variables
	private final double ADDPROTEINPRICE = 1.50;
	private final double ADDFRUITPRICE = 0.50;
	private int numOfFruits;
	private boolean addProtein;

	/**
	 * Smothie Constructor
	 * @param bevName bevName
	 * @param size bev Size
	 * @param numOfFruits
	 * @param addProtein
	 */
	public Smoothie(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		super(bevName, Type.SMOOTHIE, size);
		this.numOfFruits = numOfFruits;
		this.addProtein = addProtein;
	}
	
	/**
	 * Returns NumOfFruits method
	 * @return int
	 */
	public int getNumOfFruits()
	{
		return numOfFruits;
	}
	
	/**
	 * Add Protein Method (yes or no)
	 * @return boolean
	 */
	public boolean getAddProtein()
	{
		return addProtein;
	}
	
	/**
	 * Calculate Price method
	 * @return double Calculated price
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
		
		if (addProtein)
		{
			price += ADDPROTEINPRICE;
		}
		if (numOfFruits > 0)
		{
			price += (ADDFRUITPRICE * numOfFruits);
		}
		
		return price;
	}

	/**
	 * Equals method
	 * @return boolean
	 */
	@Override
	public boolean equals(Object anotherBev)
	{
		Smoothie smoothie = (Smoothie) anotherBev;
		
		if (super.equals(smoothie) && numOfFruits == smoothie.numOfFruits && addProtein == smoothie.addProtein)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Returns toString 
	 * @return String
	 */
	@Override
	public String toString()
	{	
		return super.toString() + ", Protein Added: " + getAddProtein() + ", " + "Number Of Fruits: " + numOfFruits + ", " + "Price: " + calcPrice();
	}
}
