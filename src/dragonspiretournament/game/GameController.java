package dragonspiretournament.game;

import javax.swing.ImageIcon;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.game.GameView;

/**
 * The Class GameController.
 */
public class GameController {
	
	/**
	 * a gameview.
	 */
	private static GameView gameView;
	

	/**
	 * used with main to initialize the game view
	 */
	public static void createGame()
	{
		gameView = new GameView();
	}
	
	/**
	 * Calls the game view's change view, which changes which view is shown.
	 * @param viewToShow the string of the view to show.
	 */
	public static void changeView(String viewToShow)
	{
		gameView.changeView(viewToShow);
	}
    
}