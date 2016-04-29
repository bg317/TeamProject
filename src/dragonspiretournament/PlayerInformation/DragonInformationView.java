package dragonspiretournament.PlayerInformation;

import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.UIComponents.ImageButton;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Image;
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

import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * The Class DragonInformationView.
 */
public class DragonInformationView {

	/** The dragon name. */
	//values to use in the display
	private String dragonName;
	
	/** The dragon description. */
	private String dragonDescription;
	
	/** The dragon icon location. */
	private String dragonIconLocation;
	
	/** The dragon art location. */
	private String dragonArtLocation;
	
	/** The dragon element. */
	private String dragonElement;
	
	/** The dragon advantage. */
	private String dragonAdvantage;
	
	
	/** The info frame. */
	private JFrame infoFrame;
	
	/** The total panel. */
	//all components to be added to the JPanel totalPanel
	private JPanel totalPanel;
	
	/** The name label. */
	private JLabel nameLabel;
	
	/** The description label. */
	private JLabel descriptionLabel;
	
	/** The stats panel. */
	private JPanel statsPanel;
	
	/** The element label. */
	private JLabel elementLabel;
	
	/** The description panel. */
	private JPanel descriptionPanel;
	
	/** The close button. */
	private JButton closeButton;
	
	/** The icon. */
	private ImageIcon icon;
	
	/** The main image. */
	private ImageButton mainImage;

	
	/**
	 * Instantiates a new dragon information view.
	 *
	 * @param dragon the dragon
	 */
	//constructor, takes in dragon information when created
	public DragonInformationView(Dragon dragon)
	{
		DragonInformationController.setDragon(dragon);
		
		//get values to use in the display
		dragonName = DragonInformationController.getName();
		dragonElement = DragonInformationController.getType();
		dragonDescription = DragonInformationController.getDescription();
		dragonIconLocation = DragonInformationController.getIcon();
		dragonArtLocation = DragonInformationController.getArt();
		dragonAdvantage = DragonInformationController.getAdvantage();
		
		
		//creating a frame
		infoFrame = new JFrame("Dragonspire Tournament--" + dragonName + " Information");
		infoFrame.getContentPane().setLayout(new GridLayout(1,1));
		infoFrame.setSize(500, 600);
		//This operation causes it to default to center.
		infoFrame.setLocationRelativeTo(null);
		
		//initializing images
		
		
		icon = DragonInformationController.createIcon(dragonIconLocation, dragonName);
		
		//initializing the J elements
		totalPanel = new JPanel(new BorderLayout());
		nameLabel = new JLabel("<html><h1 style='font-size:25px; color: #990000; padding: 10px'>"+dragonName+"</h1></html>", JLabel.CENTER);
		descriptionLabel = new JLabel("<html><table style='font-size:12px; weight: normal; #595959; padding: 10px'>"+dragonDescription +"<br/><br/> Element: " + dragonElement + "<br/>Advantage: " + dragonAdvantage + "</html>");
		descriptionPanel = new JPanel(new GridLayout(1,1));
		descriptionPanel.add(descriptionLabel);
		//statsPanel = new JPanel(new GridLayout(1,2));
		//elementLabel = new JLabel("Element: " + dragonElement);
		//statsPanel.add(elementLabel);
		
		//descriptionPanel.add(statsPanel);
		
		//adding the J elements to the total panel
		totalPanel.add(nameLabel, BorderLayout.NORTH);
		totalPanel.add(descriptionPanel, BorderLayout.SOUTH);
		
		//set main dragon image
		try {
			mainImage = new ImageButton(dragonArtLocation);
			totalPanel.add(mainImage, BorderLayout.CENTER);
		}
		finally
		{
		
		//frame stuff
		infoFrame.getContentPane().add(totalPanel);
		infoFrame.setVisible(true);
		}
	}
	
}
