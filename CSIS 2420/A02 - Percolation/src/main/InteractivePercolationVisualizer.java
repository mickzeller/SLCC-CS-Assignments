package main;

/*********************************************************
 * 
 * Name: Mick Zeller
 * Date: January 27, 2015
 *
 *********************************************************/
import edu.princeton.cs.introcs.*;


public class InteractivePercolationVisualizer
{

    public static void main(String[] args)
	{
	    final int DELAY = 45;
	    int N = 10;
	    if (args.length == 1)
		N = Integer.parseInt(args[0]);

	    StdDraw.show(0);
	    StdOut.println(N);

	    Percolation percolate = new Percolation(N);
	    PercolationVisualizer.draw(percolate, N);
	    StdDraw.show(DELAY);
	    while (true)
	    {
		if (StdDraw.mousePressed())
		{
		    double x = StdDraw.mouseX();
		    double y = StdDraw.mouseY();

		    int xInt = (int) (N - Math.floor(y) - 1);
		    int yInt = (int) (Math.floor(x));

		    if (xInt >= 0 && xInt < N && yInt >= 0 && yInt < N)
		    {
			if (!percolate.isOpen(xInt, yInt))
			{
			    StdOut.println(xInt + " " + yInt);
			}
			percolate.open(xInt, yInt);
		    }

		    PercolationVisualizer.draw(percolate, N);
		}
		StdDraw.show(DELAY);
	    }
	}
}
