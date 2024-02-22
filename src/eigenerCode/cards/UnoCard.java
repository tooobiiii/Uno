package eigenerCode.cards;


import vorgegeben.Figur;

/**
 * Overall uno card class
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class UnoCard extends Figur
{
	// References
	public BasicCard bc;
	public Symbol s;

	// Attributes
	protected boolean isSpecial;    // Only valid for special card handling.

	/**
	 * Konstruktor für Objekte der Klasse UnoCards
	 */
	public UnoCard(BasicCard bc, Symbol s)
	{
		this.bc = bc;
		this.s = s;
	}

	@Override
	public void PositionSetzen(int x, int y)
	{
		bc.PositionSetzen(x, y);
		s.PositionSetzen(x, y);
	}

	public String ReturnInfo()  // Returns the full sentence of the card info
	{
		return "The card has the color " + bc.ReturnColor() + " and has the symbol " + s.ReturnSymbol();
	}

	public String ReturnInfoShort() // User friendlier version of the method above because im to lazy to read it every time
	{
		return bc.ReturnColor() + " " + s.ReturnSymbol();
	}

	public boolean ReturnSpecial()
	{
		return isSpecial;
	}
}

