/********************************************************
 *
/********************************************************
 *  Name    :  Mick Zeller
 *  Date    :  February 14, 2015
 ********************************************************/

package main;

public class IsoscelesRightTriangle
{

    private final int leg;

    public IsoscelesRightTriangle(int leg)
    {
	this.leg = leg;
	hypotonus(leg);
    }

    @Override
    public String toString()
	{
	    return "IsoscelesRightTriangle (" + leg + ")";
	}

    public double hypotonus(double hyp)
	{
	    hyp = Math.hypot(leg, leg);
	    return hyp;
	}

    public final int getLeg()
	{
	    return leg;
	}
}
