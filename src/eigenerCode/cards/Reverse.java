package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Player;

/**
 * Write a description of class Skip here.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class Reverse extends SpecialCard
{
	/**
	 * Constructor for objects of class Skip
	 */
	public Reverse(BasicCard bc, Symbol s)
	{
		super(bc, s);

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

