package dragonspiretournament.GameObjects.Dragons;

/**
 * Class to store data on a Dragon
 *
 * @author Team 29 (LA)
 * 
 * @version Apr 9, 2016
 */

public class Dragon {	

    private static final int DEFAULT_DAMAGE = 5;
    private static final double DEFAULT_MULTIPLIER = 2.0;

    private int damage;
    private double multiplier;
    private String name;
    private String type;
    private String strength; //Type strong against
    private String statEffect; //Status effect
    private String icon; //Location of the image file
    private String description; //Description of dragon

    /**
     * Creates Dragon with default damage and multiplier with no status effect
     * 
     * @param dragonName  Name of the dragon
     * @param dragonType  Type of the dragon
     * @param typeStrong  Type that the dragon is strong against
     * @param dragonIcon  File location of the dragon's image
     * @param description File location of the description of dragon
     */

    public Dragon(String dragonName, String dragonType, String typeStrong, String dragonIcon, String description) {
        name = dragonName;
        damage = DEFAULT_DAMAGE;
        multiplier = DEFAULT_MULTIPLIER;
        type = dragonType;
        strength = typeStrong;
        statEffect = "none";
        icon = dragonIcon;
        this.description = description;
    }

    /**
     * Creates Dragon with no status effect
     * 
     * @param dragonName        Name of the dragon
     * @param dragonDamage      Base damage of the dragon
     * @param damageMultiplier  Multiplier for increased damage
     * @param dragonType        Type of the dragon
     * @param typeStrong        Type that the dragon is strong against
     * @param dragonIcon        File location of the dragon's image
     * @param description       File location of the description of dragon
     */

    public Dragon(String dragonName, int dragonDamage, double damageMultiplier, String dragonType, String typeStrong, String dragonIcon, String description) {
        name = dragonName;
        damage = dragonDamage;
        multiplier = damageMultiplier;
        type = dragonType;
        strength = typeStrong;
        statEffect = "none";
        icon = dragonIcon;
        this.description = description;
    }

    /**
     * Creates Dragon with default damage and multiplier
     * 
     * @param dragonName    Name of the dragon
     * @param dragonType    Type of the dragon
     * @param typeStrong    Type that the dragon is strong against
     * @param dragonEffect  Status effect inflicted by the dragon
     * @param dragonIcon    File location of the dragon's image
     * @param description   File location of the description of dragon
     */

    public Dragon(String dragonName, String dragonType, String typeStrong, String dragonEffect, String dragonIcon, String description) {
        name = dragonName;
        damage = DEFAULT_DAMAGE;
        multiplier = DEFAULT_MULTIPLIER;
        type = dragonType;
        strength = typeStrong;
        statEffect = dragonEffect;
        icon = dragonIcon;
        this.description = description;
    }
    
    public Dragon( Dragon toCopy ) {
    	this.name = toCopy.getName();
    	this.damage = DEFAULT_DAMAGE;
    	this.multiplier = DEFAULT_MULTIPLIER;
    	this.type = toCopy.getType();
    	this.strength = toCopy.getStrength();
    	this.statEffect = toCopy.getStatEffect();
    	this.icon = toCopy.getIcon();
    	this.description = toCopy.getDescription();
    }

    /**
     * Creates Dragon with all fields specified
     * 
     * @param dragonName        Name of the dragon
     * @param dragonDamage      Base damage of the dragon
     * @param damageMultiplier  Multiplier for increased damage
     * @param dragonType        Type of the dragon
     * @param typeStrong        Type that the dragon is strong against
     * @param dragonEffect      Status effect inflicted by the dragon
     * @param dragonIcon        File location of the dragon's image
     * @param description       File location of the description of dragon
     */

    public Dragon(String dragonName, int dragonDamage, double damageMultiplier, String dragonType, String typeStrong, String statusEffect, String dragonIcon, String description) {
        name = dragonName;
        damage = dragonDamage;
        multiplier = damageMultiplier;
        type = dragonType;
        strength = typeStrong;
        statEffect = statusEffect;
        icon = dragonIcon;
        this.description = description;
    }

    /**
     * getName - returns the dragon's name
     * 
     * @param  none
     * 
     * @return name of dragon
     */

    public String getName() {
        return name;
    }

    /**
     * getType - returns the dragon's type
     * 
     * @param  none
     * 
     * @return type of dragon
     */

    public String getType() {
        return type;
    }

    /**
     * getStatEffect - returns the dragon's status effect
     * 
     * @param  none
     * 
     * @return status effect of dragon
     */

    public String getStatEffect() {
        return statEffect;
    }

    /**
     * getIcon - returns the file location of the dragon's icon
     * 
     * @param  none
     * 
     * @return string of icon's location
     */

    public String getIcon() {
        return icon;
    }

    /**
     * getDescription - returns the description of the dragon
     * 
     * @param  none
     * 
     * @return description of the dragon
     */

    public String getDescription() {
        return description;
    }

    /**
     * attack - calculates damage dealt by the dragon,
     *              attack increased by multiplier if dragon is
     *              strong against the type of the other dragon
     * 
     * @param otherType type of the other attacking dragon
     * 
     * @return total damage dealt by the dragon
     */

    public int attack(String otherType) {
        int totalDamage = damage;

        if(strength.equals(otherType))
            totalDamage = (int) (totalDamage * multiplier);

        return totalDamage;
    }

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}
    
	public int getDamage(){
		return damage;
	}
	
	public double getDamageMultiplier(){
		return multiplier;
	}
	
	public String toString() { 
	    return name;
	} 
}