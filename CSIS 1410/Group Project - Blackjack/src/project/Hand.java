/*****************************************************************************
 *
 *  Name    :  Mick, Dante, Clifford
 *  Date    :  4/18/15
 ****************************************************************************/

package project;

import java.util.*;

public class Hand
{
    public List<Card> hand = new ArrayList<Card>();

    public void addCard(Card c)
	{
	    hand.add(c);
	}

    public int value()
	{
	    int value = 0;
	    boolean hasAce = false;

	    for (Card card : hand)
	    {
		value += card.getFace().getValue();
		if (card.getFace().getValue() == 11)
		    hasAce = true;
	    }

	    if (value > 21 && hasAce == true)
		value -= 10;

	    return value;
	}
}
