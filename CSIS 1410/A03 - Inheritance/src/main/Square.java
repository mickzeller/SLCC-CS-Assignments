/********************************************************
 * Name : Mick Zeller Date : February 14, 2015
 ********************************************************/

package main;

public class Square extends Rectangle
{

    public Square(int size)
    {

	super(size, size);

    }

    public int getSide()
	{
	    int side = getLength();
	    return side;
	}

    @Override
    public String toString()
	{
	    return "Square (" + getSide() + ")";
	}

}
