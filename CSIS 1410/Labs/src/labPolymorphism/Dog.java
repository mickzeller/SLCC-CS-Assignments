package labPolymorphism;
/*
 * Name: Mick Zeller
 * Date: March 15,2015
 * */

public class Dog
{
    private final String breed;

    public Dog(String b)
    {
	breed = b;
    }

    public void communicate()
	{
	    System.out.println("bark bark");
	}

    public void move()
	{
	    System.out.println("run");
	}

    public String getBreed()
	{
	    return breed;
	}

    @Override
    public String toString()
	{
	    return String.format("%s: %s", this.getClass().getSimpleName(), getBreed());
	}
}
