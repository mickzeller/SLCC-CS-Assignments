/*****************************************************************************
 *
 *  Name    :  Mick, Dante, Clifford
 *  Date    :  4/18/15
 ****************************************************************************/

package project;

import project.Card.Face;
import project.Card.Suit;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Deck
{
    public List<Card> deckList = new ArrayList<Card>();

    public Deck()
    {
	for (Suit suit : Suit.values())
	{
	    for (Face face : Face.values())
		deckList.add(new Card(suit, face));
	}
	shuffle();
    }

    public void shuffle()
	{
	    Collections.shuffle(deckList);
	}

    public Card draw(int i)
	{
	    Card draw = deckList.get(i);
	    deckList.remove(i);
	    return draw;
	}
}
