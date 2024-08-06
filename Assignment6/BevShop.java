/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: BevShop implements an interface
 * Due: 08/05/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming  
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Inshaal Chaudhury
*/

import java.util.ArrayList;

public class BevShop implements BevShopInterface 
{
	// Instance variables
	public int alcoholOrders;
	public int currentIndex;
	public ArrayList<Order> orders;
	
	// Constructor
	public BevShop()
	{
		this.alcoholOrders = 0;
		this.orders = new ArrayList<>();
		this.currentIndex = -1;
	}
	
	// Is Time Valid Method
	@Override
	public boolean isValidTime(int time)
	{
		if (time >= MIN_TIME && time <= MAX_TIME)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Get Max # of Fruits method
	@Override
	public int getMaxNumOfFruits()
	{
		return MAX_FRUIT;
	}
	
	// Get Min Age for Alcohol method
	@Override
	public int getMinAgeForAlcohol()
	{
		return MIN_AGE_FOR_ALCOHOL;
	}
	
	// Returns true if order exceeds max number of fruits
	@Override
	public boolean isMaxFruit(int numOfFruits)
	{
		if (numOfFruits > MAX_FRUIT)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// Get max orders for alcohol
	@Override
	public int getMaxOrderForAlcohol() 
	{
		return MAX_ORDER_FOR_ALCOHOL;
	}

	// Returns true if # of drinks reach maximum for current order
	@Override
	public boolean isEligibleForMore() 
	{
		if (alcoholOrders == MAX_ORDER_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// Returns number of alcoholic drinks 
	@Override
	public int getNumOfAlcoholDrink() 
	{
		return alcoholOrders;
	}

	// Returns true if age is greater than Minimum age
	@Override
	public boolean isValidAge(int age) 
	{
		if (age > MIN_AGE_FOR_ALCOHOL)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	// Starts new order method without a beverage
	@Override
	public void startNewOrder(int time, Day day, String customerName, int customerAge) 
	{
		Customer newCustomer = new Customer(customerName, customerAge);
		Order newOrder = new Order(time, day, newCustomer);
		orders.add(newOrder);
		alcoholOrders = 0;
		currentIndex = orders.size() - 1;
		
	}

	// Processes coffee order for the current order by adding it to the current order
	@Override
	public void processCoffeeOrder(String bevName, Size size, boolean extraShot, boolean extraSyrup) 
	{
		if (currentIndex >= 0 && currentIndex < orders.size()) 
		{
            Order currentOrder = orders.get(currentIndex);
            currentOrder.addNewBeverage(bevName, size, extraShot, extraSyrup);
        } 
		else 
		{
            System.out.println("No current order. Please start a new order.");
        }
		
	}

	// Processes Alcohol order for the current order by adding it to the current order
	@Override
	public void processAlcoholOrder(String bevName, Size size) 
	{
	    if (currentIndex >= 0 && currentIndex < orders.size()) 
	    {
	        Order currentOrder = orders.get(currentIndex);
	        
	        // Check if we can add more alcohol orders
	        if (alcoholOrders < getMaxOrderForAlcohol()) 
	        {
	            currentOrder.addNewBeverage(bevName, size); // Add the alcohol beverage to the current order
	            alcoholOrders++; // Increment the count of alcohol orders
	        } 
	        else 
	        {
	            System.out.println("Cannot add more alcohol orders. Maximum limit reached.");
	        }
	    }
	    else 
	    {
	        System.out.println("No current order. Please start a new order.");
	    }
	}

	// Processes smoothie order for the current order by adding it to the current order
	@Override
	public void processSmoothieOrder(String bevName, Size size, int numOfFruits, boolean addProtein) 
	{
		if (currentIndex >= 0 && currentIndex < orders.size()) 
		{
            Order currentOrder = orders.get(currentIndex);
            if (isMaxFruit(numOfFruits)) 
            {
                System.out.println("Maximum number of fruits exceeded.");
            } 
            else 
            {
                currentOrder.addNewBeverage(bevName, size, numOfFruits, addProtein);
            }
        } 
		
		else 
		{
            System.out.println("No current order. Please start a new order.");
        }
	}

	// Locates order based on order number 
	@Override
	public int findOrder(int orderNo) 
	{
		int orderNumber = 0;
		
		for (int i = 0; i < orders.size(); i++)
		{
			Order order = orders.get(i);
			
			if (order.getOrderNo() == orderNo)
			{
				orderNumber = i;
			}
		}
		
		return orderNumber;
	}

	// Returns the total order price of one order in a list of orders
	@Override
	public double totalOrderPrice(int orderNo) 
	{
		return orders.get(findOrder(orderNo)).calcOrderTotal();
	}

	// Calculates the total sale of all orders for this beverage shop
	@Override
	public double totalMonthlySale() 
	{
		double totalSales = 0.0;
		for (Order order : orders)
		{
			totalSales += order.calcOrderTotal();
		}
		
		return totalSales;
		
	}

	// Returns total number of orders in a month
	@Override
	public int totalNumOfMonthlyOrders() 
	{
		return orders.size();
	}

	// Returns current order located in the index in the list of orders
	@Override
	public Order getCurrentOrder() 
	{
		return orders.get(currentIndex);
	}

	// Returns order in the list of orders at the index
	@Override
	public Order getOrderAtIndex(int index) 
	{
		return orders.get(index);
	}

	// Sorts the orders by order numbers using the selection sort algorithm
	@Override
	public void sortOrders() 
	{
		int startScan, index, minIndex;
		Order minOrder;
		
		for (startScan = 0; startScan < (orders.size() - 1); startScan++)
		{
			minIndex = startScan;
			minOrder = orders.get(startScan);
			
			for (index = startScan + 1; index < orders.size(); index++)
			{
				if (orders.get(index).getOrderNo() < minOrder.getOrderNo())
				{
					minOrder = orders.get(index);
					minIndex = index;
				}
			}
			
			Order temp = orders.get(startScan);
			orders.set(startScan, orders.get(minIndex));
			orders.set(minIndex, temp);
		}
	} 
	
	// to String method
	public String toString()
	{
		String result = "Total Monthly Sales: " + totalMonthlySale() + "\n";
		
		for (int i = 0; i < orders.size(); i++)
		{
			result += "Order " + i + ": " + orders.get(i).toString() + "\n";
		}
		
		return result;
	}
