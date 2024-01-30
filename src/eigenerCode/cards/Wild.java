package eigenerCode.cards;

import eigenerCode.game.AI;
import eigenerCode.game.Game;
import eigenerCode.game.Player;

import java.util.Random;
import java.util.Scanner;

import static eigenerCode.game.Game.getCp;
import static eigenerCode.game.Game.getDeck;
import static eigenerCode.game.Misc.Sleep;

/**
 * Write a description of class Skip here.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class Wild extends SpecialCard
{
	private final Scanner scanner;
	/**
	 * Constructor for objects of class Skip
	 */
	public Wild()
	{
		super(new BasicCard("schwarz"), new Symbol("wild"));

		scanner = new Scanner(System.in);
	}

	@Override
	public void PlaySpecialCard(Player p)
	{
		boolean correct = false;
		Sleep(500);
		System.out.println("[SPECIAL CARD] Which color would you like to choose? (Type in Blue / b, Yellow / y, Red / r, green / g");
		Sleep(500);

		do {
			String input = scanner.nextLine();

			switch(input.toLowerCase())
			{
				case "red":
				case "r":
					this.bc.ChangeColor("red");
					System.out.println("[SPECIAL CARD] You have chosen the color red successfully");
					correct = true;
					isUsed = true;
					break;
				case "green":
				case "g":
					this.bc.ChangeColor("green");
					System.out.println("[SPECIAL CARD] You have chosen the color green successfully");
					correct = true;
					isUsed = true;
					break;
				case "yellow":
				case "y":
					this.bc.ChangeColor("yellow");
					System.out.println("[SPECIAL CARD] You have chosen the color yellow successfully");
					correct = true;
					isUsed = true;
					break;
				case "blue":
				case "b":
					this.bc.ChangeColor("blue");
					System.out.println("[SPECIAL CARD] You have chosen the color blue successfully");
					correct = true;
					isUsed = true;
					break;
				default:
					System.out.println("[INPUT ERROR] Please specify a valid color");
			}
		} while(! correct);
		getCp().GetALPlayedCards().add(this);
		getDeck().GetALDeckPlayer().remove(this);
		Game.getAi().PassMoveToAI();
	}

	@Override
	public void PlaySpecialCard(AI ai)
	{
		Sleep(500);
		System.out.println("[AI] AI is choosing a color");
		Sleep(500);
		Random random = new Random();
		int c = random.nextInt(1,5);
		switch (c)
		{
			case 1:
				this.bc.ChangeColor("red");
				System.out.println("[AI] I chose red!");
				isUsed = true;
				break;
			case 2:
				this.bc.ChangeColor("green");
				System.out.println("[AI] I chose green!");
				isUsed = true;
				break;
			case 3:
				this.bc.ChangeColor("yellow");
				System.out.println("[AI] I chose yellow!");
				isUsed = true;
				break;
			case 4:
				this.bc.ChangeColor("blue");
				System.out.println("[AI] I chose blue!");
				isUsed = true;
				break;
		}
		getCp().GetALPlayedCards().add(this);
		getDeck().GetALDeckAI().remove(this);
		Game.getP().PassMoveToPlayer();
	}

	@Override
	public boolean isPlayable()
	{
		return true;
	}
}

