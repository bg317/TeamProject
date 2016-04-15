package dragonspiretournament;

/* DragonTest
 * Test casses to make sure the functions of the Dragon class all work
 * 
 * @author Team 29 (CD)
 * @version 4-14-16
 * 
 */

import static org.junit.Assert.*;

import org.junit.Test;

import dragonspiretournament.GameObjects.Dragon;

public class DragonTest{
	
	@Test
	//Test to see if Dragon object is created
	public void testDragon(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertNotNull(testDrag);
	}
	
	@Test
	//Test to see if getName() works
	public void testGetName(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.getName(), "TestName");
	}
	
	@Test
	//Test to see if getType() works
	public void testGetType(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.getType(), "TestType");
	}
	
	@Test
	//Test to see if getStrength() works
	public void testGetStrength(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.getStrength(), "TestStrength");
	}
	
	@Test
	//Test to see if getStatEffect() works
	public void testStatEffect(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.getStatEffect(), "none");
	}
	
	@Test
	//Test to see if getIcon() works
	public void testGetIcon(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.getIcon(), "TestIcon");
	}
	
	@Test
	//Test to see if getDecription() works
	public void testGetDecription(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.getDecription(), "TestDecription");
	}
	
	@Test
	//Test to see if setStrength(name) works
	public void testSetStrength(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		testDrag.setStrength("NewTestStrength");
		assertEquals(testDrag.getStrength(), "NewTestStrength");
	}
	
	@Test
	//Test to see if toString() works
	public void testToString(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.toString(), "TestName");
	}
	
	@Test
	//Test to see if attack(String otherType) works without strength
	public void testAttack(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.attack("NotStrength"), DEFAULT_DAMAGE);
	}
	
	@Test
	//Test to see if attack(String otherType) works with strength
	public void testAttack(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.attack("none"), (int) (DEFAULT_DAMAGE * DEFAULT_MULTIPLIER));
	}
	
	@Test
	//Test to see if Dragon() constructor with default damage and multiplier with status effect fills data members correctly
	public void testToString(){
		Dragon testDrag = new Dragon("TestName", "TestType", "TestStrength", "TestStatEffect", "TestIcon", "TestDescription");
		assertEquals(testDrag.getName(), "TestName");
		assertEquals(testDrag.getType(), "TestType");
		assertEquals(testDrag.getStrength(), "TestStrength");
		assertEquals(testDrag.getStatEffect(), "TestStatEffect");
		assertEquals(testDrag.getIcon(), "TestIcon");
		assertEquals(testDrag.getDescription(), "TestDescription");
		assertEquals(testDrag.attack("NotTestStatEffect"), DEFAULT_DAMAGE);
		assertEquals(testDrag.attack("TestStatEffect"), (int) (DEFAULT_DAMAGE * DEFAULT_MULTIPLIER));
	}
	
	@Test
	//Test to see if Dragon() constructor with custom damage and multiplier with no status effect fills data members correctly
	public void testToString(){
		Dragon testDrag = new Dragon("TestName", 3, 3.0,  "TestType", "TestStrength", "TestIcon", "TestDescription");
		assertEquals(testDrag.getName(), "TestName");
		assertEquals(testDrag.getType(), "TestType");
		assertEquals(testDrag.getStrength(), "TestStrength");
		assertEquals(testDrag.getStatEffect(), "none");
		assertEquals(testDrag.getIcon(), "TestIcon");
		assertEquals(testDrag.getDescription(), "TestDescription");
		assertEquals(testDrag.attack("NotStrength"), 3);
		assertEquals(testDrag.attack("none"), (int) (3 * 3.0));
	}
	
	@Test
	//Test to see if Dragon() constructor with custom damage and multiplier with status effect fills data members correctly
	public void testToString(){
		Dragon testDrag = new Dragon("TestName", 3, 3.0,  "TestType", "TestStrength", "TestStatEffect", "TestIcon", "TestDescription");
		assertEquals(testDrag.getName(), "TestName");
		assertEquals(testDrag.getType(), "TestType");
		assertEquals(testDrag.getStrength(), "TestStrength");
		assertEquals(testDrag.getStatEffect(), "TestStatEffect");
		assertEquals(testDrag.getIcon(), "TestIcon");
		assertEquals(testDrag.getDescription(), "TestDescription");
		assertEquals(testDrag.attack("NotTestStatEffect"), 3);
		assertEquals(testDrag.attack("TestStatEffect"), (int) (3 * 3.0));
	}
	
	@Test
	//Test to see if the Dragon(Dragon otherDragon) constructor works
	public void testToString(){
		Dragon testDrag = new Dragon("TestName", 3, 3.0,  "TestType", "TestStrength", "TestStatEffect", "TestIcon", "TestDescription");
		Dragon testDrag2 = new Dragon(testDrag);
		assertEquals(testDrag.getName(), testDrag2.getName());
		assertEquals(testDrag.getType(), testDrag2.getType());
		assertEquals(testDrag.getStrength(), testDrag2.getStrength());
		assertEquals(testDrag.getStatEffect(), testDrag2.getStatEffect());
		assertEquals(testDrag.getIcon(), testDrag2.getIcon());
		assertEquals(testDrag.getDescription(), testDrag2.getDescription());
		assertEquals(testDrag.attack("NotTestStatEffect"), testDrag2.attack("NotTestStatEffect"));
		assertEquals(testDrag.attack("TestStatEffect"), testDrag2.attack("TestStatEffect"));
	}
}