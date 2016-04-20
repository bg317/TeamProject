import static org.junit.Assert.*;


import java.util.Observable;
import java.util.Observer;

import org.junit.Test;

import dragonspiretournament.Game.GameState;

public class GameStateObserverTest {
	
	@Test
	public void notifyObserver() {
		GameState gameState = new GameState();
		ObserverForTesting observer = new ObserverForTesting();
		gameState.addObserver( observer );

		assertFalse( observer.getUpdated() );
		
		//Change gamestate so notify() works. Will also notify observer.
		gameState.setMatchOver( true );
		
		assertTrue( observer.getUpdated() );
	}
}

/**
 * Test class for Observer pattern.
 * @author BrandonG
 *
 */
class ObserverForTesting implements Observer {
	
	GameState gameState;
	Boolean hasBeenUpdated;
	
	public ObserverForTesting() {
		gameState = new GameState();
		hasBeenUpdated = false;
	}
	
	@Override
	public void update(Observable o, Object arg) {
		this.hasBeenUpdated = true;
	}
	
	public Boolean getUpdated() {
		return hasBeenUpdated;
	}
	
}
