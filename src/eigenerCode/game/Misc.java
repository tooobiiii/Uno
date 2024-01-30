package eigenerCode.game;


import vorgegeben.Ereignisbehandlung;

/**
 * Write a description of class Misc here.
 *
 * @author (Tobi)
 * @version (1.0)
 */
public class Misc extends Ereignisbehandlung
{
	/**
	 * Constructor for objects of class Misc
	 */
	public Misc()
	{
		super();
	}

	/**
	 * This Method sleeps the thread for int time
	 * Mostly used to give the Terminal a kind of flow.
	 * @param time to wait in ms
	 */
	public static void Sleep(int time)
	{
		try
		{
			Thread.sleep(time);
		}
		catch (InterruptedException ie)
		{
			ie.printStackTrace();
		}
	}
}

