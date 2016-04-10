package dragonspiretournament.GameObjects;

import java.util.ArrayList;
import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * Class to store dice data
 *
 * @author Team 29 (LA)
 * 
 * @version Apr 9, 2016
 */

public class Dice {

    private ArrayList<Dragon> diceFaces;
    private int maxFaces; //Maximum number of faces allowed on dice

    private static final int DEFAULT_MAX = 5;

    /**
     * Creates a dice with no faces. Max number of faces is default
     * 
     * @param none
     */

    public Dice() {
        diceFaces = new ArrayList<Dragon>();
        maxFaces = DEFAULT_MAX;
    }

    /**
     * Creates a dice with no faces. 
     * 
     * @param faces Maximum number of faces on the dice
     */

    public Dice(int faces) {
        diceFaces = new ArrayList<Dragon>();
        maxFaces = faces;
    }

    /**
     * getFace - returns the dragon located at the specified dice face.
     *           If the index is out of bounds, null is returned.
     * 
     * @param  index Location of the dice face
     * 
     * @return Dragon on the dice face
     */

    public Dragon getFace(int index) {
        Dragon tmp;

        if(index < diceFaces.size())
            tmp = diceFaces.get(index);
        else
            tmp = null;
            
        return tmp;
    }

    /**
     * getDice - returns all of the dice faces
     * 
     * @param  none
     * 
     * @return ArrayList containing the dragon on each dice face
     */

    public ArrayList<Dragon> getDice() {
        return diceFaces;
    }

    /**
     * getFaceCount - Returns a count of the number of faces with dragons
     * 
     * @param none
     * 
     * @return number of dice faces with dragons
     */

    public int getFaceCount() {
        return diceFaces.size();
    }

    /**
     * add - Adds a dragon to the last dice face. 
     *       If maximum reached, no faces added.
     * 
     * @param newFace Dragon to be added
     */

    public void add(Dragon newFace) {
        if(diceFaces.size() < maxFaces)
            diceFaces.add(newFace);
    }

    /**
     * remove - Removes a dragon from the dice face,
     *          All dice faces move up one spot
     * 
     * @param index Location of the dice face
     */

    public void remove(int index) {
        diceFaces.remove(index);
    }

    /**
     * clearDice - Removes all dragons from all dice faces
     * 
     * @param none
     */

    public void clearDice() {
        diceFaces.clear();
    }
}