package file;

public class Mountain
{
    private final String name;
    private final int altitude;
    private final boolean hasGlacier;

    public Mountain(String n, int a, boolean glacier)
    {
	name = n;
	altitude = a;
	hasGlacier = glacier;
    }

    public String getName()
	{
	    return name;
	}

    public int getAltitude()
	{
	    return altitude;
	}

    public boolean isHasGlacier()
	{
	    return hasGlacier;
	}

    @Override
    public String toString()
	{
	    return name + " (" + altitude + ") " + (hasGlacier ? "*" : "");
	}
}