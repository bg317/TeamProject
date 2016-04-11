package dragonspiretournament.PlayerInformation;

import java.awt.BorderLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;

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
	
	
	private JFrame infoFrame;
	
	//all components to be added to the JPanel totalPanel
	private JPanel totalPanel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JButton closeButton;
	private ImageIcon icon;
	private JLabel mainImageLabel;

	
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
		
		
		//creating a frame
		infoFrame = new JFrame("Dragonspire Tournament--" + dragonName + " Information");
		
		//initializing images
		
		
		icon = DragonInformationController.createIcon(dragonIconLocation, dragonName);
		
		//initializing the J elements
		totalPanel = new JPanel(new BorderLayout());
		nameLabel = new JLabel("<html><h1 style='font-size:25px; color: #990000; padding: 10px'>"+dragonName+"</h1></html>", JLabel.CENTER);
		descriptionLabel = new JLabel("<html><p style='font-size:12px; weight: normal; #595959; padding: 10px'>"+dragonDescription+" <br/>Element: " + dragonElement + "</p></html>");
		
		//adding the J elements to the total panel
		totalPanel.add(nameLabel, BorderLayout.NORTH);
		totalPanel.add(descriptionLabel, BorderLayout.SOUTH);
		
		//set main dragon image
		BufferedImage mainImage;
		try {
			System.out.println(dragonArtLocation);
			mainImage = ImageIO.read(this.getClass().getResource(dragonArtLocation));
			mainImageLabel = new JLabel(new ImageIcon(mainImage));
			totalPanel.add(mainImageLabel, BorderLayout.CENTER);
		} 
		catch (IOException e) {
			System.out.println("error, invalid file");
		}

		
		//adds functionality to the button

		//frame stuff
		infoFrame.getContentPane().add(totalPanel);
		infoFrame.setSize(500, 500);
		infoFrame.setVisible(true);
	}
	
}
