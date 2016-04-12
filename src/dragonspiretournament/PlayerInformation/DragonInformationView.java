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

public class DragonInformationView {

	//values to use in the display
	private String dragonName;
	private String dragonDescription;
	private String dragonIconLocation;
	private String dragonArtLocation;
	private String dragonElement;
	private String dragonAdvantage;
	
	
	private JFrame infoFrame;
	
	//all components to be added to the JPanel totalPanel
	private JPanel totalPanel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JPanel statsPanel;
	private JLabel elementLabel;
	private JPanel descriptionPanel;
	private JButton closeButton;
	private ImageIcon icon;
	private ImageButton mainImage;

	
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
		
		//initializing images
		
		
		icon = DragonInformationController.createIcon(dragonIconLocation, dragonName);
		
		//initializing the J elements
		totalPanel = new JPanel(new BorderLayout());
		nameLabel = new JLabel("<html><h1 style='font-size:25px; color: #990000; padding: 10px'>"+dragonName+"</h1></html>", JLabel.CENTER);
		descriptionLabel = new JLabel("<html><table style='font-size:12px; weight: normal; #595959; padding: 10px'>"+dragonDescription +"</html>");
		descriptionPanel = new JPanel(new GridLayout(2,1));
		descriptionPanel.add(descriptionLabel);
		statsPanel = new JPanel(new GridLayout(1,2));
		elementLabel = new JLabel("Element: " + dragonElement);
		statsPanel.add(elementLabel);
		
		descriptionPanel.add(statsPanel);
		
		//adding the J elements to the total panel
		totalPanel.add(nameLabel, BorderLayout.NORTH);
		totalPanel.add(descriptionPanel, BorderLayout.SOUTH);
		
		//set main dragon image
		try {
			System.out.println(dragonArtLocation);
			mainImage = new ImageButton(dragonArtLocation);
			totalPanel.add(mainImage, BorderLayout.CENTER);
			System.out.println("got to the end of the try");
		}
		finally
		{
		
		System.out.println("doing finally stuff");
		//frame stuff
		infoFrame.getContentPane().add(totalPanel);
		infoFrame.setVisible(true);
		}
	}
	
}
