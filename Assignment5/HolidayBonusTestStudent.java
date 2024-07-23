import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HolidayBonusTestStudent 
{

    // New dataset for testing
    private double[][] dataSet2 = { { 10, 20, 30 }, { 40, 50, 60 }, { 70, 80, 90 } };

    @Before
    public void setUp() throws Exception 
    {
    }

    @After
    public void tearDown() throws Exception 
    {
    }

    @Test
    public void testCalculateHolidayBonusB() 
    {
        try 
        {
            double[] result = HolidayBonus.calculateHolidayBonus(dataSet2);
            assertEquals(3000.0, result[0], .001);
            assertEquals(6000.0, result[1], .001);
            assertEquals(15000.0, result[2], .001);
        } 
        catch (Exception e) 
        {
            fail("This should not have caused an Exception");
        }
    }

    @Test
    public void testCalculateTotalHolidayBonusB() 
    {
        assertEquals(24000.0, HolidayBonus.calculateTotalHolidayBonus(dataSet2), .001);
    }
}
