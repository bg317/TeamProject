package dragonspiretournament.armyselection;

import javax.swing.JFrame;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ArmySelectionView {
	
	JFrame armySelectionWindow;
	
	public ArmySelectionView() {
		armySelectionWindow = new JFrame("Select your army");
		armySelectionWindow.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel = new JPanel();
		armySelectionWindow.getContentPane().add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(41, 163, 124, 108);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(334, 111, 298, 210);
		panel.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(814, 163, 124, 108);
		panel.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(96, 441, 797, 67);
		panel.add(panel_4);
		
		JButton btnNewButton_3 = new JButton("New button");
		panel_4.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		panel_4.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		panel_4.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		panel_4.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		panel_4.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		panel_4.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		panel_4.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		panel_4.add(btnNewButton_10);
		
		JButton btnNewButton = new JButton("Pick Item");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(439, 387, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Prev");
		btnNewButton_1.setBounds(76, 347, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Next");
		btnNewButton_2.setBounds(823, 347, 89, 23);
		panel.add(btnNewButton_2);
	}
	
}
