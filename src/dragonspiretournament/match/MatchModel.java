package dragonspiretournament.match;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Army;

public class MatchModel {
	
	private Player playerOne;
	private Player playerTwo;
	
	private Army playerOneArmy;
	private Army playerTwoArmy;
	
	private Dice playerOneDice;
	private Dice playerTwoDice;
	private Dice currentDiceSelection;
	
	private String playerOneLastAction;
	private String playerTwoLastAction;
	
	private Dragon playerOneLastDragon;
	private Dragon playerTwoLastDragon;
	
	private Dragon dragonBeingAddedToDice;
	private Dragon dragonBeingRemovedFromDice;
	
	private int playerOneHealth;
	private int playerTwoHealth;
	private int playerOneLastDamageRecv;
	private int playerTwoLastDamageRecv;
	
	
	public String getPlayerOneLastAction() {
		return playerOneLastAction;
	}
	
	
	
	/**
	 * MatchModel - Constructor to create a MatchModel
	 * 
	 * @param playerOne Player that is the first player
	 * @param playerTwo Player that is the second player
	 * @param PlayerOneArmy Army of playerOne
	 * @param PlayerTwoArmy Army of playerTwo
	 * @param playerOneDice Dice of playerOne
	 * @param playerTwoDice Dice of playerTwo
	 */
	public MatchModel(Player playerOne, Player playerTwo ){
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.playerOneArmy = playerOne.getArmy();
		this.playerTwoArmy = playerTwo.getArmy();
		this.playerOneDice = playerOne.getDice();
		this.playerTwoDice = playerTwo.getDice();
		this.playerOneHealth = playerOne.getStrongholdHP();
		this.playerTwoHealth = playerTwo.getStrongholdHP();
		this.currentDiceSelection = new Dice();
		this.playerOneLastAction = "No dice has been rolled yet";
		this.playerTwoLastAction = "No dice has been rolled yet";
	}
	
	public MatchModel() {
		this.playerOne = new Player();
		this.playerTwo = new Player();
		this.playerOneArmy = new Army();
		this.playerTwoArmy = new Army();
		this.playerOneDice = new Dice();
		this.playerTwoDice = new Dice();
		this.currentDiceSelection = new Dice();
	}

	public Player getPlayerOne() {
		return playerOne;
	}

	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	public Player getPlayerTwo() {
		return playerTwo;
	}

	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	public Army getPlayerOneArmy() {
		return playerOneArmy;
	}

	public void setPlayerOneArmy(Army playerOneArmy) {
		this.playerOneArmy = playerOneArmy;
	}

	public Army getPlayerTwoArmy() {
		return playerTwoArmy;
	}

	public void setPlayerTwoArmy(Army playerTwoArmy) {
		this.playerTwoArmy = playerTwoArmy;
	}

	public Dice getPlayerOneDice() {
		return playerOne.getDice();
	}

	public void setPlayerOneDice(Dice playerOneDice) {
		this.playerOneDice = playerOneDice;
	}

	public Dice getPlayerTwoDice() {
		return playerTwo.getDice();
	}

	public void setPlayerTwoDice(Dice playerTwoDice) {
		this.playerTwoDice = playerTwoDice;
	}
	
	public void setPlayerOneLastAction(String playerOneLastAction) {
		this.playerOneLastAction = playerOneLastAction;
	}

	public String getPlayerTwoLastAction() {
		return playerTwoLastAction;
	}

	public void setPlayerTwoLastAction(String playerTwoLastAction) {
		this.playerTwoLastAction = playerTwoLastAction;
	}

	public Dragon getPlayerOneLastDragon() {
		return playerOneLastDragon;
	}

	public void setPlayerOneLastDragon(Dragon playerOneLastDragon) {
		this.playerOneLastDragon = playerOneLastDragon;
	}

	public Dragon getPlayerTwoLastDragon() {
		return playerTwoLastDragon;
	}

	public void setPlayerTwoLastDragon(Dragon playerTwoLastDragon) {
		this.playerTwoLastDragon = playerTwoLastDragon;
	}

	public Dice getCurrentDiceSelection() {
		return currentDiceSelection;
	}

	public void setCurrentDiceSelection(Dice currentDiceSelection) {
		this.currentDiceSelection = currentDiceSelection;
	}

	public Dragon getDragonBeingAddedToDice() {
		return dragonBeingAddedToDice;
	}

	public void setDragonBeingAddedToDice(Dragon dragonBeingAddedToDice) {
		this.dragonBeingAddedToDice = dragonBeingAddedToDice;
	}

	public Dragon getDragonBeingRemovedFromDice() {
		return dragonBeingRemovedFromDice;
	}

	public void setDragonBeingRemovedFromDice(Dragon dragonBeingRemovedFromDice) {
		this.dragonBeingRemovedFromDice = dragonBeingRemovedFromDice;
	}

	public int getPlayerOneHealth() {
		return playerOne.getStrongholdHP();
	}

	public void setPlayerOneHealth(int playerOneHealth) {
		this.playerOneHealth = playerOneHealth;
	}

	public int getPlayerTwoHealth() {
		return playerTwo.getStrongholdHP();
	}

	public void setPlayerTwoHealth(int playerTwoHealth) {
		this.playerTwoHealth = playerTwoHealth;
	}
	
}
