package eigenerCode.game;


import vorgegeben.Ereignisbehandlung;

/**
 * Write a description of class Misc here.
 *
 * @author (your name)
 * @version (a version number or a date)
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
	 * (von Tobi)
	 * @param time to wait in ms
	 */
	public void Sleep(int time)
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

