package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Player;

/**
 * This represents objects that are special
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

	public abstract void PlaySpecialCard(Player p);
	public abstract void PlaySpecialCard(AI ai);
	public abstract boolean isPlayable();

	public boolean ReturnUsed()
	{
		return isUsed;
	}
}

