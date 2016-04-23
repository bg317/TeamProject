package dragonspiretournament.title;

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
	
	/** The start button. */
	private JButton startButton;
	
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
		
		titleLabel = new JLabel("<html><p> <h2>Dragonspire Tournament</h2></br><div style= 'text-align: center;'>Press Start to continue!</div></p></html>", SwingConstants.CENTER);
		startButton = new JButton("Start");
		titleFrame.add(startButton, BorderLayout.SOUTH);
		titleFrame.add(titleLabel, BorderLayout.CENTER);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleController.doSomething();
				
			}
		});
		
		this.add(titleFrame);
		this.setVisible(true);
	}

}
