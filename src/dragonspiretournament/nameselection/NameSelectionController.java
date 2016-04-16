package dragonspiretournament.nameselection;

import dragonspiretournament.GameObjects.Player;

/**
 * The Class NameSelectionController.
 */
public class NameSelectionController {
	
	/** The name selector. */
	static NameSelectionModel nameSelector = new NameSelectionModel();
	/**
	 * Gets the name of the current player.
	 * @return the name of the player grabbed from the model.
	 */
	public static String getPlayer()
	{
		return nameSelector.getPlayer();
	}
	
	/**
	 * Sets the name of the current player.
	 *
	 * @param name the new name
	 */
	public static void setName(String name)
	{
		nameSelector.setPlayerName(name);
	}
	
	/**
	 * Determines whether we should get more player names or move on to the game.
	 * @return a boolean, true when we are done getting names, false when we are not.
	 */
	public static boolean goToNextFrame()
	{
		return nameSelector.getNext();
	}
	
	/**
	 * Sets the player one.
	 *
	 * @param player the new player one
	 */
	public static void setPlayerOne( Player player ) {
		nameSelector.setPlayerOne( player );
	}
	
	/**
	 * Sets the player two.
	 *
	 * @param player the new player two
	 */
	public static void setPlayerTwo( Player player ) {
		nameSelector.setPlayerTwo( player );
	}

}
