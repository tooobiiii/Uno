package eigenerCode.cards;


/**
 * This represents objects that are a blue card of any symbol
 *
 * @author @author (Tobi)
 * @version (V 1.0)
 */
public class BlueCard extends DefaultCard
{
	/**
	 * Konstruktor für Objekte der Klasse Blue card
	 */
	public BlueCard(Symbol s)
	{
		super(new BasicCard("blau"), s);
		s.NachVornBringen();
	}
}

