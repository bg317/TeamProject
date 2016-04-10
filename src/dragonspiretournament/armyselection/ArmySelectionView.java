package dragonspiretournament.armyselection;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.Dragons.TestDragon;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * The Class ArmySelectionView.
 */
public class ArmySelectionView {
	
	/** The army selection window. */
	JFrame armySelectionWindow;
	ArmySelectionModel selectionModel;
	
	/**
	 * Instantiates a new army selection view.
	 */
	public ArmySelectionView() {
		selectionModel = new ArmySelectionModel();
		armySelectionWindow = new JFrame("Select your army");
		armySelectionWindow.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		armySelectionWindow.setSize(1200, 748);
		armySelectionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		armySelectionWindow.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel prevWindow = new JPanel();
		prevWindow.setBounds(41, 163, 124, 108);
		mainPanel.add(prevWindow);
		
		JPanel currWindow = new JPanel();
		currWindow.setBounds(334, 111, 298, 210);
		mainPanel.add(currWindow);
		
		JPanel nextWindow = new JPanel();
		nextWindow.setBounds(814, 163, 124, 108);
		mainPanel.add(nextWindow);
		
		JPanel currentArmySelection = new JPanel();
		currentArmySelection.setBounds(96, 441, 797, 67);	
		currentArmySelection.setBorder(new LineBorder(Color.CYAN));
		
		updateSelectionPanel( currentArmySelection, selectionModel ); 
		
		mainPanel.add(currentArmySelection);

			
		
		JButton selectDragonBtn = new JButton("Pick Item");

		selectDragonBtn.setBounds(439, 387, 89, 23);
		mainPanel.add(selectDragonBtn);
		
		JButton prevButton = new JButton("Prev");
		prevButton.setBounds(76, 347, 89, 23);
		mainPanel.add(prevButton);
		
		JButton nextButton = new JButton("Next");
		nextButton.setBounds(823, 347, 89, 23);
		mainPanel.add(nextButton);
		
		armySelectionWindow.setVisible(true);
	}
	
	public void updateSelectionPanel( JPanel selectionPanel, ArmySelectionModel armySelectModel ) {
		ArrayList<Dragon> playerDragons = armySelectModel.getAllLibraryDragons();
		Iterator<Dragon> playerDragonsIteration = playerDragons.iterator();
		ImageIcon dragIcon;
		Dragon currentDragon;
		
		while ( playerDragonsIteration.hasNext() ) {
			currentDragon = playerDragonsIteration.next();
			dragIcon = new ImageIcon(currentDragon.getIcon());
			selectionPanel.add(new JButton(dragIcon));
		}
	}
	
}
