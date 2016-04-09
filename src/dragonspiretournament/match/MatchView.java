package dragonspiretournament.match;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonspiretournament.title.TitleController;
import javax.swing.JSplitPane;
import javax.swing.JProgressBar;
import javax.swing.JTable;

public class MatchView {
	private JFrame matchFrame;
	private JPanel playerOneDragons;
	private JPanel playerTwoDragons;
	
	public MatchView() {
		matchFrame = new JFrame("DragonSpire Tournament");
		matchFrame.setSize(849, 626);
		matchFrame.getContentPane().setLayout(null);
		matchFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBounds(36, 11, 121, 400);
		matchFrame.getContentPane().add(panel);
		
		JButton btnNewButton = new JButton("New button");
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("New button");
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel.add(btnNewButton_8);
		
		JButton btnNewButton_1 = new JButton("New button");
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("New button");
		panel.add(btnNewButton_11);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel.add(btnNewButton_9);
		
		JButton btnNewButton_12 = new JButton("New button");
		panel.add(btnNewButton_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(686, 147, 121, 400);
		matchFrame.getContentPane().add(panel_1);
		
		JButton btnNewButton_13 = new JButton("New button");
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		panel_1.add(btnNewButton_13);
		
		JButton btnNewButton_14 = new JButton("New button");
		panel_1.add(btnNewButton_14);
		
		JButton btnNewButton_16 = new JButton("New button");
		panel_1.add(btnNewButton_16);
		
		JButton btnNewButton_15 = new JButton("New button");
		panel_1.add(btnNewButton_15);
		
		JButton btnNewButton_17 = new JButton("New button");
		panel_1.add(btnNewButton_17);
		
		JButton btnNewButton_19 = new JButton("New button");
		panel_1.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("New button");
		panel_1.add(btnNewButton_20);
		
		JButton btnNewButton_18 = new JButton("New button");
		panel_1.add(btnNewButton_18);
		
		JButton btnNewButton_22 = new JButton("New button");
		panel_1.add(btnNewButton_22);
		
		JButton btnNewButton_23 = new JButton("New button");
		panel_1.add(btnNewButton_23);
		
		JButton btnNewButton_21 = new JButton("New button");
		panel_1.add(btnNewButton_21);
		
		JButton btnNewButton_24 = new JButton("New button");
		panel_1.add(btnNewButton_24);
		
		JLabel lblPlayerTwo = new JLabel("Player One Dragons");
		lblPlayerTwo.setBounds(36, 422, 121, 40);
		matchFrame.getContentPane().add(lblPlayerTwo);
		
		JLabel lblPlayerTwoDragons = new JLabel("Player Two Dragons");
		lblPlayerTwoDragons.setBounds(686, 96, 121, 40);
		matchFrame.getContentPane().add(lblPlayerTwoDragons);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(36, 484, 146, 14);
		matchFrame.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setBounds(573, 11, 146, 14);
		matchFrame.getContentPane().add(progressBar_1);
		
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
}
