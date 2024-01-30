package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Game;
import eigenerCode.game.Player;

import java.util.Scanner;

import static eigenerCode.game.Misc.Sleep;


/**
 * Write a description of class Skip here.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class WildDraw4 extends SpecialCard
{
	Scanner scanner;
	/**
	 * Constructor for objects of class Skip
	 */
	public WildDraw4()
	{
		super(new BasicCard("schwarz"), new Symbol("wildDraw4"));
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
		Game.getCp().GetALPlayedCards().add(this);
		Game.getDeck().GetALDeckPlayer().remove(this);
		Game.getAi().AIDrawCard(4);
		Game.getAi().PassMoveToAI();
	}

	@Override
	public void PlaySpecialCard(AI ai)
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
		Game.getCp().GetALPlayedCards().add(this);
		Game.getDeck().GetALDeckAI().remove(this);
		Game.getP().PlayerDrawCard(4);
		Game.getP().PassMoveToPlayer();
	}

	@Override
	public boolean isPlayable()
	{
		return true;
	}
}

