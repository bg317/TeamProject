package dragonspiretournament.armyselection;

import javax.swing.JFrame;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.UIComponents.DragonButton;

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
	
	/**
	 * Instantiates a new army selection view.
	 */
	public ArmySelectionView() {
		selectionModel = new ArmySelectionModel();
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
		
		currWindow = new JPanel();
		currWindow.setBounds(334, 111, 298, 210);
		mainPanel.add(currWindow);
		currWindow.add(new DragonButton( this.selectionModel.getCurrent()));
		
		nextWindow = new JPanel();
		nextWindow.setBounds(814, 163, 124, 108);
		mainPanel.add(nextWindow);
		nextWindow.add(new DragonButton( this.selectionModel.getNext()));
		
		currentArmySelection = new JPanel();
		currentArmySelection.setBounds(96, 441, 797, 67);	
		currentArmySelection.setBorder(new LineBorder(Color.CYAN));
		
		updateSelectionPanel( currentArmySelection, selectionModel ); 
		
		mainPanel.add(currentArmySelection);

			
		
		selectDragonBtn = new JButton("Add Dragon");
		selectDragonBtn.setBounds(439, 387, 89, 23);
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
	
	
	public void updatePanel( JPanel panel, Dragon dragon ) {
		panel.removeAll();
		panel.add( new DragonButton( dragon ));
		panel.updateUI();
	}
	
	
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
