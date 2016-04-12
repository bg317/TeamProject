package dragonspiretournament.GameObjects.UIComponents;

import javax.swing.ImageIcon;
import javax.swing.JButton;


//a version of dragon button that does not require the dragon to be passed in, rather, just the 
//path of the image for more generic use
public class ImageButton extends JButton {
	
	public ImageButton(String imagePath) {
		super(new ImageIcon( imagePath ));	
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
	}
	
}
