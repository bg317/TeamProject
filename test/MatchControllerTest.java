/* Match Controller Test
 * makes sure the controller is not broken
 * 
 * @author larry
 * @version 4-14-16
 * 
 */
import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.Dice;
import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.match.MatchController;
import dragonspiretournament.match.MatchModel;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchControllerTest {

	@Test
	//Tests Do Dragon Attack
	public void testDoDragonAttack() {
		Player testPlayer = new Player("testPlayer", new Army());
		Dragon testDrag1 = new DragonLibrary().getDragon(0);
		Dragon testDrag2 = new DragonLibrary().getDragon(1);
		MatchController.doDragonAttack(testPlayer, testDrag1, testDrag2);
		
		assertEquals(testPlayer.getStrongholdHP(), 20);//hard coded to reflect defaults if broken, adjust.
		assertEquals(testPlayer.getLastDamage(), 5);
		
	}

	@Test
	//Tests Update Player Stronghold HP
	public void testUpdatePlayerStrongholdHP() {
		Player testPlayer = new Player("testPlayer", new Army());
		MatchController.updatePlayerStrongholdHP(testPlayer, 10);
		
		assertEquals(testPlayer.getStrongholdHP(), 15);//hard coded to reflect defaults if broken, adjust.
	}

	@Test
	//Tests Update Player Dice
	public void testUpdatePlayerDice() {
		Player testPlayer = new Player("testPlayer", new Army());
		Dragon testDrag1 = new DragonLibrary().getDragon(0);
		
		MatchController.updatePlayerDice(testPlayer, testDrag1);
		
		assertEquals(testPlayer.getDice().getDice().get(0), testDrag1);
	}
	
	/*
	@Test
	public void testDiceRoll() {
		MatchModel testModel = new MatchModel();
		MatchController.diceRoll(testModel);
		
		assertEquals(null, null);
	}

	@Test
	public void testAddToDiceSelection() {
		MatchModel testModel = new MatchModel();
		Dragon testDrag1 = new DragonLibrary().getDragon(0);
		
		MatchController.addToDiceSelection(testModel, testDrag1);//I'm not sure what this is supposed to do
	}
	
	*/

	@Test
	//Tests Update Dragon to Add
	public void testUpdateDragonToAdd() {
		MatchModel testModel = new MatchModel();
		Dragon testDrag1 = new DragonLibrary().getDragon(0);
		MatchController.updateDragonToAdd(testModel, testDrag1);
		
		assertEquals(testModel.getDragonBeingAddedToDice(), testDrag1);
	}

	@Test
	//Tests Update Dragon to Delete
	public void testUpdateDragonToDelete() {
		MatchModel testModel = new MatchModel();
		Dragon testDrag1 = new DragonLibrary().getDragon(0);
		MatchController.updateDragonToDelete(testModel, testDrag1);
		
		assertEquals(testModel.getDragonBeingRemovedFromDice(), testDrag1);
	}

	@Test
	//Tests Remove From Dice Selection
	public void testRemoveFromDiceSelection() {//Not sure what to test Here
		MatchModel testModel = new MatchModel();
		//Dragon testDrag1 = new DragonLibrary().getDragon(0);
		MatchController.removeFromDiceSelection(testModel);
		
		assertEquals(testModel.getDragonBeingRemovedFromDice(), null);
	}

	@Test
	//Tests Player One Dice Setter
	public void testSetPlayerOneDice() {
		Player testPlayer = new Player("test", new Army());
		MatchModel testModel = new MatchModel();
		testModel.setPlayerOne(testPlayer);
		Dice testDice = new Dice(); 
		testModel.setCurrentDiceSelection(testDice);
		MatchController.setPlayerOneDice(testModel);
		
		assertEquals(testModel.getPlayerOne().getDice().getDice(), testDice.getDice());
	}

	@Test
	//Tests Player Two Dice Setter
	public void testSetPlayerTwoDice() {
		Player testPlayer = new Player("test", new Army());
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwo(testPlayer);
		Dice testDice = new Dice(); 
		testModel.setCurrentDiceSelection(testDice);
		MatchController.setPlayerTwoDice(testModel);
		
		assertEquals(testModel.getPlayerTwo().getDice().getDice(), testDice.getDice());
	}

}
