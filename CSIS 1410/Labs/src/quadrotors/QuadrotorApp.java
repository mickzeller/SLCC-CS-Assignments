package quadrotors;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Name: Mick Zeller Date: Spring 2015
 */

public class QuadrotorApp
{

    public static void main(String[] args)
	{
	   
	    List<Quadrotors> rotors = new ArrayList<Quadrotors>(
		    Arrays.asList(new Quadrotors(2, 4, 2), new Quadrotors(3, 4, 4), new Quadrotors(4, 4, 6),
			    new Quadrotors(5, 4, 2), new Quadrotors(6, 4, 4), new Quadrotors(7, 4, 6)));

	    System.out.println(rotors.toString());

	    changeOrientation(rotors);
	    System.out.println(rotors.toString());

	    Quadrotors searchItem = new Quadrotors(4, 6, 4);
	  
	    System.out.printf("rotors %s contain %s%n", (rotors.contains(searchItem) ? "does" : "does not"),
		    searchItem.toString());

	    System.out.println("Number of rotors: " + rotors.size());

	    rotors.remove(searchItem);
	    System.out.println(rotors.toString());

	    rotors.remove(0);
	    System.out.println(rotors.toString());

	}

    private static void changeOrientation(List<Quadrotors> list)
	{
	    for (Quadrotors o : list)
	    {
		int temp = o.getX();
		o.setX(o.getY());
		o.setY(temp);
	    }
	}
}
