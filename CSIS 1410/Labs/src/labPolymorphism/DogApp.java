package labPolymorphism;
/*
 * Name: Mick Zeller
 * Date: March 15,2015
 * */

public class DogApp
{
    public static void main(String[] args)
	{
	    Dog myDog = new Dog("Greyhound");
	    actAsDog(myDog);

	    SledDog mySledDog = new SledDog("Husky");
	    actAsDog(mySledDog);

	    CircusDog myCircusDog = new CircusDog("Terrier");
	    actAsDog(myCircusDog);

	    Dog[] kennel =
	    { myDog, mySledDog, myCircusDog };

	    for (Dog wolves : kennel)
	    {
		System.out.println(wolves);
		if (wolves instanceof SledDog)
		{
		    ((SledDog) wolves).pullSled();
		}
		actAsDog(wolves);
	    }
	}

    private static void actAsDog(Dog d)
	{
	    d.communicate();
	    d.move();
	    System.out.println();
	}
}
