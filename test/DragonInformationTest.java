/* Dragon information (model) test
 * Tests to make sure the dragon information class can retrieve dragon information
 * @author larry
 * @version 4-12-16
 * 
 */

import dragonspiretournament.PlayerInformation.DragonInformation;


import dragonspiretournament.GameObjects.Dragons.Dragon;
import static org.junit.Assert.*;

import org.junit.Test;

public class DragonInformationTest {

	@Test
	public void testDragonInformation() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertNotEquals(testDragonInformation, null);
	}

	@Test
	public void testGetName1() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertEquals(testDragonInformation.getName(), "testName");
	}
	
	@Test
	public void testGetName2() {
		Dragon testDragon = new Dragon("", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertEquals(testDragonInformation.getName(), "");
	}
	
	@Test
	public void testGetName3() {
		Dragon testDragon = new Dragon("adsfalkdsjhfp932q8u798!#@$%@#$%&&%IJDHGFsdfgwe32453476434trqav.,;<LDS~!#@$%^(*|}|}P{|()}///\\\\asdf", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertEquals(testDragonInformation.getName(), "adsfalkdsjhfp932q8u798!#@$%@#$%&&%IJDHGFsdfgwe32453476434trqav.,;<LDS~!#@$%^(*|}|}P{|()}///\\\\asdf");
	}

	@Test
	public void testGetType() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertEquals(testDragonInformation.getType(), "testType");
	}

	@Test
	public void testGetDescription() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertEquals(testDragonInformation.getDescription(), "");
	}

	@Test
	public void testGetIcon() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertEquals(testDragonInformation.getIcon(), "TestFile");
	}

	@Test
	public void testGetArt() {
		Dragon testDragon = new Dragon("testName", 7, 9000, "testType", "testStrong", "TestFile", "?"); 
		DragonInformation testDragonInformation = new DragonInformation(testDragon);
		assertEquals(testDragonInformation.getArt(), "");
	}

}
