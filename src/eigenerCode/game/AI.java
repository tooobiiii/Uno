package eigenerCode.game;

import eigenerCode.cards.UnoCard;

import java.util.ArrayList;
import java.util.Objects;

/**
 * AI works as an automatic BOT which plays whatever card is possible. If multiple, random choice.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class AI extends Misc
{
	private Player p;
	private final Deck deck;
	private final CardPile cp;

	private final ArrayList<UnoCard> deckAI;  //Error Umgehung
	private final boolean debug = false;
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

		deckAI = deck.GetALDeckAI();    //Hier weil direkte Übergabe Error
	}

	public void AIPlayCard()    //Automatically plays a card as the AI, well it only checks if something is possible, if not, AI draws a card. [Note | NOT DONE] Random choice of possible cards, or even smart choice.
	{
		if(yourMove)
		{
			int triedcards = 0;
			Sleep(500);
			System.out.println("[AI] AI thinks about what to respond to a " + cp.ReturnPlayedTopCard().bc.ReturnColor() + " " + cp.ReturnPlayedTopCard().s.ReturnSymbol());
			//deckAI = deck.GetALDeckAI();

			for(UnoCard uc : deckAI)
			{
				if((Objects.equals(uc.bc.ReturnColor(), cp.ReturnPlayedTopCard().bc.ReturnColor())) || (Objects.equals(uc.s.ReturnSymbol(), cp.ReturnPlayedTopCard().s.ReturnSymbol())))
				{
					cp.GetALPlayedCards().add(uc);
					deck.GetALDeckAI().remove(uc);

					Sleep(500);
					System.out.println("[AI] AI played a " + uc.ReturnInfoShort() + " and now has " + deck.GetALDeckAI().size() + " cards left");

					if(deck.GetALDeckAI().isEmpty())
					{
						won = true;
					} else
					{
						p.PassMoveToPlayer();
						yourMove = false;
					}

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
		}
	}

	public void AIDrawCard()    //Method used to give AI a card on draw
	{
		deck.GetALDeckAI().add(cp.GetALCardPile().get(0));
		cp.GetALCardPile().remove(0);
	}

	public void PassMoveToAI()  //Method used when player finishes and AI is next (used in player)
	{
		Sleep(500);
		System.out.println("[GAME] Your move is over. Its now AI's turn");
		yourMove = true;
		AIPlayCard();
	}

	public void AddPlayer(Player p) //Adding the player afterward to avoid error (in Game)
	{
		this.p = p;
	}

	public boolean ReturnYourMove() //This is here for future purposes for graphical design)
	{
		return yourMove;
	}

	public boolean ReturnWon()  //Did you win or did you cheat?
	{
		return won;
	}
}

