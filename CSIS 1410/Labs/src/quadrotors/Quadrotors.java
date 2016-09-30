package quadrotors;

/**
 * Name: Mick Zeller
 * Date: Spring 2015
 */
public class Quadrotors
{
    private int x;
    private int y;
    private int z;

    public Quadrotors(int x, int y, int z)
    {
	this.x = x;
	this.y = y;
	this.z = z;
    }

    public int getX()
	{
	    return x;
	}

    public void setX(int x)
	{
	    this.x = x;
	}

    public int getY()
	{
	    return y;
	}

    public void setY(int y)
	{
	    this.y = y;
	}

    public int getZ()
	{
	    return z;
	}

    public void setZ(int z)
	{
	    this.z = z;
	}

    @Override
    public String toString()
	{
	    return "QR:" + x + "/" + y + "/" + z;
	}

    @Override
    public int hashCode()
	{
	    final int prime = 31;
	    int result = 1;
	    result = prime * result + x;
	    result = prime * result + y;
	    result = prime * result + z;
	    return result;
	}

    @Override
    public boolean equals(Object obj)
	{
	    if (!(obj instanceof Quadrotors))
		return false;
	    Quadrotors other = (Quadrotors) obj;
	    if (x == other.x && y == other.y && z == other.z)
		return true;
	    return false;
	}
}
