package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Player;

/**
 * Write a description of class Skip here.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class WildDraw4 extends SpecialCard
{
	/**
	 * Constructor for objects of class Skip
	 */
	public WildDraw4(Symbol s)
	{
		super(new BasicCard("schwarz"), new Symbol("draw4"));

	}

	@Override
	public void PlaySpecialCard(Player p)
	{

	}

	@Override
	public void PlaySpecialCard(AI ai)
	{

	}

	@Override
	public boolean isPlayable()
	{
		return false;
	}
}

