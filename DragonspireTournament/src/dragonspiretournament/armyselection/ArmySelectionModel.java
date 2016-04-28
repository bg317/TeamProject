package dragonspiretournament.armyselection;

import java.util.ArrayList;

import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * The Class ArmySelectionModel.
 */
public class ArmySelectionModel {
	
	/** The player. */
	private Player player;
	
	/** The drag lib. */
	private DragonLibrary dragLib;
	
	/** The current. */
	private Dragon current;
	
	/** The prev. */
	private Dragon prev;
	
	/** The next. */
	private Dragon next;
	
	/** The current player army. */
	private Army currentPlayerArmy;
	
	/** The player name. */
	String playerName;

	
	/**
	 * Gets the current player army.
	 *
	 * @return the current player army
	 */
	public Army getCurrentPlayerArmy() {
		return currentPlayerArmy;
	}

	/**
	 * Sets the current player army.
	 *
	 * @param currentPlayerArmy the new current player army
	 */
	public void setCurrentPlayerArmy(Army currentPlayerArmy) {
		this.currentPlayerArmy = currentPlayerArmy;
	}

	/**
	 * Instantiates a new army selection model.
	 *
	 * @param player the player
	 * @param dragLib the drag lib
	 */
	public ArmySelectionModel(Player player, DragonLibrary dragLib) {
		this.player = player;
		this.playerName = player.getName();
		this.dragLib = dragLib;
		this.current = current;
		this.prev = prev;
		this.next = next;
		this.currentPlayerArmy = new Army();
		
	}
	
	/**
	 * Instantiates a new army selection model.
	 */
	public ArmySelectionModel() {
		// TODO Auto-generated constructor stub
		this.dragLib = new DragonLibrary();
		this.currentPlayerArmy = new Army();
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
	
	/**
	 * Gets the player name.
	 *
	 * @return the player name
	 */
	public String getPlayerName() {
		return playerName;
	}

	/**
	 * Sets the player name.
	 *
	 * @param playerName the new player name
	 */
	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	/**
	 * Gets the all library dragons.
	 *
	 * @return the all library dragons
	 */
	public ArrayList<Dragon> getAllLibraryDragons() { 
		return dragLib.getLibrary();
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
