/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This class primarily serves to calculate the holiday bonuses and additionally
 * calculate the total of the holiday bonuses.
 * Due: 07/22/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Inshaal Chaudhury
*/

public class HolidayBonus extends Object
{
	// Constant Values
	private static final double HIGHEST_BONUS = 5000;
	private static final double LOWEST_BONUS = 1000;
	private static final double OTHER_BONUS = 2000;
	
	// No-arg Constructor
	public HolidayBonus()
	{
	}
	
	/**
	 * Method primarily works to calculate the holiday bonus in district 5
	 * @param data is the two dimensional array
	 * @return returns an array of the bonus for each store 
	 */
	public static double[] calculateHolidayBonus(double[][] data) 
  {
		// Creates new array to store bonuses
    	double[] bonuses = new double[data.length];
    	
    	// Nested for loop iterates by row and by column
		for (int row = 0; row < data.length; row++) 
		{
			// Accumulator is set to zero for the row
			bonuses[row] = 0;
			
			/* 
			 * Inner for loop iterates through each column and 
			 * checks if the current column's value in the current row
			 * is either the highest or lowest in that column across all rows
			 */
			for (int col = 0; col < data[row].length; col++) 
			{
				if (TwoDimRaggedArrayUtility.getLowestInColumnIndex(data, col) == row) 
					bonuses[row] += LOWEST_BONUS;
				else if (TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, col) == row) 
					bonuses[row] += HIGHEST_BONUS;
				else 
					bonuses[row] += OTHER_BONUS;
			}
		}
		
		return bonuses;
  }
	
	/**
	 * Method calculates the total of the holiday bonuses
	 * @param data is the two dim array
	 * @return returns a double with the total
	 */
	public static double calculateTotalHolidayBonus(double[][] data)
	{
		/* Array that stores the bonuses from the data ragged array
		 * totalBonuses is a running total initialized to 0
		 */
		double[] bonuses = calculateHolidayBonus(data);
		double totalBonuses = 0;
		
		// Accumulates using an enhanced for loop 
		for (double bonus : bonuses)
		{
			totalBonuses += bonus;
		}
		
		return totalBonuses;
	}
}
