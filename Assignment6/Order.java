/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Order implements an interface
 * Due: 08/04/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Order implements OrderInterface, Comparable<Order>
{
	// Instance variables
	private int orderNum;
	private int orderTime;
	private Day orderDay;
	private Customer cust;
	private List<Beverage> beverages;
	
	/**
	 * Constructor
	 * @param orderTime
	 * @param orderDay
	 * @param cust
	 */
	public Order(int orderTime, Day orderDay, Customer cust)
	{
		this.orderTime = orderTime;
		this.orderDay = orderDay;
		this.cust = cust;
		beverages = new ArrayList<>();
	}
	
	/**
	 * Generate random order number from 10000 to 90000
	 * @return integer number
	 */
	public int generateOrder()
	{
		Random random = new Random();
		int number = random.nextInt(80001) + 10000;
		return number;
	}
	
	/**
	 * Returns order number
	 * @return order number
	 */
	public int getOrderNo()
	{
		return orderNum;
	}
	
	/**
	 * Returns order time
	 * @return integer of order time
	 */
	public int getOrderTime()
	{
		return orderTime;
	}
	
	/**
	 * Returns day from enum list
	 * @return Day
	 */
	public Day getOrderDay()
	{
		return orderDay;
	}
	
	/**
	 * Returns customer object
	 * @return Customer
	 */
	public Customer getCustomer()
	{
		return cust;
	}
	
	/**
	 * Returns true/false if it is the weekend
	 * @return boolean
	 */
	public boolean isWeekend()
	{
		if (orderDay == Day.SATURDAY || orderDay == Day.SUNDAY)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * Get beverage object
	 * @param itemNo is the itemNumber
	 * @return beverage type
	 */
	public Beverage getBeverage(int itemNo)
	{
		return beverages.get(itemNo);
	}
	
	/**
	 * Returns total number of beverages in order
	 * @return int
	 */
	public int getTotalItems()
	{
		return beverages.size();
	}
	
	/**
	 * Adds coffee beverage to order list
	 * @param bevName
	 * @param size
	 * @param extraShot
	 * @param extraSyrup
	 */
	public void addNewBeverage(String bevName, Size size, boolean extraShot, boolean extraSyrup)
	{
		Coffee coffee = new Coffee(bevName, size, extraShot, extraSyrup);
		beverages.add(coffee);
	}
	
	/**
	 * Adds alcoholic beverage to list
	 * @param bevName
	 * @param size
	 */
	public void addNewBeverage(String bevName, Size size)
	{
		Alcohol alcohol = new Alcohol(bevName, size, this.isWeekend());
		beverages.add(alcohol);
	}
	
	/**
	 * Adds smoothie beverage to list
	 * @param bevName
	 * @param size
	 * @param numOfFruits
	 * @param addProtein
	 */
	public void addNewBeverage(String bevName, Size size, int numOfFruits, boolean addProtein)
	{
		Smoothie smoothie = new Smoothie(bevName, size, numOfFruits, addProtein);
		beverages.add(smoothie);
	}
	
	/**
	 * Calculates total price on the entire order
	 * @return double of total bill
	 */
	public double calcOrderTotal()
	{
		double totalPrice = 0;
		
		for (Beverage beverage : beverages)
		{
			totalPrice += beverage.calcPrice();
		}
		
		return totalPrice;
	}
	
	/**
	 * Finds the number of bevs with the same type in a list
	 * @param type of beverage type
	 * @return integer of index
	 */
	public int findNumOfBeveType(Type type)
	{
		int numOfBeveType = 0;
		
		for (Beverage beverage : beverages)
		{
			if (type.equals(beverage.getType()))
			{
				numOfBeveType++;
			}
		}
		
		return numOfBeveType;
	}
	
	// To String method
	/**
	 * toString method
	 * @return String concantenation
	 */
	@Override
	public String toString()
	{
		String result = "Order Number: " + orderNum + ", " + "Order Time: " + orderTime + ", Order Day: " 
		+ orderDay + ", Cust Name: " + cust.getName() + ", Cust Age: " + cust.getAge() + "\n";
		
		result += "Beverage List: ";
		for (Beverage beverage : beverages)
		{
			result += beverage.getBevName();
			result += ", ";
		}
		
		return result;
	}
	
	// Compare to Method
	@Override
	/**
	 * Compares one order with another
	 * @return int 
	 */
	public int compareTo(Order anotherOrder)
	{
		int equalsNum = 0;
		
		if (orderNum == anotherOrder.getOrderNo())
		{
			equalsNum = 0;
		}
		else if (orderNum > anotherOrder.getOrderNo())
		{
			equalsNum = 1;
		}
		else if (orderNum < anotherOrder.getOrderNo())
		{
			equalsNum = -1;
		}
		
		return equalsNum;
	}
}
