package printer;

/*
 * Author: Mick Zeller
 * CSIS 1410 Printer Lab
 * Feb 20, 2015
 * 
 * */
public class LaserPrinter extends Printer
{
    private int remaingingToner;

    public LaserPrinter(int sNumber)
    {
	super(sNumber);

	remaingingToner = 100;
	this.remaingingToner = getRemaingingToner();
	System.out.print("LaserPrinter #" + sNumber + "\n");
    }

    public void print()
	{
	    if (remaingingToner > 0)
	    {
		remaingingToner -= 10;
		System.out.println("LaserPrinter is printing " + getRemaingingToner() + "%");

	    }

	}

    public final int getRemaingingToner()
	{
	    return remaingingToner;
	}

    @Override
    public String toString()
	{
	    return "Remaining Toner: " + remaingingToner + "%";
	}

}
