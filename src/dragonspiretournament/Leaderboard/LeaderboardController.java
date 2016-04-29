package dragonspiretournament.Leaderboard;

import java.util.ArrayList;

import dragonspiretournament.PlayerDatabase.DragonDB;
import dragonspiretournament.PlayerDatabase.PlayerEntry;
import dragonspiretournament.game.GameController;
/**
 * Controller for the leaderboard
 * @author Team 29(CD)
 */
public class LeaderboardController{
	
	/**
	 * getLeaderboardList-Method that reads the database for player information
	 * @return returns an ArrayList of all the players in the leaderboard
	 */
	public static ArrayList<PlayerEntry> getLeaderboardList(){
		DragonDB db = new DragonDB();
		
		db.read();
		db.sort();
		return db.get();
	}
	
	/**
	 * Method to change screen views
	 */
	public static void goToTitleView() {
	    GameController.changeView("titleView");
	}
}
