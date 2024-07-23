/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: This class primarily serves as the class that reads and writes documents into a TwoDimArray,
 * returning several values such as the average, total, etc.
 * Due: 07/22/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Inshaal Chaudhury
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility extends Object
{
	
	// No-arg Constructor
	public TwoDimRaggedArrayUtility()
	{
	}
	
	/**
	 * @param file is the file to read from
	 * @return returns a two dimensional ragged array 
	 * @throws FileNotFoundException if the file is not found
	 * method essentially reads data from a file and returns a ragged array of doubles
	 */
	public static double[][] readFile(File file) throws FileNotFoundException
	{
		// Create a Scanner that reads the file
		Scanner scanner = new Scanner(file);
		
		// Initializes rows counter to zero
		int rows = 0;
		
		// While loop that checks if the file has another line, rows adds 1 and it reads the next line
		while (scanner.hasNextLine())
		{
			rows++;
			scanner.nextLine();
		}
		
		// Scanner closes
		scanner.close();
		
		// Ragged array with unknown number of columns but uses the rows from above
		double[][] data  = new double[rows][];
		
		// Creates another scanner
		Scanner input = new Scanner(file);
		
		// Nested For loop, where outer loop iterates through each row and inner iterates through the columns 
		for (int row = 0; row < data.length; row++) 
		{
			// New string equals the next line
			String line = input.nextLine();
			// String array has elements that are stripped from their white spaces
			String[] separated = line.split(" ");
			
			// the row data is a double type
			data[row] = new double[separated.length];
			
			for (int col = 0; col < data[row].length; col++) 
			{
				data[row][col] = Double.valueOf(separated[col]);
			}
		}
		
		input.close();
		return data;
	}
	
	/**
	 * This method writes the data from the array into an output file
	 * @param data is the two dim ragged array
	 * @param outputFile file we are writing to
	 * @throws FileNotFoundException if no file is found
	 */
	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException
	{
		// Creates PrintWriter object
		PrintWriter writer = new PrintWriter(outputFile);
		
		// Iterates through each row of data, constructing a new line by appending each element with a space
		for (double[] row : data)
		{
			
			StringBuilder line = new StringBuilder();
			
			for (int col = 0; col < row.length; col++)
			{
				line.append(row[col]).append(" ");
			}
			
			// Prints a new line to the file while removing the trailing space
			writer.println(line.toString().trim());
		}
		
		writer.close();
	}
	
	/**
	 * this method primarily serves to return the sum of all elements in an array
	 * @param data is the two dim ragged array
	 * @return returns the sum of all elements in the array
	 */
	public static double getTotal(double[][] data)
	{
		// Initialize total to 0 (counter)
		double total = 0;
		
		// For loop to calculator total
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
			}
		}
		
		return total;
	}
	
	/**
	 * this method serves to return the average of all the data in the two dim ragged array
	 * @param data is the two dim ragged array
	 * @return returns the average of all of the elements in the array
	 */
	public static double getAverage(double[][] data)
	{
		// Initialize double values that acts as counters
		double total = 0;
		int numOfElements = 0;
		
		// Increments the total sum of the data as well as the total number of elements
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				total += data[row][col];
				numOfElements++;
			}
		}
		
		// If statement checks if the denominator doesn't equal to 0, resulting in a calculation of the average
		if (numOfElements != 0)
		{
			return (total / numOfElements); 
		}
		else
		{
			return 0;
		}
	}
	
	/**
	 * Returns the total of the selected row in the two dimensional array index 0 refers to the first row.
	 * @param data is the two dim array
	 * @param row is the row index to take the total of (0 refers to first row)
	 * @return returns the total of the row
	 */
	public static double getRowTotal(double[][] data, int row)
	{
		// Initializes row total values to zero initially
		double rowTotal = 0;
		
		// For loop increments the total value per element in a row
		for (int col = 0; col < data[row].length; col++)
		{
			rowTotal += data[row][col];
		}
		
		return rowTotal;
	}
	
	/**
	 * Returns the total of the selected column in the two dim array
	 * @param data is the two dim array
	 * @param col is the column index to take the total of
	 * @return returns the total of the column
	 */
	public static double getColumnTotal(double[][] data, int col)
	{
		// Initializes column total values to zero initially 
		double colTotal = 0;
		
		// For loop increments the column total
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length)
			{
				colTotal += data[row][col];
			}
		}
		
		return colTotal;
	}
	
	/**
	 * Method returns the largest element in the specified row within the two dim array
	 * @param data is the two dim array
	 * @param row is the specified row
	 * @return returns the largest element in the row 
	 */
	public static double getHighestInRow(double[][] data, int row)
	{
		// Initializes largest element in row with first column
		double highestElement = data[row][0];
		
		// For loop sets the largest element if it is lower than the element it is being compared to
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] > highestElement)
			{
				highestElement = data[row][col];
			}
		}
		
		return highestElement;
	}
	
	/**
	 * Method returns the index of the largest element in the specified row
	 * @param data is the two dim array
	 * @param row is the specified row
	 * @return returns the index of the largest element in the specified row
	 */
	public static int getHighestInRowIndex(double[][] data, int row)
	{
		// Initializes the index to 0, and the highest value to the first column of the row
		int index = 0;
		double highestValue = data[row][0];
		
		// For loop checks per column the highest value, as well as sets the index to the column that has the largest element in the row
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] > highestValue)
			{
				highestValue = data[row][col];
				index = col;
			}
		}
		
		return index;
	}
	
	/**
	 * Method returns the lowest element in the specified row
	 * @param data is the two dim ragged array
	 * @param row is the specified row
	 * @return returns the lowest element in the array 
	 */
	public static double getLowestInRow(double[][] data, int row)
	{
		// Initializes lowest element in row with first column
		double lowestElement = data[row][0];
		
		// For loop sets the lowest element if it is higher than the element it is being compared to
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] < lowestElement)
			{
				lowestElement = data[row][col];
			}
		}	
		
		return lowestElement;
	}
	
	/**
	 * Method returns the index of the lowest element in the array
	 * @param data is the two dim ragged array
	 * @param row is the specified row
	 * @return returns the index of the lowest element in the array
	 */
	public static int getLowestInRowIndex(double[][] data, int row)
	{
		// initializes lowest element and index in row with first column
		int index = 0;
		double lowestElement = data[row][0];
		
		// For loop sets the lowest element if it is higher than the element it is being compared to
		for (int col = 0; col < data[row].length; col++)
		{
			if (data[row][col] < lowestElement)
			{
				lowestElement = data[row][col];
				index = col;
			}
		}	
		
		return index;
	}
	
	/**
	 * Method returns the largest element in a specified column within a two dim array
	 * @param data is the two dim array
	 * @param col is the specified array
	 * @return returns highest element in the array 
	 */
	public static double getHighestInColumn(double[][] data, int col)
	{
		// Initializes highest element to begin in first row
		double highestElement = data[0][col];
		
		// For loop sets highest in column after checking if it col is within the bounds of the current row 
		// & if the highestElement is lower than the element is is being compared to
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length && data[row][col] > highestElement)
			{
				highestElement = data[row][col];
			}
		}
		
		return highestElement;
	}
	
	/**
	 * Method returns the largest element in the column's index
	 * @param data is the two dim array
	 * @param col is the specified array
	 * @return returns the highest element in the column's index
	 */
	public static int getHighestInColumnIndex(double[][] data, int col)
	{
		// Initializes highest element to begin in first row and for the index to begin at 0	
		int index = 0;
		double highestElement = data[0][col];
		
		// For loop sets highest in column after checking if it col is within the bounds of the current row 
		// & if the highestElement is lower than the element is is being compared to
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length && data[row][col] > highestElement)
			{
				highestElement = data[row][col];
				index = row;
			}
		}
		
		return index;
	}

	/**
	 * Method returns the smallest element in the specified column in the two dim array
	 * @param data is the two dimensional array
	 * @param col is the specified column
	 * @return returns the smallest element in the column in the array
	 */
	public static double getLowestInColumn(double[][] data, int col)
	{
		// Initializes the lowest element to be in the first row 
		double lowestElement = data[0][col];
		
		// For loop sets lowest in column 
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length && data[row][col] < lowestElement)
			{
				lowestElement = data[row][col];
			}
		}
		
		return lowestElement;
	}
	
	/**
	 * Method returns the smallest element's index in the specified column
	 * @param data is the two dim array
	 * @param col is the specified column
	 * @return returns the smallest element's index in the column in the array
	 */
	public static int getLowestInColumnIndex(double[][] data, int col)
	{
		// Initializes the lowest element to be in the first row & index to equal 0
		int index = 0;
		double lowestElement = data[0][col];
		
		// For loop sets lowest in column as well as the index to equal the row
		for (int row = 0; row < data.length; row++)
		{
			if (col < data[row].length && data[row][col] < lowestElement)
			{
				lowestElement = data[row][col];
				index = row;
			}
		}
		
		return index;
	}
	
	/**
	 * Method returns the largest element in the array
	 * @param data is the two dim array
	 * @return returns the largest element in the array
	 */
	public static double getHighestInArray(double[][] data)
	{
		// Initialize the highest element to start from the first row, first column element
		double highestElement = data[0][0];
		
		// For loop iterates through each row and column and compares it to the highest element
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				if (data[row][col] > highestElement)
				{
					highestElement = data[row][col];
				}
			}
		}
		
		return highestElement;
	}
	
	/**
	 * Method returns the smallest element in the array
	 * @param data is the two dimensional array
	 * @return returns the smallest element in the array
	 */
	public static double getLowestInArray(double[][] data)
	{
		// Check if the array is empty
	    if (data.length == 0 || data[0].length == 0) 
	    {
	        throw new IllegalArgumentException("The array is empty or improperly initialized.");
	    }
	    
		// Initializes the lowest element to start from the first row, first column element 
		double lowestElement = data[0][0];
		
		// For loop iterates through each row and column and compares it to the lowest element
		for (int row = 0; row < data.length; row++)
		{
			for (int col = 0; col < data[row].length; col++)
			{
				if (data[row][col] < lowestElement)
				{
					lowestElement = data[row][col];
				}
			}
		}
		return lowestElement;
	}
}
