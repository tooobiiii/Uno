package eigenerCode.game;

import eigenerCode.cards.*;

import java.util.ArrayList;
import java.util.Collections;
/**
 * Beschreiben Sie hier die Klasse CardPile.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class CardPile
{
	private final Deck deck;

	private static ArrayList<UnoCard> cardPile;
	private static ArrayList<UnoCard> playedCards;

	private static boolean debug = false;
	/**
	 * Konstruktor für Objekte der Klasse CardPile
	 */
	public CardPile(Deck deck)
	{
		cardPile = new ArrayList<UnoCard>();
		playedCards = new ArrayList<UnoCard>();
		this.deck = deck;
		if(debug)
		{
			System.out.println("Card-pile created, currently empty");
		}
	}

	public void AllCards()      //Did not include all in one loop for overview purposes.
	{
		cardPile.clear();
		//Reds
		for(int i = 0; i < 2; i++)
		{
			cardPile.add(new RedCard(new Symbol("one")));
			cardPile.add(new RedCard(new Symbol("two")));
			cardPile.add(new RedCard(new Symbol("three")));
			cardPile.add(new RedCard(new Symbol("four")));
			cardPile.add(new RedCard(new Symbol("five")));
			cardPile.add(new RedCard(new Symbol("six")));
			cardPile.add(new RedCard(new Symbol("seven")));
			cardPile.add(new RedCard(new Symbol("eight")));
			cardPile.add(new RedCard(new Symbol("nine")));
			/*
			 cardpile.add(new RedCard(new Symbol("skip")));
			 cardpile.add(new RedCard(new Symbol("draw2")));
			 cardpile.add(new RedCard(new Symbol("sd")));
			 */
		}
		cardPile.add(new RedCard(new Symbol("zero")));

		if(debug)
		{
			System.out.println("All red cards have been successfully created");
		}

		//Blues
		for(int i = 0; i < 2; i++)
		{
			cardPile.add(new BlueCard(new Symbol("one")));
			cardPile.add(new BlueCard(new Symbol("two")));
			cardPile.add(new BlueCard(new Symbol("three")));
			cardPile.add(new BlueCard(new Symbol("four")));
			cardPile.add(new BlueCard(new Symbol("five")));
			cardPile.add(new BlueCard(new Symbol("six")));
			cardPile.add(new BlueCard(new Symbol("seven")));
			cardPile.add(new BlueCard(new Symbol("eight")));
			cardPile.add(new BlueCard(new Symbol("nine")));
			/*
			 cardpile.add(new BlueCard(new Symbol("skip")));
			 cardpile.add(new BlueCard(new Symbol("draw2")));
			 cardpile.add(new BlueCard(new Symbol("sd")));
			 */
		}
		cardPile.add(new BlueCard(new Symbol("zero")));

		if(debug)
		{
			System.out.println("All blue cards have been successfully created");
		}

		//Yellows
		for(int i = 0; i < 2; i++)
		{
			cardPile.add(new YellowCard(new Symbol("one")));
			cardPile.add(new YellowCard(new Symbol("two")));
			cardPile.add(new YellowCard(new Symbol("three")));
			cardPile.add(new YellowCard(new Symbol("four")));
			cardPile.add(new YellowCard(new Symbol("five")));
			cardPile.add(new YellowCard(new Symbol("six")));
			cardPile.add(new YellowCard(new Symbol("seven")));
			cardPile.add(new YellowCard(new Symbol("eight")));
			cardPile.add(new YellowCard(new Symbol("nine")));
			/*
			 cardpile.add(new YellowCard(new Symbol("skip")));
			 cardpile.add(new YellowCard(new Symbol("draw2")));
			 cardpile.add(new YellowCard(new Symbol("sd")));
			 */
		}
		cardPile.add(new YellowCard(new Symbol("zero")));

		if(debug)
		{
			System.out.println("All yellow cards have been successfully created");
		}
		//Green
		for(int i = 0; i < 2; i++)
		{
			cardPile.add(new GreenCard(new Symbol("one")));
			cardPile.add(new GreenCard(new Symbol("two")));
			cardPile.add(new GreenCard(new Symbol("three")));
			cardPile.add(new GreenCard(new Symbol("four")));
			cardPile.add(new GreenCard(new Symbol("five")));
			cardPile.add(new GreenCard(new Symbol("six")));
			cardPile.add(new GreenCard(new Symbol("seven")));
			cardPile.add(new GreenCard(new Symbol("eight")));
			cardPile.add(new GreenCard(new Symbol("nine")));
			/*
			 cardpile.add(new GreenCard(new Symbol("skip")));
			 cardpile.add(new GreenCard(new Symbol("draw2")));
			 cardpile.add(new GreenCard(new Symbol("sd")));
			 */
		}
		cardPile.add(new GreenCard(new Symbol("zero")));

		if(debug)
		{
			System.out.println("All green cards have been successfully created");
		}


		//Specials nicht implementiert, nicht geschafft.
		for(int i = 0; i < 4; i++)
		{
			cardPile.add(new Wild());
		}

	}

	public void ShuffleArrayList()  //Shuffles the ArrayList card pile so every card is positioned randomly
	{
		Collections.shuffle(cardPile);
	}

	public void SizeArrayList() //Outputs the size of the ArrayList card pile
	{
		System.out.println("There are " + cardPile.size() + " cards on the cardpile");
	}

	public void GiveCardsToPlayers()    //Gives 7 cards to each player and ai and adds 1 playing card
	{
		for(int i = 0; i < 7; i++)
		{
			UnoCard topcard = cardPile.get(0);
			//First gives to the KI
			deck.GetALDeckAI().add(topcard);
			cardPile.remove(topcard);

			topcard = cardPile.get(0);    //refreshes top card

			//Then gives to the Player
			deck.GetALDeckPlayer().add(topcard);
			cardPile.remove(topcard);
		}

		//Another card which will be the beginning card
		UnoCard cpTop = cardPile.get(0);

		playedCards.add(cpTop);
		cardPile.remove(cpTop);

		if(debug)
		{
			System.out.println("All cards have been given to the players");
		}
	}

	public void RefillCardPile()    //DON'T USE, DIDNT TEST IT YET. [Well intended to use when a card pile runs empty and needs to be refilled]
	{
		UnoCard topCard = ReturnPlayedTopCard();
		playedCards.remove(topCard);

		for(int i = 0; i < playedCards.size(); i++)
		{
			// cardPile.add(i);
			playedCards.remove(i);
		}

		System.out.println(playedCards.size());
		playedCards.add(topCard);
		Collections.shuffle(cardPile);
	}

	public ArrayList<UnoCard> GetALCardPile()    //Returns ArrayList
	{
		return cardPile;
	}

	public UnoCard ReturnPlayedTopCard()    //Returns the card which was recently played (on the playing pile)
	{
		return playedCards.get(playedCards.size() - 1);
	}

	public ArrayList<UnoCard> GetALPlayedCards() //Returns ArrayList of the played cards
	{
		return playedCards;
	}
}
