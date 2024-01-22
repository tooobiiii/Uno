package eigenerCode.game;

import eigenerCode.cards.UnoCard;

import java.util.Objects;
import java.util.ArrayList;

/**
 * This is the "control" class which starts the game and creates each object needed.
 *
 * @author (Tobi)
 * @version (V 1.1)
 */
public class Game extends Misc
{
	private final Player p;
	private final Deck deck;
	private final CardPile cp;
	private final AI ai;

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

		//Comment this if you dont want the game to autostart when an object of class game is created
		StartGame();
	}

	@Override
	public void TaktImpulsAusführen()   //Will not work as long as graphic is not implemented
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

	public void YouLost()   //Method for when you lose
	{
		for(int i = 0; i < 3; i++)
		{
			Sleep(1000);
			System.out.println("[GAME] Oh no. Seems like AI won the game. You might win next round!");
		}
		started = false;
	}

	public void YouWon()    //Method for when you won
	{
		for(int i = 0; i < 3; i++)
		{
			Sleep(1000);
			System.out.println("[GAME] Congratulations!!! You have been able to beat our AI");
		}
		started = false;
	}

	public void PrepareGame()   //Used for checking for bugs, because you cant run other methods while scanner is waiting for an answer so this does not start the game but prepares it.
	{
		//  Creating and shuffling all cards, as well as giving them out to the player and ki
		cp.AllCards();
		cp.ShuffleArrayList();
		cp.GiveCardsToPlayers();
	}

	public void StartGame() //Prepares and starts the game
	{
		PrepareGame();
		Starten();
		started = true;
		p.PassMoveToPlayer();
	}

	public void Testing(String test)    //Method used for error spotting
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
}

