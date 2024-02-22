package eigenerCode.game;

import eigenerCode.cards.SpecialCard;
import eigenerCode.cards.UnoCard;

import java.util.ArrayList;
import java.util.Objects;

/**
 * AI works as an automatic BOT which plays whatever card is possible. If multiple, random choice.
 * It is not that smart yet
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class AI extends Misc
{
	private Player p;
	private final Deck deck;
	private final CardPile cp;

	private final ArrayList<UnoCard> deckAI;
	private boolean yourMove;
	private boolean won;
	/**
	 * Constructor for objects of class AI
	 */
	public AI(Deck deck, CardPile cp)
	{
		this.cp = cp;
		this.deck = deck;

		won = false;

		deckAI = deck.GetALDeckAI();
	}

	public void AIPlayCard()    // Automatically plays a card as the AI, well it only checks if something is possible, if not, AI draws a card. [Note | NOT DONE] Random choice of possible cards, or even smart choice.
	{
		/* Ai card check
		System.out.println(deckAI.size());
		deckAI.forEach(unoCard -> System.out.println(unoCard.ReturnInfo()));
		 */
		if(yourMove)
		{
			int triedcards = 0;
			Sleep(500);
			System.out.println("[AI] AI thinks about what to respond to a " + cp.ReturnPlayedTopCard().bc.ReturnColor() + " " + cp.ReturnPlayedTopCard().s.ReturnSymbol());

			for(UnoCard uc : deckAI)
			{
				if (uc instanceof SpecialCard specialCard)
					if (specialCard.isPlayable())
					{
						System.out.println("[SPECIAL CARD] AI played a " + uc.ReturnInfoShort());
						specialCard.PlaySpecialCard(this);
						break;
					}
					else continue;
				if((Objects.equals(uc.bc.ReturnColor(), cp.ReturnPlayedTopCard().bc.ReturnColor())) || (Objects.equals(uc.s.ReturnSymbol(), cp.ReturnPlayedTopCard().s.ReturnSymbol())))
				{
					cp.GetALPlayedCards().add(uc);
					deck.GetALDeckAI().remove(uc);

					Sleep(500);
					System.out.println("[AI] AI played a " + uc.ReturnInfoShort() + " and now has " + deck.GetALDeckAI().size() + " cards left");

					break;
				}   else
				{
					triedcards++;
					if(triedcards == deckAI.size())
					{
						AIDrawCard();
						Sleep(500);
						System.out.println("[AI] AI drew a new card, they cant play and have now " + deck.GetALDeckAI().size() + " cards left. You are next!");

						p.PassMoveToPlayer();
						yourMove = false;

						break;
					}
				}
			}
			if(deck.GetALDeckAI().isEmpty())
			{
				won = true;
			} else
			{
				p.PassMoveToPlayer();
				yourMove = false;
			}
		}
	}

	public void AIDrawCard()    // Method used to give AI a card on draw
	{
		deck.GetALDeckAI().add(cp.GetALCardPile().get(0));
		cp.GetALCardPile().remove(0);
	}

	public void AIDrawCard(int amount)    // Method used to give AI x number of cards on draw
	{
		for (int i = 0; i < amount; i++)
		{
			deck.GetALDeckAI().add(cp.GetALCardPile().get(0));
			cp.GetALCardPile().remove(0);
		}
	}

	public void PassMoveToAI()  // Method used when player finishes and AI is next (used in player)
	{
		Sleep(500);
		System.out.println("[GAME] Its now AI's turn");
		yourMove = true;
		AIPlayCard();
	}

	public void AddPlayer(Player p) // Adding the player afterward to avoid error (in Game)
	{
		this.p = p;
	}

	public boolean ReturnYourMove() // This is here for future purposes for graphical design
	{
		return yourMove;
	}

	public boolean ReturnWon()  // Did you win or did you cheat?
	{
		return won;
	}
}

