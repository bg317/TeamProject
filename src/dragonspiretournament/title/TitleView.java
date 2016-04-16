package dragonspiretournament.title;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

// TODO: Auto-generated Javadoc
/**
 * The Class TitleView.
 */
public class TitleView {
	
	/** The title frame. */
	private JFrame titleFrame;
	
	/** The title label. */
	private JLabel titleLabel;
	
	/** The start button. */
	private JButton startButton;
	
	/**
	 * Instantiates a new title view.
	 */
	public TitleView() {
		titleFrame = new JFrame("DragonSpire Tournament");
		titleFrame.getContentPane().setLayout(new BorderLayout());
		titleFrame.setSize(500, 500);
		
		titleLabel = new JLabel("DragonSpire Tournament - Press Start to continue!");
		startButton = new JButton("Start");
		titleFrame.getContentPane().add(startButton, BorderLayout.SOUTH);
		titleFrame.getContentPane().add(titleLabel, BorderLayout.CENTER);
		
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TitleController.doSomething();
			}
		});
		
		titleFrame.setVisible(true);
	}

}
