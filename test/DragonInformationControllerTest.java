

/* Dragon information controller test
 * Tests to make sure the dragon information controller is working
 * @author larry
 * @version 4-12-16
 * beware the static-ness of this class
 * I suggest overloading set dragon with no parameters for a reset 
 * 
 */

import static org.junit.Assert.*;
import javax.swing.ImageIcon;

import org.junit.Test;

import dragonspiretournament.PlayerInformation.DragonInformationController;
import dragonspiretournament.GameObjects.Dragons.Dragon;

public class DragonInformationControllerTest {

	@Test
	public void testSetDragon1() {
		assertEquals(DragonInformationController.getName(), "testName");		
	}
	
	@Test
	public void testSetDragon2() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?");
		DragonInformationController.setDragon(testDragon);
		assertEquals(DragonInformationController.getName(), "testName");		
	}
	
	@Test
	public void testSetDragon3() {
		assertEquals(DragonInformationController.getName(), "testName");		
	}
	

	@Test
	public void testGetName1() {
		assertEquals(DragonInformationController.getName(), "No Data");
	}
	
	@Test
	public void testGetName2() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?");
		DragonInformationController.setDragon(testDragon);
		assertEquals(DragonInformationController.getName(), "testName");	
	}

	@Test
	public void testGetDescription() {
		assertEquals(DragonInformationController.getDescription(), "");
	}

	@Test
	public void testGetArt() {
		assertEquals(DragonInformationController.getArt(), "");
	}

	@Test
	public void testGetIcon() {
		assertEquals(DragonInformationController.getIcon(), "TestFile");
	}

	@Test
	public void testGetType() {
		assertEquals(DragonInformationController.getType(), "testType");
	}

	@Test
	public void testCreateIcon1() {
		assertEquals(DragonInformationController.createIcon("derp", "derp"), null);
		
	}
	
	/*
	 * not really sure what to do here.
	 *//*
	@Test
	public void testCreateIcon2() {
		java.net.URL imageLocation = DragonInformationView.class.getResource("/TeamProject/src/dragons/icons/Arinial.png");
		 ImageIcon test = DragonInformationController.createIcon("/TeamProject/src/dragons/icons/Arinial.png", "derp");
		assertEquals(test, null);
	}*/

}
