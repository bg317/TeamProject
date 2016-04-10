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
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.UIComponents.DragonButton;
import dragonspiretournament.title.TitleController;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class MatchView {
	private JFrame matchFrame;
	private JPanel playerOneDragons;
	private JPanel playerTwoDragons;
	JPanel playerTwoArmy;
	JPanel playerOneArmy;
	
	private MatchModel matchModel;
	
	public MatchView( Player playerOne, Player playerTwo ) {
		matchModel = new MatchModel( playerOne, playerTwo );
		System.out.println( playerOne.getArmy() );
		matchFrame = new JFrame("DragonSpire Tournament");
		matchFrame.setSize(849, 626);
		matchFrame.getContentPane().setLayout(null);
		matchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		playerOneArmy = new JPanel();
		playerOneArmy.setBounds(36, 11, 121, 400);
		matchFrame.getContentPane().add(playerOneArmy);
		updateArmyPanel( playerOneArmy, matchModel.getPlayerOneArmy() );

		playerTwoArmy = new JPanel();
		playerTwoArmy.setBounds(686, 147, 121, 400);
		matchFrame.getContentPane().add(playerTwoArmy);
		updateArmyPanel( playerTwoArmy, matchModel.getPlayerTwoArmy() );
		
		JButton btnNewButton_13 = new JButton("New button");
		btnNewButton_13.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblPlayerTwo = new JLabel("Player One Dragons");
		lblPlayerTwo.setBounds(36, 422, 121, 40);
		matchFrame.getContentPane().add(lblPlayerTwo);
		
		JLabel lblPlayerTwoDragons = new JLabel("Player Two Dragons");
		lblPlayerTwoDragons.setBounds(686, 96, 121, 40);
		matchFrame.getContentPane().add(lblPlayerTwoDragons);
		
		JProgressBar playerOneHP = new JProgressBar();
		playerOneHP.setBounds(36, 484, 146, 14);
		matchFrame.getContentPane().add(playerOneHP);
		
		JProgressBar playerTwoHP = new JProgressBar();
		playerTwoHP.setBounds(573, 11, 146, 14);
		matchFrame.getContentPane().add(playerTwoHP);
		
		JButton btnNewButton_25 = new JButton("New button");
		btnNewButton_25.setBounds(226, 105, 146, 108);
		matchFrame.getContentPane().add(btnNewButton_25);
		
		JButton button = new JButton("New button");
		button.setBounds(381, 105, 146, 108);
		matchFrame.getContentPane().add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(226, 220, 146, 108);
		matchFrame.getContentPane().add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(381, 220, 146, 108);
		matchFrame.getContentPane().add(button_2);
		
		matchFrame.setVisible(true);
	}
	
	public void updateArmyPanel( JPanel playersArmy, Army playerArmy ) {
		
		ArrayList<Dragon> dragons = playerArmy.getArmy();
		Iterator<Dragon> dragonsItr = dragons.iterator();
		DragonButton dragBtn;
		Dragon currentDrag;
		playersArmy.removeAll();
		
		while ( dragonsItr.hasNext() ) {
			currentDrag = dragonsItr.next();
			dragBtn = new DragonButton( currentDrag );
			playersArmy.add(dragBtn);
		}
		
		playersArmy.updateUI();	
	}
}
