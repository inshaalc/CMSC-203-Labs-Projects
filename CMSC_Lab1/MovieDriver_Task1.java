/**
 * Programmer: Inshaal Chaudhury
 * Class: CMSC 203 - 40438
 * Assignment: Lab 1
 * MovieDriver_Task1.java
 */

import java.util.Scanner;

public class MovieDriver_Task1 
{
	public static void main(String[] args) 
	{
		// Scanner object
		Scanner keyboard = new Scanner(System.in);
		
		// Movie object
		Movie movie = new Movie();
		
		// Prompt user for movie title
		System.out.println("Enter the name of a movie: ");
		String movieTitle = keyboard.nextLine();
		
		// Set title into movie object
		movie.setTitle(movieTitle);
		
		// Prompt user for movie rating
		System.out.println("Enter the rating of the movie: ");
		String movieRating = keyboard.nextLine();
		
		// Set rating into movie object
		movie.setRating(movieRating);
		
		// Prompt user for # of tickets sold
		System.out.println("Enter the number of tickets sold for this movie: ");
		int tickets = keyboard.nextInt();
		
		// Set tickets into movie object
		movie.setSoldTickets(tickets);
		
		// toString method to print out information
		System.out.println(movie.toString());
		System.out.println("Goodbye");
		keyboard.close();
	}
}
