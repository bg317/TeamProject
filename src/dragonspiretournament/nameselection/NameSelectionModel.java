package dragonspiretournament.nameselection;

import dragonspiretournament.GameObjects.Player;

/**
 * The Class NameSelectionModel.
 */
public class NameSelectionModel {
	
	/** The one. */
	//for ease of remembering which player we're dealing with
	private final int ONE = 0;
	
	/** The two. */
	private final int TWO = 1;
	
	 /** The current player. */
 	//keeps track of which name and player is being stored/changed
	private int currentPlayer;
	
	/** The player one name. */
	//the stored names
	private String playerOneName;
	
	/** The player two name. */
	private String playerTwoName;
	
	/** The player1. */
	//player objects to be passed the name
	private Player player1;
	
	/** The player2. */
	private Player player2;
	
	/**
	 * constructor.
	 */
	public NameSelectionModel()
	{
		currentPlayer = ONE;
		playerOneName = "Player 1";
		playerTwoName = "Player 2";
		
		player1 = new Player(playerOneName);
		player2 = new Player(playerTwoName);
	}
	
	//gets the current player that we are setting
	
	/**
	 * Gets the name of whichever player is currently selected.
	 * @return the name of the current player.
	 */
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
	/**
	 * Sets the player name for whichever player is current.
	 * @param name the name we are setting for the current player.
	 */
	public void setPlayerName(String name)
	{
		if (currentPlayer == ONE)
		{
			playerOneName = name;
			System.out.println("name: " + playerOneName);
			//sets the name in the actual player 1 object
			player1.setName(playerOneName);
		}
		else if (currentPlayer == TWO)
		{
			playerTwoName = name;
			System.out.println("name: " + playerTwoName);
			//sets the name in the actual player 2 object
			player2.setName(playerTwoName);
		}
		
		//create a player with the name information
		
	}
	
	//gets the next place to go--either the second player entry (false) or the start of the game (true)
	/**
	 * Determines whether or not we are done entering player names.
	 * @return true if we are ready to move to the next game, or false if we have another player's
	 *name to enter.
	 */
	public boolean getNext()
	{
		if (currentPlayer == TWO)
		{
			return true;
		}
		else if (currentPlayer == ONE)
		{
			currentPlayer++;
			return false;
		}
		else
		{
			return true;
		}
	}

	/**
	 * Sets the player one.
	 *
	 * @param player the new player one
	 */
	public void setPlayerOne(Player player) {
		this.player1 = player;
	}
	
	/**
	 * Sets the player two.
	 *
	 * @param player the new player two
	 */
	public void setPlayerTwo( Player player ) {
		this.player2 = player;
	}
}

