package dragonspiretournament.Game;

import java.util.Observable;

public class GameState extends Observable {

	private Boolean playerOneNameSelection;
	private Boolean playerTwoNameSelection;
	private Boolean playerOneArmySelection;
	private Boolean playerTwoArmySelection;
	private Boolean playerOneDiceSelection;
	private Boolean playerTwoDiceSelection;
	private Boolean matchOver;
	
	public GameState() {
		this.playerOneNameSelection = false;
		this.playerTwoNameSelection = false;
		this.playerOneArmySelection = false;
		this.playerTwoArmySelection = false;
		this.playerOneDiceSelection = false;
		this.playerTwoDiceSelection = false;
		this.matchOver = false;
	}
	
	public Boolean getMatchOver() {
		return matchOver;
	}

	
	public void setMatchOver(Boolean matchOver) {
		this.setChanged();
		this.matchOver = matchOver;
		notifyObservers();
	}

	public Boolean getPlayerOneNameSelection() {
		return playerOneNameSelection;
	}
	
	public void setPlayerOneNameSelection(Boolean playerOneNameSelection) {
		this.playerOneNameSelection = playerOneNameSelection;
		this.setChanged();
		notifyObservers();
	}
	
	public Boolean getPlayerTwoNameSelection() {
		return playerTwoNameSelection;
	}
	
	public void setPlayerTwoNameSelection(Boolean playerTwoNameSelection) {
		this.playerTwoNameSelection = playerTwoNameSelection;
		this.setChanged();
		notifyObservers();
	}
	
	public Boolean getPlayerOneArmySelection() {
		return playerOneArmySelection;
	}
	
	public void setPlayerOneArmySelection(Boolean playerOneArmySelection) {
		this.playerOneArmySelection = playerOneArmySelection;
		this.setChanged();
		notifyObservers();
	}
	
	public Boolean getPlayerTwoArmySelection() {
		return playerTwoArmySelection;
	}
	
	public void setPlayerTwoArmySelection(Boolean playerTwoArmySelection) {
		this.playerTwoArmySelection = playerTwoArmySelection;
		this.setChanged();
		notifyObservers();
	}
	
	public Boolean getPlayerOneDiceSelection() {
		return playerOneDiceSelection;
	}
	
	public void setPlayerOneDiceSelection(Boolean playerOneDiceSelection) {
		this.playerOneDiceSelection = playerOneDiceSelection;
		this.setChanged();
		notifyObservers();
	}
	
	public Boolean getPlayerTwoDiceSelection() {
		return playerTwoDiceSelection;
	}
	
	public void setPlayerTwoDiceSelection(Boolean playerTwoDiceSelection) {
		this.playerTwoDiceSelection = playerTwoDiceSelection;
		this.setChanged();
		notifyObservers();
	}
}
