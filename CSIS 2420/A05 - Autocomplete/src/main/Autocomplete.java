/**
 * Name: Mick Zeller
 * Date: February 11, 2015
 */
package main;

import java.util.Arrays;

public class Autocomplete
{

    private Term[] terms;

    public Autocomplete(Term[] terms)
    {
	if (terms == null)
	{
	    throw new NullPointerException();
	}
	;
	this.terms = terms;
	Arrays.sort(this.terms);
    }

    public Term[] allMatches(String prefix)
	{
	    if (prefix == null)
	    {
		throw new NullPointerException();
	    }
	    Term key = new Term(prefix, 0);
	    int first = BinarySearchDeluxe.<Term> firstIndexOf(this.terms, key, Term.byPrefixOrder(prefix.length()));
	    int last = BinarySearchDeluxe.<Term> lastIndexOf(this.terms, key, Term.byPrefixOrder(prefix.length()));
	    if (first == -1 || last == -1)
	    {
		Term[] empty = new Term[0];
		return empty;
	    }
	    Term[] t = new Term[(last - first) + 1];
	    t = Arrays.copyOfRange(this.terms, first, last + 1);
	    Arrays.sort(t, Term.byReverseWeightOrder());
	    return t;
	}

    public int numberOfMatches(String prefix)
	{
	    if (prefix == null)
	    {
		throw new NullPointerException();
	    }
	    Term key = new Term(prefix, 0);
	    int first = BinarySearchDeluxe.<Term> firstIndexOf(terms, key, Term.byPrefixOrder(prefix.length()));
	    int last = BinarySearchDeluxe.<Term> lastIndexOf(terms, key, Term.byPrefixOrder(prefix.length()));
	    return (last - first) + 1;
	}

}
