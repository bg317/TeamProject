package dragonspiretournament.Leaderboard;

import java.util.ArrayList;
import dragonspiretournament.Leaderboard.LeaderboardController;
import dragonspiretournament.PlayerDatabase.PlayerEntry;

/**
 * This is the leaderboard model which holds the information 
 * for the leaderboard
 * @author Team 29(CD)
 *
 */
public class LeaderboardModel{
	
	private ArrayList<PlayerEntry> playerArray;
	
	/**
	 * Default constructor that grabs the player database
	 */
	public LeaderboardModel(){
		playerArray = LeaderboardController.getLeaderboardList();
	}
	
	/**
	 * toString- Method that can print out the entire player database
	 */
	public String toString(){
		String result = "";
		for(int i = 0; i < playerArray.size(); i++){
			result += i + 1 + "\t" +
					    playerArray.get(i).getPlayerName() + "\t\t" +
					    playerArray.get(i).getWins() + "/" +
					    playerArray.get(i).getLosses() + "/" +
					    playerArray.get(i).getTies() + "\n";
		}
		return result;
	}
	
	/**
	 * size-Method that returns the size of the player database
	 * 
	 * @return int that is the number of players in the leaderboard
	 */
	public int size() {
		return playerArray.size();
	}
	
	/**
	 * getName-Method that returns the name of a player in the database
	 * @param i index that you want the name from
	 * @return name of the player at index i
	 */
	public String getName(int i) {
		return playerArray.get(i).getPlayerName();
	}
	
	/**
	 * getStats-Method to get the stats from the player at index i
	 * @param i index that you want the stats from
	 * @return returns a string with win/loss/ties
	 */
	public String getStats(int i) {
		String result = "";
		result += playerArray.get(i).getWins() + "/" +
				    playerArray.get(i).getLosses() + "/" +
				    playerArray.get(i).getTies();
		return result;
	}

}