package eigenerCode.cards;


/**
 * This represents objects that are a red card of any symbol
 *
 * @author @author (Tobi)
 * @version (V 1.0)
 */
public class RedCard extends DefaultCard
{
	/**
	 * Konstruktor für Objekte der Klasse RedCard
	 */
	public RedCard(Symbol s)
	{
		super(new BasicCard("rot"), s);
		s.NachVornBringen();
	}
}

