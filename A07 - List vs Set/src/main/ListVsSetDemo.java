package main;
/********************************************************
 *Name : Mick Zeller 
 *Date : March 30, 2015
 ********************************************************/
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListVsSetDemo
{

    private List<ColoredSquare> list;// = new ArrayList<ColoredSquare>();
    private Set<ColoredSquare> set;// = new HashSet<ColoredSquare>();

 
    public ListVsSetDemo(ColoredSquare... elements)
    {
	list = new ArrayList<ColoredSquare>();
	set = new HashSet<ColoredSquare>();

	for (ColoredSquare el : elements)
	{
	    addElement(el);
	}
    }

    public String getListElements()
	{
	    StringBuilder string = new StringBuilder();
	    for (ColoredSquare el : list)
	    {
		string.append(el.toString()).append("\n");
	    }
	    return string.toString();
	}

    public String getSetElements()
	{
	    StringBuilder string = new StringBuilder();
	    for (ColoredSquare el : set)
	    {
		string.append(el.toString()).append("\n");
	    }
	    return string.toString();
	}

    public void addElement(ColoredSquare el)
	{
	    list.add(el);
	    set.add(el);
	}
}
