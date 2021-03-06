package dragonspiretournament.armyselection;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dragonspiretournament.game.GameState;
import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.UIComponents.DragonButton;
import dragonspiretournament.GameObjects.UIComponents.ImageButton;
import dragonspiretournament.PlayerInformation.DragonInformation;
import dragonspiretournament.PlayerInformation.DragonInformationView;
import dragonspiretournament.match.MatchView;
import dragonspiretournament.game.GameController;

import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JLabel;

/**
 * The Class ArmySelectionView.
 */
public class ArmySelectionView extends JPanel {
	
	/** The army selection window. */
	JPanel armySelectionWindow;
	
	/** The selection model. */
	ArmySelectionModel selectionModel;
	
	/** The main panel. */
	JPanel mainPanel;
	
	/** The prev window. */
	JPanel prevWindow;
	
	/** The curr window. */
	JPanel currWindow;
	
	/** The next window. */
	JPanel nextWindow;
	
	/** The current army selection. */
	JPanel currentArmySelection;
	
	/** The select dragon btn. */
	JButton selectDragonBtn;

	/** The current dragon button. */
	DragonButton currDragBtn;
	
	/** The prev button. */
	JButton prevButton;
	
	/** The next button. */
	JButton nextButton;
	
	/** The confirm selection button*/
	JButton btnConfirmSelection;	
	/**
	 * Instantiates a new army selection view.
	 *
	 * @param playerOne the player one
	 * @param playerTwo the player two
	 * @param isTwo the is two
	 */
	public ArmySelectionView( Player playerOne, Player playerTwo, GameState gameState ) {
		
		selectionModel = new ArmySelectionModel();
		
		// Set the player being selected for the army.
		if ( gameState.getPlayerOneArmySelection() && !gameState.getPlayerTwoArmySelection() ) {
			selectionModel.setPlayer( playerOne );
		} else {
			selectionModel.setPlayer( playerTwo );
		}
		
		ArmySelectionController.initCurrentAndPrev(selectionModel);
		//armySelectionWindow = new JFrame("Select your army");
		//armySelectionWindow.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		//armySelectionWindow.setSize(1200, 748);
		//armySelectionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		armySelectionWindow = new JPanel(new GridLayout(0, 1, 0, 0));
		armySelectionWindow.setPreferredSize(new Dimension(1200, 748));
		this.setLayout(new GridLayout(1,1));
		
		mainPanel = new JPanel();
		armySelectionWindow.add(mainPanel);
		mainPanel.setLayout(null);
		
		prevWindow = new JPanel();
		prevWindow.setBounds(106, 193, 60, 54);
		mainPanel.add(prevWindow);
		prevWindow.add(new DragonButton( this.selectionModel.getPrev()));
		prevWindow.setBorder(new LineBorder(Color.BLACK));
		
		currWindow = new JPanel();
		currWindow.setBounds(344, 111, 298, 218);
		mainPanel.add(currWindow);
		currDragBtn = new DragonButton( this.selectionModel.getCurrent(),  "M");
		setupCurrentDragonButtonListener( currDragBtn );
		currWindow.add( currDragBtn );
		currWindow.setBorder(new LineBorder(Color.BLACK));
		
		nextWindow = new JPanel();
		nextWindow.setBounds(854, 193, 60, 54);
		mainPanel.add(nextWindow);
		nextWindow.add(new DragonButton( this.selectionModel.getNext()));
		nextWindow.setBorder(new LineBorder(Color.BLACK));
		
		currentArmySelection = new JPanel();
		currentArmySelection.setBounds(70, 441, 860, 54);	
		currentArmySelection.setBorder(new LineBorder(Color.BLACK));
		
        btnConfirmSelection = new ImageButton(ArmySelectionController.getConfirmSelectionButton());
        btnConfirmSelection.setSize(new Dimension(217,40));
        btnConfirmSelection.setBounds(706, 527, 217, 40);
        btnConfirmSelection.setVisible(false);
        
		updateSelectionPanel( currentArmySelection, selectionModel ); 
		
		mainPanel.add(currentArmySelection);
        mainPanel.add(btnConfirmSelection);

			
		
		selectDragonBtn = new ImageButton(ArmySelectionController.getAddDragonButton());
		selectDragonBtn.setBounds(379, 352, 29, 29);
		selectDragonBtn.setSize(new Dimension(240,59));
		mainPanel.add(selectDragonBtn);
		selectDragonBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.addToArmy( selectionModel, selectionModel.getCurrent() );
				updateSelectionPanel( currentArmySelection, selectionModel );
			}
		});
		
		prevButton = new ImageButton(ArmySelectionController.getPreviousButton());
		prevButton.setBounds(66, 347, 133, 40);
		mainPanel.add(prevButton);
		prevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.shiftPreviewLeft( selectionModel );
				updateSelectionPanel( currentArmySelection, selectionModel );
				updatePreviewPanels();
			}
		});
		
		nextButton = new ImageButton(ArmySelectionController.getNextButton());
		nextButton.setBounds(823, 347, 133, 40);
		mainPanel.add(nextButton);
		
		JLabel playerPickMessage = new JLabel(selectionModel.getPlayer().getName() + ", select your Army!");
		playerPickMessage.setFont(new Font(playerPickMessage.getFont().getFontName(), Font.PLAIN, 20));
		playerPickMessage.setBounds(66, 30, 900, 33);
		mainPanel.add(playerPickMessage);
		btnConfirmSelection.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.confirmPlayersArmy( selectionModel );
				if ( gameState.getPlayerOneArmySelection() && !gameState.getPlayerTwoArmySelection() ) {
					gameState.setPlayerTwoArmySelection( true );
					GameController.createArmySelectionView(playerOne, playerTwo);
					GameController.changeView("armySelect");
					//new ArmySelectionView( playerOne, playerTwo, gameState );
					//armySelectionWindow.setVisible(false);
				} else {
                    gameState.setPlayerTwoArmySelection( false );
					armySelectionWindow.setVisible(false);
					gameState.setPlayerOneDiceSelection( true );
					//create a new match card
					GameController.createMatchView( playerOne, playerTwo, gameState );
					GameController.changeView("matchView");
					//new MatchView( playerOne, playerTwo, gameState );
				}
			}
		});
		
		nextButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.shiftPreviewRight( selectionModel );
				updateSelectionPanel( currentArmySelection, selectionModel );
				updatePreviewPanels();
			}
		});
		
		armySelectionWindow.setVisible(true);
		
		this.add(armySelectionWindow);
	}
	
	private void setupCurrentDragonButtonListener(DragonButton dragBtn) {
		dragBtn.addActionListener( new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				DragonButton actionPerfomedOn = (DragonButton) arg0.getSource();
				Dragon dragonToDisplay = actionPerfomedOn.getAssociatedDragon();
				DragonInformationView dragonInformation = new DragonInformationView( dragonToDisplay );
			}
			
		});
	}

	/**
	 * Update preview panels.
	 */
	//Updates previous, current, and next preview panels for dragon selection.
	public void updatePreviewPanels() {
		updatePanel( currWindow, selectionModel.getCurrent() );
		updatePanel( nextWindow, selectionModel.getNext() );
		updatePanel( prevWindow, selectionModel.getPrev() );
	}
	
	
	/**
	 * Updates a panel to display the dragon passed in.
	 *
	 * @param panel the panel
	 * @param dragon the dragon
	 */
	public void updatePanel( JPanel panel, Dragon dragon ) {
		
		DragonButton dragBtn;
		
		if (panel.getHeight() > 200)
		{
			dragBtn = new DragonButton ( dragon, "M" );
		}
		else
		{
			dragBtn = new DragonButton ( dragon );
		}
		setupCurrentDragonButtonListener( dragBtn );
		panel.removeAll();
		panel.add( dragBtn );
		panel.updateUI();
	}
	
	
	/**
	 * Update selection panel.
	 *
	 * @param selectionPanel The Panel that is displaying the user's selection
	 * @param armySelectModel The model containing the user's army
	 * Updates the panel displaying the user's current selection
	 */
	public void updateSelectionPanel( JPanel selectionPanel, ArmySelectionModel armySelectModel ) {
		
		Army playerDragons = armySelectModel.getCurrentPlayerArmy();
		Iterator<Dragon> playerDragonsIteration = playerDragons.getArmy().iterator();
		Dragon currentDragon;
		DragonButton dragButton;
		selectionPanel.removeAll();
		
		if ( playerDragons.getSize() != 0 ) {
			while ( playerDragonsIteration.hasNext() ) {
				currentDragon = playerDragonsIteration.next();
				dragButton = new DragonButton( currentDragon );
				configureDragonButtonActionListener( selectionPanel, armySelectModel, dragButton );
				selectionPanel.add( dragButton );
				selectionPanel.updateUI();
			}
		}

		if(playerDragons.getSize() > 0)
		    btnConfirmSelection.setVisible(true);
		else
            btnConfirmSelection.setVisible(false);

		selectionPanel.updateUI();
		
	}
	
	/**
	 * Configure dragon button action listener.
	 *
	 * @param currentArmySelection the current army selection
	 * @param selectionModel the selection model
	 * @param dragBtn the drag btn
	 */
	public void configureDragonButtonActionListener( JPanel currentArmySelection, ArmySelectionModel selectionModel, DragonButton dragBtn ) {
		dragBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.removeFromArmy( selectionModel.getCurrentPlayerArmy(), dragBtn.getAssociatedDragon() );
				updateSelectionPanel( currentArmySelection, selectionModel );
			}
		});
	}
}
