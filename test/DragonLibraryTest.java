//package dragonspiretournament;

/* DragonLibraryTest
 * Test casses to make sure the functions of the DragonLibrary class all work
 * 
 * @author Team 29 (CD)
 * @version 4-15-16
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.DragonLibrary;

public class DragonLibraryTest{
	
	@Test
	//Tests the DragonLibrary() constructor
	public void testDragonLibrary(){
		DragonLibrary testDragLib = new DragonLibrary();
		Dragon testDrag;
		
		assertNotNull(testDragLib);
		assertEquals(testDragLib.getSize(), 7);
		testDrag = testDragLib.getDragon(0);
		assertEquals(testDrag.getName(), "Igneagnus");
	}
	
	@Test
	//Test to see if getDragon(int index) is wokring
	public void testGetDragon(){
		DragonLibrary testDragLib = new DragonLibrary();
		Dragon testDrag;
		
		testDrag = testDragLib.getDragon(3);
		assertEquals(testDrag.getName(), "Skenna");
		testDrag = testDragLib.getDragon(6);
		assertEquals(testDrag.getName(), "Trudrake");
		testDrag = testDragLib.getDragon(5);
		assertEquals(testDrag.getName(), "Galthi");
	}
}