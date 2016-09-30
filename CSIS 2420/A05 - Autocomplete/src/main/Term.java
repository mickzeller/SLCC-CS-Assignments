/**
 * Name: Mick Zeller
 * Date: February 11, 2015
 */

package main;

import java.util.Comparator;

public class Term implements Comparable<Term>
{

    private String query;
    private double weight;

    public Term(String query, double weight)
    {
	if (query == null)
	{
	    throw new NullPointerException("The query can't be null");
	}
	;
	if (weight < 0)
	{
	    throw new IllegalArgumentException("The weight can't be negative");
	}
	;
	this.query = query;
	this.weight = weight;
    }

    public static Comparator<Term> byReverseWeightOrder()
	{
	    return new byReverseWO();
	}

    private static class byReverseWO implements Comparator<Term>
    {

	@Override
	public int compare(Term left, Term right)
	    {
		double result = right.weight - left.weight;
		if (result > 0)
		{
		    return 1;
		} else if (result < 0)
		{
		    return -1;
		} else
		    return 0;
	    }

    }

    public static Comparator<Term> byPrefixOrder(int r)
	{
	    if (r < 0)
	    {
		throw new IllegalArgumentException();
	    }
	    ;
	    return new byPO(r);
	}

    private static class byPO implements Comparator<Term>
    {

	private int r;

	public byPO(int r)
	{
	    this.r = r;
	}

	@Override
	public int compare(Term left, Term right)
	    {
		String one = left.query.substring(0, Math.min(left.query.length(), this.r));
		String two = right.query.substring(0, Math.min(right.query.length(), this.r));
		return one.compareToIgnoreCase(two);
	    }

    }

    @Override
    public int compareTo(Term that)
	{
	    return this.query.compareToIgnoreCase(that.query);
	}

    @Override
    public String toString()
	{
	    return this.weight + "\t" + this.query;
	}

}
