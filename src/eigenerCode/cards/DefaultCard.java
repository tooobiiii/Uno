package eigenerCode.cards;

/**
 * This class represents all objects that are not a special card
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

