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

    /**
     * Creates Dragon with default damage and multiplier with no status effect
     * 
     * @param dragonName Name of the dragon
     * @param dragonType Type of the dragon
     * @param typeStrong Type that the dragon is strong against
     * @param dragonIcon File location of the dragon's image
     */

    public Dragon(String dragonName, String dragonType, String typeStrong, String dragonIcon) {
        name = dragonName;
        damage = DEFAULT_DAMAGE;
        multiplier = DEFAULT_MULTIPLIER;
        type = dragonType;
        strength = typeStrong;
        statEffect = "none";
        icon = dragonIcon;
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
     */

    public Dragon(String dragonName, int dragonDamage, double damageMultiplier, String dragonType, String typeStrong, String dragonIcon) {
        name = dragonName;
        damage = dragonDamage;
        multiplier = damageMultiplier;
        type = dragonType;
        strength = typeStrong;
        statEffect = "none";
        icon = dragonIcon;
    }

    /**
     * Creates Dragon with default damage and multiplier
     * 
     * @param dragonName    Name of the dragon
     * @param dragonType    Type of the dragon
     * @param typeStrong    Type that the dragon is strong against
     * @param dragonEffect  Status effect inflicted by the dragon
     * @param dragonIcon    File location of the dragon's image
     */

    public Dragon(String dragonName, String dragonType, String typeStrong, String dragonEffect, String dragonIcon) {
        name = dragonName;
        damage = DEFAULT_DAMAGE;
        multiplier = DEFAULT_MULTIPLIER;
        type = dragonType;
        strength = typeStrong;
        statEffect = dragonEffect;
        icon = dragonIcon;
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
     */

    public Dragon(String dragonName, int dragonDamage, double damageMultiplier, String dragonType, String typeStrong, String statusEffect, String dragonIcon) {
        name = dragonName;
        damage = dragonDamage;
        multiplier = damageMultiplier;
        type = dragonType;
        strength = typeStrong;
        statEffect = statusEffect;
        icon = dragonIcon;
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
}