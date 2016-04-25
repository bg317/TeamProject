package dragonspiretournament.match;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Army;

/**
 * The Class MatchModel.
 */
public class MatchModel {
	
	/** The player one. */
	private Player playerOne;
	
	/** The player two. */
	private Player playerTwo;
	
	/** The player one army. */
	private Army playerOneArmy;
	
	/** The player two army. */
	private Army playerTwoArmy;
	
	/** The player one dice. */
	private Dice playerOneDice;
	
	/** The player two dice. */
	private Dice playerTwoDice;
	
	/** The current dice selection. */
	private Dice currentDiceSelection;
	
	/** The player one last action. */
	private String playerOneLastAction;
	
	/** The player two last action. */
	private String playerTwoLastAction;
	
	/** The player one last dragon. */
	private Dragon playerOneLastDragon;
	
	/** The player two last dragon. */
	private Dragon playerTwoLastDragon;
	
	/** The dragon being added to dice. */
	private Dragon dragonBeingAddedToDice;
	
	/** The dragon being removed from dice. */
	private Dragon dragonBeingRemovedFromDice;
	
	/** The player one health. */
	private int playerOneHealth;
	
	/** The player two health. */
	private int playerTwoHealth;
	
	/** The player one last damage recv. */
	private int playerOneLastDamageRecv;
	
	/** The player two last damage recv. */
	private int playerTwoLastDamageRecv;
	
	
	/** The draw. */
	private boolean draw;
	
	/** The match over. */
	private boolean matchOver;
	
	/** The winner. */
	private Player winner;
	
	
	/**
	 * Gets the player one last action.
	 *
	 * @return the player one last action
	 */
	public String getPlayerOneLastAction() {
		return playerOneLastAction;
	}
	
	
	
	/**
	 * MatchModel - Constructor to create a MatchModel.
	 *
	 * @param playerOne Player that is the first player
	 * @param playerTwo Player that is the second player
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
		this.matchOver = false;
	}
	
	/**
	 * Instantiates a new match model.
	 */
	public MatchModel() {
		this.playerOne = new Player();
		this.playerTwo = new Player();
		this.playerOneArmy = new Army();
		this.playerTwoArmy = new Army();
		this.playerOneDice = new Dice();
		this.playerTwoDice = new Dice();
		this.currentDiceSelection = new Dice();
		this.matchOver = false;
	}

	/**
	 * Gets the player one.
	 *
	 * @return the player one
	 */
	public Player getPlayerOne() {
		return playerOne;
	}

	/**
	 * Sets the player one.
	 *
	 * @param playerOne the new player one
	 */
	public void setPlayerOne(Player playerOne) {
		this.playerOne = playerOne;
	}

	/**
	 * Gets the player two.
	 *
	 * @return the player two
	 */
	public Player getPlayerTwo() {
		return playerTwo;
	}

	/**
	 * Sets the player two.
	 *
	 * @param playerTwo the new player two
	 */
	public void setPlayerTwo(Player playerTwo) {
		this.playerTwo = playerTwo;
	}

	/**
	 * Gets the player one army.
	 *
	 * @return the player one army
	 */
	public Army getPlayerOneArmy() {
		return playerOneArmy;
	}

	/**
	 * Sets the player one army.
	 *
	 * @param playerOneArmy the new player one army
	 */
	public void setPlayerOneArmy(Army playerOneArmy) {
		this.playerOneArmy = playerOneArmy;
	}

	/**
	 * Gets the player two army.
	 *
	 * @return the player two army
	 */
	public Army getPlayerTwoArmy() {
		return playerTwoArmy;
	}

	/**
	 * Sets the player two army.
	 *
	 * @param playerTwoArmy the new player two army
	 */
	public void setPlayerTwoArmy(Army playerTwoArmy) {
		this.playerTwoArmy = playerTwoArmy;
	}

	/**
	 * Gets the player one dice.
	 *
	 * @return the player one dice
	 */
	public Dice getPlayerOneDice() {
		return playerOne.getDice();
	}

	/**
	 * Sets the player one dice.
	 *
	 * @param playerOneDice the new player one dice
	 */
	public void setPlayerOneDice(Dice playerOneDice) {
		this.playerOneDice = playerOneDice;
	}

	/**
	 * Gets the player two dice.
	 *
	 * @return the player two dice
	 */
	public Dice getPlayerTwoDice() {
		return playerTwo.getDice();
	}

	/**
	 * Sets the player two dice.
	 *
	 * @param playerTwoDice the new player two dice
	 */
	public void setPlayerTwoDice(Dice playerTwoDice) {
		this.playerTwoDice = playerTwoDice;
	}
	
	/**
	 * Sets the player one last action.
	 *
	 * @param playerOneLastAction the new player one last action
	 */
	public void setPlayerOneLastAction(String playerOneLastAction) {
		this.playerOneLastAction = playerOneLastAction;
	}

	/**
	 * Gets the player two last action.
	 *
	 * @return the player two last action
	 */
	public String getPlayerTwoLastAction() {
		return playerTwoLastAction;
	}

	/**
	 * Sets the player two last action.
	 *
	 * @param playerTwoLastAction the new player two last action
	 */
	public void setPlayerTwoLastAction(String playerTwoLastAction) {
		this.playerTwoLastAction = playerTwoLastAction;
	}

	/**
	 * Gets the player one last dragon.
	 *
	 * @return the player one last dragon
	 */
	public Dragon getPlayerOneLastDragon() {
		return playerOneLastDragon;
	}

	/**
	 * Sets the player one last dragon.
	 *
	 * @param playerOneLastDragon the new player one last dragon
	 */
	public void setPlayerOneLastDragon(Dragon playerOneLastDragon) {
		this.playerOneLastDragon = playerOneLastDragon;
	}

	/**
	 * Gets the player two last dragon.
	 *
	 * @return the player two last dragon
	 */
	public Dragon getPlayerTwoLastDragon() {
		return playerTwoLastDragon;
	}

	/**
	 * Sets the player two last dragon.
	 *
	 * @param playerTwoLastDragon the new player two last dragon
	 */
	public void setPlayerTwoLastDragon(Dragon playerTwoLastDragon) {
		this.playerTwoLastDragon = playerTwoLastDragon;
	}

	/**
	 * Gets the current dice selection.
	 *
	 * @return the current dice selection
	 */
	public Dice getCurrentDiceSelection() {
		return currentDiceSelection;
	}

	/**
	 * Sets the current dice selection.
	 *
	 * @param currentDiceSelection the new current dice selection
	 */
	public void setCurrentDiceSelection(Dice currentDiceSelection) {
		this.currentDiceSelection = currentDiceSelection;
	}

	/**
	 * Gets the dragon being added to dice.
	 *
	 * @return the dragon being added to dice
	 */
	public Dragon getDragonBeingAddedToDice() {
		return dragonBeingAddedToDice;
	}

	/**
	 * Sets the dragon being added to dice.
	 *
	 * @param dragonBeingAddedToDice the new dragon being added to dice
	 */
	public void setDragonBeingAddedToDice(Dragon dragonBeingAddedToDice) {
		this.dragonBeingAddedToDice = dragonBeingAddedToDice;
	}

	/**
	 * Gets the dragon being removed from dice.
	 *
	 * @return the dragon being removed from dice
	 */
	public Dragon getDragonBeingRemovedFromDice() {
		return dragonBeingRemovedFromDice;
	}

	/**
	 * Sets the dragon being removed from dice.
	 *
	 * @param dragonBeingRemovedFromDice the new dragon being removed from dice
	 */
	public void setDragonBeingRemovedFromDice(Dragon dragonBeingRemovedFromDice) {
		this.dragonBeingRemovedFromDice = dragonBeingRemovedFromDice;
	}

	/**
	 * Gets the player one health.
	 *
	 * @return the player one health
	 */
	public int getPlayerOneHealth() {
		return playerOne.getStrongholdHP();
	}

	/**
	 * Sets the player one health.
	 *
	 * @param playerOneHealth the new player one health
	 */
	public void setPlayerOneHealth(int playerOneHealth) {
		this.playerOneHealth = playerOneHealth;
	}

	/**
	 * Gets the player two health.
	 *
	 * @return the player two health
	 */
	public int getPlayerTwoHealth() {
		return playerTwo.getStrongholdHP();
	}

	/**
	 * Sets the player two health.
	 *
	 * @param playerTwoHealth the new player two health
	 */
	public void setPlayerTwoHealth(int playerTwoHealth) {
		this.playerTwoHealth = playerTwoHealth;
	}



	/**
	 * Sets the draw.
	 *
	 * @param b the new draw
	 */
	public void setDraw(boolean b) {
		this.draw = b;
	}



	/**
	 * Sets the match over.
	 *
	 * @param b the new match over
	 */
	public void setMatchOver(boolean b) {
		this.matchOver = b;
	}



	/**
	 * Sets the winner.
	 *
	 * @param player the new winner
	 */
	public void setWinner( Player player ) {
		this.winner = player;
	}



	/**
	 * Checks if is draw.
	 *
	 * @return true, if is draw
	 */
	public boolean isDraw() {
		return draw;
	}



	/**
	 * Checks if is match over.
	 *
	 * @return true, if is match over
	 */
	public boolean isMatchOver() {
		return matchOver;
	}



	/**
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public Player getWinner() {
		return winner;
	}
	
	
	
}
