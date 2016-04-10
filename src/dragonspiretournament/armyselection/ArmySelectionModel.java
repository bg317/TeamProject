package dragonspiretournament.armyselection;

import java.util.ArrayList;

import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;

public class ArmySelectionModel {
	
	private Player player;
	private DragonLibrary dragLib;
	private Dragon current;
	private Dragon prev;
	private Dragon next;
	
	/**
	 * Instantiates a new army selection model.
	 *
	 * @param player the player
	 * @param dragLib the drag lib
	 * @param current the current
	 * @param prev the prev
	 * @param next the next
	 */
	public ArmySelectionModel(Player player, DragonLibrary dragLib) {
		this.player = player;
		this.dragLib = dragLib;
		this.current = current;
		this.prev = prev;
		this.next = next;
		
	}
	
	/**
	 * Instantiates a new army selection model.
	 */
	public ArmySelectionModel() {
		// TODO Auto-generated constructor stub
		dragLib = new DragonLibrary();
		
		ArmySelectionController.initCurrentAndPrev(this);
	}
	

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	public Player getPlayer() {
		return player;
	}
	
	/**
	 * Sets the player.
	 *
	 * @param player the new player
	 */
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public ArrayList<Dragon> getAllLibraryDragons() { 
		return dragLib.getDragonLibrary();
	}
	/**
	 * Gets the drag lib.
	 *
	 * @return the drag lib
	 */
	public DragonLibrary getDragLib() {
		return dragLib;
	}
	
	/**
	 * Sets the drag lib.
	 *
	 * @param dragLib the new drag lib
	 */
	public void setDragLib(DragonLibrary dragLib) {
		this.dragLib = dragLib;
	}
	
	/**
	 * Gets the current.
	 *
	 * @return the current
	 */
	public Dragon getCurrent() {
		return current;
	}
	
	/**
	 * Sets the current.
	 *
	 * @param current the new current
	 */
	public void setCurrent(Dragon current) {
		this.current = current;
	}
	
	/**
	 * Gets the prev.
	 *
	 * @return the prev
	 */
	public Dragon getPrev() {
		return prev;
	}
	
	/**
	 * Sets the prev.
	 *
	 * @param prev the new prev
	 */
	public void setPrev(Dragon prev) {
		this.prev = prev;
	}
	
	/**
	 * Gets the next.
	 *
	 * @return the next
	 */
	public Dragon getNext() {
		return next;
	}
	
	/**
	 * Sets the next.
	 *
	 * @param next the new next
	 */
	public void setNext(Dragon next) {
		this.next = next;
	}
	
	

}
