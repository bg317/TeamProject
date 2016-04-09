package dragonspiretournament.GameObjects.Dragons;

import javax.swing.Icon;

// TODO: Auto-generated Javadoc
/**
 * The Class Dragon.
 */
public abstract class Dragon {
	
	/** The dragon name. */
	private String dragonName;
	
	/** The dragon icon. */
	private Icon dragonIcon;
	
	/**
	 * Gets the dragon name.
	 *
	 * @return the dragon name
	 */
	public String getDragonName() {
		return dragonName;
	}
	
	/**
	 * Sets the dragon name.
	 *
	 * @param dragonName the new dragon name
	 */
	public void setDragonName(String dragonName) {
		this.dragonName = dragonName;
	}
	
	/**
	 * Gets the dragon icon.
	 *
	 * @return the dragon icon
	 */
	public Icon getDragonIcon() {
		return dragonIcon;
	}
	
	/**
	 * Sets the dragon icon.
	 *
	 * @param dragonIcon the new dragon icon
	 */
	public void setDragonIcon(Icon dragonIcon) {
		this.dragonIcon = dragonIcon;
	}
	
	

}
