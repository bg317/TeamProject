package dragonspiretournament.Leaderboard;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.border.LineBorder;
import java.awt.Color;

import dragonspiretournament.Leaderboard.LeaderboardModel;

public class LeaderboardView{
	
	/** The leaderboard model */
	private LeaderboardModel info;
	
	/** The Leaderboard frame */
	private JFrame leaderboardFrame;
	
	/** The main panel */
	private JPanel mainPanel;
	
	/** The main panel */
	private JPanel infoPanel;
	
	/** The back button */
	private JButton backButton;
	
	/** The player name label */
	private JLabel playerNames;
	
	/** The W/L/T label */
	private JLabel winsLabel;
	
	/** The rank label */
	private JLabel rank;
	
	/** The player ranks label */
	private JLabel ranks;
	
	/** The player names label */
	private JLabel names;
	
	/** The player stats label */
	private JLabel stats;
	
	/**
	 * Instantiates a new leaderboard view.
	 */
	public LeaderboardView(){
		info = new LeaderboardModel();
		
		leaderboardFrame = new JFrame("Leaderboard");
		leaderboardFrame.getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		leaderboardFrame.setSize(500, 800);
		leaderboardFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		leaderboardFrame.setVisible(true);
		
		mainPanel = new JPanel();
		leaderboardFrame.getContentPane().add(mainPanel);
		mainPanel.setLayout(null);
		
		infoPanel = new JPanel();
		infoPanel.setBounds(50, 50, 380, 600);
		infoPanel.setLayout(null);
		mainPanel.add(infoPanel);
		infoPanel.setBorder(new LineBorder(Color.BLACK));
		
		rank = new JLabel("Rank");
		rank.setBounds(50, 20, 30, 30);
		mainPanel.add(rank);
		
		playerNames = new JLabel("Player Name");
		playerNames.setBounds(120, 20, 300, 30);
		mainPanel.add(playerNames);
		
		winsLabel = new JLabel("W/L/T");
		winsLabel.setBounds(350, 20, 100, 30);
		mainPanel.add(winsLabel);
		
		backButton = new JButton("Back");
		backButton.setBounds(350, 675, 75, 50);
		mainPanel.add(backButton);
		
		for(int i = 0; i < info.size(); i++){
			ranks = new JLabel(i + 1 + "", JLabel.LEFT);
			ranks.setBounds(5, i * 17, 50, 20);
			names = new JLabel(info.getName(i), JLabel.LEFT);
			names.setBounds(75, i * 17, 150, 20);
			stats = new JLabel(info.getStats(i), JLabel.CENTER);
			stats.setBounds(265, i * 17, 100, 20);
			infoPanel.add(ranks);
			infoPanel.add(names);
			infoPanel.add(stats);
			infoPanel.repaint();
		}
		
	}

}
