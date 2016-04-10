package dragonspiretournament.match;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Army;

public class Match {
	
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
	public MatchModel(Player playerOne, Player playerTwo, Army playerOneArmy, Army playerTwoArmy, Dice playerOneDice, Dice playerTwoDice){
		this.playerOne = playerOne;
		this.playerTwo = playerTwo;
		this.playerOneArmy = playerOneArmy;
		this.playerTwoArmy = playerTwoArmy;
		this.playerOneDice = playerOneDice;
		this.playerTwoDice = playerTwoDice;
	}
}
