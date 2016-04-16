package dragonspiretournament.nameselection;

import dragonspiretournament.GameObjects.Player;

public class NameSelectionController {
	
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
	 * @param The name to set as the current player's name.
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
	
	public static void setPlayerOne( Player player ) {
		nameSelector.setPlayerOne( player );
	}
	
	public static void setPlayerTwo( Player player ) {
		nameSelector.setPlayerTwo( player );
	}

}
