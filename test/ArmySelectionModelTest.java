/* ArmySelectionModelTest
 * makes sure the models getters and setters work
 * 
 * @author larry
 * @version 4-14-16
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.armyselection.ArmySelectionModel;

public class ArmySelectionModelTest {

	@Test
	// Tests the Get Current Player Army
	public void testGetCurrentPlayerArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		testModel.setCurrentPlayerArmy(testPlayer.getArmy());
		
		assertEquals(testModel.getCurrentPlayerArmy().toString(), testPlayer.getArmy().toString());
	}

	@Test
	// Tests the Set Current Player Army
	public void testSetCurrentPlayerArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		
		assertEquals(testModel.getCurrentPlayerArmy().toString(), "");//precondition
		testModel.setCurrentPlayerArmy(testPlayer.getArmy());
		assertEquals(testModel.getCurrentPlayerArmy().toString(), testPlayer.getArmy().toString());//postcondition
	}

	@Test
	// Tests the OverLoaded constructor
	public void testArmySelectionModelPlayerDragonLibrary() {//overloaded constructor test
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		
		assertNotEquals(testModel, null);
		assertEquals(testModel.getPlayer(), testPlayer);
		assertEquals(testModel.getDragLib(), testLib);
	}

	@Test
	// Tests the Default constructor
	public void testArmySelectionModel() {//default constructor
		ArmySelectionModel testModel = new ArmySelectionModel();
		assertNotEquals(testModel, null);
		assertEquals(testModel.getPlayer(), null);
		assertNotEquals(testModel.getDragLib(), null);
	}

	@Test
	// Tests the Player Getter
	public void testGetPlayer() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		
		assertEquals(testModel.getPlayer(), testPlayer);
	}

	@Test
	// Tests the Player Setter
	public void testSetPlayer() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setPlayer(testPlayer);
		
		assertEquals(testModel.getPlayer(), testPlayer);
	}

	@Test
	// Tests the All Library Dragons Getter
	public void testGetAllLibraryDragons() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		
		assertEquals(testModel.getAllLibraryDragons(), testLib.getLibrary());
	}

	@Test
	// Tests the Dragon Library Getter
	public void testGetDragLib() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		
		assertEquals(testModel.getDragLib(), testLib);
	}

	@Test
	// Tests the Dragon Library Setter
	public void testSetDragLib() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setDragLib(testLib);
		
		assertEquals(testModel.getDragLib(), testLib);
	}

	@Test
	// Tests the Current Getter
	public void testGetCurrent() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setCurrent(testLib.getDragon(0));
		
		assertEquals(testModel.getCurrent(), testLib.getDragon(0));
		
	}

	@Test
	// Tests the Current Setter
	public void testSetCurrent() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setCurrent(testLib.getDragon(0));
		
		assertEquals(testModel.getCurrent(), testLib.getDragon(0));
	}

	@Test
	// Tests the Previous Dragon Getter
	public void testGetPrev() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setPrev(testLib.getDragon(0));
		
		assertEquals(testModel.getPrev(), testLib.getDragon(0));
	}

	@Test
	// Tests the Previous Dragon Setter
	public void testSetPrev() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setPrev(testLib.getDragon(0));
		
		assertEquals(testModel.getPrev(), testLib.getDragon(0));
	}

	@Test
	// Tests the Next Dragon Getter
	public void testGetNext() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setNext(testLib.getDragon(0));
		
		assertEquals(testModel.getNext(), testLib.getDragon(0));
	}

	@Test
	// Tests the Previous Dragon Setter
	public void testSetNext() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		ArmySelectionModel testModel = new ArmySelectionModel();
		testModel.setNext(testLib.getDragon(0));
		
		assertEquals(testModel.getNext(), testLib.getDragon(0));
	}

}
