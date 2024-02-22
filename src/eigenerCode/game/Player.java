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
	// References
	private final CardPile cp;
	private final Deck deck;
	private final Scanner scanner;
	private final AI ai;

	// Attributes
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

	public void PlayerDryDraw(int amount)
	{
		for(int i = 0; i < amount; i++)
		{
			UnoCard drawCard = cp.GetALCardPile().get(0);
			drewCards.add(drawCard);

			deck.GetALDeckPlayer().add(drawCard);
			cp.GetALCardPile().remove(drawCard);

			Sleep(500);
			System.out.println("[PLAYER] You just got a " + drawCard.bc.ReturnColor() + " " + drawCard.s.ReturnSymbol());
		}
	}

	public void PlayerDrawCard(int amount)  // Method to draw a card as the player
	{
		drewCards.clear();
		PlayerDryDraw(amount);

		// Offers to play a card of possible after you drew one
		for(UnoCard uc : drewCards)
		{
			if(((Objects.equals(uc.s.ReturnSymbol(), cp.ReturnPlayedTopCard().s.ReturnSymbol())) || (Objects.equals(uc.bc.ReturnColor(), cp.ReturnPlayedTopCard().bc.ReturnColor())) || (uc.ReturnSpecial())))
			{
				if (uc instanceof SpecialCard specialCard)
					if (!specialCard.isPlayable())
						return;
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
								if (uc instanceof SpecialCard specialCard)
									specialCard.PlaySpecialCard(this);
								else
								{
									cp.GetALPlayedCards().add(uc);
									deck.GetALDeckPlayer().remove(deck.GetALDeckPlayer().get(deck.GetALDeckPlayer().size() - 1));
									Sleep(500);
									System.out.println("[PLAYER] Card played successfully.");
								}
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
								System.out.println("[INPUT ERROR] Invalid command. Try again");
								break;
						}
					} while (! correct);
				}
			}
		}

		yourMove = false;
		ai.PassMoveToAI();
	}

	public void ScannerInput()  // Uses the scanner to check and react on the player input
	{
		if(scanner.hasNextInt())
		{
			int input = scanner.nextInt();
			scanner.nextLine(); // Clearing the \n
			if((input >= 1) && (input <= deck.GetALDeckPlayer().size()))
			{
				UnoCard triedCard = deck.GetALDeckPlayer().get(input - 1);

				if(triedCard instanceof SpecialCard specialCard)   // Proceed for special cards
				{
					if (!specialCard.isPlayable()) return;
					specialCard.PlaySpecialCard(this);
				} else // Proceed for not special cards
				{
					if(Objects.equals(triedCard.bc.ReturnColor(), cp.ReturnPlayedTopCard().bc.ReturnColor()) || (Objects.equals(triedCard.s.ReturnSymbol(), cp.ReturnPlayedTopCard().s.ReturnSymbol())))
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
						Sleep(500);
						System.out.println("[GAME] This card is not allowed to be played here. Try again.");
						ScannerInput();
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
			if (command.equals("draw") || command.equals("d"))
			{
				PlayerDrawCard(1);
			} else
			{
				Sleep(500);
				System.out.println("[CONSOLE ERROR] Invalid command");
				ScannerInput();
			}
		}
	}

	public void PlayerPlayCard()    // Method used to play a card as the player
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

	public void PassMoveToPlayer()  // This method is used when the AI finished their move and passes their move to the player
	{
		yourMove = true;
		PlayerPlayCard();
	}

	public boolean ReturnWon()  // Returns won
	{
		return won;
	}
}

