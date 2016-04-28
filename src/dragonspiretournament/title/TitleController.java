package dragonspiretournament.title;

import dragonspiretournament.game.GameController;

// TODO: Auto-generated Javadoc
/**
 * The Class TitleController.
 */
public class TitleController {
	
	/**
	 * Do something.
	 */
	public static void doSomething() {
		System.out.println("Do Something");
		GameController.createNameSelectionView();
		GameController.changeView("nameView");
	}

	public static void goToLeaderboard() {
	    GameController.createLeaderboardView();
	    GameController.changeView("leaderboardView");
	}
}
