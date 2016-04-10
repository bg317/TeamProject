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
		MatchView matchView = new MatchView();
		TitleView titleView = new TitleView();
	}

}