package keyValuePair2;

/**
 * Project: Lab Key Value Pair 2
 * Name: Mick Zeller 
 * Date: 4/18/2015.
 */


import java.util.ArrayList;
import java.util.Collections;

public class PairApp
{

    public static void main(String[] args)
	{

	    KeyValuePair<String, Integer> p1 = new KeyValuePair<>("SLC", 189899);
	    KeyValuePair<String, Integer> p2 = new KeyValuePair<>("NY", 8244910);
	    KeyValuePair<String, Integer> p3 = new KeyValuePair<>("LA", 3819702);
	    KeyValuePair<String, Integer> p4 = new KeyValuePair<>("SF", 812826);

	    ArrayList<KeyValuePair<String, Integer>> cities = new ArrayList<>();
	    cities.add(p1);
	    cities.add(p2);
	    cities.add(p3);
	    cities.add(p4);

	    System.out.println("Original list:");
	    for (KeyValuePair<String, Integer> el : cities)
	    {
		System.out.println(el.toString());
	    }

	    System.out.println();

	    Collections.sort(cities);
	    System.out.println("Sorted list:");
	    for (KeyValuePair<String, Integer> el : cities)
	    {
		System.out.println(el.toString());
	    }

	}

}
