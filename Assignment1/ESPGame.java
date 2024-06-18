/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Create a program that tests your extrasensory perception. 
 * In this program, the user selects a color from a list, while the program 
 * randomly selects a color from the list provided. It tests the user 3 times. 
 * Upon completion, the program displays whether the user selected the same color as the program for each turn. 
 * In additon, the program asks for the users name, due date, and asks the user to write a sentence describing themselbes. 
 * Finally, the program should display this information at the end.
 * Due: 06/17/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment 
 * independently. I have not copied the code from a student or   * any source. I have not given my code to any student.
 * Print your Name here: Inshaal Chaudhury
*/

import java.io.*;
import java.util.Scanner;
import java.util.Random;

public class ESPGame 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		// Start
		System.out.println("CMSC203 Assignment1: Test your ESP skills!");
		
		// Entering Filename
		Scanner keyboard = new Scanner(System.in);
		
		/*
		 *  have colors.txt file in eclipse-workspace folder of the project next to bin and src folders
		 */
		
		System.out.print("Enter the filename: ");
		String filename = keyboard.nextLine();
		
		// Open the file
		File file = new File(filename);
		Scanner inputFile = new Scanner(file);
		
		// Read the file
		System.out.println("There are sixteen colors from a file: ");
		
		// Display the colors
		while (inputFile.hasNext())
		{
			String line = inputFile.nextLine();			
			System.out.println(line);
		}

		// Constants
		final String COLOR_BLACK = "Black";
		final String COLOR_WHITE = "White";
		final String COLOR_GRAY = "Gray";
		final String COLOR_SILVER = "Silver";
		final String COLOR_MAROON = "Maroon";
		final String COLOR_RED = "Red";
		final String COLOR_PURPLE = "Purple";
		final String COLOR_FUCHSIA = "Fuchsia";
		final String COLOR_GREEN = "Green";
		final String COLOR_LIME = "Lime";
		final String COLOR_OLIVE = "Olive";
		final String COLOR_YELLOW = "Yellow";
		final String COLOR_NAVY = "Navy";
		final String COLOR_BLUE = "Blue";
		final String COLOR_TEAL = "Teal";
		final String COLOR_AQUA = "Aqua";
		final int MAX_COLORS = 16;
		final int MIN_COLORS = 1;
		
		// Random Generator Object
		Random RANDOM_COLOR_GEN = new Random();
		
		// Accumulator
		int correct = 0;
		String random_color;
		
		// New Scanner for user guesses
		Scanner user_guess = new Scanner(System.in);
		
		// For statement, repeated for all three rounds
		for (int i = 1; i <= 3; i++)
		{
			// Random Color Selected Variable between 1 and 16
			int color_num = RANDOM_COLOR_GEN.nextInt(MAX_COLORS) + MIN_COLORS;
			
			// Switch statement to assign a Random # to color from list of constant colors
			switch (color_num)
			{
				case 1:
					random_color = COLOR_BLACK;
					break;
					
				case 2:
					random_color = COLOR_WHITE;
					break;
				
				case 3:
					random_color = COLOR_GRAY;
					break;
				
				case 4:
					random_color = COLOR_SILVER;
					break;
				
				case 5:
					random_color = COLOR_MAROON;
					break;
				
				case 6:
					random_color = COLOR_RED;
					break;
				
				case 7:
					random_color = COLOR_PURPLE;
					break;
				
				case 8:
					random_color = COLOR_FUCHSIA;
					break;
				
				case 9:
					random_color = COLOR_GREEN;
					break;
				
				case 10:
					random_color = COLOR_LIME;
					break;
				
				case 11:
					random_color = COLOR_OLIVE;
					break;
				
				case 12:
					random_color = COLOR_YELLOW;
					break;
				
				case 13:
					random_color = COLOR_NAVY;
					break;
				
				case 14:
					random_color = COLOR_BLUE;
					break;
				
				case 15:
					random_color = COLOR_TEAL;
					break;
				
				case 16:
					random_color = COLOR_AQUA;
					break;
				
				default:
					random_color = "Unknown";
					break;
			}
			
			// Flags & Sentinels
			boolean isValid = false;
			String color_guess = "";
			
			// Prompt with input validation using while loop w/ nested if/else statement 
			while (!isValid)
			{
				// Prompt user to type in their guess
				System.out.println("\nRound " + i);
				System.out.println("\nI am thinking of a color\n" + "Is it one from the list of colors above?" + "\nEnter your guess: ");
				color_guess = user_guess.nextLine();			
				
				if (color_guess.equalsIgnoreCase(COLOR_BLACK) || color_guess.equalsIgnoreCase(COLOR_WHITE) || color_guess.equalsIgnoreCase(COLOR_GRAY) || 
	                    color_guess.equalsIgnoreCase(COLOR_SILVER) || color_guess.equalsIgnoreCase(COLOR_MAROON) || color_guess.equalsIgnoreCase(COLOR_RED) || 
	                    color_guess.equalsIgnoreCase(COLOR_PURPLE) || color_guess.equalsIgnoreCase(COLOR_FUCHSIA) || color_guess.equalsIgnoreCase(COLOR_GREEN) || 
	                    color_guess.equalsIgnoreCase(COLOR_LIME) || color_guess.equalsIgnoreCase(COLOR_OLIVE) || color_guess.equalsIgnoreCase(COLOR_YELLOW) || 
	                    color_guess.equalsIgnoreCase(COLOR_NAVY) || color_guess.equalsIgnoreCase(COLOR_BLUE) || color_guess.equalsIgnoreCase(COLOR_TEAL) || 
	                    color_guess.equalsIgnoreCase(COLOR_AQUA)) 
				{
					isValid = true;
	            } 
				else 
	            {
					System.out.println("Invalid color. Please enter a color from the list.");
	            }
			}
			
			// Reveals color chosen by system 
			System.out.println("\nI was thinking of " + random_color + ".");
			
			// Accumulator if statement
			if (color_guess.equalsIgnoreCase(random_color))
			{
				correct++;
			}
		}
		
		// Game over
		System.out.println("Game over");
		
		// # of Correct Guesses
		System.out.println("\nYou guessed " + correct + " out of 3 colors correctly.\n");
		
		// User name prompt
		System.out.print("Enter your name: ");
		String user_name = keyboard.nextLine();
		
		// Describe yourself
		System.out.print("Describe yourself: ");
		String description = keyboard.nextLine();
		
		// Due date		
		System.out.print("Due Date: ");
		String dueDate = keyboard.nextLine();
		
		// Print user information
		System.out.println("User Name: " + user_name);
		System.out.println("Describe yourself: " + description);
		System.out.println("Date: " + dueDate);
		
		keyboard.close();		
	}
}
