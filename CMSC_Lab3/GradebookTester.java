import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GradebookTester 
{
	Gradebook gradebook1;
	Gradebook gradebook2;
	
	@BeforeEach
	void setUp() throws Exception 
	{
		gradebook1 = new Gradebook(5);
		gradebook2 = new Gradebook(5);
		
		gradebook1.addScore(75);
		gradebook1.addScore(50);
		gradebook2.addScore(60);
		gradebook2.addScore(80);
	}

	@AfterEach
	void tearDown() throws Exception 
	{
		gradebook1 = null;
		gradebook2 = null;
	}

	@Test
	void testGetScoreSize() 
	{
	}

	@Test
	void testToString() 
	{
	}

	@Test
	void testAddScore() 
	{
		assertTrue(gradebook1.toString().equals("75.0 50.0 "));
		assertEquals("75.0 50.0 ", gradebook1.toString());
		assertTrue(gradebook2.toString().equals("60.0 80.0 "));
		assertEquals("60.0 80.0 ", gradebook2.toString());
	}

	@Test
	void testSum() 
	{
		assertEquals(125.0, gradebook1.sum(), .0001);
		assertEquals(140.0, gradebook2.sum(), .0001);
	}

	@Test
	void testMinimum() 
	{
		assertEquals(50, gradebook1.minimum(), .001);
		assertEquals(60, gradebook2.minimum(), .0001);
	}

	@Test
	void testFinalScore() 
	{
		assertEquals(75, gradebook1.finalScore(), .001);
		assertEquals(80, gradebook2.finalScore(), .001);
	}

}
