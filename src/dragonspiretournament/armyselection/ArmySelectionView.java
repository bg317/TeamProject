package dragonspiretournament.armyselection;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.UIComponents.DragonButton;
import dragonspiretournament.match.MatchView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class ArmySelectionView.
 */
public class ArmySelectionView {
	
	/** The army selection window. */
	JFrame armySelectionWindow;
	ArmySelectionModel selectionModel;
	
	JPanel mainPanel;
	JPanel prevWindow;
	JPanel currWindow;
	JPanel nextWindow;
	JPanel currentArmySelection;
	
	JButton selectDragonBtn;
	JButton prevButton;
	JButton nextButton;
	
	Boolean isTwo;
	
	/**
	 * Instantiates a new army selection view.
	 */
	public ArmySelectionView( Player playerOne, Player playerTwo, Boolean isTwo ) {
		selectionModel = new ArmySelectionModel();
		if ( !isTwo ) {
			selectionModel.setPlayer( playerOne );
		} else {
			selectionModel.setPlayer( playerTwo );
		}
		this.isTwo = isTwo;
		
		ArmySelectionController.initCurrentAndPrev(selectionModel);
		armySelectionWindow = new JFrame("Select your army");
		armySelectionWindow.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		armySelectionWindow.setSize(1200, 748);
		armySelectionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		armySelectionWindow.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		prevWindow = new JPanel();
		prevWindow.setBounds(41, 163, 124, 108);
		mainPanel.add(prevWindow);
		prevWindow.add(new DragonButton( this.selectionModel.getPrev()));
		prevWindow.setBorder(new LineBorder(Color.BLACK));
		
		currWindow = new JPanel();
		currWindow.setBounds(334, 111, 298, 210);
		mainPanel.add(currWindow);
		currWindow.add(new DragonButton( this.selectionModel.getCurrent()));
		currWindow.setBorder(new LineBorder(Color.BLACK));
		
		nextWindow = new JPanel();
		nextWindow.setBounds(814, 163, 124, 108);
		mainPanel.add(nextWindow);
		nextWindow.add(new DragonButton( this.selectionModel.getNext()));
		nextWindow.setBorder(new LineBorder(Color.BLACK));
		
		currentArmySelection = new JPanel();
		currentArmySelection.setBounds(96, 441, 797, 67);	
		currentArmySelection.setBorder(new LineBorder(Color.BLACK));
		
		updateSelectionPanel( currentArmySelection, selectionModel ); 
		
		mainPanel.add(currentArmySelection);

			
		
		selectDragonBtn = new JButton("Add Dragon");
		selectDragonBtn.setBounds(439, 387, 89, 23);
		selectDragonBtn.setSize(new Dimension(150,50));
		mainPanel.add(selectDragonBtn);
		selectDragonBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.addToArmy( selectionModel, selectionModel.getCurrent() );
				updateSelectionPanel( currentArmySelection, selectionModel );
			}
		});
		
		prevButton = new JButton("Prev");
		prevButton.setBounds(76, 347, 89, 23);
		mainPanel.add(prevButton);
		prevButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.shiftPreviewLeft( selectionModel );
				updateSelectionPanel( currentArmySelection, selectionModel );
				updatePreviewPanels();
			}
		});
		
		nextButton = new JButton("Next");
		nextButton.setBounds(823, 347, 89, 23);
		mainPanel.add(nextButton);
		
		JButton btnConfirmSelection = new JButton("Confirm Selection");
		btnConfirmSelection.setBounds(746, 557, 177, 23);
		mainPanel.add(btnConfirmSelection);
		btnConfirmSelection.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				ArmySelectionController.confirmPlayersArmy( selectionModel );
				if ( !isTwo ) {
					new ArmySelectionView( playerOne, playerTwo, true );
					armySelectionWindow.setVisible(false);
				} else {
					armySelectionWindow.setVisible(false);
					new MatchView( playerOne, playerTwo );
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
	}
	
	//Updates previous, current, and next preview panels for dragon selection.
	public void updatePreviewPanels() {
		updatePanel( currWindow, selectionModel.getCurrent() );
		updatePanel( nextWindow, selectionModel.getNext() );
		updatePanel( prevWindow, selectionModel.getPrev() );
	}
	
	
	/**
	 * Updates a panel to display the dragon passed in
	 *
	 * @param panel the panel
	 * @param dragon the dragon
	 */
	public void updatePanel( JPanel panel, Dragon dragon ) {
		panel.removeAll();
		panel.add( new DragonButton( dragon ));
		panel.updateUI();
	}
	
	
	/**
	 * @param selectionPanel The Panel that is displaying the user's selction
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
