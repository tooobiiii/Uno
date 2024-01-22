package eigenerCode.cards;

import java.util.Scanner;
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
	public void PlaySpecialCard()
	{
		boolean correct = false;

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
	}
}

