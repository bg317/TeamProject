package dragonspiretournament.title;
import dragonspiretournament.GameObjects.UIComponents.ImageButton;

import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


// TODO: Auto-generated Javadoc
/**
 * The Class TitleView.
 */
public class TitleView extends JPanel {
	
	/** The title panel. */
	private JPanel titleFrame;
	
	/** The title label. */
	private JLabel titleLabel;
	
	/** The button panel. */
	private JPanel buttonPanel;

	/** The start button. */
	private JButton startButton;
	
	/** The leaderboard button. */
	private JButton leaderboardButton;
	
	/**
	 * Instantiates a new title view.
	 */
	public TitleView() {
		//titleFrame = new JFrame("DragonSpire Tournament");
		//titleFrame.getContentPane().setLayout(new BorderLayout());
		//titleFrame.setSize(500, 500);
		
		titleFrame = new JPanel(new BorderLayout());
		titleFrame.setPreferredSize(new Dimension(500,500));
		titleFrame.setBackground(Color.white);
		
		titleLabel = new JLabel("<html><p><div style= 'font-size: 40;'>Dragonspire Tournament</div><br><div style= 'text-align: center; font-size: 14'>Press Start to continue!</div></p></html>", SwingConstants.CENTER);
        titleFrame.add(titleLabel, BorderLayout.CENTER);
        
        buttonPanel = new JPanel(new BorderLayout());
		startButton = new ImageButton(TitleController.getStartButton());
		buttonPanel.add(startButton, BorderLayout.NORTH);
		leaderboardButton = new ImageButton(TitleController.getLeaderboardButton());
		buttonPanel.add(leaderboardButton, BorderLayout.SOUTH);
		titleFrame.add(buttonPanel, BorderLayout.SOUTH);
		buttonPanel.setBackground(Color.white);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleController.doSomething();
				
			}
		});
		
		leaderboardButton.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        TitleController.goToLeaderboard();
		    }
		});
		
		this.add(titleFrame);
		this.setVisible(true);
	}

}
