package project;

import java.util.ArrayList;

/*****************************************************************************
*
*  Name    :  Mick, Dante, Clifford
*  Date    :  4/18/15
****************************************************************************/
public class Game
{
    boolean playerBusts = false;
    boolean playerWins = false;
    boolean dealerBusts = false;
    boolean dealerWins = false;
    boolean tieGame = false;
    Deck deck = new Deck();
    Hand dealerHand = new Hand();
    Hand playerHand = new Hand();
    int cardNumber;

    @SuppressWarnings("unchecked")
    public void newGame()
	{
	    
	    playerBusts = false;
	    playerWins = false;
	    dealerBusts = false;
	    dealerWins = false;
	    tieGame = false;
	    cardNumber = 0;
	    //Adding new deck if cards are getting low
	    if (deck.deckList.size() < 20)
	    {
		Deck newDeck = new Deck();
		@SuppressWarnings("rawtypes")
		ArrayList moreCards = new ArrayList();
		moreCards.addAll(newDeck.deckList);
		deck.deckList.addAll(moreCards);
	    }
	    //Dealing first 4 cards
	    playerHand.addCard(deck.draw(cardNumber));
	    dealerHand.addCard(deck.draw(cardNumber + 1));
	    playerHand.addCard(deck.draw(cardNumber + 2));
	    dealerHand.addCard(deck.draw(cardNumber + 3));

	    if (dealerHand.value() == 21)
	    {
		if (playerHand.value() == 21)
		{
		    tieGame = true;
		} else
		{
		    dealerWins = true;
		}
	    }
	    if (playerHand.value() == 21 && dealerHand.value() != 21)
		playerWins = true;
	}

    //Method for Hit button
    public void hit()
	{
	    //First card to be drawn from the deck is 4, or the 5th card
	    Card temp = deck.draw(cardNumber);
	    playerHand.addCard(temp);
	    ++cardNumber;
	    //If player busts
	    if (playerHand.value() > 21)
	    {
		playerBusts = true;
	    }
	}

    //Method for Stay button
    public void stay()
	{
	    while (dealerHand.value() <= 16)
	    {
		dealerDraw();
	    }
	    determineWinner();
	}

    //Determines who wins based what is passed
    public void determineWinner()
	{
	    if (playerHand.value() > dealerHand.value())
	    {
		playerWins = true;
	    }
	    if (dealerHand.value() > playerHand.value())
	    {
		dealerWins = true;
	    }
	    if (dealerHand.value() == playerHand.value())
	    {
		tieGame = true;
	    }
	}

    //Gives the dealer a card if the total is less than 17
    public void dealerDraw()
	{
	    if (dealerHand.value() >= 17)
	    {
		return;
	    } else
	    {
		dealerHand.addCard(deck.draw(cardNumber));
		++cardNumber;
	    }

	    //If dealer busts
	    if (dealerHand.value() > 21)
	    {
		dealerBusts = true;
	    }
	}
}
