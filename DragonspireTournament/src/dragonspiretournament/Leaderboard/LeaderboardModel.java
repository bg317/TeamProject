package dragonspiretournament.Leaderboard;

import java.util.ArrayList;
import dragonspiretournament.Leaderboard.LeaderboardController;
import dragonspiretournament.PlayerDatabase.PlayerEntry;

public class LeaderboardModel{
	
	private ArrayList<PlayerEntry> playerArray;
	
	public LeaderboardModel(){
		playerArray = LeaderboardController.getLeaderboardList();
	}
	
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
	
	public static void main(String[] args){
		LeaderboardModel info = new LeaderboardModel();
		System.out.println(info.toString());
	}

	public int size() {
		return playerArray.size();
	}

	public String getName(int i) {
		return playerArray.get(i).getPlayerName();
	}

	public String getStats(int i) {
		String result = "";
		result += playerArray.get(i).getWins() + "/" +
				    playerArray.get(i).getLosses() + "/" +
				    playerArray.get(i).getTies();
		return result;
	}

}