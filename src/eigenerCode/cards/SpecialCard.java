package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Player;

/**
 * Beschreiben Sie hier die Klasse SpecialCards.
 *
 * @author (Tobi)
 * @version (1.0)
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

	public abstract void PlaySpecialCard(Player p); //!!This class and all classes that extends from this one are not working as well as not included!!
	public abstract void PlaySpecialCard(AI ai);
	public abstract boolean isPlayable();

	public boolean ReturnUsed()
	{
		return isUsed;
	}
}

