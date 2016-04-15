/* Match Model
 * makes sure the model's getters and setters work
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
import dragonspiretournament.match.MatchModel;

import static org.junit.Assert.*;

import org.junit.Test;

public class MatchModelTest {

	@Test
	public void testGetPlayerOneLastAction() {
		MatchModel testModel = new MatchModel();
		testModel.setPlayerOneLastAction("Last Action");
		
		assertEquals("Last Action", testModel.getPlayerOneLastAction());
	}

	@Test
	public void testMatchModelPlayerPlayer() {
		Player testPlayer1 = new Player("Name1", new Army());
		Player testPlayer2 = new Player("Name2", new Army());
		MatchModel testModel = new MatchModel(testPlayer1, testPlayer2);
		
		assertNotEquals(testModel, null);
		assertEquals(testModel.getPlayerOne(), testPlayer1);
		assertEquals(testModel.getPlayerTwo(), testPlayer2);
		
	}

	@Test
	public void testMatchModel() {
		MatchModel testModel = new MatchModel();
		
		assertNotEquals(testModel, null);
		assertNotEquals(testModel.getPlayerOne(), null);
		assertNotEquals(testModel.getPlayerTwo(), null);
	}

	@Test
	public void testGetPlayerOne() {
		Player testPlayer1 = new Player("Name1", new Army());
		MatchModel testModel = new MatchModel(testPlayer1, testPlayer1);
		
		assertNotEquals(testModel, null);
		assertEquals(testModel.getPlayerOne(), testPlayer1);
	}

	@Test
	public void testSetPlayerOne() {
		Player testPlayer1 = new Player("Name1", new Army());
		MatchModel testModel = new MatchModel();
		testModel.setPlayerOne(testPlayer1);
		
		assertNotEquals(testModel, null);
		assertEquals(testModel.getPlayerOne(), testPlayer1);
	}

	@Test
	public void testGetPlayerTwo() {
		Player testPlayer1 = new Player("Name1", new Army());
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwo(testPlayer1);
		
		assertNotEquals(testModel, null);
		assertEquals(testModel.getPlayerTwo(), testPlayer1);
	}

	@Test
	public void testSetPlayerTwo() {
		Player testPlayer1 = new Player("Name1", new Army());
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwo(testPlayer1);
		
		assertNotEquals(testModel, null);
		assertEquals(testModel.getPlayerTwo(), testPlayer1);
	}

	@Test
	public void testGetPlayerOneArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		
		MatchModel testModel = new MatchModel();
		testModel.setPlayerOne(testPlayer);
		testModel.setPlayerOneArmy(testArmy);
		
		assertEquals(testModel.getPlayerOneArmy(), testPlayer.getArmy());
	}

	@Test
	public void testSetPlayerOneArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("testname", testArmy);
		
		MatchModel testModel = new MatchModel();
		testModel.setPlayerOne(testPlayer);
		testModel.setPlayerOneArmy(testArmy);
		
		assertEquals(testModel.getPlayerOneArmy(), testPlayer.getArmy());
	}

	@Test
	public void testGetPlayerTwoArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player();
		
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwo(testPlayer);
		testModel.setPlayerTwoArmy(testArmy);
		
		assertEquals(testModel.getPlayerTwoArmy(), testArmy);
	}

	@Test
	public void testSetPlayerTwoArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("hello", testArmy);
		
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwo(testPlayer);
		testModel.setPlayerTwoArmy(testArmy);
		
		assertEquals(testModel.getPlayerTwoArmy(), testPlayer.getArmy());
	}

	@Test
	public void testGetPlayerOneDice() {
		Player testPlayer = new Player();
		Dice testDice = new Dice();
		testPlayer.setDice(testDice);
	
		MatchModel testModel = new MatchModel();
		testModel.setPlayerOne(testPlayer);
		
		assertEquals(testModel.getPlayerOneDice(), testDice);
	}

	@Test
	public void testSetPlayerOneDice() { //dont know why this is failing
	//	Player testPlayer = new Player();
		Dice testDice = new Dice();
		MatchModel testModel = new MatchModel();
		//testModel.setPlayerOne(testPlayer);
		Player testPlayer = new Player("hello", new Army());
		testModel.setPlayerOne(testPlayer);
		testModel.setPlayerOneDice(testDice);
		
		assertNotEquals(null, testModel.getPlayerOneDice());
		assertEquals( testDice.getDice(), testModel.getPlayerOneDice().getDice()); //Holy crap
	}

	@Test
	public void testGetPlayerTwoDice() {
		Player testPlayer = new Player();
		Dice testDice = new Dice();
		testPlayer.setDice(testDice);
	
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwo(testPlayer);
		
		assertEquals(testModel.getPlayerTwoDice(), testDice);
	}

	@Test
	public void testSetPlayerTwoDice() {
		Player testPlayer = new Player("hi", new Army());
		Dice testDice = new Dice();
		
	
		MatchModel testModel = new MatchModel();
		
		testModel.setPlayerTwo(testPlayer);
		testModel.setPlayerTwoDice(testDice);
		
		assertNotEquals(testModel.getPlayerTwoDice().getDice(), null);
		assertEquals(testModel.getPlayerTwoDice().getDice(), testPlayer.getDice().getDice());
		assertEquals(testModel.getPlayerTwoDice().getDice(), testModel.getPlayerTwo().getDice().getDice());//just for laughs
		
	}

	@Test
	public void testSetPlayerOneLastAction() {
		MatchModel testModel = new MatchModel();
		testModel.setPlayerOneLastAction("Last Action");
		
		assertEquals("Last Action", testModel.getPlayerOneLastAction());
	}

	@Test
	public void testGetPlayerTwoLastAction() {
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwoLastAction("Last Action");
		
		assertEquals("Last Action", testModel.getPlayerTwoLastAction());
	}

	@Test
	public void testSetPlayerTwoLastAction() {
		MatchModel testModel = new MatchModel();
		testModel.setPlayerTwoLastAction("Last Action");
		
		assertEquals("Last Action", testModel.getPlayerTwoLastAction());
	}

	@Test
	public void testGetPlayerOneLastDragon() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		testModel.setPlayerOneLastDragon(testDragon);
		
		assertEquals(testDragon, testModel.getPlayerOneLastDragon());
	}

	@Test
	public void testSetPlayerOneLastDragon() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		testModel.setPlayerOneLastDragon(testDragon);
		
		assertEquals(testDragon, testModel.getPlayerOneLastDragon());
	}

	@Test
	public void testGetPlayerTwoLastDragon() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		testModel.setPlayerTwoLastDragon(testDragon);
		
		assertEquals(testDragon, testModel.getPlayerTwoLastDragon());
	}

	@Test
	public void testSetPlayerTwoLastDragon() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		testModel.setPlayerTwoLastDragon(testDragon);
		
		assertEquals(testDragon, testModel.getPlayerTwoLastDragon());
	}

	@Test
	public void testGetCurrentDiceSelection() {
		Dice testDice = new Dice();
		MatchModel testModel = new MatchModel();
		testModel.setCurrentDiceSelection(testDice);
		
		assertEquals(testModel.getCurrentDiceSelection(), testDice);
	}

	@Test
	public void testSetCurrentDiceSelection() {
		Dice testDice = new Dice();
		MatchModel testModel = new MatchModel();
		testModel.setCurrentDiceSelection(testDice);
		
		assertEquals(testModel.getCurrentDiceSelection(), testDice);
	}

	@Test
	public void testGetDragonBeingAddedToDice() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		
		testModel.setDragonBeingAddedToDice(testDragon);
		
		assertEquals(testModel.getDragonBeingAddedToDice(), testDragon);
	}

	@Test
	public void testSetDragonBeingAddedToDice() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		
		testModel.setDragonBeingAddedToDice(testDragon);
		
		assertEquals(testModel.getDragonBeingAddedToDice(), testDragon);
	}

	@Test
	public void testGetDragonBeingRemovedFromDice() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		
		testModel.setDragonBeingRemovedFromDice(testDragon);
		
		assertEquals(testModel.getDragonBeingRemovedFromDice(), testDragon);
	}

	@Test
	public void testSetDragonBeingRemovedFromDice() {
		MatchModel testModel = new MatchModel();
		DragonLibrary testLib = new DragonLibrary();
		Dragon testDragon = testLib.getDragon(0);
		
		testModel.setDragonBeingRemovedFromDice(testDragon);
		
		assertEquals(testModel.getDragonBeingRemovedFromDice(), testDragon);
	}

}
