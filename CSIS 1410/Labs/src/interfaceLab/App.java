package interfaceLab;
public class App
{
    	/*
	 * Author: Mick Zeller
	 * Lab Interface
	 * CSIS 1410 Spring
	 * March 15,2015
	 * 
	 * */
	public static void main(String[] args)
	{
		Plane myPlane = new Plane(4, "Boing 747");
		System.out.printf("myPlane: %s%n", myPlane);

		Hangglider myHangglider = new Hangglider(true);
		System.out.printf("myHangglider: %s%n", myHangglider);

		Bird myBird = new Bird("Swallow");
		System.out.printf("myBird: %s%n", myBird);
		
		System.out.println();
		
		Flyable[ ] flyingThings = { myPlane,myHangglider,myBird };
		
		for(Flyable flying : flyingThings)
		{
			System.out.println(flying);
			runWay(flying);
		}
	}
	private static void runWay(Flyable fly)
	{
		fly.launch();
		fly.land();
		System.out.println();
	}
}
