/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Primarily manages a group of properties while providing various methods to manipulate and retrieve information about these properties. 
 * It is designed to handle the important operations of a property management company, including adding and removing properties, calculating total rent, etc.
 * Due: 07/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Inshaal Chaudhury
*/

import java.lang.Object;

public class ManagementCompany extends Object
{
	// Constants
	public static final int MAX_PROPERTY = 5;
	public static final int MGMT_DEPTH = 10;
	public static final int MGMT_WIDTH = 10;
	
	// Instance Fields
	private String name;
	private String taxID;
	private double mgmFee;
	private Property[] properties;
	private Plot plot;
	private int numberOfProperties;
	
	// Constructors
	public ManagementCompany()
	{
		name = "";
		taxID = "";
		mgmFee = 0.0;
		properties = new Property[MAX_PROPERTY];
		plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.numberOfProperties = 0;
	}
	
	public ManagementCompany(String name, String taxID, double mgmFee, int x, int y, int width, int depth)
	{
		this.name = name;
		this.taxID = taxID;
		this.mgmFee = mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		this.plot = new Plot(x, y, width, depth);
		this.numberOfProperties = 0;
	}
	
	// Copy constructor
	public ManagementCompany(ManagementCompany otherCompany)
	{
		this.name = otherCompany.name;
		this.taxID = otherCompany.taxID;
		this.mgmFee = otherCompany.mgmFee;
		this.properties = new Property[MAX_PROPERTY];
		
		// Deep copy for array
		for (int i = 0; i < otherCompany.numberOfProperties; i++)
		{
			this.properties[i] = new Property(otherCompany.properties[i]);
		}
		
		this.plot = new Plot(otherCompany.plot);
		this.numberOfProperties = otherCompany.numberOfProperties;
	}
	
	// Methods
	public int addProperty(String name, String city, double rent, String owner)
	{
		// checks if array is full
		if (numberOfProperties >= MAX_PROPERTY)
		{
			return -1;
		}
		
		// checks if property object is null
		Property newProperty = new Property(name, city, rent, owner);
		if (newProperty == null)
		{
			return -2;
		}
		
		// checks if plot is not encompassed by management company plot
		if (!plot.encompasses(newProperty.getPlot()))
		{
			return -3;
		}
		
		// checks if property plot overlaps with any existing properties
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].getPlot().overlaps(newProperty.getPlot()))
			{
				return -4;
			}
		}
		
		// if all checks pass, and property is successfully added, returns index of the array where the property was added
		properties[numberOfProperties] = newProperty;
		int addedIndex = numberOfProperties;
		numberOfProperties++;
		return addedIndex;
	}
	
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth)
	{
		// checks if array is full
		if (numberOfProperties >= MAX_PROPERTY)
		{
			return -1;
		}
		
		// checks if property object is null
		Property newProperty = new Property(name, city, rent, owner, x, y, width, depth);
		if (newProperty == null)
		{
			return -2;
		}
		
		// checks if plot is not encompassed by management company plot
		if (!plot.encompasses(newProperty.getPlot()))
		{
			return -3;
		}
		
		// checks if property plot overlaps with any existing properties
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].getPlot().overlaps(newProperty.getPlot()))
			{
				return -4;
			}
		}
		
		// if all checks pass, and property is successfully added, returns index of the array where the property was added
		properties[numberOfProperties] = newProperty;
		int addedIndex = numberOfProperties;
		numberOfProperties++;
		return addedIndex;		
	}
	
	// Copy Property Method
	public int addProperty(Property property)
	{
		// checks if array is full
		if (numberOfProperties >= MAX_PROPERTY)
		{
			return -1;
		}
		
		// checks if property object is null
		if (property == null)
		{
			return -2;
		}
		
		// checks if plot is not encompassed by management company plot
		if (!plot.encompasses(property.getPlot()))
		{
			return -3;
		}
		
		// checks if property plot overlaps with any existing properties
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].getPlot().overlaps(property.getPlot()))
			{
				return -4;
			}
		}
		
		// if all checks pass, and property is successfully added, returns index of the array where the property was added
		properties[numberOfProperties] = new Property(property);
		int addedIndex = numberOfProperties;
		numberOfProperties++;
		return addedIndex;			
	}
	
	public void removeLastProperty()
	{
		if (numberOfProperties > 0)
		{
			properties[numberOfProperties - 1] = null;
			numberOfProperties--;
		}
	}
	
	public boolean isPropertiesFull()
	{
		if (numberOfProperties == MAX_PROPERTY)
		{
			return true;
		}
		else 
		{
			return false;
		}
	}
	
	public int getPropertiesCount()
	{
		return numberOfProperties;
	}
	
	public double getTotalRent()
	{
		double totalRent = 0.0;
		for (int i = 0; i < numberOfProperties; i++)
		{
			totalRent += properties[i].getRentAmount();
		}
		
		return totalRent;
	}
	
	public Property getHighestRentPropperty()
	{
		Property highestRentProperty = properties[0];
		
		for (int i = 0; i < numberOfProperties; i++)
		{
			if (properties[i].getRentAmount() > highestRentProperty.getRentAmount())
			{
				highestRentProperty = properties[i];
			}
		}
		
		return highestRentProperty;
	}
	
	public boolean isMangementFeeValid()
	{
		if (mgmFee > 0 && mgmFee < 100)
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	// Accessor Methods
	
	public String getName()
	{
		return name;
	}
	
	public String getTaxID()
	{
		return taxID;
	}
	
	public Property[] getProperties()
	{
		return properties;
	}
	
	public double getMgmFeePer()
	{
		return mgmFee;
	}
	
	public Plot getPlot()
	{
		return plot;
	}
	
	public double calculateTotalManagementFee() 
	{
	    double totalRent = getTotalRent();
	    double managementFeeAmount = totalRent * (mgmFee / 100.0);
	    return managementFeeAmount;
	}
	
	public String toString()
	{
		String finalString = "";
		
		// Header
		finalString += "List of the properties for " + name + ", taxID: " + taxID + "\n";
		finalString += "______________________________________________________\n";
		
		// Property Details
		for (int i = 0; i < numberOfProperties; i++)
		{
			Property property = properties[i];
			finalString += property.getPropertyName() + "," + property.getCity() + "," + property.getOwner() + "," + property.getRentAmount() + "\n";
			
		}
		
		// Final Footer
		finalString += "______________________________________________________\n";
		finalString += "\n total management Fee: " + String.format("%.2f", calculateTotalManagementFee());
		
		return finalString;
	}
}
