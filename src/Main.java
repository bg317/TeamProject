import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.armyselection.ArmySelectionView;

import dragonspiretournament.match.MatchView;
import dragonspiretournament.title.TitleView;

import java.io.FileNotFoundException;
/**
 * The Class Main.
 * This is the main run for the Game.
 */
public class Main {
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws FileNotFoundException the file not found exception
	 */
	public static void main(String[] args) throws FileNotFoundException {
		ArmySelectionView armySelectView = new ArmySelectionView();
		
		Army playerOneArmy = new Army();
		DragonLibrary dragLib = new DragonLibrary();
		System.out.println( dragLib.getDragon(1) );
		playerOneArmy.add( dragLib.getDragon(0));
		playerOneArmy.add( dragLib.getDragon(1));
		playerOneArmy.add( dragLib.getDragon(2));
		Player playerOne = new Player("Name", playerOneArmy);
		Player playerTwo = new Player("Name2", playerOneArmy);
		MatchView matchView = new MatchView( playerOne, playerTwo );
		
		TitleView titleView = new TitleView();
	}

}