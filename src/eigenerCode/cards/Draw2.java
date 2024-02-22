package eigenerCode.cards;


import eigenerCode.game.AI;
import eigenerCode.game.Game;
import eigenerCode.game.Misc;
import eigenerCode.game.Player;

import java.util.Objects;

import static eigenerCode.game.Game.getCp;
import static eigenerCode.game.Game.getDeck;

/**
 * This represents objects that are of the draw2 type, no matter what color
 *
 * @author (Tobi)
 * @version (V 1.0)
 *
 * Missing stacking feature!
 */
public class Draw2 extends SpecialCard
{
	private static int stacks; // Used for stacking mechanic - Not done yet
	/**
	 * Constructor for objects of class Skip
	 */
	public Draw2(String color)
	{
		super(new BasicCard(color), new Symbol("draw2"));
		stacks = 0;
	}

	@Override
	public void PlaySpecialCard(Player p)
	{
		if (Game.getCp().GetALPlayedCards().isEmpty()) // If draw2 is the starting card
		{
			Misc.Sleep(500);
			Game.getP().PlayerDrawCard(2);
			System.out.println("[SPECIAL CARD] You had to draw 2 cards");
			getCp().GetALPlayedCards().add(this);
			getDeck().GetALDeckAI().remove(this);
			Game.getP().PassMoveToPlayer();
		}
		else
		{
			isUsed = true;
			Misc.Sleep(500);
			Game.getAi().AIDrawCard(2);
			System.out.println("[SPECIAL CARD] AI drew 2 cards");
			getCp().GetALPlayedCards().add(this);
			getDeck().GetALDeckPlayer().remove(this);
			Game.getAi().PassMoveToAI();
		}
	}

	@Override
	public void PlaySpecialCard(AI ai)
	{
		isUsed = true;
		Misc.Sleep(500);
		Game.getP().PlayerDryDraw(2);
		System.out.println("[SPECIAL CARD] You had to draw 2 cards");
		getCp().GetALPlayedCards().add(this);
		getDeck().GetALDeckAI().remove(this);
		Game.getP().PassMoveToPlayer();
	}

	@Override
	public boolean isPlayable()
	{
		return Game.getCp().ReturnPlayedTopCard() instanceof Draw2 || Objects.equals(Game.getCp().ReturnPlayedTopCard().bc.ReturnColor(), this.bc.ReturnColor());
	}
}

