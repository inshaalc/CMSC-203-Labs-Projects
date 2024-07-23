import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TwoDimRaggedArrayUtilityTestStudent 
{

    private double[][] dataSet;
    private File tempFile;

    @Before
    public void setUp() throws Exception 
    {
        // Initialize a sample dataset
        dataSet = new double[][] {
            { 1.0, 2.0, 3.0 },
            { 4.0, 5.0 },
            { 6.0, 7.0, 8.0 }
        };

        // Create a temporary file for testing readFile and writeToFile methods
        tempFile = File.createTempFile("testfile", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) 
        {
            writer.println("1 2 3");
            writer.println("4 5");
            writer.println("6 7 8");
        }
    }

    @After
    public void tearDown() throws Exception 
    {
        // Delete temporary file
        if (tempFile != null && tempFile.exists()) 
        {
            tempFile.delete();
        }
    }

    @Test
    public void testReadFile() throws Exception 
    {
        double[][] result = TwoDimRaggedArrayUtility.readFile(tempFile);
        assertArrayEquals(dataSet, result);
    }

    @Test
    public void testWriteToFile() throws Exception 
    {
        File outputFile = new File("output.txt");
        TwoDimRaggedArrayUtility.writeToFile(dataSet, outputFile);

        double[][] result = TwoDimRaggedArrayUtility.readFile(outputFile);
        assertArrayEquals(dataSet, result);

        // Clean up
        outputFile.delete();
    }

    @Test
    public void testGetTotal() 
    {
        assertEquals(36.0, TwoDimRaggedArrayUtility.getTotal(dataSet), 0.001);
    }

    @Test
    public void testGetAverage() 
    {
        assertEquals(4.5, TwoDimRaggedArrayUtility.getAverage(dataSet), 0.001);
    }

    @Test
    public void testGetRowTotal() 
    {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet, 0), 0.001);
        assertEquals(9.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet, 1), 0.001);
        assertEquals(21.0, TwoDimRaggedArrayUtility.getRowTotal(dataSet, 2), 0.001);
    }

    @Test
    public void testGetColumnTotal() 
    {
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet, 0), 0.001);
        assertEquals(14.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet, 1), 0.001);
        assertEquals(11.0, TwoDimRaggedArrayUtility.getColumnTotal(dataSet, 2), 0.001);
    }

    @Test
    public void testGetHighestInRow() 
    {
        assertEquals(3.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet, 0), 0.001);
        assertEquals(5.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet, 1), 0.001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInRow(dataSet, 2), 0.001);
    }

    @Test
    public void testGetHighestInRowIndex() 
    {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet, 0));
        assertEquals(1, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInRowIndex(dataSet, 2));
    }

    @Test
    public void testGetLowestInRow() 
    {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet, 0), 0.001);
        assertEquals(4.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet, 1), 0.001);
        assertEquals(6.0, TwoDimRaggedArrayUtility.getLowestInRow(dataSet, 2), 0.001);
    }

    @Test
    public void testGetLowestInRowIndex() 
    {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInRowIndex(dataSet, 2));
    }

    @Test
    public void testGetHighestInColumn() 
    {
        assertEquals(6.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet, 0), 0.001);
        assertEquals(7.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet, 1), 0.001);
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInColumn(dataSet, 2), 0.001);
    }

    @Test
    public void testGetHighestInColumnIndex() 
    {
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet, 0));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet, 1));
        assertEquals(2, TwoDimRaggedArrayUtility.getHighestInColumnIndex(dataSet, 2));
    }

    @Test
    public void testGetLowestInColumn() 
    {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet, 0), 0.001);
        assertEquals(2.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet, 1), 0.001);
        assertEquals(3.0, TwoDimRaggedArrayUtility.getLowestInColumn(dataSet, 2), 0.001);
    }

    @Test
    public void testGetLowestInColumnIndex() 
    {
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet, 0));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet, 1));
        assertEquals(0, TwoDimRaggedArrayUtility.getLowestInColumnIndex(dataSet, 2));
    }

    @Test
    public void testGetHighestInArray() 
    {
        assertEquals(8.0, TwoDimRaggedArrayUtility.getHighestInArray(dataSet), 0.001);
    }

    @Test
    public void testGetLowestInArray() 
    {
        assertEquals(1.0, TwoDimRaggedArrayUtility.getLowestInArray(dataSet), 0.001);
    }
}
