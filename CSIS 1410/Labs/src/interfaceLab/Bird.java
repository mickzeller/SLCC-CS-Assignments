package interfaceLab;

/*
 * Author: Mick Zeller
 * Lab Interface
 * CSIS 1410 Spring
 * March 15,2015
 * 
 * */
public class Bird implements Flyable
{
    private final String type;

    public Bird(String t)
    {
	type = t;
    }

    @Override
    public String toString()
	{
	    return type;
	}

    @Override
    public void land()
	{
	    System.out.println("Flapping the wings until landing");
	}

    @Override
    public void launch()
	{
	    System.out.println("Flapping the wings to take off");
	}
}
