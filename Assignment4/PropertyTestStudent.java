/**
 * Programmer : Inshaal Chaudhury
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent 
{

	private Property defaultProperty;
    private Property parameterizedProperty;
    private Property fullProperty;
    private Property copiedProperty;

    @BeforeEach
    public void setUp() 
    {
        defaultProperty = new Property();
        parameterizedProperty = new Property("Sunset Villa", "Los Angeles", 2500.0, "John Doe");
        fullProperty = new Property("Ocean Breeze", "Miami", 3500.0, "Jane Smith", 5, 5, 10, 10);
        copiedProperty = new Property(fullProperty);
    }

    @Test
    public void testDefaultConstructor() 
    {
        assertEquals("", defaultProperty.getPropertyName());
        assertEquals("", defaultProperty.getCity());
        assertEquals(0.0, defaultProperty.getRentAmount());
        assertEquals("", defaultProperty.getOwner());
        assertNotNull(defaultProperty.getPlot());
    }

    @Test
    public void testParameterizedConstructor() 
    {
        assertEquals("Sunset Villa", parameterizedProperty.getPropertyName());
        assertEquals("Los Angeles", parameterizedProperty.getCity());
        assertEquals(2500.0, parameterizedProperty.getRentAmount());
        assertEquals("John Doe", parameterizedProperty.getOwner());
        assertNotNull(parameterizedProperty.getPlot());
    }

    @Test
    public void testFullConstructor() 
    {
        assertEquals("Ocean Breeze", fullProperty.getPropertyName());
        assertEquals("Miami", fullProperty.getCity());
        assertEquals(3500.0, fullProperty.getRentAmount());
        assertEquals("Jane Smith", fullProperty.getOwner());
        assertNotNull(fullProperty.getPlot());
        assertEquals(5, fullProperty.getPlot().getX());
        assertEquals(5, fullProperty.getPlot().getY());
        assertEquals(10, fullProperty.getPlot().getWidth());
        assertEquals(10, fullProperty.getPlot().getDepth());
    }

    @Test
    public void testCopyConstructor() 
    {
        assertEquals("Ocean Breeze", copiedProperty.getPropertyName());
        assertEquals("Miami", copiedProperty.getCity());
        assertEquals(3500.0, copiedProperty.getRentAmount());
        assertEquals("Jane Smith", copiedProperty.getOwner());
        assertNotNull(copiedProperty.getPlot());
        assertEquals(5, copiedProperty.getPlot().getX());
        assertEquals(5, copiedProperty.getPlot().getY());
        assertEquals(10, copiedProperty.getPlot().getWidth());
        assertEquals(10, copiedProperty.getPlot().getDepth());
    }

    @Test
    public void testToString() 
    {
        String expected = "Sunset Villa,Los Angeles,John Doe,2500.0";
        assertEquals(expected, parameterizedProperty.toString());
    }

    @Test
    public void testGetCity() 
    {
        assertEquals("Los Angeles", parameterizedProperty.getCity());
    }

    @Test
    public void testGetOwner() 
    {
        assertEquals("John Doe", parameterizedProperty.getOwner());
    }

    @Test
    public void testGetPlot() 
    {
        assertNotNull(parameterizedProperty.getPlot());
    }

    @Test
    public void testGetPropertyName() 
    {
        assertEquals("Sunset Villa", parameterizedProperty.getPropertyName());
    }

    @Test
    public void testGetRentAmount() 
    {
        assertEquals(2500.0, parameterizedProperty.getRentAmount());
    }

}
