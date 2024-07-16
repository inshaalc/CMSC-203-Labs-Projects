/**
 * Programmer : Inshaal Chaudhury
 */


import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent 
{
	@Test
    public void testDefaultConstructor() 
	{
        Plot plot = new Plot();
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(1, plot.getWidth());
        assertEquals(1, plot.getDepth());
    }

    @Test
    public void testParameterizedConstructor() 
    {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals(2, plot.getX());
        assertEquals(3, plot.getY());
        assertEquals(4, plot.getWidth());
        assertEquals(5, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() 
    {
        Plot originalPlot = new Plot(2, 3, 4, 5);
        Plot copiedPlot = new Plot(originalPlot);
        assertEquals(2, copiedPlot.getX());
        assertEquals(3, copiedPlot.getY());
        assertEquals(4, copiedPlot.getWidth());
        assertEquals(5, copiedPlot.getDepth());
    }

    @Test
    public void testGettersAndSetters() 
    {
        Plot plot = new Plot();
        plot.setX(10);
        plot.setY(20);
        plot.setWidth(30);
        plot.setDepth(40);

        assertEquals(10, plot.getX());
        assertEquals(20, plot.getY());
        assertEquals(30, plot.getWidth());
        assertEquals(40, plot.getDepth());
    }

    @Test
    public void testOverlaps() 
    {
        Plot plot1 = new Plot(0, 0, 10, 10);
        Plot plot2 = new Plot(5, 5, 10, 10);
        Plot plot3 = new Plot(20, 20, 5, 5);

        assertTrue(plot1.overlaps(plot2));
        assertFalse(plot1.overlaps(plot3));
    }

    @Test
    public void testEncompasses() 
    {
        Plot plot1 = new Plot(0, 0, 10, 10);
        Plot plot2 = new Plot(1, 1, 5, 5);
        Plot plot3 = new Plot(5, 5, 10, 10);

        assertTrue(plot1.encompasses(plot2));
        assertFalse(plot1.encompasses(plot3));
    }

    @Test
    public void testToString() 
    {
        Plot plot = new Plot(2, 3, 4, 5);
        assertEquals("2,3,4,5", plot.toString());
    }

}
