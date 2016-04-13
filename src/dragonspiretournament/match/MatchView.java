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
	private JPanel playerOneDragons;
	private JPanel playerTwoDragons;
	private JPanel playerTwoArmy;
	private JPanel playerOneArmy;
	private JPanel currentDiceSelection;
	
	private JLabel lblPlayerTwo;
	private JLabel lblPlayerTwoDragons;
	private JLabel playerOneLastAction;
	private JLabel playerTwoLastAction;
	
	private JProgressBar playerOneHP;
	private JProgressBar playerTwoHP;
	
	private DragonButton playerOneLastDragon;
	private DragonButton playerTwoLastDragon;
	private JButton btnConfirmSelection;
	
	
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
		
		playerOneHP = new JProgressBar();
		playerOneHP.setBounds(46, 467, 146, 14);
		matchFrame.getContentPane().add(playerOneHP);
		
		playerTwoHP = new JProgressBar();
		playerTwoHP.setBounds(677, 86, 146, 14);
		matchFrame.getContentPane().add(playerTwoHP);
		
		playerOneLastAction = new JLabel("No dragons rolled yet");
		playerOneLastAction.setBounds(226, 105, 146, 108);
		matchFrame.getContentPane().add(playerOneLastAction);
		
		playerTwoLastAction = new JLabel("No dragons rolled yet");
		playerTwoLastAction.setBounds(381, 220, 146, 108);		
		matchFrame.setVisible(true);
		matchFrame.getContentPane().add(playerTwoLastAction);
		
		playerOneLastDragon = new DragonButton("New button");
		playerOneLastDragon.setBounds(381, 105, 146, 108);
		matchFrame.getContentPane().add(playerOneLastDragon);
		
		playerTwoLastDragon = new DragonButton("New button");
		playerTwoLastDragon.setBounds(226, 220, 146, 108);
		matchFrame.getContentPane().add(playerTwoLastDragon);
		
		JButton btnRoll = new JButton("Roll");
		btnRoll.setBounds(485, 442, 89, 23);
		matchFrame.getContentPane().add(btnRoll);
		
		currentDiceSelection = new JPanel();
		currentDiceSelection.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		currentDiceSelection.setBounds(223, 492, 515, 93);
		matchFrame.getContentPane().add(currentDiceSelection);
		
		JLabel lblAddDiceHere = new JLabel("Add dice here by selecting from your library");
		lblAddDiceHere.setBounds(228, 467, 299, 14);
		matchFrame.getContentPane().add(lblAddDiceHere);
		
		btnConfirmSelection = new JButton("Confirm Selection");
		btnConfirmSelection.setBounds(417, 588, 157, 23);
		matchFrame.getContentPane().add(btnConfirmSelection);
		btnRoll.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MatchController.setPlayerOneDice( matchModel );
				MatchController.setPlayerTwoDice( matchModel );
			}
		});
		
		
		
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
					MatchController.updateDragonToAdd(matchModel, btnSelected.getAssociatedDragon());
					MatchController.addToDiceSelection( matchModel );
					updateDiceSelectionPanel( currentDiceSelection );
				}
			});
			playersArmy.add(dragBtn);
		}
		
		playersArmy.updateUI();	
	}
	
	public void updateDiceSelectionPanel( JPanel diceSelectionPanel ) { 
		
		Dice dragonFaces = matchModel.getCurrentDiceSelection();
		ArrayList<Dragon> dragons = dragonFaces.getDice();
		Iterator<Dragon> dragonsItr = dragons.iterator();
		DragonButton dragBtn;
		Dragon currentDrag;
		diceSelectionPanel.removeAll();
		
		while ( dragonsItr.hasNext() ) {
			currentDrag = dragonsItr.next();
			MatchController.updateDragonToDelete( matchModel, currentDrag );
			dragBtn = new DragonButton( currentDrag );
			diceSelectionPanel.add( dragBtn );
			dragBtn.addActionListener( new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					MatchController.removeFromDiceSelection( matchModel );
				}
			});
		}
		
		diceSelectionPanel.updateUI();
		
	}
	
	public void updateLastDragon() {
		if ( matchModel.getPlayerOneLastDragon() != null ) {
			playerOneLastDragon.setAssociatedDragon( matchModel.getPlayerOneLastDragon() );
			playerOneLastDragon.updateUI();
		} 
		if ( matchModel.getPlayerTwoLastDragon() != null ) {
			playerTwoLastDragon.setAssociatedDragon( matchModel.getPlayerTwoLastDragon() );
			playerOneLastDragon.updateUI();
		}
	}
	
	public void updateLastPlayerOneAction() {
		playerOneLastAction.setText( matchModel.getPlayerOneLastAction() );
		playerOneLastAction.updateUI();
	}
	
	public void updateLastPlayerTwoAction() {
		playerTwoLastAction.setText( matchModel.getPlayerTwoLastAction() );
		playerOneLastAction.updateUI();
	}
}
