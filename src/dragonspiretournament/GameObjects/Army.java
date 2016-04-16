package dragonspiretournament.GameObjects;

import java.util.ArrayList;
import dragonspiretournament.GameObjects.Dragons.*;

/**
 * Class to dragon army data.
 *
 * @author Team 29 (LA)
 * @version Apr 10, 2016
 */

public class Army {
    
    /** ArrayList of Dragons that make up the army. */
    private ArrayList<Dragon> army;

    /** The Constant MAX_ARMY_SIZE*/
    private static final int MAX_ARMY_SIZE = 12;

    /**
     * Creates an empty army.
     */

    public Army() {
        army = new ArrayList<Dragon>();
    }

    /**
     * getSize - Returns a count of the number of dragons in the army.
     *
     * @return number of dragons in army
     */


    public int getSize() {
        return army.size();
    }

    /**
     * getDragon - returns the Dragon at a specified point in the army.
     *
     * @param index the index
     * @return dragon at the position requested
     */

    public Dragon getDragon(int index) {
        return army.get(index);
    }

    /**
     * getArmy - returns the entire dragon army.
     *
     * @return ArrayList containing all of the dragons in the army
     */

    public ArrayList<Dragon> getArmy() {
        return army;
    }

    /**
     * add - Adds a dragon to the last army position.
     *       If 
     * 
     * @param newDragon Dragon to be added
     */

    public void add(Dragon newDragon) {
        if(army.size() < MAX_ARMY_SIZE)
            army.add(newDragon);
    }

    /**
     * remove - Removes a dragon from the army,
     *          All dragons move up one position in the army.
     *
     * @param index Location of the dragon
     */

    public void remove(int index) {
        army.remove(index);
    }

    /**
     * clearArmy - Removes all dragons from the army.
     */

    public void clearArmy() {
        army.clear();
    }
    
    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    public String toString() { 
	    String retString = "";
	    for (int index = 0; index < army.size(); index++)
	    	retString += army.get(index).toString() + " ";
    	return retString;
	} 
    
}