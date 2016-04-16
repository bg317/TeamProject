/* TitleViewController Test
 * 
 * @author larry
 * @version 4-12-16
 * 
 */

import dragonspiretournament.title.TitleController;

import static org.junit.Assert.*;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TitleControllerTest {
	
	/*
	 * This is the magic crap that gets console output into a usable form
	 * 
	 */
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

	@Before
	//Set up
	public void setUpStreams() {
	    System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	//Clean Up
	public void cleanUpStreams() {
	    System.setOut(null);
	    System.setErr(null);
	}
	
	@Test
	//Tests the Limits
	public void doingSomethingTest() {
		TitleController.doSomething();
		assertEquals("Doing Something\n", outContent.toString());
	}

}
