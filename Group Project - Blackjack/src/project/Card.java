/*****************************************************************************
 *
 *  Name    :  Mick, Dante, Clifford
 *  Date    :  4/18/15
 ****************************************************************************/

package project;

import javax.swing.*;

public class Card extends JLabel
{

    private static final long serialVersionUID = -9067325588578610570L;

    public enum Suit
    {
	HEARTS, DIAMONDS, SPADES, CLUBS
    }

    public enum Face
    {
	Ace(11), Two(2), Three(3), Four(4), Five(5), Six(6), Seven(7), Eight(8), Nine(9), Ten(10), Jack(10), Queen(
		10), King(10);

	private int value;

	private Face(int value)
	{
	    this.value = value;
	}

	public int getValue()
	    {
		return value;
	    }

    }

    private final Suit suit;
    private final Face face;
    private ImageIcon icon;

    
    Card(Suit suit, Face face)
    {
	this.face = face;
	this.suit = suit;
	this.icon = new ImageIcon(getClass().getResource("Images/" + this.toString() + ".png"));

    }

    public Face getFace()
	{
	    return face;
	}

    public Suit getSuit()
	{
	    return suit;
	}

    public ImageIcon getIcon()
	{
	    return icon;
	}

    public int getValue()
	{
	    return this.getFace().getValue();
	}

    @Override
    public String toString()
	{
	    return "" + suit + face;
	}

}
