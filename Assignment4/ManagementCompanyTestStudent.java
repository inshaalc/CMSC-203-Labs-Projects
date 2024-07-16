/**
 * Programmer : Inshaal Chaudhury
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyTestStudent 
{
	private ManagementCompany company;

    @BeforeEach
    public void setUp() 
    {
        company = new ManagementCompany("TestCompany", "12345", 10.0);
    }

    // Constructor tests
    @Test
    public void testDefaultConstructor() 
    {
        ManagementCompany mc = new ManagementCompany();
        assertNotNull(mc);
        assertEquals("", mc.getName());
        assertEquals("", mc.getTaxID());
        assertEquals(0.0, mc.getMgmFeePer());
        assertEquals(0, mc.getPropertiesCount());
        assertEquals(0.0, mc.getTotalRent());
    }

    @Test
    public void testConstructorWithNameTaxIDFee() 
    {
        assertEquals("TestCompany", company.getName());
        assertEquals("12345", company.getTaxID());
        assertEquals(10.0, company.getMgmFeePer());
    }

    @Test
    public void testConstructorWithNameTaxIDFeePlot() 
    {
        ManagementCompany mc = new ManagementCompany("TestCompany", "12345", 10.0, 1, 2, 5, 5);
        assertEquals(1, mc.getPlot().getX());
        assertEquals(2, mc.getPlot().getY());
        assertEquals(5, mc.getPlot().getWidth());
        assertEquals(5, mc.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() 
    {
        ManagementCompany mcCopy = new ManagementCompany(company);
        assertEquals(company.getName(), mcCopy.getName());
        assertEquals(company.getTaxID(), mcCopy.getTaxID());
        assertEquals(company.getMgmFeePer(), mcCopy.getMgmFeePer());
        assertEquals(company.getPropertiesCount(), mcCopy.getPropertiesCount());
        assertEquals(company.getTotalRent(), mcCopy.getTotalRent());
    }

    // Method tests
    @Test
    public void testAddProperty() 
    {
        int index = company.addProperty("Property1", "City1", 1000.0, "Owner1");
        assertEquals(0, index);
        assertEquals(1, company.getPropertiesCount());
        assertEquals(1000.0, company.getTotalRent());
    }

    @Test
    public void testAddPropertyWithPlot() 
    {
        int index = company.addProperty("Property2", "City2", 1500.0, "Owner2", 1, 1, 4, 4);
        assertEquals(0, index);
        assertEquals(1, company.getPropertiesCount());
        assertEquals(1500.0, company.getTotalRent());
    }

    @Test
    public void testAddPropertyObject() 
    {
        Property property = new Property("Property3", "City3", 2000.0, "Owner3", 2, 2, 3, 3);
        int index = company.addProperty(property);
        assertEquals(0, index);
        assertEquals(1, company.getPropertiesCount());
        assertEquals(2000.0, company.getTotalRent());
    }

    @Test
    public void testRemoveLastProperty() 
    {
        company.addProperty("Property4", "City4", 2500.0, "Owner4");
        company.removeLastProperty();
        assertEquals(0, company.getPropertiesCount());
        assertEquals(0.0, company.getTotalRent());
    }

    @Test
    public void testIsPropertiesFull() 
    {
        assertFalse(company.isPropertiesFull());
        for (int i = 0; i < 5; i++) {
            company.addProperty("Property" + i, "City" + i, 1000.0 + i * 500, "Owner" + i);
        }
        assertTrue(company.isPropertiesFull());
    }

    @Test
    public void testGetPropertiesCount() 
    {
        assertEquals(0, company.getPropertiesCount());
        company.addProperty("Property5", "City5", 3000.0, "Owner5");
        assertEquals(1, company.getPropertiesCount());
    }

    @Test
    public void testGetTotalRent() 
    {
        assertEquals(0.0, company.getTotalRent());
        company.addProperty("Property6", "City6", 3500.0, "Owner6");
        assertEquals(3500.0, company.getTotalRent());
    }

    @Test
    public void testGetHighestRentProperty() 
    {
        company.addProperty("Property7", "City7", 4000.0, "Owner7");
        company.addProperty("Property8", "City8", 2000.0, "Owner8");
        Property highestRentProperty = company.getHighestRentPropperty();
        assertEquals("Property7", highestRentProperty.getPropertyName());
        assertEquals(4000.0, highestRentProperty.getRentAmount());
    }

    @Test
    public void testIsManagementFeeValid() 
    {
        assertTrue(company.isMangementFeeValid());
        ManagementCompany highFeeCompany = new ManagementCompany("HighFeeCompany", "54321", 150.0);
        assertFalse(highFeeCompany.isMangementFeeValid());
    }

    @Test
    public void testGetName() 
    {
        assertEquals("TestCompany", company.getName());
    }

    @Test
    public void testGetTaxID() 
    {
        assertEquals("12345", company.getTaxID());
    }

    @Test
    public void testGetProperties() 
    {
        assertNotNull(company.getProperties());
    }

    @Test
    public void testGetMgmFeePer() 
    {
        assertEquals(10.0, company.getMgmFeePer());
    }

    @Test
    public void testGetPlot() 
    {
        assertEquals(0, company.getPlot().getX());
        assertEquals(0, company.getPlot().getY());
        assertEquals(10, company.getPlot().getWidth());
        assertEquals(10, company.getPlot().getDepth());
    }

    @Test
    public void testCalculateTotalManagementFee() 
    {
        company.addProperty("Property9", "City9", 5000.0, "Owner9");
        assertEquals(500.0, company.calculateTotalManagementFee());
    }

    @Test
    public void testToString() 
    {
        company.addProperty("Property10", "City10", 6000.0, "Owner10");
        String expectedString = "List of the properties for TestCompany, taxID: 12345\n" +
                                "______________________________________________________\n" +
                                "Property10,City10,Owner10,6000.0\n" +
                                "______________________________________________________\n\n" +
                                " total management Fee: 600.00";
        assertEquals(expectedString, company.toString());
    }
}
