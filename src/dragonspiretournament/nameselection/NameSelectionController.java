package dragonspiretournament.nameselection;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.game.GameController;

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
	
	/**
	 * Gives the final names to the game controller.
	 * @param playerOne the data for player one.
	 * @param playertwo the data for player two.
	 */
	public static void finalizeNames()
	{
		GameController.createPlayers(nameSelector.getPlayerOne(), nameSelector.getPlayerTwo());
	}
	
	/**
	 * Now that names are selected, indicate that we're done with the name select and should 
	 * move on to select army.
	 */
	public static void goToChooseArmy()
	{
		System.out.println("going to choose army screen");
		GameController.createArmySelectionView(nameSelector.getPlayerOne(), nameSelector.getPlayerTwo());
		GameController.changeView("armySelect");
	}

	public static void resetPlayers() 
	{
	    nameSelector.resetPlayers();
	}
	
	/**
	 * Gets the path to the submit button.
	 * @return path to the submit button.
	 */
	public static String getSubmitButton() {
		return "Art/UIGraphics/SubmitButton.png";
	}
}
