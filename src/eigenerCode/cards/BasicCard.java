package eigenerCode.cards;


import vorgegeben.Figur;

/**
 * Beschreiben Sie hier die Klasse BasicCard.
 *
 * @author (Thomas, Amelie, Tobi)
 * @version (V 1.0)
 */
public class BasicCard extends Figur
{
	private String color;
	private static boolean debug;  //Debug boolean which outputs more information in console for error spotting (if set to true) [used for me to stop errors]
	/**
	 * Konstruktor für Objekte der Klasse BasicCard
	 */
	public BasicCard(String farbe)
	{
		super();

		debug = false;

		FigurteilFestlegenRechteck(100, 100, 300, 400, farbe);
		FigurteilFestlegenEllipse(110,110,270,370, "weiß");

		this.color = farbe;
		if(debug)   //Part of the debug
		{
			System.out.println("The card has the color " + farbe);
		}
	}

	public String ReturnColor() //Translating color from Figur and returning
	{
		return switch (color)
		{
			case "grün" ->
			{
				this.color = "green";
				yield color;
			}
			case "gelb" ->
			{
				this.color = "yellow";
				yield color;
			}
			case "blau" ->
			{
				this.color = "blue";
				yield color;
			}
			case "rot" ->
			{
				this.color = "red";
				yield color;
			}
			case "schwarz" ->
			{
				this.color = "black";
				yield color;
			}
			default -> color;
		};
	}

	public void ChangeColor(String color)   //sets new card color. valid for wild cards.
	{
		switch(color)
		{
			case "green":
				this.color = "green";
				break;
			case "yellow":
				this.color = "yellow";
				break;
			case "blue":
				this.color = "blue";
				break;
			case "red":
				this.color = "red";
				break;
			case "schwarz":
				this.color = "black";
				break;

			default:
				System.out.println("[ERROR] INVALID COLOR WAS GIVEN TO CARD CHECK CLASSES"); //Error
				break;
		}
	}
}

