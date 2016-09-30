package keyValuePair1;
/**
 * Project: Lab Key Value Pair
 * Name: Mick Zeller 
 * Date: 4/17/2015.
 */
public class PairApp
{
    @SuppressWarnings("unchecked")
    public static void main(String[] args)
	{
	    @SuppressWarnings(
	    { "rawtypes" })
	    KeyValuePair p1 = new KeyValuePair("SLC", 189899);
	    @SuppressWarnings("rawtypes")
	    KeyValuePair p2 = new KeyValuePair("NY", 8244910);

	    System.out.println("p1: " + p1.toString());
	    System.out.println("p2: " + p2.toString());
	    System.out.println("p1 equals p2? " + p1.equals(p2));
	    System.out.println();

	    p1 = p2;

	    System.out.println("p1: " + p1.toString());
	    System.out.println("p2: " + p2.toString());
	    System.out.println("p1 equals p2? " + p1.equals(p2));
	}

}
