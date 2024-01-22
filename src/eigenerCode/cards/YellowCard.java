package eigenerCode.cards;


/**
 * Beschreiben Sie hier die Klasse YellowCard.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class YellowCard extends DefaultCard
{
	/**
	 * Konstruktor für Objekte der Klasse YellowCard
	 */
	public YellowCard(Symbol s)
	{
		super(new BasicCard("gelb"), s);
		s.NachVornBringen();
	}
}

