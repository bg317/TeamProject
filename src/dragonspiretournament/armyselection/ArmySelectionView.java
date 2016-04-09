package dragonspiretournament.armyselection;

import javax.swing.JFrame;

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

// TODO: Auto-generated Javadoc
/**
 * The Class ArmySelectionView.
 */
public class ArmySelectionView {
	
	/** The army selection window. */
	JFrame armySelectionWindow;
	ArmySelectionModel selectionModel = new ArmySelectionModel();
	
	/**
	 * Instantiates a new army selection view.
	 */
	public ArmySelectionView() {
		armySelectionWindow = new JFrame("Select your army");
		armySelectionWindow.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		armySelectionWindow.setSize(1200, 748);
		armySelectionWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel mainPanel = new JPanel();
		armySelectionWindow.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 163, 124, 108);
		mainPanel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(334, 111, 298, 210);
		mainPanel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(814, 163, 124, 108);
		mainPanel.add(panel_3);
		
		JPanel currentArmySelection = new JPanel();
		currentArmySelection.setBounds(96, 441, 797, 67);	
		currentArmySelection.setBorder(new LineBorder(Color.CYAN));
		
		//Get this from the Model object. Model gets it from associated player object
		ArrayList<Dragon> onlyForTestingDragons = new ArrayList<Dragon>();
		for ( int index = 0; index < 8; index++ ) {
			onlyForTestingDragons.add(new TestDragon());
		}
		updateSelectionPanel( currentArmySelection, onlyForTestingDragons); 
		
		mainPanel.add(currentArmySelection);

			
		
		JButton btnNewButton = new JButton("Pick Item");

		btnNewButton.setBounds(439, 387, 89, 23);
		mainPanel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Prev");
		btnNewButton_1.setBounds(76, 347, 89, 23);
		mainPanel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.setBounds(823, 347, 89, 23);
		mainPanel.add(btnNewButton_2);
		
		armySelectionWindow.setVisible(true);
	}
	
	public void updateSelectionPanel( JPanel selectionPanel, ArrayList<Dragon> playerDragons ) {
		
		Iterator<Dragon> playerDragonsIteration = playerDragons.iterator();
		Dragon currentDragon;
		
		while ( playerDragonsIteration.hasNext() ) {
			currentDragon = playerDragonsIteration.next();
			selectionPanel.add(new JButton(currentDragon.getDragonIcon()));
		}
	}
	
}
