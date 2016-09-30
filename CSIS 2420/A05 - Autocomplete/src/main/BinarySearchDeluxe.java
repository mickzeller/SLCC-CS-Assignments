/**
 * Name: Mick Zeller
 * Date: February 11, 2015
 */
package main;

import java.util.Comparator;

public class BinarySearchDeluxe
{

    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
	    if (a == null || key == null || comparator == null)
	    {
		throw new NullPointerException();
	    }
	    ;
	    int lo = 0;
	    int hi = a.length - 1;
	    int result = -1;
	    while (lo <= hi)
	    {
		int mid = lo + (hi - lo) / 2;
		if (comparator.compare(key, a[mid]) == 0)
		{
		    result = mid;
		    hi = mid - 1;
		} else if (comparator.compare(key, a[mid]) < 0)
		    hi = mid - 1;
		else
		    lo = mid + 1;
	    }
	    return result;
	}

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator)
	{
	    if (a == null || key == null || comparator == null)
	    {
		throw new NullPointerException();
	    }
	    ;
	    int lo = 0;
	    int hi = a.length - 1;
	    int result = -1;
	    while (lo <= hi)
	    {
		int mid = lo + (hi - lo) / 2;
		if (comparator.compare(key, a[mid]) == 0)
		{
		    result = mid;
		    lo = mid + 1;
		} else if (comparator.compare(key, a[mid]) < 0)
		    hi = mid - 1;
		else
		    lo = mid + 1;
	    }
	    return result;
	}
}
