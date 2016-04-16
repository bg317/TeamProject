//package dragonspiretournament;

/* ArmyTest
 * Test cases to make sure the functions of the Dragon class all work
 * 
 * @author Team 29 (CD)
 * @version 4-14-16
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import dragonspiretournament.GameObjects.Dragons.Dragon;
import dragonspiretournament.GameObjects.Army;

public class ArmyTest{
	
	@Test
	//Test to see if Army() constructor works
	public void testArmy(){
		Army testArmy = new Army();
		
		assertNotNull(testArmy);
	}
	
	@Test
	//Test to see if add(Dragon newDragon) works
	public void testAdd(){
		Army testArmy = new Army();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		testArmy.add(testDrag);
		
		assertEquals(testArmy.getSize(), 1);
		assertEquals(testArmy.toString(), "TestName ");
	}
	
	@Test
	//Test to see if add(Dragon newDragon) works with multiple adds
	public void testAddMultiple1(){
		Army testArmy = new Army();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon("TestName2", "TestType2", "TestStrength2", "TestIcon2", "TestDescription2");
		testArmy.add(testDrag);
		testArmy.add(testDrag2);
		
		assertEquals(testArmy.getSize(), 2);
		assertEquals(testArmy.toString(), "TestName TestName2 ");
		
		Dragon testDrag3 = new Dragon("TestName3", "TestType3", "TestStrength3", "TestIcon3", "TestDescription3");
		Dragon testDrag4 = new Dragon("TestName4", "TestType4", "TestStrength4", "TestIcon4", "TestDescription4");
		testArmy.add(testDrag3);
		testArmy.add(testDrag4);
		
		assertEquals(testArmy.getSize(), 4);
		assertEquals(testArmy.toString(), "TestName TestName2 TestName3 TestName4 ");
	}
	
	@Test
	//Test to see if getSize() / remove() / clearArmy() work
	public void testAddMultiple2(){
		Army testArmy = new Army();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon("TestName2", "TestType2", "TestStrength2", "TestIcon2", "TestDescription2");
		testArmy.add(testDrag);
		testArmy.add(testDrag2);
		
		assertEquals(testArmy.getSize(), 2);
		
		Dragon testDrag3 = new Dragon("TestName3", "TestType3", "TestStrength3", "TestIcon3", "TestDescription3");
		Dragon testDrag4 = new Dragon("TestName4", "TestType4", "TestStrength4", "TestIcon4", "TestDescription4");
		testArmy.add(testDrag3);
		testArmy.add(testDrag4);
		
		assertEquals(testArmy.getSize(), 4);
		testArmy.remove(0);
		assertEquals(testArmy.getSize(), 3);
		testArmy.add(testDrag3);
		testArmy.add(testDrag4);
		assertEquals(testArmy.getSize(), 5);
		testArmy.remove(2);
		testArmy.remove(1);
		assertEquals(testArmy.getSize(), 3);
		testArmy.clearArmy();
		assertEquals(testArmy.getSize(), 0);
	}
	
	@Test
	//Test to see if toString() works properly
	public void testToString(){
		Army testArmy = new Army();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon("TestName2", "TestType2", "TestStrength2", "TestIcon2", "TestDescription2");
		Dragon testDrag3 = new Dragon("TestName3", "TestType3", "TestStrength3", "TestIcon3", "TestDescription3");
		Dragon testDrag4 = new Dragon("TestName4", "TestType4", "TestStrength4", "TestIcon4", "TestDescription4");
		testArmy.add(testDrag);
		testArmy.add(testDrag2);
		testArmy.add(testDrag3);
		testArmy.add(testDrag4);
		
		assertEquals(testArmy.toString(), "TestName TestName2 TestName3 TestName4 ");
	}
	
	@Test
	//Test to see if getDragon(Dragon index) works properly
	public void testGetDragon(){
		Army testArmy = new Army();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon("TestName2", "TestType2", "TestStrength2", "TestIcon2", "TestDescription2");
		Dragon testDrag3 = new Dragon("TestName3", "TestType3", "TestStrength3", "TestIcon3", "TestDescription3");
		Dragon testDrag4 = new Dragon("TestName4", "TestType4", "TestStrength4", "TestIcon4", "TestDescription4");
		Dragon testDrag5;
		testArmy.add(testDrag);
		testArmy.add(testDrag2);
		testArmy.add(testDrag3);
		testArmy.add(testDrag4);
		testDrag5 = testArmy.getDragon(1);
		
		assertEquals(testDrag5.getName(), "TestName2");
	}
	
	@Test
	//Test to see if getArmy() works properly
	public void testGetArmy(){
		Army testArmy = new Army();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon("TestName2", "TestType2", "TestStrength2", "TestIcon2", "TestDescription2");
		Dragon testDrag3 = new Dragon("TestName3", "TestType3", "TestStrength3", "TestIcon3", "TestDescription3");
		Dragon testDrag4 = new Dragon("TestName4", "TestType4", "TestStrength4", "TestIcon4", "TestDescription4");
		Army testArmy2;
		testArmy.add(testDrag);
		testArmy.add(testDrag2);
		testArmy.add(testDrag3);
		testArmy.add(testDrag4);
		testArmy2 = testArmy;
		
		assertEquals(testArmy.getArmy().toString(), testArmy2.getArmy().toString());
	}
}