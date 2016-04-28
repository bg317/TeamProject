package dragonspiretournament.Leaderboard;

import java.util.ArrayList;

import dragonspiretournament.PlayerDatabase.DragonDB;
import dragonspiretournament.PlayerDatabase.PlayerEntry;

public class LeaderboardController{
	
	public static ArrayList<PlayerEntry> getLeaderboardList(){
		DragonDB db = new DragonDB();
		
		db.read();
		db.sort();
		return db.get();
	}
	
}
