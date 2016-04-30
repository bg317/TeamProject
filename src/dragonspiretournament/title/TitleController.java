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
		GameController.createNameSelectionView();
		GameController.changeView("nameView");
	}

	public static void goToLeaderboard() {
	    GameController.createLeaderboardView();
	    GameController.changeView("leaderboardView");
	}
	
	/**
	 * Gets the path to the start button.
	 * @return path to the start button.
	 */
	public static String getStartButton() {
		return "Art/UIGraphics/StartButton.png";
	}
	
	/**
	 * Gets the path to the leaderboard button.
	 * @return path to the leaderboard button.
	 */
	public static String getLeaderboardButton() {
		return "Art/UIGraphics/LeaderboardButton.png";
	}
	
	/**
	 * Gets the path to the logo image.
	 * @return path to the logo image.
	 */
	public static String getLogo() {
		return "Art/UIGraphics/Logo.png";
	}
}
