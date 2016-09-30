/********************************************************
 * Project : <StackOfStrings_CSIS_1410|StackOfStrings> 
 * Name : Mick Zeller 
 * Date : 1/22/2015
 ********************************************************/

package stackOfStrings;

public class StackOfStrings
{

    private int n = 0;
    private String[] s;

    public StackOfStrings(int capacity)
    {
	s = new String[capacity];
    }

    public boolean isEmpty()
	{
	    return n == 0;
	}

    public void push(String item)
	{

	    if (n < 10)
	    {
		s[n] = item;
		n++;
	    } else
	    {
		System.out.print("WARNING!!!!!! ERRORR!!!!! 502");
	    }
	}

    public String pop()
	{
	    if (isEmpty())
	    {
		return "WARNING!!!!!! ERRORR!!!!! 502";
	    } else
	    {
		n--;
		return s[n];
	    }
	}
}
