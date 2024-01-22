package eigenerCode.cards;


/**
 * Beschreiben Sie hier die Klasse Blue card.
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

