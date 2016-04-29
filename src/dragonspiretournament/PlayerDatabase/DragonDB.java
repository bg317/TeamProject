package dragonspiretournament.PlayerDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * Class to make the database for the leaderboard
 * @author Team 29 (LS)
 *
 */
public class DragonDB {
	
	public ArrayList<PlayerEntry> playerArray; 	
	
	public DragonDB(){
		playerArray = new ArrayList<PlayerEntry>();
	}
	
	/**
	 * read-Method to read the current database file and store it 
	 * in a DB object
	 */
	public void read(){
		try {
			Scanner inFile = new Scanner(new FileReader("DragonGame.dat")).useDelimiter(",");
			//	elArray[0] = new Element("ER0 Hydrogen",1,"H",1.00794,"FFFFFF"); //this one works.
		
			while (inFile.hasNextLine()){
				String tempstr = inFile.nextLine();
				Scanner s = new Scanner(tempstr).useDelimiter(",");
				PlayerEntry tempPlayer = new PlayerEntry(s.next(), s.nextInt(),s.nextInt(),s.nextInt());
			
				playerArray.add(tempPlayer);
			
			
				s.close();
			}
		
			
			inFile.close();
		} catch (FileNotFoundException e) {
			write();
			//JOptionPane.showMessageDialog( null, "DragonGame.dat is not a valid filename. prepare for failure");
			//e.printStackTrace();
		}
	}
	
	/**
	 * write-Method to write from the DragonDB object to the 
	 * database file
	 */
	public void write(){
		File f = new File("DragonGame.dat");
		if(!(f.exists() && !f.isDirectory())) { 
	    // do something
		}
		try (PrintWriter writer = new PrintWriter("DragonGame.dat", "UTF-8");) {
			for(int ii = 0; ii < playerArray.size(); ii++){
				String s = playerArray.get(ii).getPlayerName() + ",";
				s += playerArray.get(ii).getWins()+ ",";
				s += playerArray.get(ii).getLosses()+ ",";
				s += playerArray.get(ii).getTies();
		
				writer.println(s);		
			}	
		} catch (IOException x) {
			System.err.format("IOException: %s%n", x);
		}
	}
	
	/**
	 * exists-Method to find if a player's name exists in the database
	 * @param findMe String of the name of the player you are trying to 
	 * 				find in the database
	 * @return boolean if the player's name is in the database or not
	 */
	public boolean exists(String findMe){
		boolean ret = false;
	
		for(int ii = 0; ii < playerArray.size(); ii++){
			if (playerArray.get(ii).getPlayerName().equals(findMe) )
				ret = true;
		}
	
		return ret; 
	}

	/**
	 * Find-Method to get the player information from the database for
	 * 				a give player's name
	 * @param findMe String of the name of the player you want to access 
	 * 				the information for
	 * @return PlayerEntry with the information of the player's name
	 * 				that was searched for
	 */
	public PlayerEntry Find(String findMe){
		PlayerEntry ret = null;
	
		if (exists(findMe))
			for(int ii = 0; ii < playerArray.size(); ii++){
				if (playerArray.get(ii).getPlayerName().equals(findMe) )
					ret = playerArray.get(ii);
			}
	
		return ret;
		
	}
	
	/**
	 * findIndex-Method to find the index in the playerArray for a given name
	 * @param findMe String of name of the player you are trying to find
	 * @return int of the index where given name is 
	 */
	public int findIndex(String findMe){
		int ret = -1;
	
		if (exists(findMe))
			for(int ii = 0; ii < playerArray.size(); ii++){
				if (playerArray.get(ii).getPlayerName().equals(findMe) )
					ret = ii;
			}
	
		return ret;
	
	}

	/**
	 * get-Method that is an accessor for the playerArray data member
	 * @return ArrayList<PlayerEntry> 
	 */
	public ArrayList<PlayerEntry> get(){
		return playerArray;
	}
	
	/**
	 * add-Method to add a player's info into the array of players
	 * @param playerName String player name
	 * @param wins int how many wins the player has
	 * @param losses int how many losses the player has
	 * @param ties int how many ties the player has
	 */
	public void add(String playerName, int wins, int losses, int ties){
		playerArray.add(new PlayerEntry(playerName, wins, losses, ties));	
	}
	
	/**
	 * sort-Method to sort the array of PlayerEntries by how many wins 
	 * 			a player has
	 */
	public void sort(){
		Collections.sort(playerArray); 
	}
	
	/**
	 * toString-Method to print the entire playerArray out
	 */
	public String toString(){
		String retString = "";
		for (int ii = 0; ii < playerArray.size(); ii++)
			retString += playerArray.get(ii).toString() + "\n"; 
		return retString;
	}


}