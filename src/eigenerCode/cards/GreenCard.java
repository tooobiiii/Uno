package eigenerCode.cards;


/**
 * Beschreiben Sie hier die Klasse GreenCard.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class GreenCard extends DefaultCard
{
	/**
	 * Konstruktor für Objekte der Klasse GreenCard
	 */
	public GreenCard(Symbol s)
	{
		super(new BasicCard("grün"), s);
		s.NachVornBringen();
	}
}

