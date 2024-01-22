package eigenerCode.cards;


/**
 * Beschreiben Sie hier die Klasse RedCard.
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

