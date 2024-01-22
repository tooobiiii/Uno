package eigenerCode.game;

import eigenerCode.cards.SpecialCard;
import eigenerCode.cards.UnoCard;
import eigenerCode.cards.Wild;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
/**
 * This class has every import method for the player here.
 *
 * @author (Tobi)
 * @version (1.0)
 */
public class Player extends Misc
{
	//References
	private final CardPile cp;
	private final Deck deck;
	private final Scanner scanner;
	private final AI ai;

	//Attributes
	private boolean yourMove;
	private boolean won;
	private final ArrayList<UnoCard> drewCards;

	/**
	 * Constructor for objects of class Player
	 */
	public Player(Deck deck, CardPile cp, AI ai)
	{
		this.deck = deck;
		this.cp = cp;
		this.ai = ai;

		scanner = new Scanner(System.in);
		drewCards = new ArrayList<>();

		won = false;
	}

	public void PlayerDrawCard(int amount)  //Method to draw a card as the player
	{
		drewCards.clear();
		for(int i = 0; i < amount; i++)
		{
			UnoCard drawCard = cp.GetALCardPile().get(0);
			drewCards.add(drawCard);

			deck.GetALDeckPlayer().add(drawCard);
			cp.GetALCardPile().remove(drawCard);

			Sleep(500);
			System.out.println("[PLAYER] You just got a " + drawCard.bc.ReturnColor() + " " + drawCard.s.ReturnSymbol());
		}

		//Offers to play a card of possible after you drew one
		for(UnoCard uc : drewCards)
		{
			if(((Objects.equals(uc.s.ReturnSymbol(), cp.ReturnPlayedTopCard().s.ReturnSymbol())) || (Objects.equals(uc.bc.ReturnColor(), cp.ReturnPlayedTopCard().bc.ReturnColor())) || (uc.ReturnSpecial())))
			{
				if(amount == 1){
					Sleep(500);
					System.out.println("[GAME] You have the possibility to play the card you just drew. Do you want to do that. (Type in yes / y, or no / n)");

					boolean correct = false;

					do
					{
						String input = scanner.nextLine().toLowerCase();
						switch(input)
						{
							case "yes":
							case "y":
								cp.GetALPlayedCards().add(uc);
								deck.GetALDeckPlayer().remove(deck.GetALDeckPlayer().get(deck.GetALDeckPlayer().size() - 1));
								Sleep(500);
								System.out.println("[PLAYER] Card played successfully.");
								correct = true;
								break;

							case "no":
							case "n":
								Sleep(500);
								System.out.println("[PLAYER] Offer skipped.");
								correct = true;
								break;

							default:
								Sleep(500);
								System.out.println("[INPUT ERROR] Unvalid command. Try again");
								correct = false;
								break;
						}
					} while (! correct);
				}
			}
		}

		yourMove = false;
		ai.PassMoveToAI();
	}

	public void ScannerInput()  //Uses the scanner to check and react on the players input
	{
		if(scanner.hasNextInt())
		{
			int input = scanner.nextInt();
			scanner.nextLine(); //Clearing the \n
			if((input >= 1) && (input <= deck.GetALDeckPlayer().size()))
			{
				UnoCard triedCard = (UnoCard) deck.GetALDeckPlayer().get(input - 1);

				if(triedCard.ReturnSpecial())   //Proceed for special cards
				{
					if(triedCard instanceof Wild wildcard)
					{

						Sleep(500);
						System.out.println("[SPECIAL CARD] Which color would you like to choose? (Type in Blue / b, Yellow / y, Red / r, green / g");
						Sleep(500);

						wildcard.PlaySpecialCard();
						cp.GetALPlayedCards().add(wildcard);
						deck.GetALDeckPlayer().remove(wildcard);
						ai.PassMoveToAI();
					}
				} else //proceed for not special cards
				{
					if((triedCard.getClass() == cp.ReturnPlayedTopCard().getClass()) || (triedCard.s.ReturnSymbol() == cp.ReturnPlayedTopCard().s.ReturnSymbol()))
					{
						cp.GetALPlayedCards().add(triedCard);
						deck.GetALDeckPlayer().remove(triedCard);
						Sleep(500);
						System.out.println("[GAME] You have successfully played this card");

						if(deck.GetALDeckPlayer().isEmpty())
						{
							won = true;
						} else
						{
							yourMove = false;
							ai.PassMoveToAI();
						}
					} else
					{
						if(cp.ReturnPlayedTopCard().ReturnSpecial())
						{
							SpecialCard specialcard = (SpecialCard) triedCard;
							if(! specialcard.ReturnUsed())
							{
								cp.GetALPlayedCards().add(triedCard);
								deck.GetALDeckPlayer().remove(triedCard);

								System.out.println("[GAME] You have successfully played this card");
							}
						} else
						{
							Sleep(500);
							System.out.println("[GAME] This card is not allowed to be played here. Try again.");
							ScannerInput();
						}
					}
				}
			} else
			{
				Sleep(500);
				System.out.println("[SCANNER ERROR] Please insert a valid Number. Try again.");
				ScannerInput();
			}
		} else
		{
			String command = scanner.nextLine().toLowerCase();
			if (command.equals("draw"))
			{
				PlayerDrawCard(1);
			} else
			{
				Sleep(500);
				System.out.println("[CONSOLE ERROR] Unvalid command");
				ScannerInput();
			}
		}
	}

	public void PlayerPlayCard()    //Method used to play a card as the player
	{
		if((yourMove) && (! deck.GetALDeckPlayer().isEmpty()))
		{
			Sleep(500);
			System.out.println("[PLAYER] So its time to make a move! The current playing card is a " + cp.ReturnPlayedTopCard().ReturnInfoShort());
			deck.ShowYourDeck();

			Sleep(500);
			System.out.println("[PLAYER] What card do you want to be played? Specify a number. 1 - " + deck.GetALDeckPlayer().size() + ". If you cant play any card, type in draw");

			ScannerInput();
		}
	}

	public void PassMoveToPlayer()  //This method is used when the the AI finished their move and passes their move to the player
	{
		yourMove = true;
		PlayerPlayCard();
	}

	public boolean ReturnWon()  //Returns won
	{
		return won;
	}
}

