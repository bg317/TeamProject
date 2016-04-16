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
import javax.swing.JOptionPane;
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

/**
 * The Class MatchView.
 */
public class MatchView {
	
	/** The match model. */
	private MatchModel matchModel;
		
	/** The match frame. */
	private JFrame matchFrame;
	
	/** The player two army. */
	private JPanel playerTwoArmy;
	
	/** The player one army. */
	private JPanel playerOneArmy;
	
	/** The current dice selection. */
	private JPanel currentDiceSelection;
	
	/** The lbl player two. */
	private JLabel lblPlayerTwo;
	
	/** The lbl player two dragons. */
	private JLabel lblPlayerTwoDragons;
	
	/** The player one last action. */
	private JLabel playerOneLastAction;
	
	/** The player two last action. */
	private JLabel playerTwoLastAction;
	
	/** The lbl add dice here. */
	private JLabel lblAddDiceHere;
	
	/** The player one hp. */
	private JProgressBar playerOneHP;
	
	/** The player two hp. */
	private JProgressBar playerTwoHP;
	
	/** The player one last dragon. */
	private DragonButton playerOneLastDragon;
	
	/** The player two last dragon. */
	private DragonButton playerTwoLastDragon;
	
	/** The btn confirm selection. */
	private JButton btnConfirmSelection;
	
	/** The btn roll. */
	private JButton btnRoll;
	
	/** The match over box. */
	private static JOptionPane matchOverBox;
	
	
	/**
	 * Instantiates a new match view.
	 *
	 * @param playerOne the player one
	 * @param playerTwo the player two
	 */
	public MatchView( Player playerOne, Player playerTwo ) {
		matchModel = new MatchModel( playerOne, playerTwo );

		matchFrame = new JFrame("DragonSpire Tournament");
		matchFrame.setSize(980, 700);
		matchFrame.getContentPane().setLayout(null);
		matchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		playerOneArmy = new JPanel();
		playerOneArmy.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerOneArmy.setBounds(41, 31, 54, 580);
		matchFrame.getContentPane().add(playerOneArmy);
		updateArmyPanel( playerOneArmy, matchModel.getPlayerOneArmy(), new DragonButton() );

		playerTwoArmy = new JPanel();
		playerTwoArmy.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		playerTwoArmy.setBounds(800, 31, 54, 580);
		matchFrame.getContentPane().add(playerTwoArmy);
		updateArmyPanel( playerTwoArmy, matchModel.getPlayerTwoArmy(), new DragonButton() );
		
		lblPlayerTwo = new JLabel( matchModel.getPlayerOne().getName() );
		lblPlayerTwo.setBounds(101, 492, 121, 40);
		matchFrame.getContentPane().add(lblPlayerTwo);
		
		lblPlayerTwoDragons = new JLabel( matchModel.getPlayerTwo().getName() );
		lblPlayerTwoDragons.setBounds(627, 48, 79, 40);
		matchFrame.getContentPane().add(lblPlayerTwoDragons);
		
		playerOneHP = new JProgressBar(0, 25); //25 is the max strongholdHP
		playerOneHP.setBounds(111, 537, 146, 14);
		matchFrame.getContentPane().add(playerOneHP);
		playerOneHP.setValue(50);
		
		playerTwoHP = new JProgressBar(0, 25); //25 is the max strongholdHP
		playerTwoHP.setBounds(637, 86, 146, 14);
		matchFrame.getContentPane().add(playerTwoHP);
		playerTwoHP.setValue(50);

		playerOneLastAction = new JLabel("No dragons rolled yet");
		playerOneLastAction.setBounds(296, 105, 243, 108);
		matchFrame.getContentPane().add(playerOneLastAction);

		playerTwoLastAction = new JLabel("No dragons rolled yet");
		playerTwoLastAction.setBounds(471, 220, 311, 108);		
		matchFrame.setVisible(true);
		matchFrame.getContentPane().add(playerTwoLastAction);
		
		playerOneLastDragon = new DragonButton("");
		playerOneLastDragon.setBounds(479, 99, 146, 108);
		matchFrame.getContentPane().add(playerOneLastDragon);
		
		playerTwoLastDragon = new DragonButton("");
		playerTwoLastDragon.setBounds(306, 220, 146, 108);
		matchFrame.getContentPane().add(playerTwoLastDragon);
		
		btnRoll = new JButton("Roll");
		btnRoll.setBounds(405, 442, 89, 23);
		matchFrame.getContentPane().add(btnRoll);
		btnRoll.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MatchController.diceRoll(matchModel);
				MatchController.clearDiceSelection(matchModel);
				updateViewForDiceRoll();
				checkIfMatchOver();
			}
		});
		btnRoll.setVisible(false);
		
		currentDiceSelection = new JPanel();
		currentDiceSelection.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		currentDiceSelection.setBounds(285, 492, 360, 54);
		matchFrame.getContentPane().add(currentDiceSelection);
		
		lblAddDiceHere = new JLabel("Add to dice here by selecting dragons from your army:");
		lblAddDiceHere.setBounds(289, 467, 320, 14);
		matchFrame.getContentPane().add(lblAddDiceHere);
		
		btnConfirmSelection = new JButton("Confirm Selection");
		btnConfirmSelection.setBounds(385, 554, 157, 23);
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
	
	/**
	 * Update view for dice roll.
	 */
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
	
	/**
	 * Hide players armies.
	 */
	public void hidePlayersArmies() {
		playerOneArmy.setVisible(false);
		playerTwoArmy.setVisible(false);
		playerOneArmy.updateUI();
		playerTwoArmy.updateUI();
	}
	
	/**
	 * Show players armies.
	 */
	public void showPlayersArmies() {
		playerOneArmy.setVisible(true);
		playerTwoArmy.setVisible(true);
		playerOneArmy.updateUI();
		playerTwoArmy.updateUI();
	}
	
	/**
	 * Hide dice selection.
	 */
	public void hideDiceSelection() {
		currentDiceSelection.setVisible(false);
		currentDiceSelection.removeAll();
		currentDiceSelection.updateUI();
	}
	
	/**
	 * Show dice selection.
	 */
	public void showDiceSelection() {
		currentDiceSelection.setVisible(true);
		currentDiceSelection.removeAll();
		currentDiceSelection.updateUI();
	}
	
	/**
	 * Roll dice.
	 */
	public void rollDice() {
		MatchController.diceRoll( this.matchModel );
		updatePlayersHealthBars();
		updateLastPlayerOneAction();
		updateLastPlayerTwoAction();
		System.out.println( matchModel.isMatchOver() );
	}
	
	/**
	 * Check if match is over.
	 */
	public void checkIfMatchOver() { 
//		System.out.println( matchModel.isMatchOver() + " is match over? "); //Used in testing
		if ( matchModel.isMatchOver() ) {
			if ( matchModel.isDraw() ) {
				JOptionPane.showMessageDialog( matchFrame, "Game has come to a draw!");
			} else {
				JOptionPane.showMessageDialog( matchFrame, "The player " + matchModel.getWinner().getName() + " has won the game!");
			}
		}
	}
	
	/**
	 * Update army panel.
	 *
	 * @param playersArmy the players army
	 * @param playerArmy the player army
	 * @param dragBtn the drag btn
	 */
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
	
	/**
	 * Update dice selection panel.
	 *
	 * @param diceSelectionPanel the dice selection panel
	 */
	public void updateDiceSelectionPanel( JPanel diceSelectionPanel ) { 
		
		Dice dragonFaces = this.matchModel.getCurrentDiceSelection();
		ArrayList<Dragon> dragons = dragonFaces.getDice();
		Iterator<Dragon> dragonsItr = dragons.iterator();
		DragonButton dragBtn;
		Dragon currentDrag;
		diceSelectionPanel.removeAll();

        currentDrag = dragonsItr.next();//Skips "Missed" Dragon
		
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
	
	/**
	 * Update last dragon.
	 */
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
	
	/**
	 * Update last player one action.
	 */
	public void updateLastPlayerOneAction() {
		this.playerOneLastAction.setText( matchModel.getPlayerOneLastAction() );
		this.playerOneLastAction.updateUI();
	}
	
	/**
	 * Update last player two action.
	 */
	public void updateLastPlayerTwoAction() {
		this.playerTwoLastAction.setText( matchModel.getPlayerTwoLastAction() );
		this.playerOneLastAction.updateUI();
	}
	
	/**
	 * Update players health bars.
	 */
	public void updatePlayersHealthBars() {
		int healthPlayerOne = matchModel.getPlayerOneHealth();
		int healthPlayerTwo = matchModel.getPlayerTwoHealth();
		
		this.playerOneHP.setValue( healthPlayerOne );
		this.playerTwoHP.setValue( healthPlayerTwo );
		
		playerOneHP.updateUI();
		playerTwoHP.updateUI();
	}
}
