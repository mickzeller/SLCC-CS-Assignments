package main;
/*********************************************************
 * 
 * Name: Mick Zeller
 * Date: January 27, 2015
 *
 *********************************************************/
import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation
{

    int n, size, topRow, bottomRow;
    boolean[][] grid;
    WeightedQuickUnionUF unionFind, unionFind2;



    public Percolation(int N)
    {
	if (n < 0)
	{
	    throw new IllegalArgumentException("No negitive values");
	}

	grid = new boolean[N][N];

	n = N;
	size = n * n;
	unionFind = new WeightedQuickUnionUF((size + 2));
	unionFind2 = new WeightedQuickUnionUF((size + 1));
	topRow = size;
	bottomRow = size + 1;

	for (int i = 0; i < n; i++)
	{
	    unionFind.union(i, topRow);
	    unionFind2.union(i, topRow);
	    unionFind.union(size - i - 1, bottomRow);
	}
    }

    public void open(int x, int y)
	{
	    if (x > n - 1 || x < 0 || y > n - 1 || y < 0)
	    {
		throw new IndexOutOfBoundsException("Index out of bounds!");
	    }
	    grid[x][y] = true;
	    if (x - 1 >= 0 && grid[x - 1][y])
	    {
		unionFind.union(locationID(x - 1, y), locationID(x, y));
		unionFind2.union(locationID(x - 1, y), locationID(x, y));
	    }
	    if (x + 1 < n && grid[x + 1][y])
	    {
		unionFind.union(locationID(x + 1, y), locationID(x, y));
		unionFind2.union(locationID(x + 1, y), locationID(x, y));
	    }
	    if (y - 1 >= 0 && grid[x][y - 1])
	    {
		unionFind.union(locationID(x, y - 1), locationID(x, y));
		unionFind2.union(locationID(x, y - 1), locationID(x, y));
	    }
	    if (y + 1 < n && grid[x][y + 1])
	    {
		unionFind.union(locationID(x, y + 1), locationID(x, y));
		unionFind2.union(locationID(x, y + 1), locationID(x, y));
	    }
	}

    public boolean isOpen(int x, int y)
	{
	    if (x > n - 1 || x < 0 || y > n - 1 || y < 0)
	    {
		throw new IndexOutOfBoundsException("Index out of bounds!");
	    }
	    return grid[x][y];
	}

    public boolean isFull(int x, int y)
	{
	    if (x > n - 1 || x < 0 || y > n - 1 || y < 0)
	    {
		throw new IndexOutOfBoundsException("Index out of bounds!");
	    }
	    if (!isOpen(x, y))
	    {
		return false;
	    }
	    return unionFind2.connected(topRow, locationID(x, y));
	}

    public boolean percolates()
	{

	    return unionFind.connected(topRow, bottomRow);
	}

    private int locationID(int x, int y)
	{
	    return (n * x) + y;
	}

}