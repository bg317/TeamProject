/* ArmySelectionControllerTest
 * makes sure the controller can do everything it need to.
 * 
 * @author larry
 * @version 4-14-16
 * 
 */

import dragonspiretournament.GameObjects.Army;
import dragonspiretournament.GameObjects.DragonLibrary;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.armyselection.ArmySelectionController;
import dragonspiretournament.armyselection.ArmySelectionModel;
import static org.junit.Assert.*;

import org.junit.Test;

public class ArmySelectionControllerTest {

	@Test
	// Tests the controller initializer
	public void testInitCurrentAndPrev1() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		ArmySelectionController.initCurrentAndPrev(testModel);
		
		assertEquals(testModel.getNext().toString(),  "Arinial");
		assertEquals(testModel.getCurrent().toString(),  "Tenebret");
		assertEquals(testModel.getPrev().toString(),  "Igneagnus");
	}
	
	@Test
	// Tests the Remove from Army
	public void testRemoveFromArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));  //make an army
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib); //make a model with that army
		
		ArmySelectionController.removeFromArmy(testArmy, testLib.getDragon(0));//make the controller work on that model
		assertEquals(testModel.getPlayer().getArmy().getSize(),  0);//see if it worked 
	}

	@Test
	// Tests the Add to Army
	public void testAddToArmy() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		//testArmy.add( testLib.getDragon(0));  //make an army
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib); //make a model with that army
		
		assertEquals(testModel.getCurrentPlayerArmy().getSize(),  0);//precondition
		ArmySelectionController.addToArmy(testModel, testLib.getDragon(1));//make the controller work on that model
		assertEquals(testModel.getCurrentPlayerArmy().getSize(),  1);//see if it worked 	
	}

	@Test
	// Tests the Shift Preview Left
	public void testShiftPreviewLeft() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		ArmySelectionController.initCurrentAndPrev(testModel);
		ArmySelectionController.shiftPreviewLeft(testModel);
		
		assertEquals(testModel.getNext().toString(),  "Tenebret");
		assertEquals(testModel.getCurrent().toString(),  "Igneagnus");
		assertEquals(testModel.getPrev().toString(),  "Tenebret"); // this may be a bug
	}

	@Test
	// Tests the Shift Preview Right
	public void testShiftPreviewRight() {
		Army testArmy = new Army();
		DragonLibrary testLib = new DragonLibrary();
		testArmy.add( testLib.getDragon(0));
		Player testPlayer = new Player("Name", testArmy);
		ArmySelectionModel testModel = new ArmySelectionModel(testPlayer, testLib);
		ArmySelectionController.initCurrentAndPrev(testModel);
		ArmySelectionController.shiftPreviewRight(testModel);
		
		assertEquals(testModel.getNext().toString(),  "Skenna");
		assertEquals(testModel.getCurrent().toString(),  "Arinial");
		assertEquals(testModel.getPrev().toString(),  "Tenebret");
	}

}
