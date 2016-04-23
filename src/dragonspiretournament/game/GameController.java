package dragonspiretournament.game;

import javax.swing.ImageIcon;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.game.GameView;
import dragonspiretournament.game.GameState;

/**
 * The Class GameController.
 */
public class GameController {
	
	/**
	 * a gameview.
	 */
	private static GameView gameView;
	
	/**
	 * persistent player objects to be passed around
	 */
	private static Player playerOne;
	private static Player playerTwo;
	
	/**
	 * The persistant game state
	 */
	private static GameState gameState;

	/**
	 * used with main to initialize the game view
	 */
	public static void createGame()
	{
		gameView = new GameView();
		gameState = new GameState();
	}
	
	/**
	 * Calls the game view's change view, which changes which view is shown.
	 * @param viewToShow the string of the view to show.
	 */
	public static void changeView(String viewToShow)
	{
		gameView.changeView(viewToShow);
	}
	
	/**
	 * Creates the persistant player objects that will be passed along to other controllers.
	 * @param playerOne the first player's information
	 * @param playerTwo the second player's information
	 */
	public static void createPlayers(Player playerOneNew, Player playerTwoNew)
	{
		playerOne = playerOneNew;
		playerTwo = playerTwoNew;
		
		//created with default armies
		Army playerOneArmy = new Army();
		DragonLibrary dragLib = new DragonLibrary();
		playerOneArmy.add( dragLib.getDragon(0));
		playerOneArmy.add( dragLib.getDragon(1));
		playerOneArmy.add( dragLib.getDragon(2));
		
		playerOne.setArmy(playerOneArmy);
		
		Army playerTwoArmy = new Army();
		DragonLibrary dragLib2 = new DragonLibrary();
		playerOneArmy.add( dragLib2.getDragon(0));
		playerOneArmy.add( dragLib2.getDragon(1));
		playerOneArmy.add( dragLib2.getDragon(2));
		
		playerTwo.setArmy(playerTwoArmy);
	}
	
	/**
	 * calls the method in game view to create a new card for the army selection screen.
	 * @param playerOne the player object containing information on player one, passed from name selection.
	 * @param playerTwo the player object containing information on player two, passed from name selection.
	 */
	public static void createArmySelectionView(Player playerOne, Player playerTwo)
	{
		gameView.createArmySelectionView(playerOne, playerTwo, gameState);
	}
	
	/**
	 * creates the match view when we have the required information from the army selection view.
	 */
	public static void createMatchView(Player playerOne, Player playerTwo, GameState gameStateEdit)
	{
		gameState = gameStateEdit;
		gameView.createMatchView(playerOne, playerTwo, gameStateEdit);
	}
    
}