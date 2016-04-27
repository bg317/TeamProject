package dragonspiretournament.PlayerDatabase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class DragonDB {
	
	public ArrayList<PlayerEntry> playerArray; 	
	
	public DragonDB(){
		playerArray = new ArrayList<PlayerEntry>();
	}

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
			JOptionPane.showMessageDialog( null, "DragonGame.dat is not a valid filename. prepare for failure");
			e.printStackTrace();
		}
	}

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

	public boolean exists(String findMe){
		boolean ret = false;
	
		for(int ii = 0; ii < playerArray.size(); ii++){
			if (playerArray.get(ii).getPlayerName().equals(findMe) )
				ret = true;
		}
	
		return ret; 
	}

	public PlayerEntry Find(String findMe){
		PlayerEntry ret = null;
	
		if (exists(findMe))
			for(int ii = 0; ii < playerArray.size(); ii++){
				if (playerArray.get(ii).getPlayerName().equals(findMe) )
					ret = playerArray.get(ii);
			}
	
		return ret;
		
	}

	public int findIndex(String findMe){
		int ret = -1;
	
		if (exists(findMe))
			for(int ii = 0; ii < playerArray.size(); ii++){
				if (playerArray.get(ii).getPlayerName().equals(findMe) )
					ret = ii;
			}
	
		return ret;
	
	}

	public ArrayList<PlayerEntry> get(){
		return playerArray;
	}
	
	public void add(String playerName, int wins, int losses, int ties){
		playerArray.add(new PlayerEntry(playerName, wins, losses, ties));	
	}

	public void sort(){
		Collections.sort(playerArray); 
	}
	public String toString(){
		String retString = "";
		for (int ii = 0; ii < playerArray.size(); ii++)
			retString += playerArray.get(ii).toString() + "\n"; 
		return retString;
	}


}