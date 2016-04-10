package dragonspiretournament.GameObjects;

import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * Class to store player data
 *
 * @author Team 29 (LA)
 * 
 * @version Apr 10, 2016
 */

public class Player {

    private String name;
    private Army army;
    private Dice dice;
    private int strongholdHP;
    private int lastDamage;
    private Dragon lastDragon;

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
     * Creates a player using a specified name and HP
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
     * getName - returns the name of the player
     * 
     * @param  none
     * 
     * @return String of name of player
     */

    public String getName() {
        return name;
    }

    /**
     * getArmy - returns the current player army
     * 
     * @param  none
     * 
     * @return player's army
     */

    public Army getArmy() {
        return army;
    }

    /**
     * getDice - returns the current player dice
     * 
     * @param  none
     * 
     * @return player's dice
     */

    public Dice getDice() {
        return dice;
    }

    /**
     * getStrongholdHP - returns the current player's stronghold HP
     * 
     * @param  none
     * 
     * @return integer representing stronghold hit points
     */

    public int getStrongholdHP() { 
        return strongholdHP;
    }
    
    /**
     * getLastDamage - returns the last damage dealt to opposing player
     * 
     * @param  none
     * 
     * @return integer representing last damage dealt
     */

    public int getLastDamage() {
        return lastDamage;
    }

    /**
     * getLastDragon - returns the dragon last used to deal damage
     * 
     * @param  none
     * 
     * @return Dragon last used to deal damage
     */

    public Dragon getLastDragon() {
        return lastDragon;
    }

    /**
     * setName - renames player according to input
     * 
     * @param  playerName new player name
     */

    public void setName(String playerName) {
        name = playerName;
    }

    /**
     * setArmy - sets the current army
     * 
     * @param playerArmy army to be assigned to player
     */

    public void setArmy(Army playerArmy) {
        army = playerArmy;
    }

    /**
     * setDice - sets the current dice
     * 
     * @param playerDice dice to be assigned to player
     */

    public void setDice(Dice playerDice) {
        dice = playerDice;
    }

    /**
     * setStrongholdHP - sets the current stronghold's hit points
     * 
     * @param newHP new total hit points
     */

    public void setStrongholdHP(int newHP) { 
        strongholdHP = newHP;
    }

    /**
     * setLastDamage - sets the last damage dealt by player
     * 
     * @param newDamage last amount of damage dealt by player to the other player
     */

    public void setLastDamage(int newDamage) {
        lastDamage = newDamage;
    }

    /**
     * setLastDragon - sets the dragon last used by the player
     * 
     * @param newDragon last dragon used
     */

    public void setLastDragon(Dragon newDragon) {
        lastDragon = newDragon;
    }
}
