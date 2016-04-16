package dragonspiretournament.match;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import java.util.Random;

/**
 * class to control the match screen.
 *
 * @author Team29 (CD)
 * @version April, 10 2016
 */

public class MatchController {
	
	/**
	 * doDragonAttack - calculates the damage done by attacking dragon
	 * 					and updates the enemy player's health.
	 *
	 * @param defender Player that is being attacked
	 * @param attacker dragon that the attacking player is using
	 * @param defending dragon that the defending player is using
	 */
	
	public static void doDragonAttack(Player defender, Dragon attacker, Dragon defending) {
		
		int damage;
		damage = attacker.attack(defending.getType());
		updatePlayerStrongholdHP(defender, damage);
		
	}
	
	/**
	 * updatePlayersStrongholdHP - Updates a players health.
	 *
	 * @param player Player that health needs to be changed
	 * @param damage the damage that is being done to a player
	 */
	
	public static void updatePlayerStrongholdHP(Player player, int damage ) {
		player.setStrongholdHP(player.getStrongholdHP() - damage);
		player.setLastDamage( damage );
	}
	
	
	/**
	 * updatePlayerDice - gets the new selected dragon for a player and 
	 *                      adds that dragon to the player's dice.
	 *
	 * @param player Player that is selecting the dragon
	 * @param selected Dragon that is being added to the dice
	 */
	
	public static void updatePlayerDice(Player player, Dragon selected) {
		Dice tempDice = player.getDice();
		
		tempDice.add(selected);
		player.setDice(tempDice);
	}
	
	/**
	 * diceRoll - after players dice are selected will roll the dice and 
	 *              determine the appropriate actions.
	 *
	 * @param matchModel the match model
	 */
	
	public static void diceRoll( MatchModel matchModel ){
		Player playerOne = matchModel.getPlayerOne();
		Player playerTwo = matchModel.getPlayerTwo();
		
		int playerOneRoll;
		int playerTwoRoll;
		Dragon playerOneDrag;
		Dragon playerTwoDrag;
		Dice playerOneDice = playerOne.getDice();
		Dice playerTwoDice = playerTwo.getDice();
		Random rand = new Random();
		
		playerOneRoll = rand.nextInt(playerOneDice.getFaceCount());
		playerTwoRoll = rand.nextInt(playerTwoDice.getFaceCount());
		
		playerOneDrag = playerOneDice.getFace(playerOneRoll);
		playerTwoDrag = playerTwoDice.getFace(playerTwoRoll);
		
		updatePlayerLastDragon( playerOne, playerTwoDrag );
		updatePlayerLastDragon( playerTwo, playerOneDrag );
		
		doDragonAttack( playerTwo, playerOneDrag, playerTwoDrag );
		doDragonAttack( playerOne, playerTwoDrag, playerOneDrag );
		
		updateRollActionText( matchModel );
		updateRollActionDragon( matchModel );
		
		checkIfWin( playerOne, playerTwo, matchModel );
	}
	
	/**
	 * Check if win.
	 *
	 * @param playerOne the player one
	 * @param playerTwo the player two
	 * @param matchModel the match model
	 */
	public static void checkIfWin( Player playerOne, Player playerTwo, MatchModel matchModel ) {
		int playerOneHP = playerOne.getStrongholdHP();
		int playerTwoHP = playerTwo.getStrongholdHP();
		
		if ( playerOneHP < 1  && playerTwoHP < 1 ) { 
			matchModel.setDraw( true );
			matchModel.setMatchOver( true );
		} else if ( playerOneHP < 1 && playerTwoHP > 1 ) {
			matchModel.setMatchOver( true );
			matchModel.setWinner( playerTwo );
		} else if ( playerTwoHP < 1 && playerOneHP > 1 ) {
			matchModel.setMatchOver( true );
			matchModel.setWinner( playerOne );
		}
	}
	
	/**
	 * Update player last dragon.
	 *
	 * @param player the player
	 * @param dragon the dragon
	 */
	public static void updatePlayerLastDragon( Player player, Dragon dragon ) {
		player.setLastDragon( dragon );
	}
	
	/**
	 * Update roll action text.
	 *
	 * @param matchModel the match model
	 */
	public static void updateRollActionText( MatchModel matchModel ) {
		String playerOneActionText;
		String playerTwoActionText;
		Player playerOne = matchModel.getPlayerOne();
		Player playerTwo = matchModel.getPlayerTwo();
		
		Dragon oneLast = playerOne.getLastDragon();
		Dragon twoLast = playerTwo.getLastDragon();
		
		String oneDragonName = oneLast.getName();
		String twoDragonName = twoLast.getName();
		
		playerOneActionText = "Dragon: " + oneDragonName + " Damage: " + playerOne.getLastDamage();
		playerTwoActionText = "Dragon: " + twoDragonName + " Damage: " + playerTwo.getLastDamage();
		
		matchModel.setPlayerOneLastAction( playerOneActionText );
		matchModel.setPlayerTwoLastAction( playerTwoActionText );
			
	}
	
	/**
	 * Update roll action dragon.
	 *
	 * @param matchModel the match model
	 */
	public static void updateRollActionDragon( MatchModel matchModel ) {
		Player playerOne = matchModel.getPlayerOne();
		Player playerTwo = matchModel.getPlayerTwo();
		
		Dragon oneLast = playerOne.getLastDragon();
		Dragon twoLast = playerTwo.getLastDragon();
		
		matchModel.setPlayerOneLastDragon( oneLast );
		matchModel.setPlayerTwoLastDragon( twoLast );
	}
	
	/**
	 * Adds the to dice selection.
	 *
	 * @param matchModel the match model
	 * @param addedDragon the added dragon
	 */
	public static void addToDiceSelection( MatchModel matchModel, Dragon addedDragon ) {
		Dice currentDice = matchModel.getCurrentDiceSelection();
		currentDice.add( addedDragon );
	}
	
	/**
	 * Clear dice selection.
	 *
	 * @param matchModel the match model
	 */
	public static void clearDiceSelection( MatchModel matchModel ) {
		matchModel.getCurrentDiceSelection().clearDice();
	}

	/**
	 * Update dragon to add.
	 *
	 * @param matchModel the match model
	 * @param currentDrag the current drag
	 */
	public static void updateDragonToAdd( MatchModel matchModel, Dragon currentDrag ) {
		matchModel.setDragonBeingAddedToDice( currentDrag );
	}
	
	/**
	 * Update dragon to delete.
	 *
	 * @param matchModel the match model
	 * @param currentDrag the current drag
	 */
	public static void updateDragonToDelete( MatchModel matchModel, Dragon currentDrag ) {
		matchModel.setDragonBeingRemovedFromDice( currentDrag );
		
	}

	/**
	 * Removes the from dice selection.
	 *
	 * @param matchModel the match model
	 */
	public static void removeFromDiceSelection( MatchModel matchModel ) {
		Dice selectionDice = matchModel.getCurrentDiceSelection();
		Dragon departingDrag = matchModel.getDragonBeingRemovedFromDice();
		selectionDice.getDice().remove( departingDrag );
	}
	
	/**
	 * Sets the player one dice.
	 *
	 * @param matchModel the new player one dice
	 */
	public static void setPlayerOneDice( MatchModel matchModel ) {
		Dice currentDice = matchModel.getCurrentDiceSelection();
		Player playerOne = matchModel.getPlayerOne();
		playerOne.setDice( currentDice );
	}
	
	/**
	 * Sets the player two dice.
	 *
	 * @param matchModel the new player two dice
	 */
	public static void setPlayerTwoDice( MatchModel matchModel ) {
		Dice selectionDice = matchModel.getCurrentDiceSelection();
		Player playerTwo = matchModel.getPlayerTwo();
		playerTwo.setDice( selectionDice );
	}


}
