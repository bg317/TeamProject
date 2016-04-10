package dragonspiretournament.match;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Army;

public class MatchModel {
	
	private Player playerOne;
	private Player playerTwo;
	private Army playerOneArmy;
	private Army playerTwoArmy;
	private Dice playerOneDice;
	private Dice playerTwoDice;
	
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
		return playerOneDice;
	}

	public void setPlayerOneDice(Dice playerOneDice) {
		this.playerOneDice = playerOneDice;
	}

	public Dice getPlayerTwoDice() {
		return playerTwoDice;
	}

	public void setPlayerTwoDice(Dice playerTwoDice) {
		this.playerTwoDice = playerTwoDice;
	}

	public MatchModel() {
		this.playerOne = new Player();
		this.playerTwo = new Player();
		this.playerOneArmy = new Army();
		this.playerTwoArmy = new Army();
		this.playerOneDice = new Dice();
		this.playerTwoDice = new Dice();
	}
	
	
}
