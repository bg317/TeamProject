package dragonspiretournament.GameObjects.UIComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ToolTipManager;

import dragonspiretournament.GameObjects.Dragons.Dragon;

public class DragonButton extends JButton implements ActionListener {
	
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
	}

	public DragonButton() {
		super();
	}

	public Dragon getAssociatedDragon() {
		return associatedDragon;
	}

	public void setAssociatedDragon(Dragon associatedDragon) {
		this.associatedDragon = associatedDragon;
		this.setIcon( new ImageIcon( associatedDragon.getIcon() ));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//By default? Nothing.
		ToolTipManager.sharedInstance().setInitialDelay(10);
        ToolTipManager.sharedInstance().setDismissDelay(60000);
		((JComponent) e.getSource()).setToolTipText("test");
		System.out.println("You just invoked a dragon button event: " + e.toString());
		System.out.println("   " + e.getSource().toString());
	}
	
	
}
