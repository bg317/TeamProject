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

import dragonspiretournament.game.GameController;
import dragonspiretournament.game.GameState;
import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.UIComponents.DragonButton;
import dragonspiretournament.PlayerInformation.DragonInformationView;
import dragonspiretournament.title.TitleController;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import java.awt.Color;

/**
 * The Class MatchView.
 */
public class MatchView extends JPanel {
	
	/** The match model. */
	private MatchModel matchModel;
		
	/** The match frame. */
	private JPanel matchFrame;
	
	/** The player two army. */
	private JPanel playerTwoArmyUnclickable;
	
	/** The player one army. */
	private JPanel playerOneArmy;
    
    /** The player two army. */
    private JPanel playerOneArmyUnclickable;
    
    /** The player one army. */
    private JPanel playerTwoArmy;
	
	/** The current dice selection for player one. */
	private JPanel PlayerOneDiceSelection;
	
    /** The current dice selection for player two. */
    private JPanel PlayerTwoDiceSelection;
    
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
	private JButton btnConfirmSelectionPlayerOne;
    
    /** The btn confirm selection. */
    private JButton btnConfirmSelectionPlayerTwo;
	
	/** The btn roll. */
	private JButton btnRoll;
	
	
	/**
	 * Instantiates a new match view.
	 *
	 * @param playerOne the player one
	 * @param playerTwo the player two
	 */
	public MatchView( Player playerOne, Player playerTwo) {
		matchModel = new MatchModel( playerOne, playerTwo );

		//matchFrame = new JFrame("DragonSpire Tournament");
		//matchFrame.setSize(980, 700);
		//matchFrame.getContentPane().setLayout(null);
		//matchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		matchFrame = new JPanel();
		matchFrame.setPreferredSize(new Dimension(980, 700));
		matchFrame.setLayout(null);
		
		this.setPreferredSize(new Dimension(980, 700));
		//this.setLayout(new GridLayout(1,1));
		
		
        
        playerOneArmy = new JPanel();
        playerOneArmy.setBorder(new LineBorder(new Color(255, 0, 0), 2));
        playerOneArmy.setBounds(74, 31, 54, 580);
        matchFrame.add(playerOneArmy);
        updateArmyPanelOne( playerOneArmy, matchModel.getPlayerOneArmy(), new DragonButton() );

        playerTwoArmyUnclickable = new JPanel();
        playerTwoArmyUnclickable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        playerTwoArmyUnclickable.setBounds(835, 31, 54, 580);
        matchFrame.add(playerTwoArmyUnclickable);
        updateArmyPanelOther( playerTwoArmyUnclickable, matchModel.getPlayerTwoArmy(), new DragonButton() );
        
        playerTwoArmy = new JPanel();
        playerTwoArmy.setBorder(new LineBorder(new Color(255, 0, 0), 2));
        playerTwoArmy.setBounds(835, 31, 54, 580);
        matchFrame.add(playerTwoArmy);
        updateArmyPanelTwo( playerTwoArmy, matchModel.getPlayerTwoArmy(), new DragonButton() );
        playerTwoArmy.setVisible(false);

        playerOneArmyUnclickable = new JPanel();
        playerOneArmyUnclickable.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        playerOneArmyUnclickable.setBounds(74, 31, 54, 580);
        matchFrame.add(playerOneArmyUnclickable);
        updateArmyPanelOther( playerOneArmyUnclickable, matchModel.getPlayerOneArmy(), new DragonButton() );
        playerOneArmyUnclickable.setVisible(false);
		
		lblPlayerTwo = new JLabel( matchModel.getPlayerOne().getName() );
		lblPlayerTwo.setBounds(140, 492, 121, 40);
		matchFrame.add(lblPlayerTwo);
		
		lblPlayerTwoDragons = new JLabel( matchModel.getPlayerTwo().getName() );
		lblPlayerTwoDragons.setBounds(662, 48, 79, 40);
		matchFrame.add(lblPlayerTwoDragons);
		
		playerOneHP = new JProgressBar(0, 25); //25 is the max strongholdHP
		playerOneHP.setBounds(146, 537, 146, 14);
		matchFrame.add(playerOneHP);
		playerOneHP.setValue(50);
		
		playerTwoHP = new JProgressBar(0, 25); //25 is the max strongholdHP
		playerTwoHP.setBounds(672, 86, 146, 14);
		matchFrame.add(playerTwoHP);
		playerTwoHP.setValue(50);

		playerOneLastAction = new JLabel("No dragons rolled yet");
		playerOneLastAction.setBounds(306, 105, 243, 108);
		matchFrame.add(playerOneLastAction);

		playerTwoLastAction = new JLabel("No dragons rolled yet");
		playerTwoLastAction.setBounds(509, 220, 311, 108);		
		matchFrame.setVisible(true);
		matchFrame.add(playerTwoLastAction);
		
		playerOneLastDragon = new DragonButton(new Dragon("Missed", 0, 0, "none", "none", "src/dragons/icons/Missed.png", "src/dragons/descr/Missed.txt"));
		playerOneLastDragon.setBounds(506, 99, 146, 108);
		matchFrame.add(playerOneLastDragon);
		playerOneLastDragon.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DragonButton actionPerfomedOn = (DragonButton) arg0.getSource();
				Dragon dragonToDisplay = actionPerfomedOn.getAssociatedDragon();
				DragonInformationView dragonInformation = new DragonInformationView( dragonToDisplay );
			}
			
		});
		
		playerTwoLastDragon = new DragonButton(new Dragon("Missed", 0, 0, "none", "none", "src/dragons/icons/Missed.png", "src/dragons/descr/Missed.txt"));
		playerTwoLastDragon.setBounds(301, 220, 146, 108);
		matchFrame.add(playerTwoLastDragon);
		playerTwoLastDragon.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DragonButton actionPerfomedOn = (DragonButton) arg0.getSource();
				Dragon dragonToDisplay = actionPerfomedOn.getAssociatedDragon();
				DragonInformationView dragonInformation = new DragonInformationView( dragonToDisplay );
			}
			
		});
		
		btnRoll = new JButton("Roll");
		btnRoll.setBounds(440, 442, 89, 23);
		matchFrame.add(btnRoll);
		btnRoll.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MatchController.diceRoll(matchModel);
				MatchController.clearDiceSelection(matchModel);
				updateViewForDiceRoll();
				checkIfMatchOver();
                showDiceSelectionOne();
                showPlayerOneArmies();
                if ( !matchModel.isMatchOver() )
                	JOptionPane.showMessageDialog( matchFrame, "It is " + playerOne.getName() + "'s turn now!");
			}
		});
		btnRoll.setVisible(false);
		
        PlayerOneDiceSelection = new JPanel();
        PlayerOneDiceSelection.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        PlayerOneDiceSelection.setBounds(320, 492, 360, 54);
        matchFrame.add(PlayerOneDiceSelection);
        
        PlayerTwoDiceSelection = new JPanel();
        PlayerTwoDiceSelection.setBorder(new LineBorder(new Color(0, 0, 0), 2));
        PlayerTwoDiceSelection.setBounds(320, 492, 360, 54);
        matchFrame.add(PlayerTwoDiceSelection);
        
		lblAddDiceHere = new JLabel("Add to dice here by selecting dragons from your army:");
		lblAddDiceHere.setBounds(324, 467, 320, 14);
		matchFrame.add(lblAddDiceHere);
		
        btnConfirmSelectionPlayerOne = new JButton("Confirm Selection");
        btnConfirmSelectionPlayerOne.setBounds(420, 554, 157, 23);
        matchFrame.add(btnConfirmSelectionPlayerOne);
        btnConfirmSelectionPlayerOne.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matchModel.getPlayerOne().setDice( matchModel.getPlayerOneDiceSelection() );
                btnConfirmSelectionPlayerOne.setVisible(false);
                btnConfirmSelectionPlayerTwo.setVisible(true);
                hidePlayerOneArmies();
                showPlayerTwoArmies();
                hideDiceSelectionOne();
                showDiceSelectionTwo();
                if ( !matchModel.isMatchOver() )
                	JOptionPane.showMessageDialog( matchFrame, "It is " + playerTwo.getName() + "'s turn now!");
            }
        });
        btnConfirmSelectionPlayerOne.setVisible(true);
        
        btnConfirmSelectionPlayerTwo = new JButton("Confirm Selection");
        btnConfirmSelectionPlayerTwo.setBounds(420, 554, 157, 23);
        matchFrame.add(btnConfirmSelectionPlayerTwo);
        btnConfirmSelectionPlayerTwo.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                matchModel.getPlayerTwo().setDice( matchModel.getPlayerTwoDiceSelection() );
                btnConfirmSelectionPlayerTwo.setVisible(false);
                btnRoll.setVisible(true);
                hidePlayerTwoArmies();
                hideDiceSelectionTwo();
            }
        });
        btnConfirmSelectionPlayerTwo.setVisible(false);
        
		
		this.add(matchFrame);
		
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
		showPlayerOneArmies();
		showDiceSelectionOne();
		btnConfirmSelectionPlayerOne.setVisible(true);
		lblAddDiceHere.setVisible(true);
		btnRoll.setVisible(false);
	}
	
    /**
     * Hide player one armies.
     */
    public void hidePlayerOneArmies() {
        playerOneArmy.setVisible(false);
        playerTwoArmyUnclickable.setVisible(false);
        playerOneArmy.updateUI();
        playerTwoArmyUnclickable.updateUI();
    }

    /**
     * Hide player two armies.
     */
    public void hidePlayerTwoArmies() {
        playerTwoArmy.setVisible(false);
        playerOneArmyUnclickable.setVisible(false);
        playerTwoArmy.updateUI();
        playerOneArmyUnclickable.updateUI();
    }
    
    /**
     * Show player one armies.
     */
    public void showPlayerOneArmies() {
        playerOneArmy.setVisible(true);
        playerTwoArmyUnclickable.setVisible(true);
        playerOneArmy.updateUI();
        playerTwoArmyUnclickable.updateUI();
    }
    
    /**
     * Show player two armies.
     */
    public void showPlayerTwoArmies() {
        playerTwoArmy.setVisible(true);
        playerOneArmyUnclickable.setVisible(true);
        playerTwoArmy.updateUI();
        playerOneArmyUnclickable.updateUI();
    }

    /**
     * Clear dice selection.
     */
    public void clearDiceSelection() {
        MatchController.clearDiceSelection(matchModel);
        PlayerOneDiceSelection.removeAll();
        PlayerTwoDiceSelection.removeAll();
        PlayerOneDiceSelection.updateUI();
        PlayerTwoDiceSelection.updateUI();
    }

    /**
     * Hide dice selection for player one.
     */
    public void hideDiceSelectionOne() {
        PlayerOneDiceSelection.setVisible(false);
        PlayerOneDiceSelection.removeAll();
        PlayerOneDiceSelection.updateUI();
    }
    
    /**
     * Hide dice selection for player two.
     */
    public void hideDiceSelectionTwo() {
        PlayerTwoDiceSelection.setVisible(false);
        PlayerTwoDiceSelection.removeAll();
        PlayerTwoDiceSelection.updateUI();
    }
    
    /**
     * Show dice selection for player one.
     */
    public void showDiceSelectionOne() {
        PlayerOneDiceSelection.setVisible(true);
        PlayerOneDiceSelection.removeAll();
        PlayerOneDiceSelection.updateUI();
    }
    
    /**
     * Show dice selection for player one.
     */
    public void showDiceSelectionTwo() {
        PlayerTwoDiceSelection.setVisible(true);
        PlayerTwoDiceSelection.removeAll();
        PlayerTwoDiceSelection.updateUI();
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
				GameController.changeView("titleView");
			} else {
				JOptionPane.showMessageDialog( matchFrame, "The player " + matchModel.getWinner().getName() + " has won the game!");
                GameController.changeView("titleView");
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
    public void updateArmyPanelOne( JPanel playersArmy, Army playerArmy, DragonButton dragBtn ) {
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
                    MatchController.addToDiceSelectionOne( matchModel, new Dragon( btnSelected.getAssociatedDragon() ) );
                    updateDiceSelectionPanelOne( PlayerOneDiceSelection );
                }
            });
            playersArmy.add(dragBtn);
        }
        
        playersArmy.updateUI(); 
    }

    /**
     * Update army panel.
     *
     * @param playersArmy the players army
     * @param playerArmy the player army
     * @param dragBtn the drag btn
     */

    public void updateArmyPanelTwo( JPanel playersArmy, Army playerArmy, DragonButton dragBtn ) {
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
                    MatchController.addToDiceSelectionTwo( matchModel, new Dragon( btnSelected.getAssociatedDragon() ) );
                    updateDiceSelectionPanelTwo( PlayerTwoDiceSelection );
                }
            });
            playersArmy.add(dragBtn);
        }
        
        playersArmy.updateUI(); 
    }

    /**
     * Update army panel for the other player
     *
     * @param playersArmy the players army
     * @param playerArmy the player army
     * @param dragBtn the drag btn
     */
    public void updateArmyPanelOther( JPanel playersArmy, Army playerArmy, DragonButton dragBtn ) {
        ArrayList<Dragon> dragons = playerArmy.getArmy();
        Iterator<Dragon> dragonsItr = dragons.iterator();
        
        Dragon currentDrag;
        playersArmy.removeAll();
        
        while ( dragonsItr.hasNext() ) {
            currentDrag = dragonsItr.next();
            dragBtn = new DragonButton( currentDrag );
            playersArmy.add(dragBtn);
        }
        
        playersArmy.updateUI(); 
    }
    

    /**
     * Update dice selection panel for player one.
     *
     * @param diceSelectionPanel the dice selection panel
     */
    public void updateDiceSelectionPanelOne( JPanel diceSelectionPanel ) { 
        
        Dice dragonFaces = this.matchModel.getPlayerOneDiceSelection();
        ArrayList<Dragon> dragons = dragonFaces.getDice();
        Iterator<Dragon> dragonsItr = dragons.iterator();
        DragonButton dragBtn;
        Dragon currentDrag;
        diceSelectionPanel.removeAll();

        currentDrag = dragonsItr.next(); //Skips "Missed" Dragon
        
        while ( dragonsItr.hasNext() ) {
            currentDrag = dragonsItr.next();
            MatchController.updateDragonToDelete( this.matchModel, currentDrag );
            dragBtn = new DragonButton( currentDrag );
            diceSelectionPanel.add( dragBtn );
            dragBtn.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MatchController.removeFromDiceSelectionOne( matchModel );
                    updateDiceSelectionPanelOne( diceSelectionPanel );
                }
            });
        }
        
        diceSelectionPanel.updateUI();
        
    }
    
    /**
     * Update dice selection panel for player two.
     *
     * @param diceSelectionPanel the dice selection panel
     */
    public void updateDiceSelectionPanelTwo( JPanel diceSelectionPanel ) { 
        
        Dice dragonFaces = this.matchModel.getPlayerTwoDiceSelection();
        ArrayList<Dragon> dragons = dragonFaces.getDice();
        Iterator<Dragon> dragonsItr = dragons.iterator();
        DragonButton dragBtn;
        Dragon currentDrag;
        diceSelectionPanel.removeAll();

        currentDrag = dragonsItr.next(); //Skips "Missed" Dragon
        
        while ( dragonsItr.hasNext() ) {
            currentDrag = dragonsItr.next();
            MatchController.updateDragonToDelete( this.matchModel, currentDrag );
            dragBtn = new DragonButton( currentDrag );
            diceSelectionPanel.add( dragBtn );
            dragBtn.addActionListener( new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    MatchController.removeFromDiceSelectionTwo( matchModel );
                    updateDiceSelectionPanelTwo( diceSelectionPanel );
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
