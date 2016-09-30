/***************************
 * Author: Mick Zeller
 * Program: Lab Itinerary
 ***************************/
package travel;

import java.util.ArrayList;
import java.util.Scanner;

public class Itinerary
{

    public Itinerary()
    {

    }

    public static void main(String[] args)
	{

	    ArrayList<String> itinerary = new ArrayList<String>();

	    Scanner input = new Scanner(System.in);

	    String userInput = null;
	    System.out.println("Please enter your Destinations\nWhen you are done" + " type DONE\n\n");
	    do
	    {
		System.out.print("Destination: ");
		userInput = input.nextLine().toUpperCase();

		if (!userInput.equals("DONE"))
		    itinerary.add(userInput);
	    } while (!userInput.equals("DONE"));

	    input.close();

	    StringBuilder sbTravel = new StringBuilder();
	    int i = 0;
	    for (String s : itinerary)
	    {
		sbTravel.append(s);

		if (i < itinerary.size() - 1)
		{
		    sbTravel.append(" to ");
		    i++;
		}
	    }

	    String travelRoute = sbTravel.toString();
	    String travelRoute2 = sbTravel.substring(0);
	    System.out.println("\nTravel Route: " + travelRoute);
	    System.out.println("Travel Route: " + travelRoute2);
	    System.out.println("Travel Route: " + sbTravel.toString());
	}

}
