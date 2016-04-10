package dragonspiretournament.PlayerInformation;

import java.awt.BorderLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DragonInformationView {

	//get values to use in the display
	private String dragonName = DragonInformationController.getName();
	private String dragonDescription = DragonInformationController.getDescription();
	private String dragonIconLocation = DragonInformationController.getIcon();
	private String dragonArtLocation = DragonInformationController.getArt();
	
	
	private JFrame infoFrame;
	
	//all components to be added to the JPanel totalPanel
	private JPanel totalPanel;
	private JLabel nameLabel;
	private JLabel descriptionLabel;
	private JButton closeButton;
	private ImageIcon icon;
	
	//constructor
	public DragonInformationView()
	{
		
		//creating a frame
		infoFrame = new JFrame("Dragonspire Tournament--" + dragonName + " Information");
		
		//initializing images
		icon = DragonInformationController.createIcon(dragonIconLocation, dragonName);
		
		//initializing the J elements
		totalPanel = new JPanel(new BorderLayout());
		nameLabel = new JLabel("<html><h1 style='font-size:25px; color: red; padding: 10px'>"+dragonName+"</h1></html>", JLabel.CENTER);
		descriptionLabel = new JLabel("<html><p style='font-size:14px; color: grey; padding: 10px'>"+dragonDescription+"</p></html>");
		
		//adding the J elements to the total panel
		totalPanel.add(nameLabel, BorderLayout.NORTH);
		totalPanel.add(descriptionLabel, BorderLayout.SOUTH);

		
		//adds functionality to the button

		//frame stuff
		infoFrame.getContentPane().add(totalPanel);
		infoFrame.setSize(500, 500);
		infoFrame.setVisible(true);
	}
	
}
