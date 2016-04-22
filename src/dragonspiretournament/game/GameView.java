package dragonspiretournament.game;

import dragonspiretournament.GameObjects.Dragons.Dragon;

import dragonspiretournament.GameObjects.UIComponents.ImageButton;
import dragonspiretournament.title.TitleController;
import dragonspiretournament.nameselection.NameSelectionView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class GameView.
 */
public class GameView {
	
	/** The title frame. */
	private JFrame titleFrame;
	
	/*test stuff*/
	private JButton testButton;
	
	/**
	 * Instantiates a new game view.
	 */
	public GameView() {
		titleFrame = new JFrame("DragonSpire Tournament");
		titleFrame.setSize(1036, 610);
		
		titleFrame.setVisible(true);
		
		//setting the card layout
		titleFrame.getContentPane().setLayout(new CardLayout(20,20));
		
		//creating elements to add to the card layout
		NameSelectionView nameView = new NameSelectionView();
		
		//adding elements to the card layout
		//test adds
		//testButton = new JButton("test");
		//titleFrame.getContentPane().add(testButton);
		titleFrame.getContentPane().add(nameView);
		titleFrame.setVisible(true);
	}

    
}