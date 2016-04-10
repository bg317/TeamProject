package dragonspiretournament.nameselection;

public class NameSelectionModel {
	
	//for ease of remembering which player we're dealing with
	private final int ONE = 0;
	private final int TWO = 1;
	
	 //keeps track of which name is being stored/changed
	private int currentPlayer;
	//the stored names
	private String playerOneName;
	private String playerTwoName;
	
	NameSelectionModel()
	{
		currentPlayer = ONE;
		playerOneName = "Player 1";
		playerTwoName = "Player 2";
	}
	
	//gets the current player that we are setting
	public String getPlayer()
	{
		if (currentPlayer == ONE)
		{
			return playerOneName;
		}
		else
		{
			return playerTwoName;
		}
	}
	
	//sets the name of the player
	public void setPlayerName(String name)
	{
		if (currentPlayer == ONE)
		{
			playerOneName = name;
		}
		else
		{
			playerTwoName = name;
		}
	}
	
	//gets the next place to go--either the second player entry (false) or the start of the game (true)
	public boolean getNext()
	{
		if (currentPlayer == TWO)
		{
			return true;
		}
		else
		{
			currentPlayer++;
			return false;
		}
	}
}