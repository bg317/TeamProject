package dragonspiretournament.GameObjects.UIComponents;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dragonspiretournament.GameObjects.Dragons.Dragon;

public class DragonButton extends JButton {
	
	Dragon associatedDragon;
	
	public DragonButton(Dragon dragon) {
		super(new ImageIcon( dragon.getIcon() ));	
		associatedDragon = dragon;
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
	}

	public Dragon getAssociatedDragon() {
		return associatedDragon;
	}

	public void setAssociatedDragon(Dragon associatedDragon) {
		this.associatedDragon = associatedDragon;
	}
	
}
