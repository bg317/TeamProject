package dragonspiretournament.GameObjects.UIComponents;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import dragonspiretournament.GameObjects.Dragons.Dragon;

public class DragonButton extends JButton {
	public DragonButton(Dragon dragon) {
		super(new ImageIcon( dragon.getIcon() ));		
	}
}
