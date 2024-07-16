/*
 * Class: CMSC203 
 * Instructor: Grigoriy Grinberg
 * Description: Represents a rectangular area defined by its position on a grid (specifically an (x,y) coordinate) in addition to its width and depth dimensions. 
 * This data is used to determine the boundaries of properties within a management company. 
 * Due: 07/15/2024
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Inshaal Chaudhury
*/

import java.lang.Object;

public class Plot extends Object
{
	// instance variables
	private int x;
	private int y;
	private int width;
	private int depth;
	
	// Constructors
	public Plot()
	{
		this.width = 1;
		this.depth = 1;
	}
	
	public Plot(int x, int y, int width, int depth)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.depth = depth;
	}
	
	public Plot(Plot otherPlot)
	{
		this.x = otherPlot.x;
		this.y = otherPlot.y;
		this.width = otherPlot.width;
		this.depth = otherPlot.depth;
	}
	
	// Getters (Accessors)
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getWidth()
	{
		return width;
	}
	
	public int getDepth()
	{
		return depth;
	}
	
	// Setters (Mutators)
	public void setX(int x)
	{
		this.x = x;
	}
	
	public void setY(int y)
	{
		this.y = y;
	}
	
	public void setWidth(int width)
	{
		this.width = width;
	}
	
	public void setDepth(int depth)
	{
		this.depth = depth;
	}
	
	
	// Overlap Method
	public boolean overlaps(Plot plot)
	{
		// Edges of current plot
		int thisRight = this.x + this.width;
		int thisBottom = this.y + this.depth;
		
		// Edges of Other Plot
		int otherRight = plot.getX() + plot.getY(); 
		int otherBottom = plot.getY() + plot.getWidth();
		
		// Checks for conditions of no overlap
		if (this.x >= otherRight || plot.getX() >= thisRight)
		{
			return false;
		}
		
		if (this.y >= otherBottom || plot.getY() >= thisBottom)
		{
			return false;
		}
		
		// If the no plot conditions aren't met, then overlap exists
		return true;
	}
	
	// Encompass Method
	public boolean encompasses(Plot plot)
	{
		// Edges of current plot
		int thisRight = this.x + this.width;
		int thisBottom = this.y + this.depth;
		
		// Edges of other plot
		int otherRight = plot.getX() + plot.getWidth();
		int otherBottom = plot.getY() + plot.getDepth();
		
		// Bool Statement where if all these conditions are met, isEncompassed is true (else is false)
		boolean isEncompassed = plot.getX() >= this.x && otherRight <= thisRight &&
								plot.getY() >= this.y && otherBottom <= thisBottom;
								
		return isEncompassed;
	}
	
	// toString method
	public String toString()
	{
		return x + "," + y + "," + width + "," + depth;
	}
	
}
