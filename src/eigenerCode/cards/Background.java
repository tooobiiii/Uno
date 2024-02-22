package eigenerCode.cards;


import vorgegeben.Figur;

/**
 * This is the background of the playing area in the uno visualization part
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class Background extends Figur
{
	/**
	 * Constructor for objects of class Background
	 * For graphical part, which is not implemented yet
	 */
	public Background()
	{
		super();
		FigurteilFestlegenRechteck(0, 0, 6500, 3500, "grün");
		FigurteilFestlegenRechteck(6500/6, 0, 4333, 3500, "weiß");
		FigurteilFestlegenRechteck(275, 350, 500, 500, "orange");
		FigurteilFestlegenRechteck(275, 350*4, 500, 500, "orange");
		FigurteilFestlegenRechteck(275, 350*7, 500, 500, "orange");
		this.PositionSetzen(0, 0);
	}

	@Override
	public void MausGeklickt(int x, int y, int anzahl)  // I created buttons for the graphical design to perform an action
	{
		System. out. println ("Maus: (" + x + "|" + y + "), " + anzahl + " mal");
		if((x >= 110) && (x <= 310)) {
			if((y >= 140) && (y <= 340))
			{
				System.out.println("Button 1");     // Draw
			}

			if((y >= 560) && (y <= 760))
			{
				System.out.println("Button 2");     // PlayCard
			}

			if((y >= 980) && (y <= 1180))
			{
				System.out.println("Button 3");     // I don't know yet
			}
		}
	}
}

