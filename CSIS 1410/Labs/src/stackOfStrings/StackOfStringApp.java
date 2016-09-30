/********************************************************
 * Project : <StackOfStrings_CSIS_1410|StackOfStrings> 
 * Name : Mick Zeller 
 * Date : 1/22/2015
 ********************************************************/

package stackOfStrings;

public class StackOfStringApp
{

    public static void main(String[] args)
	{
	    StackOfStrings stackOf = new StackOfStrings(10);

	    stackOf.push("good");
	    stackOf.push("life");

	    stackOf.pop();
	    stackOf.push("is");
	    stackOf.push("Life");

	    while (!stackOf.isEmpty())
	    {
		System.out.println(stackOf.pop());
	    }
	}
}
