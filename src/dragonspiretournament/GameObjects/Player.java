package dragonspiretournament.GameObjects;

import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * Class to store player data.
 *
 * @author Team 29 (LA)
 * @version Apr 10, 2016
 */

public class Player {

    /** The name of the player. */
    private String name;
    
    /** The army of the player. */
    private Army army;
    
    /** The dice of the player. */
    private Dice dice;
    
    /** The stronghold hp of the player. */
    private int strongholdHP;
    
    /** The last damage dealt by the player. */
    private int lastDamage;
    
    /** The last dragon used by the player. */
    private Dragon lastDragon;

    /** The Constant MAX_HP of the stronghold. */
    private static final int MAX_HP = 25;

    /**
     * Creates a player using a specified name. Default HP is set to MAX_HP
     * 
     * @param playerName Name of player
     */

    public Player(String playerName) {
        name = playerName;
        army = null;
        dice = null;
        strongholdHP = MAX_HP;
        lastDamage = -1;
        lastDragon = null;
    }

    /**
     * Creates a player using a specified name and army.
     *
     * @param playerName  Name of player
     * @param army        Player's army of dragons
     */

    public Player(String playerName, Army army) {
        name = playerName;
        this.army = army;
        dice = new Dice();
        strongholdHP = MAX_HP;
        lastDamage = -1;
        lastDragon = null;
    }

    /**
     * Creates a player using a specified name and HP.
     *
     * @param playerName Name of player
     * @param hitPoints  Number of hit points
     */

    public Player(String playerName, int hitPoints) {
        name = playerName;
        army = null;
        dice = null;
        strongholdHP = hitPoints;
        lastDamage = -1;
        lastDragon = null;
    }
    
    /**
     * Generates an empty player.
     */
    public Player() {
        name = "No Name";
        army = null;
        dice = null;
        strongholdHP = MAX_HP;
        lastDamage = -1;
        lastDragon = null;
	}

	/**
	 * getName - returns the name of the player.
	 *
     * @param  none
	 * @return String of name of player
	 */

    public String getName() {
        return name;
    }

    /**
     * getArmy - returns the current player army.
     *
     * @param  none
     * @return player's army
     */

    public Army getArmy() {
        return army;
    }

    /**
     * getDice - returns the current player dice.
     *
     * @param  none
     * @return player's dice
     */

    public Dice getDice() {
        return dice;
    }

    /**
     * getStrongholdHP - returns the current player's stronghold HP.
     *
     * @param  none
     * @return integer representing stronghold hit points
     */

    public int getStrongholdHP() { 
        return strongholdHP;
    }
    
    /**
     * getLastDamage - returns the last damage dealt to opposing player.
     *
     * @param  none
     * @return integer representing last damage dealt
     */

    public int getLastDamage() {
        return lastDamage;
    }

    /**
     * getLastDragon - returns the dragon last used to deal damage.
     *
     * @param  none
     * @return Dragon last used to deal damage
     */

    public Dragon getLastDragon() {
        return lastDragon;
    }

    /**
     * setName - renames player according to input.
     *
     * @param playerName the new name
     */

    public void setName(String playerName) {
        this.name = playerName;
    }

    /**
     * setArmy - sets the current army.
     *
     * @param playerArmy army to be assigned to player
     */

    public void setArmy(Army playerArmy) {
        this.army = playerArmy;
    }

    /**
     * setDice - sets the current dice.
     *
     * @param playerDice dice to be assigned to player
     */

    public void setDice(Dice playerDice) {
        this.dice = playerDice;
    }

    /**
     * setStrongholdHP - sets the current stronghold's hit points.
     *
     * @param newHP new total hit points
     */

    public void setStrongholdHP(int newHP) { 
        this.strongholdHP = newHP;
    }

    /**
     * setLastDamage - sets the last damage dealt by player.
     *
     * @param newDamage last amount of damage dealt by player to the other player
     */

    public void setLastDamage(int newDamage) {
        lastDamage = newDamage;
    }

    /**
     * setLastDragon - sets the dragon last used by the player.
     *
     * @param newDragon last dragon used
     */

    public void setLastDragon(Dragon newDragon) {
        lastDragon = newDragon;
    }
}
