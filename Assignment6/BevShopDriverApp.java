/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Simple driver app class demonstrating how it works
 * Due: 08/04/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

import java.util.Scanner;

public class BevShopDriverApp 
{
	public static void main(String[] args) 
	{
		// Variables
		int tempAge, tempOrderNo;
		
		Customer tempCustomer;
		int anInvalidTime = 8; 
		int anotherInvalidTime = 24;

		BevShop b = new BevShop();
		
		// Fail
		if (!b.isValidTime(anInvalidTime))
		{
			System.out.println( "Failed the test for invalid time!!"); 
		}
		
		if (b.isValidTime(anotherInvalidTime))
		{
			System.out.println( "Failed the test for invalid time!!");  
		}
		
		// Example Values
		System.out.println(b.getMaxOrderForAlcohol()); // 3
		System.out.println(b.getMinAgeForAlcohol()); // 21
		System.out.println("Start a new order"); // Start a new order
		b.startNewOrder(12, Day.MONDAY, "John", 23);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 0.0

		tempCustomer = b.getCurrentOrder().getCustomer();

		tempCustomer.setName("kim");
		tempCustomer.setAge(10);

		System.out.println(b.getCurrentOrder().getCustomer().getName()); // John
		System.out.println(b.getCurrentOrder().getCustomer().getAge()); // 23

		tempAge = b.getCurrentOrder().getCustomer().getAge();
		System.out.println(b.isValidAge(tempAge)); // true
		
		if (b.isValidAge(tempAge)) 
		{
			System.out.println("Add alcohol drink"); // Add alcohol drink
			b.processAlcoholOrder("Mohito", Size.SMALL);
		}

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 2.0
		System.out.println(b.isEligibleForMore()); // true

		System.out.println("Add second alcohol drink"); // Add second alcohol drink
														
		b.processAlcoholOrder("tonic", Size.LARGE);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 6.0
		System.out.println(b.getNumOfAlcoholDrink()); // 2

		System.out.println("Add third alcohol drink"); // Add third alcohol
														// drink
		b.processAlcoholOrder("wine", Size.SMALL);

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 8.0

		System.out.println(b.getNumOfAlcoholDrink()); // 3

		if (!b.isEligibleForMore())
		{
			System.out.println("Maximum alcohol drink for this order"); 
		}
		
		System.out.println("Add a COFFEE to order"); // Add a COFFEE to order
		b.processCoffeeOrder("cappuchino", Size.SMALL, true, true);
		System.out.println(b.getNumOfAlcoholDrink()); // 3

		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 11.0
		tempOrderNo = b.getCurrentOrder().getOrderNo();

		if (b.findOrder(tempOrderNo) != -1) 
		{
			System.out.println("Total on the Order:" + b.totalOrderPrice(tempOrderNo)); // 11.0
		}

		else
		{
			System.out.println("order not found! Should not get to here!");
		}
		
		// Start a new order
		System.out.println("Start a new order"); 
		b.startNewOrder(10, Day.SUNDAY, "Mary", 12);

		// Total
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 0.0
		
		// Add a smoothie to order
		System.out.println("Add a SMOOTHIE to order"); 
		
		b.processSmoothieOrder("Morning Boost", Size.LARGE, 2, true);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 6.5
		System.out.println("Add a COFFEE to order");
		b.processCoffeeOrder("Latte", Size.MEDIUM, false, false);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 9.5
		System.out.println(b.getNumOfAlcoholDrink()); // 0
		if (b.isValidAge(b.getCurrentOrder().getCustomer().getAge())) 
		{
			System.out.println("Should not get to here!!!");
			b.processAlcoholOrder("mohito", Size.MEDIUM);
		} 
		else
		{
			System.out.println("Age not appropriate for alcohol drink!!"); 
		}
		
		tempOrderNo = b.getCurrentOrder().getOrderNo();

		if (b.findOrder(tempOrderNo) != -1)
		{
			System.out.println("Total on the Order:" + b.totalOrderPrice(tempOrderNo)); // 9.5
		}
		else 
		{
			System.out.println("Order not found. Should no get to here!!");
		}

		// Num of Fruits = 6
		int numOfFruits = 6;
		
		if (b.isMaxFruit(numOfFruits)) 
		{
			// Maximum number of fruits
			System.out.println("Maximum number of fruits\n"); 
		}
		numOfFruits = 5;

		b.processSmoothieOrder("Detox", Size.LARGE, numOfFruits, false);
		System.out.println("Total on the Order:" + b.getCurrentOrder().calcOrderTotal()); // 16.0
		System.out.println("Total amount for all orders:" + b.totalMonthlySale()); // 27.0
		}
}

