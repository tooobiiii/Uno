package eigenerCode.cards;


import vorgegeben.Figur;

/**
 * Symbol for the cards
 * @author (Tobi)
 * @version (V 1.0)
 */
public class Symbol extends Figur
{
	private final String symbol;
	private static final boolean debug = false;  //Debug boolean which outputs more information in console for error spotting (if set to true) [used for me to stop errors]
	/**
	 * Konstruktor für Objekte der Klasse Symbol
	 */
	public Symbol(String type)  //creates an empty figure, because graphics are not ready yet.
	{
		super();
		symbol = type;
		switch(type.toLowerCase())
		{
			case "zero":
				FigurteilFestlegenEllipse(145,150,200,300, "schwarz");
				FigurteilFestlegenEllipse(165,170,160,260, "weiß");
				break;
			case "one":
				FigurteilFestlegenRechteck(220, 200, 50, 190, "schwarz");
				break;
			case "two":
				FigurteilFestlegenRechteck(180, 210, 50, 180, "schwarz");
				FigurteilFestlegenRechteck(270, 210, 50, 180, "schwarz");
				break;
			case "three":
				FigurteilFestlegenRechteck(160, 210, 50, 180, "schwarz");
				FigurteilFestlegenRechteck(220, 210, 50, 180, "schwarz");
				FigurteilFestlegenRechteck(280, 210, 50, 180, "schwarz");
				break;
			case "four":
				FigurteilFestlegenRechteck(160, 170, 180, 250, "schwarz");
				FigurteilFestlegenRechteck(195, 170, 110, 120, "weiß");
				FigurteilFestlegenRechteck(160, 320, 150, 100, "weiß");
				break;
			case "five":
				FigurteilFestlegenRechteck(165, 170, 160, 160, "schwarz");
				FigurteilFestlegenRechteck(185, 190, 160, 140, "weiß");
				FigurteilFestlegenEllipse(150,290,180,180, "schwarz");
				FigurteilFestlegenEllipse(170,310,140,140, "weiß");
				FigurteilFestlegenRechteck(150, 330, 60, 60, "weiß");
				break;
			case "six":
				FigurteilFestlegenEllipse(140,150,210,300, "schwarz");
				FigurteilFestlegenEllipse(160,180,200,300, "weiß");
				FigurteilFestlegenEllipse(150,260,190,190, "schwarz");
				FigurteilFestlegenEllipse(170,280,150,150, "weiß");
				FigurteilFestlegenRechteck(290, 200, 60, 60, "weiß");
				break;
			case "seven":
				FigurteilFestlegenRechteck(290, 160, 40, 260, "schwarz");
				FigurteilFestlegenRechteck(160, 160, 160, 40, "schwarz");
				break;
			case "eight":
				FigurteilFestlegenEllipse(160,150,170,170, "schwarz");
				FigurteilFestlegenEllipse(160,290,170,170, "schwarz");
				FigurteilFestlegenEllipse(185,170,120,120, "weiß");
				FigurteilFestlegenEllipse(185,315,120,120, "weiß");
				break;
			case "nine":
				FigurteilFestlegenEllipse(130,140,210,300, "schwarz");
				FigurteilFestlegenEllipse(110,120,210,300, "weiß");
				FigurteilFestlegenEllipse(160,150,170,170, "schwarz");
				FigurteilFestlegenEllipse(185,170,120,120, "weiß");
				break;
			case "draw2":

				break;

			case "wilddraw4":

				break;
			case "skip":

				break;
			case "reverse":

				break;

			case "wild":

				break;

			default:
				System.out.println("Kein Symbol erschaffen Fehler 0");
				this.Entfernen();
				break;
		}

		if(debug)   //Part of the debug
		{
			System.out.println("Symbol " + type);
		}
	}

	public String ReturnSymbol()    //Returns the symbol which a UnoCard has
	{
		return symbol;
	}
}

