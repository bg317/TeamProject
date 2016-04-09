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
	
	

    private static final int DEFAULT_DAMAGE = 5;
    private static final double DEFAULT_MULTIPLIER = 2.0;

    private int damage;
    private double multiplier;
    private String name;
    private String type;
    private String strength; //Type strong against
    private String statEffect; //Status effect
    private String icon; //Location of the image file

    //Default Dragon constructor
    public Dragon(String dragonName, String dragonType, String typeStrong, String dragonIcon) {
        name = dragonName;
        damage = DEFAULT_DAMAGE;
        multiplier = DEFAULT_MULTIPLIER;
        type = dragonType;
        strength = typeStrong;
        statEffect = "none";
        icon = dragonIcon;
    }

    //Overloaded constructor for specifying damage and multiplier
    public Dragon(String dragonName, int dragonDamage, double damageMultiplier, String dragonType, String typeStrong, String dragonIcon) {
        name = dragonName;
        damage = dragonDamage;
        multiplier = damageMultiplier;
        type = dragonType;
        strength = typeStrong;
        statEffect = "none";
        icon = dragonIcon;
    }

    //Default Dragon constructor with status effects
    public Dragon(String dragonName, String dragonType, String typeStrong, String dragonEffect, String dragonIcon) {
        name = dragonName;
        damage = DEFAULT_DAMAGE;
        multiplier = DEFAULT_MULTIPLIER;
        type = dragonType;
        strength = typeStrong;
        statEffect = dragonEffect;
        icon = dragonIcon;
    }

    //Overloaded constructor for status effects
    public Dragon(String dragonName, int dragonDamage, double damageMultiplier, String dragonType, String typeStrong, String statusEffect, String dragonIcon) {
        name = dragonName;
        damage = dragonDamage;
        multiplier = damageMultiplier;
        type = dragonType;
        strength = typeStrong;
        statEffect = statusEffect;
        icon = dragonIcon;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getStatEffect() {
        return statEffect;
    }

    public String getIcon() {
        return icon;
    }

    public int attack(String otherType) {
        int totalDamage = damage;

        if(strength.equals(otherType))
            totalDamage = (int) (totalDamage * multiplier);

        return totalDamage;
    }
}
