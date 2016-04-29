package dragonspiretournament.PlayerDatabase;

import dragonspiretournament.PlayerDatabase.DragonDB;

/**
 * Class that makes up the entries in the database
 * @author Team 29(LS)
 *
 */
public class PlayerEntry implements Comparable <PlayerEntry>{

	protected String playerName;
	protected int wins;
	protected int losses;
	protected int ties; 
	
	/**
	 * PlayerEntry-Constructor for PlayerEntry
	 * @param playerName String name of player
	 * @param wins int number of wins for player
	 * @param losses int number of losses for player
	 * @param ties int number of ties for player
	 */
	public PlayerEntry(String playerName, int wins, int losses, int ties){
		this.playerName = playerName;
		this.ties = ties;
		this.wins = wins;
		this.losses = losses; 
	}
	
	/**
	 * compareTo-Method that overrides comparable's compareTo
	 */
	@Override
	public int compareTo(PlayerEntry arg0) {
		if (this.wins <= arg0.wins)
			return 1;
		else 
			return -1;
	}
	
	/**
	 * getPlayerName-Accessor for playerName
	 * @return String of player's name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * setPlayerName-Setter for playerName
	 * @param playerName String player's name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * getTies-Accessor for ties
	 * @return int number of ties for player
	 */
	public int getTies() {
		return ties;
	}

	/**
	 * setTies-Setter for ties
	 * @param ties int number of ties for player
	 */
	public void setTies(int ties) {
		this.ties = ties;
	}

	/**
	 * getWins-Accessor for wins
	 * @return int number of wins for player
	 */
	public int getWins() {
		return wins;
	}

	/**
	 * setWins-Setter for wins
	 * @param wins int number of wins for player
	 */
	public void setWins(int wins) {
		this.wins = wins;
	}

	/**
	 * getLosses-Accessor for losses
	 * @return int number of losses for player
	 */
	public int getLosses() {
		return losses;
	}

	/**
	 * setLosses-Setter for losses
	 * @param losses int number of losses for player
	 */
	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	/**
	 * toString-Method to print PlayerEntry as a string
	 */
	public String toString(){
		String retString = "";
		
		retString += this.getPlayerName() + " " 
		+this.getWins() + "/" 
		+this.getLosses() + "/" 
		+this.getTies() + " ";
		
		return retString; 
	}

}
