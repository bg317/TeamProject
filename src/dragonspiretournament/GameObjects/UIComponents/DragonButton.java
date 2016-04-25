package dragonspiretournament.GameObjects.UIComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.ToolTipManager;

import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * The Class DragonButton.
 */
public class DragonButton extends JButton{
	
	/** The associated dragon. */
	Dragon associatedDragon;
	
	/**
	 * Instantiates a new dragon button.
	 *
	 * @param dragon the dragon
	 */
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
	
	/**
	 * Instantiates a new dragon button.
	 *
	 * @param label the label
	 */
	public DragonButton(String label) {
		super(label);
		ToolTipManager.sharedInstance().setInitialDelay(10);
        ToolTipManager.sharedInstance().setDismissDelay(60000);
		this.setToolTipText(label);
	}

	/**
	 * Instantiates a new dragon button.
	 */
	public DragonButton() {
		super();
		ToolTipManager.sharedInstance().setInitialDelay(10);
        ToolTipManager.sharedInstance().setDismissDelay(60000);
		this.setToolTipText("no dragon");
	}

	/**
	 * Gets the associated dragon.
	 *
	 * @return the associated dragon
	 */
	public Dragon getAssociatedDragon() {
		return associatedDragon;
	}

	/**
	 * Sets the associated dragon.
	 *
	 * @param associatedDragon the new associated dragon
	 */
	public void setAssociatedDragon(Dragon associatedDragon) {
		this.associatedDragon = associatedDragon;
		this.setIcon( new ImageIcon( associatedDragon.getIcon() ));
		ToolTipManager.sharedInstance().setInitialDelay(10);
        ToolTipManager.sharedInstance().setDismissDelay(60000);
		this.setToolTipText(associatedDragon.getName());
	}

	
	
}
