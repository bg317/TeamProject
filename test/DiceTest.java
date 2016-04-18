/* DiceTest
 * Test cases to make sure the functions of the Dice class all work
 * 
 * @author Team 29 (CD)
 * @version 4-15-16
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import dragonspiretournament.GameObjects.Dragons.*;
import dragonspiretournament.GameObjects.Dice;

public class DiceTest{
	
	@Test
	//Test to see if Dice() constructor is working
	public void testDice(){
		Dice testDice = new Dice();
		
		assertNotNull(testDice);
	}
	
	@Test
	//Test to see if add(Dragon newFace) is working
	public void addTest(){
		Dice testDice = new Dice();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		
		testDice.add(testDrag);
		assertEquals(testDice.getFaceCount(), 2);
		testDice.add(testDrag);
		testDice.add(testDrag);
		assertEquals(testDice.getFaceCount(), 4);
	}
	
	@Test
	//Test to see if remove(int index) is working
	public void removeTest(){
		Dice testDice = new Dice();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon("TestName2", "TestType2", "TestStrength2", "TestIcon2", "TestDescription2");
		Dragon testDrag3 = new Dragon("TestName3", "TestType3", "TestStrength3", "TestIcon3", "TestDescription3");
		
		testDice.add(testDrag);
		testDice.add(testDrag2);
		testDice.add(testDrag3);
		testDice.add(testDrag);
		testDice.remove(2);
		assertEquals(4, testDice.getFaceCount());
		testDice.remove(1);
		testDice.remove(1);
		assertEquals(2, testDice.getFaceCount());
		testDice.remove(0);
		assertEquals(2, testDice.getFaceCount()); //the decrement might be brokn based on this behavior
	}
	
	@Test
	//Test to see if clearDice() is working
	public void testClearDice(){
		Dice testDice = new Dice();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon missDrag;
		
		testDice.add(testDrag);
		testDice.clearDice();
		assertEquals(testDice.getFaceCount(), 1);//clearing inserts a missed
		missDrag = testDice.getFace(0);
		assertEquals(missDrag.getName(), "Missed");
		testDice.add(testDrag);
		testDice.add(testDrag);
		testDice.add(testDrag);
		testDice.add(testDrag);
		testDice.clearDice();
		assertEquals(testDice.getFaceCount(), 1);
		missDrag = testDice.getFace(0);
		assertEquals(missDrag.getName(), "Missed");
	}
	
	
	@Test
	//Test to see if getFace(int index) is working
	public void testGetFace(){
		Dice testDice = new Dice();
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon("TestName2", "TestType2", "TestStrength2", "TestIcon2", "TestDescription2");
		Dragon testDrag3 = new Dragon("TestName3", "TestType3", "TestStrength3", "TestIcon3", "TestDescription3");
		Dragon testDrag4;
		
		testDice.add(testDrag);
		testDice.add(testDrag2);
		testDice.add(testDrag3);
		//testDice.add(testDrag4);
		testDrag4 = testDice.getFace(1);
		assertEquals(testDrag4.getName(), "TestName");
		testDrag4 = testDice.getFace(2);
		assertEquals(testDrag4.getName(), "TestName2");
		testDrag4 = testDice.getFace(3);
		assertEquals(testDrag4.getName(), "TestName3");
	}
	
	@Test
	//Test to see if Dice(int faces) constructor is working
	public void testDiceCustomFace(){
		Dice testDice = new Dice(6);
		
		assertNotEquals(testDice, null);
		Dragon testDrag4;
		testDrag4 = testDice.getFace(0);
		assertEquals(testDrag4.getName(), "Missed");
	}
	
	@Test
	//Test to see if getFaceCount() is working
	public void testGetFaceCount(){
		Dice testDice = new Dice();
		Dice testDice2 = new Dice(8);
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		
		assertEquals(1, testDice2.getFaceCount());
		assertEquals(1, testDice.getFaceCount());
		testDice.add(testDrag);
		testDice.add(testDrag);
		testDice.add(testDrag);
		testDice2.add(testDrag);
		assertEquals(2, testDice2.getFaceCount());
		assertEquals(4, testDice.getFaceCount());
	}
	
	@Test
	//Test to see if getDice() is working
	public void getDice(){
		Dice testDice = new Dice();
		Dice testDice2 = new Dice(8);
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		
		testDice2.add(testDrag);
		testDice = testDice2;
		assertEquals(testDice.getFaceCount(), testDice2.getFaceCount());
	}
}