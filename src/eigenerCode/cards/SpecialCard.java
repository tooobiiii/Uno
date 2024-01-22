package eigenerCode.cards;


/**
 * Beschreiben Sie hier die Klasse SpecialCards.
 *
 * @author (Tobi)
 * @version (-)
 */
public abstract class SpecialCard extends UnoCard

{
	protected boolean isUsed;
	/**
	 * Konstruktor für Objekte der Klasse SpecialCards
	 */
	public SpecialCard(BasicCard bc, Symbol s)
	{
		super(bc, s);
		isSpecial = true;
		isUsed = false;
	}

	public abstract void PlaySpecialCard(); //!!This class and all classes which extends from this one are not working as well as not included!!

	public boolean ReturnUsed()
	{
		return isUsed;
	}
}

