package dragonspiretournament.PlayerDatabase;

import dragonspiretournament.PlayerDatabase.DragonDB;


public class PlayerEntry implements Comparable <PlayerEntry>{

	protected String playerName;
	protected int wins;
	protected int losses;
	protected int ties; 
	
	public PlayerEntry(String playerName, int wins, int losses, int ties){
		this.playerName = playerName;
		this.ties = ties;
		this.wins = wins;
		this.losses = losses; 
	}
	
	@Override
	public int compareTo(PlayerEntry arg0) {
		if (this.wins <= arg0.wins)
			return 1;
		else 
			return -1;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getTies() {
		return ties;
	}

	public void setTies(int ties) {
		this.ties = ties;
	}

	public int getWins() {
		return wins;
	}

	public void setWins(int wins) {
		this.wins = wins;
	}

	public int getLosses() {
		return losses;
	}

	public void setLosses(int losses) {
		this.losses = losses;
	}
	
	public String toString(){
		String retString = "";
		
		retString += this.getPlayerName() + " " 
		+this.getWins() + "/" 
		+this.getLosses() + "/" 
		+this.getTies() + " ";
		
		return retString; 
	}
	
	public static void main(String[] args) {
		DragonDB db = new DragonDB();
		
		db.add("P1", 1, 5, 1);
		db.add("P2", 22, 4, 33);
		db.add("P3", 33, 3, 333);
		db.add("P4", 44, 2, 4444);
		
		System.out.println(db.toString());
		
		db.write();
		
		DragonDB db2 = new DragonDB();
		
		db2.read(); 
		
		System.out.println(db2.toString());
		
		db2.Find("P2").setTies(999999);
		
		db2.write();
		
		DragonDB db3 = new DragonDB();
		
		db3.read();
		
		for (int ii = 0; ii < db3.get().size(); ii++){
			System.out.println(db3.get().get(ii).toString());
		}
		
		db3.sort();
		System.out.println();
		
		for (int ii = 0; ii < db3.get().size(); ii++){
			System.out.println(db3.get().get(ii).toString());
		}
		System.out.println();
		System.out.println(db3.Find("P1").getPlayerName() + "   @index: " + db3.findIndex("P1"));

	}

}
