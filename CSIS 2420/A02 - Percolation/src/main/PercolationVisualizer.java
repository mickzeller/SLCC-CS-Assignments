package main;

import java.awt.Font;
import edu.princeton.cs.introcs.*;
/*********************************************************
 * 
 * Name: Mick Zeller
 * Date: January 27, 2015
 *
 *********************************************************/
public class PercolationVisualizer
{

    private final static int DELAY = 10;

    public static void draw(Percolation perc, int N)
	{
	    StdDraw.clear();
	    StdDraw.setPenColor(StdDraw.BLACK);
	    StdDraw.setXscale(-.05 * N, 1.05 * N);
	    StdDraw.setYscale(-.05 * N, 1.05 * N); 
	    StdDraw.filledSquare(N / 2.0, N / 2.0, N / 2.0);

	    // draw N-by-N grid
	    for (int row = 0; row < N; row++)
	    {
		for (int col = 0; col < N; col++)
		{
		    if (perc.isFull(row, col))
		    {
			StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
		    } else if (perc.isOpen(row, col))
		    {
			StdDraw.setPenColor(StdDraw.WHITE);
		    } else
		    {
			StdDraw.setPenColor(StdDraw.BLACK);
		    }
		    StdDraw.filledSquare(col + 0.5, N - row - 0.5, 0.45);
		}
	    }

	    StdDraw.setFont(new Font("SansSerif", Font.PLAIN, 12));
	    StdDraw.setPenColor(StdDraw.BLACK);
	    if (perc.percolates())
		StdDraw.text(.75 * N, -N * .025, "percolates");
	    else
		StdDraw.text(.75 * N, -N * .025, "does not percolate");

	}

    @SuppressWarnings("deprecation")
    private static void simulateFromFile(String filename)
	{
	    In in = new In(filename);
	    int N = in.readInt();
	    Percolation perc = new Percolation(N);

	    StdDraw.show(0);
	    draw(perc, N);
	    StdDraw.show(DELAY);
	    while (!in.isEmpty())
	    {
		int i = in.readInt();
		int j = in.readInt();
		perc.open(i, j);
		draw(perc, N);
		StdDraw.show(DELAY);
	    }
	}

    public static void main(String[] args)
	{
	    String filename = "src/input20.txt";
	    simulateFromFile(filename);
	}
}
