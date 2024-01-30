package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Game;
import eigenerCode.game.Player;

import java.util.Objects;

import static eigenerCode.game.Game.getCp;
import static eigenerCode.game.Game.getDeck;

/**
 * Write a description of class Skip here.
 *
 * @author (Tobi)
 * @version (V 1.0)
 */
public class Skip extends SpecialCard
{
	/**
	 * Constructor for objects of class Skip
	 */
	public Skip(BasicCard bc, Symbol s)
	{
		super(bc, s);

	}

	@Override
	public void PlaySpecialCard(Player p)
	{
		System.out.println("[GAME] You skipped the AI!!");
		isUsed = true;
		getCp().GetALPlayedCards().add(this);
		getDeck().GetALDeckPlayer().remove(this);
		Game.getP().PassMoveToPlayer();
	}

	@Override
	public void PlaySpecialCard(AI ai)
	{
		System.out.println("[GAME] The AI skipped you!");
		isUsed = true;
		getCp().GetALPlayedCards().add(this);
		getDeck().GetALDeckAI().remove(this);
		Game.getAi().PassMoveToAI();
	}

	@Override
	public boolean isPlayable()
	{
		return Objects.equals(Game.getCp().ReturnPlayedTopCard().bc.ReturnColor(), this.bc.ReturnColor()) || Game.getCp().ReturnPlayedTopCard() instanceof Skip;
	}
}

