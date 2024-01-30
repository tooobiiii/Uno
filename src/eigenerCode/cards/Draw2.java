package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Player;

/**
 * Write a description of class Skip here.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class Draw2 extends SpecialCard
{
	/**
	 * Constructor for objects of class Skip
	 */
	public Draw2(String color)
	{
		super(new BasicCard(color), new Symbol("draw2"));
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

