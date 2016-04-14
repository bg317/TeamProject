package dragonspiretournament.match;

import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.UIComponents.DragonButton;
import dragonspiretournament.title.TitleController;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class MatchView {
	
	private MatchModel matchModel;
		
	private JFrame matchFrame;
	private JPanel playerTwoArmy;
	private JPanel playerOneArmy;
	private JPanel currentDiceSelection;
	
	private JLabel lblPlayerTwo;
	private JLabel lblPlayerTwoDragons;
	private JLabel playerOneLastAction;
	private JLabel playerTwoLastAction;
	private JLabel lblAddDiceHere;
	
	private JProgressBar playerOneHP;
	private JProgressBar playerTwoHP;
	
	private DragonButton playerOneLastDragon;
	private DragonButton playerTwoLastDragon;
	
	private JButton btnConfirmSelection;
	private JButton btnRoll;
	
	
	public MatchView( Player playerOne, Player playerTwo ) {
		matchModel = new MatchModel( playerOne, playerTwo );

		matchFrame = new JFrame("DragonSpire Tournament");
		matchFrame.setSize(993, 661);
		matchFrame.getContentPane().setLayout(null);
		matchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		playerOneArmy = new JPanel();
		playerOneArmy.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerOneArmy.setBounds(36, 11, 121, 400);
		matchFrame.getContentPane().add(playerOneArmy);
		updateArmyPanel( playerOneArmy, matchModel.getPlayerOneArmy(), new DragonButton() );

		playerTwoArmy = new JPanel();
		playerTwoArmy.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerTwoArmy.setBounds(778, 111, 121, 400);
		matchFrame.getContentPane().add(playerTwoArmy);
		updateArmyPanel( playerTwoArmy, matchModel.getPlayerTwoArmy(), new DragonButton() );
		
		lblPlayerTwo = new JLabel("Player One ");
		lblPlayerTwo.setBounds(36, 422, 121, 40);
		matchFrame.getContentPane().add(lblPlayerTwo);
		
		lblPlayerTwoDragons = new JLabel("Player Two ");
		lblPlayerTwoDragons.setBounds(601, 48, 79, 40);
		matchFrame.getContentPane().add(lblPlayerTwoDragons);
		
		playerOneHP = new JProgressBar(0, 100);
		playerOneHP.setBounds(46, 467, 146, 14);
		matchFrame.getContentPane().add(playerOneHP);
		playerOneHP.setValue(50);
		
		playerTwoHP = new JProgressBar(0, 100);
		playerTwoHP.setBounds(677, 86, 146, 14);
		matchFrame.getContentPane().add(playerTwoHP);
		playerTwoHP.setValue(50);
		
		playerOneLastAction = new JLabel("No dragons rolled yet");
		playerOneLastAction.setBounds(226, 105, 243, 108);
		matchFrame.getContentPane().add(playerOneLastAction);
		
		playerTwoLastAction = new JLabel("No dragons rolled yet");
		playerTwoLastAction.setBounds(381, 220, 311, 108);		
		matchFrame.setVisible(true);
		matchFrame.getContentPane().add(playerTwoLastAction);
		
		playerOneLastDragon = new DragonButton("New button");
		playerOneLastDragon.setBounds(479, 99, 146, 108);
		matchFrame.getContentPane().add(playerOneLastDragon);
		
		playerTwoLastDragon = new DragonButton("New button");
		playerTwoLastDragon.setBounds(226, 220, 146, 108);
		matchFrame.getContentPane().add(playerTwoLastDragon);
		
		btnRoll = new JButton("Roll");
		btnRoll.setBounds(485, 442, 89, 23);
		matchFrame.getContentPane().add(btnRoll);
		btnRoll.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MatchController.diceRoll(matchModel);
				MatchController.clearDiceSelection(matchModel);
				updateViewForDiceRoll();
			}
		});
		btnRoll.setVisible(false);
		
		currentDiceSelection = new JPanel();
		currentDiceSelection.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		currentDiceSelection.setBounds(223, 492, 515, 93);
		matchFrame.getContentPane().add(currentDiceSelection);
		
		lblAddDiceHere = new JLabel("Add dice here by selecting from your library");
		lblAddDiceHere.setBounds(228, 467, 299, 14);
		matchFrame.getContentPane().add(lblAddDiceHere);
		
		btnConfirmSelection = new JButton("Confirm Selection");
		btnConfirmSelection.setBounds(417, 588, 157, 23);
		matchFrame.getContentPane().add(btnConfirmSelection);
		btnConfirmSelection.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//HARD CODED NEXT TWO LINES FOR TESTING DO REMOVE
				matchModel.getPlayerOne().setDice( matchModel.getCurrentDiceSelection() );
				matchModel.getPlayerTwo().setDice( matchModel.getCurrentDiceSelection() );
				btnConfirmSelection.setVisible(false);
				btnRoll.setVisible(true);
				hideDiceSelection();
				hidePlayersArmies();
			}
		});
		btnConfirmSelection.setVisible(true);
		
		matchFrame.repaint();
	}
	
	public void updateViewForDiceRoll() {
		updateLastDragon();
		updateLastPlayerOneAction();
		updateLastPlayerTwoAction();
		updatePlayersHealthBars();
		showPlayersArmies();
		showDiceSelection();
		btnConfirmSelection.setVisible(true);
		lblAddDiceHere.setVisible(true);
		btnRoll.setVisible(false);
	}
	
	public void hidePlayersArmies() {
		playerOneArmy.setVisible(false);
		playerTwoArmy.setVisible(false);
		playerOneArmy.updateUI();
		playerTwoArmy.updateUI();
	}
	
	public void showPlayersArmies() {
		playerOneArmy.setVisible(true);
		playerTwoArmy.setVisible(true);
		playerOneArmy.updateUI();
		playerTwoArmy.updateUI();
	}
	
	public void hideDiceSelection() {
		currentDiceSelection.setVisible(false);
		currentDiceSelection.removeAll();
		currentDiceSelection.updateUI();
	}
	
	public void showDiceSelection() {
		currentDiceSelection.setVisible(true);
		currentDiceSelection.removeAll();
		currentDiceSelection.updateUI();
	}
	
	public void rollDice() {
		MatchController.diceRoll( this.matchModel );
		updatePlayersHealthBars();
		updateLastPlayerOneAction();
		updateLastPlayerTwoAction();
	}
	
	public void updateArmyPanel( JPanel playersArmy, Army playerArmy, DragonButton dragBtn ) {
		
		ArrayList<Dragon> dragons = playerArmy.getArmy();
		Iterator<Dragon> dragonsItr = dragons.iterator();
		Dragon currentDrag;
		playersArmy.removeAll();
		
		while ( dragonsItr.hasNext() ) {
			currentDrag = dragonsItr.next();
			dragBtn = new DragonButton( currentDrag );
			dragBtn.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					DragonButton btnSelected = (DragonButton) e.getSource();
					MatchController.updateDragonToAdd( matchModel, new Dragon( btnSelected.getAssociatedDragon() ));
					MatchController.addToDiceSelection( matchModel, new Dragon( btnSelected.getAssociatedDragon() ) );
					updateDiceSelectionPanel( currentDiceSelection );
				}
			});
			playersArmy.add(dragBtn);
		}
		
		playersArmy.updateUI();	
	}
	
	public void updateDiceSelectionPanel( JPanel diceSelectionPanel ) { 
		
		Dice dragonFaces = this.matchModel.getCurrentDiceSelection();
		ArrayList<Dragon> dragons = dragonFaces.getDice();
		Iterator<Dragon> dragonsItr = dragons.iterator();
		DragonButton dragBtn;
		Dragon currentDrag;
		diceSelectionPanel.removeAll();
		
		while ( dragonsItr.hasNext() ) {
			currentDrag = dragonsItr.next();
			MatchController.updateDragonToDelete( this.matchModel, currentDrag );
			dragBtn = new DragonButton( currentDrag );
			diceSelectionPanel.add( dragBtn );
			dragBtn.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MatchController.removeFromDiceSelection( matchModel );
					updateDiceSelectionPanel( diceSelectionPanel );
				}
			});
		}
		
		diceSelectionPanel.updateUI();
		
	}
	
	public void updateLastDragon() {
		if ( matchModel.getPlayerOneLastDragon() != null ) {
			this.playerOneLastDragon.setAssociatedDragon( matchModel.getPlayerOneLastDragon() );
			this.playerOneLastDragon.updateUI();
		} 
		if ( matchModel.getPlayerTwoLastDragon() != null ) {
			this.playerTwoLastDragon.setAssociatedDragon( matchModel.getPlayerTwoLastDragon() );
			this.playerOneLastDragon.updateUI();
		}
	}
	
	public void updateLastPlayerOneAction() {
		this.playerOneLastAction.setText( matchModel.getPlayerOneLastAction() );
		this.playerOneLastAction.updateUI();
	}
	
	public void updateLastPlayerTwoAction() {
		this.playerTwoLastAction.setText( matchModel.getPlayerTwoLastAction() );
		this.playerOneLastAction.updateUI();
	}
	
	public void updatePlayersHealthBars() {
		int healthPlayerOne = matchModel.getPlayerOneHealth();
		int healthPlayerTwo = matchModel.getPlayerTwoHealth();
		
		this.playerOneHP.setValue( healthPlayerOne );
		this.playerTwoHP.setValue( healthPlayerTwo );
		
		playerOneHP.updateUI();
		playerTwoHP.updateUI();
	}
}
