package dragonspiretournament.armyselection;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

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
		
		
		currWindow = new JPanel();
		currWindow.setBounds(334, 111, 298, 210);
		mainPanel.add(currWindow);
		
		nextWindow = new JPanel();
		nextWindow.setBounds(814, 163, 124, 108);
		mainPanel.add(nextWindow);
		
		currentArmySelection = new JPanel();
		currentArmySelection.setBounds(96, 441, 797, 67);	
		currentArmySelection.setBorder(new LineBorder(Color.CYAN));
		
		updateSelectionPanel( currentArmySelection, selectionModel ); 
		
		mainPanel.add(currentArmySelection);

			
		
		selectDragonBtn = new JButton("Pick Item");
		selectDragonBtn.setBounds(439, 387, 89, 23);
		mainPanel.add(selectDragonBtn);
		
		prevButton = new JButton("Prev");
		prevButton.setBounds(76, 347, 89, 23);
		mainPanel.add(prevButton);
		
		nextButton = new JButton("Next");
		nextButton.setBounds(823, 347, 89, 23);
		mainPanel.add(nextButton);
		
		armySelectionWindow.setVisible(true);
	}
	
	public void updateSelectionPanel( JPanel selectionPanel, ArmySelectionModel armySelectModel ) {
		ArrayList<Dragon> playerDragons = armySelectModel.getAllLibraryDragons();
		Iterator<Dragon> playerDragonsIteration = playerDragons.iterator();
		ImageIcon dragIcon;
		Dragon currentDragon;
		DragonButton dragButton;
		
		while ( playerDragonsIteration.hasNext() ) {
			currentDragon = playerDragonsIteration.next();
			dragButton = new DragonButton( currentDragon );
			configureActionListener( dragButton );
			selectionPanel.add( dragButton );
		}
	}
	
	public void configureActionListener( DragonButton dragBtn ) {
		dragBtn.addActionListener( new ActionListener() {
			@Override
			public void actionPerformed( ActionEvent e ) {
				//ArmySelectionController.removeFromArmy()
				//updateSelectionPanel( this.currentArmySelection, this.selectionModel )
			}
		});
	}
	
}
