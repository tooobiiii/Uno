package eigenerCode.cards;


/**
 * Beschreiben Sie hier die Klasse Bluecard.
 *
 * @author @author (Tobi)
 * @version (V 1.0)
 */
public class BlueCard extends DefaultCard
{
	/**
	 * Konstruktor für Objekte der Klasse Bluecard
	 */
	public BlueCard(Symbol s)
	{
		super(new BasicCard("blau"), s);
		s.NachVornBringen();
	}
}

