package eigenerCode.game;

import eigenerCode.cards.UnoCard;

import java.util.ArrayList;
/**
 * Write a description of class Deck here.
 *
 * @author (Tobi)
 * @version (1.0)
 */
public class Deck extends Misc
{
	private static ArrayList<UnoCard> deckplayer;  // Used to save all cards that the player currently has
	private static ArrayList<UnoCard> deckAI;  // Used to save all cards that the AI currently has
	/**
	 * Constructor for objects of class Deck
	 */
	public Deck()
	{
		deckAI = new ArrayList<>();
		deckplayer = new ArrayList<>();
	}

	public ArrayList<UnoCard> GetALDeckPlayer()  // Returns the ArrayList to make it easy to use in other classes
	{
		return deckplayer;
	}

	public ArrayList<UnoCard> GetALDeckAI()  // Returns the ArrayList to make it easy to use in other classes
	{
		return deckAI;
	}

	public void ShowYourDeck()  // Console output for the player to know about what cards he has
	{
		Sleep(500);
		System.out.println("Here are your cards: ");
		for(int i = 0; i < deckplayer.size(); i++)
		{
			Sleep(250);
			UnoCard card = deckplayer.get(i);
			System.out.println(i+1 + ". " + "You have a " + card.bc.ReturnColor() + " " + card.s.ReturnSymbol());
		}
	}
}
