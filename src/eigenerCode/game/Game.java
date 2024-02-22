package eigenerCode.game;

import eigenerCode.cards.SpecialCard;
import eigenerCode.cards.UnoCard;

import java.util.Objects;
import java.util.ArrayList;

/**
 * This is the "control" class which starts the game and creates each object needed.
 *
 * @author (Tobi)
 * @version (1.1)
 */
public class Game extends Misc
{
	private static Player p;
	private static Deck deck;
	private static CardPile cp;
	private static AI ai;

	private boolean started;
	/**
	 * Constructor for objects of class Spiel
	 */
	public Game()
	{
		cp = new CardPile(deck = new Deck());
		ai = new AI(deck, cp);
		p = new Player(deck, cp, ai);
		ai.AddPlayer(p);
		started = false;
	}

	@Override
	public void TaktImpulsAusführen()   // Will not work as long as graphic is not implemented
	{
		if(started)
		{
			if((deck.GetALDeckPlayer().isEmpty()) && (p.ReturnWon()))
			{
				Anhalten();
				YouWon();
			}

			if((deck.GetALDeckAI().isEmpty()) && (ai.ReturnWon()))
			{
				Anhalten();
				YouLost();
			}
		}
	}

	public void YouLost()   // Method for when you lose
	{
		for(int i = 0; i < 3; i++)
		{
			Sleep(1000);
			System.out.println("[GAME] Oh no. Seems like AI won the game. You might win next round!");
		}
		started = false;
	}

	public void YouWon()    // Method for when you won
	{
		for(int i = 0; i < 3; i++)
		{
			Sleep(1000);
			System.out.println("[GAME] Congratulations!!! You have been able to beat our AI");
		}
		started = false;
	}

	public void PrepareGame()   // Used for checking for bugs, because you cant run other methods while scanner is waiting for an answer so this does not start the game but prepares it.
	{
		// Creating and shuffling all cards, as well as giving them out to the player and ki
		cp.AllCards();
		cp.ShuffleArrayList();
		cp.GiveCardsToPlayers();
	}

	public void StartGame() // Prepares and starts the game
	{
		PrepareGame();
		Starten();
		started = true;
		if (cp.ReturnPlayedTopCard() instanceof SpecialCard specialCard)
			specialCard.PlaySpecialCard(p);
		else
			p.PassMoveToPlayer();
	}

	public void Testing(String test)    // Method used for error spotting
	{
		ArrayList<UnoCard> playedCards = cp.GetALPlayedCards();
		ArrayList<UnoCard> deckAI = deck.GetALDeckAI();
		ArrayList<UnoCard> deckP = deck.GetALDeckPlayer();

		if(Objects.equals(test, "playedCards"))
		{
			for(UnoCard uc : playedCards)
			{
				System.out.println(uc.ReturnInfo());
			}
		}

		if(Objects.equals(test, "deckAI"))
		{
			for(UnoCard uc : deckAI)
			{
				System.out.println(uc.ReturnInfo());
			}
		}

		if(Objects.equals(test, "deckP"))
		{
			for(UnoCard uc : deckP)
			{
				System.out.println(uc.ReturnInfo());
			}
		}
	}

	public static AI getAi()
	{
		return ai;
	}

	public static CardPile getCp()
	{
		return cp;
	}

	public static Deck getDeck()
	{
		return deck;
	}

	public static Player getP()
	{
		return p;
	}
}

