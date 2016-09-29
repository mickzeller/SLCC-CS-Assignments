package interfaceLab;

/*
 * Author: Mick Zeller
 * Lab Interface
 * CSIS 1410 Spring
 * March 15,2015
 * 
 * */
public class Hangglider implements Flyable
{
    private final boolean isRigidWing;

    public Hangglider(boolean rigidWing)
    {
	isRigidWing = rigidWing;
    }

    @Override
    public String toString()
	{
	    return String.format(isRigidWing ? "Rigid-wing" : "Flex-wing");
	}

    @Override
    public void land()
	{
	    System.out.println("Gliding to a land");

	}

    @Override
    public void launch()
	{
	    System.out.println("Running until take-off");

	}
}
