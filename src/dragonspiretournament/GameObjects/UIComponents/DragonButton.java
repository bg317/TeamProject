package dragonspiretournament.GameObjects.UIComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ToolTipManager;

import dragonspiretournament.GameObjects.Dragons.Dragon;

public class DragonButton extends JButton{
	
	Dragon associatedDragon;
	
	public DragonButton(Dragon dragon) {
		super(new ImageIcon( dragon.getIcon() ));	
		associatedDragon = dragon;
		this.setOpaque(false);
		this.setContentAreaFilled(false);
		this.setBorderPainted(false);
		
		ToolTipManager.sharedInstance().setInitialDelay(10);
        ToolTipManager.sharedInstance().setDismissDelay(60000);
		this.setToolTipText(associatedDragon.getName());
	}
	
	public DragonButton(String label) {
		super(label);
		ToolTipManager.sharedInstance().setInitialDelay(10);
        ToolTipManager.sharedInstance().setDismissDelay(60000);
		this.setToolTipText(label);
	}

	public DragonButton() {
		super();
		ToolTipManager.sharedInstance().setInitialDelay(10);
        ToolTipManager.sharedInstance().setDismissDelay(60000);
		this.setToolTipText("no dragon");
	}

	public Dragon getAssociatedDragon() {
		return associatedDragon;
	}

	public void setAssociatedDragon(Dragon associatedDragon) {
		this.associatedDragon = associatedDragon;
		this.setIcon( new ImageIcon( associatedDragon.getIcon() ));
	}

	
	
}
