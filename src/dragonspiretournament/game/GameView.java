package dragonspiretournament.game;

import dragonspiretournament.GameObjects.Dragons.Dragon;

import dragonspiretournament.GameObjects.UIComponents.ImageButton;
import dragonspiretournament.title.TitleController;
import dragonspiretournament.nameselection.NameSelectionView;
import dragonspiretournament.title.TitleView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

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
	
	/*the container panel*/
	private JPanel wrapperPanel;
	
	/** the title view*/
	TitleView titleView;
	
	/** the name selection view */
	NameSelectionView nameView;
	
	/**
	 * Instantiates a new game view.
	 */
	public GameView() {
		titleFrame = new JFrame("Dragonspire Tournament");
		titleFrame.setSize(1036, 610);
		
		titleFrame.setVisible(true);
		
		//setting the card layout
		wrapperPanel = new JPanel(new CardLayout());
		
		titleFrame.setLayout(new GridLayout(1,1));
		
		//creating elements to add to the card layout
		nameView = new NameSelectionView();
		nameView.setBackground(Color.white);
		titleView = new TitleView();
		titleView.setBackground(Color.white);
		
		//adding elements to the card layout
		wrapperPanel.add(titleView, "titleView");
		wrapperPanel.add(nameView, "nameView");
		titleFrame.getContentPane().add(wrapperPanel);
		//make the frame visible
		titleFrame.setVisible(true);
		wrapperPanel.repaint();
		
	}
	
	/**
	 * Method that allows switching between instantiated view objects.
	 * @param ViewToShow the name of the view objects to show next.
	 */
	public void changeView(String ViewToShow)
	{
		CardLayout cardLayout = (CardLayout) wrapperPanel.getLayout();
		cardLayout.show(wrapperPanel, ViewToShow);
		
		wrapperPanel.repaint();
	}

    
}