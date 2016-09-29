package interfaceLab;

/*
 * Author: Mick Zeller
 * Lab Interface
 * CSIS 1410 Spring
 * March 15,2015
 * 
 * */
public class Plane implements Flyable
{
    private final int numberOfEngines;
    private final String model;

    public Plane(int engines, String m)
    {
	numberOfEngines = engines;
	model = m;
    }

    @Override
    public String toString()
	{
	    return String.format("%s with %d engines", model, numberOfEngines);
	}

    @Override
    public void land()
	{
	    System.out.println("Rolling to a stop");

	}

    @Override
    public void launch()
	{
	    System.out.println("Rolling until take-off");
	}
}
