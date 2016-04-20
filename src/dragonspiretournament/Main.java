package dragonspiretournament;

import dragonspiretournament.Game.GameState;
import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.armyselection.ArmySelectionController;
import dragonspiretournament.armyselection.ArmySelectionModel;
import dragonspiretournament.armyselection.ArmySelectionView;
import dragonspiretournament.match.MatchView;
import dragonspiretournament.nameselection.NameSelectionView;
import dragonspiretournament.title.TitleView;
import dragonspiretournament.PlayerInformation.DragonInformationView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import javax.swing.JButton;
import javax.swing.JFrame;

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
		
		GameState gameState = new GameState();
		
		Player playerOne = new Player(" Player One ");
		Player playerTwo = new Player(" Player Two ");

		
		ArmySelectionView armySelectViewOne;
		ArmySelectionView armySelectViewTwo;
		
		/*NameSelectionView nameView = new NameSelectionView( playerOne, playerTwo ); */
		gameState.setPlayerOneArmySelection( true );
		armySelectViewOne = new ArmySelectionView( playerOne, playerTwo, gameState ); 
		
		Army playerOneArmy = new Army();
		DragonLibrary dragLib = new DragonLibrary();
		playerOneArmy.add( dragLib.getDragon(0));
		playerOneArmy.add( dragLib.getDragon(1));
		playerOneArmy.add( dragLib.getDragon(2));
		
		//MatchView matchView = new MatchView( playerOne, playerTwo );
		
		/*
		TitleView titleView = new TitleView();
		DragonInformationView infoView = new DragonInformationView(dragLib.getDragon(3)); */
	}

}