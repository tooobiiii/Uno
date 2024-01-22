package eigenerCode.cards;

/**
 * Beschreiben Sie hier die Klasse DefaultCards.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public abstract class DefaultCard extends UnoCard
{
	/**
	 * Konstruktor für Objekte der Klasse DefaultCards
	 */
	public DefaultCard(BasicCard bc, Symbol s)
	{
		super(bc, s);
		isSpecial = false;
	}
}

