package dragonspiretournament.title;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TitleView {
	
	private JFrame titleFrame;
	private JLabel titleLabel;
	private JButton startButton;
	
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
