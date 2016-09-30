/********************************************************
 *  Name    :  Mick Zeller
 *  Date    :  February 14, 2015
 ********************************************************/

package main;

public class Circle 
{
	private final int radius;
	
	public Circle(int radius) 
	{
		this.radius = radius;
		circumference();
		diameter();
	}

	@Override
	public String toString() {
		return "Circle (" + radius + ")";
	}

	public final int getRadius() {
		return radius;
	}
	
	public int diameter()
	{
		return getRadius()*2;
	}
	public double circumference()
	{
		return Math.PI * 2 * getRadius();
	}

}
