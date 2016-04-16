/* PlayerTest
 * Test casses to make sure the functions of the Player class all work
 * 
 * @author Team 29 (CD)
 * @version 4-15-16
 * 
 */

import static org.junit.Assert.*;
import org.junit.Test;
import dragonspiretournament.GameObjects.Player;

public class PlayerTest{
	
	@Test
	//Test to see if Player() constructor is working
	public void testPlayer(){
		Player testPlayer = new Player();
		
		assertNotNull(testPlayer);
	}
	
	@Test
	//Test to see if setName(String name) and getName() is working
	public void testSetGetName(){
		Player testPlayer = new Player();
		testPlayer.setName("TestPlayer");
		assertEquals(testPlayer.getName(), "TestPlayer");
		testPlayer.setName("Steve");
		assertEquals(testPlayer.getName(), "Steve");
	}
	
	@Test
	//Test to see if setStrongholdHP(int health) and getStrongHoldHP() is working
	public void testGetStrongholdHP(){
		Player testPlayer = new Player();
		testPlayer.setStrongholdHP(15);
		assertEquals(testPlayer.getStrongholdHP(), 15);
		testPlayer.setStrongholdHP(20);
		assertEquals(testPlayer.getStrongholdHP(), 20);
	}
	
	@Test
	//Test to see if setStrongholdHP(int health) and getStrongHoldHP() is working
	public void testSetStrongholdHP(){
		Player testPlayer = new Player();
		
		testPlayer.setStrongholdHP(15);
		assertEquals(testPlayer.getStrongholdHP(), 15);
		testPlayer.setStrongholdHP(20);
		assertEquals(testPlayer.getStrongholdHP(), 20);
	}
	
	@Test
	//Test to see if setLastDamage(int health) and getLastDamage() is working
	public void testSetGetStrongholdHP(){
		Player testPlayer = new Player();
		
		testPlayer.setLastDamage(15);
		assertEquals(testPlayer.getLastDamage(), 15);
		testPlayer.setLastDamage(20);
		assertEquals(testPlayer.getLastDamage(), 20);
	}
}