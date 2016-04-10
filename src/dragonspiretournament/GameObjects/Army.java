package dragonspiretournament.GameObjects;

import java.util.ArrayList;
import dragonspiretournament.GameObjects.Dragons.*;

/**
 * Class to dragon army data
 *
 * @author Team 29 (LA)
 * 
 * @version Apr 10, 2016
 */

class Army {
    private ArrayList<Dragon> army;

    /**
     * Creates an empty army.
     * 
     * @param none
     */

    public Army() {
        army = new ArrayList<Dragon>();
    }

    /**
     * getSize - Returns a count of the number of dragons in the army
     * 
     * @param none
     * 
     * @return number of dragons in army
     */


    public int getSize() {
        return army.size();
    }

    /**
     * getDragon - returns the Dragon at a specified point in the army
     * 
     * @param  index Position in the army
     * 
     * @return dragon at the position requested
     */

    public Dragon getDragon(int index) {
        return army.get(index);
    }

    /**
     * getArmy - returns the entire dragon army
     * 
     * @param  none
     * 
     * @return ArrayList containing all of the dragons in the army
     */

    public ArrayList<Dragon> getArmy() {
        return army;
    }

    /**
     * add - Adds a dragon to the last army position.
     * 
     * @param newDragon Dragon to be added
     */

    public void add(Dragon newDragon) {
        army.add(newDragon);
    }

    /**
     * remove - Removes a dragon from the army,
     *          All dragons move up one position in the army
     * 
     * @param index Location of the dragon
     */

    public void remove(int index) {
        army.remove(index);
    }

    /**
     * clearArmy - Removes all dragons from the army
     * 
     * @param none
     */

    public void clearArmy() {
        army.clear();
    }
}