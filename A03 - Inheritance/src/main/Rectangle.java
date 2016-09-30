/********************************************************
 *
/********************************************************
 *  Name    :  Mick Zeller
 *  Date    :  February 14, 2015
 ********************************************************/

package main;

public class Rectangle
{
    private final int length, width;

    public Rectangle(int length, int width)
    {

	this.length = length;
	this.width = width;

    }

    @Override
    public String toString()
	{
	    return "Rectangle (" + length + "x" + width + ")";
	}

    public final int getLength()
	{
	    return length;
	}

    public final int getWidth()
	{
	    return width;
	}

}
