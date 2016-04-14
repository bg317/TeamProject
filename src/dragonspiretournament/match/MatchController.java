package dragonspiretournament.match;

import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import java.util.Random;

/**
 * class to control the match screen
 * 
 * @author Team29 (CD)
 * @version April, 10 2016
 */

public class MatchController {
	
	/**
	 * doDragonAttack - calculates the damage done by attacking dragon
	 * 					and updates the enemy player's health
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
	 * updatePlayersStrongholdHP - Updates a players health
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
	 *                      adds that dragon to the player's dice
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
	 *              determine the appropriate actions
	 * 
	 * @param playerOne first Player that is rolling the dice
	 * @param playerTwo second Player that is rolling the dice
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
		
		updatePlayerLastDragon( playerOne, playerOneDrag );
		updatePlayerLastDragon( playerTwo, playerTwoDrag );
		
		doDragonAttack( playerTwo, playerOneDrag, playerTwoDrag );
		doDragonAttack( playerOne, playerTwoDrag, playerOneDrag );
		
		updateRollActionText( matchModel );
		updateRollActionDragon( matchModel );
	}
	
	public static void updatePlayerLastDragon( Player player, Dragon dragon ) {
		player.setLastDragon( dragon );
	}
	
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
	
	public static void updateRollActionDragon( MatchModel matchModel ) {
		Player playerOne = matchModel.getPlayerOne();
		Player playerTwo = matchModel.getPlayerTwo();
		
		Dragon oneLast = playerOne.getLastDragon();
		Dragon twoLast = playerTwo.getLastDragon();
		
		matchModel.setPlayerOneLastDragon( oneLast );
		matchModel.setPlayerTwoLastDragon( twoLast );
	}
	
	public static void addToDiceSelection( MatchModel matchModel, Dragon addedDragon ) {
		Dice currentDice = matchModel.getCurrentDiceSelection();
		currentDice.add( addedDragon );
	}
	
	public static void clearDiceSelection( MatchModel matchModel ) {
		matchModel.getCurrentDiceSelection().clearDice();
	}

	public static void updateDragonToAdd( MatchModel matchModel, Dragon currentDrag ) {
		matchModel.setDragonBeingAddedToDice( currentDrag );
	}
	
	public static void updateDragonToDelete( MatchModel matchModel, Dragon currentDrag ) {
		matchModel.setDragonBeingRemovedFromDice( currentDrag );
		
	}

	public static void removeFromDiceSelection( MatchModel matchModel ) {
		Dice selectionDice = matchModel.getCurrentDiceSelection();
		Dragon departingDrag = matchModel.getDragonBeingRemovedFromDice();
		selectionDice.getDice().remove( departingDrag );
	}
	
	public static void setPlayerOneDice( MatchModel matchModel ) {
		Dice currentDice = matchModel.getCurrentDiceSelection();
		Player playerOne = matchModel.getPlayerOne();
		playerOne.setDice( currentDice );
	}
	
	public static void setPlayerTwoDice( MatchModel matchModel ) {
		Dice selectionDice = matchModel.getCurrentDiceSelection();
		Player playerTwo = matchModel.getPlayerTwo();
		playerTwo.setDice( selectionDice );
	}


}
