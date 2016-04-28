package dragonspiretournament.game;

import dragonspiretournament.GameObjects.Dragons.Dragon;

import dragonspiretournament.GameObjects.UIComponents.ImageButton;
import dragonspiretournament.title.TitleController;
import dragonspiretournament.nameselection.NameSelectionController;
import dragonspiretournament.nameselection.NameSelectionView;
import dragonspiretournament.title.TitleView;
import dragonspiretournament.armyselection.ArmySelectionView;
import dragonspiretournament.GameObjects.Player;
import dragonspiretournament.match.MatchView;
import dragonspiretournament.Leaderboard.LeaderboardView;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.awt.Color;

import java.io.IOException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
/**
 * The Class GameView.
 */
public class GameView {
	
	/** The title frame. */
	private JFrame titleFrame;
	
	/*the container panel*/
	private JPanel wrapperPanel;
	
	/** the title view*/
	TitleView titleView;
	
	/** the name selection view */
	NameSelectionView nameView;
	
	/** the army select view*/
	ArmySelectionView armySelectView;
	
	/** the match view*/
	MatchView matchView;
	
	/** the leaderboard view*/
	LeaderboardView leaderboardView;
	
	/**
	 * Instantiates a new game view.
	 */
	public GameView() {
		titleFrame = new JFrame("Dragonspire Tournament");
		titleFrame.setSize(1036, 700);
		titleFrame.setLocationRelativeTo(null);
		titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		titleFrame.setVisible(true);
		
		//setting the card layout
		wrapperPanel = new JPanel(new CardLayout());
		
		titleFrame.setLayout(new GridLayout(1,1));
		
		//creating elements to add to the card layout
		titleView = new TitleView();
		titleView.setBackground(Color.white);
		
		//adding elements to the card layout
		wrapperPanel.add(titleView, "titleView");
		titleFrame.getContentPane().add(wrapperPanel);
		//make the frame visible
		titleFrame.setVisible(true);
		wrapperPanel.repaint();
		
		
	}
	
	/**
	 * Method that allows switching between instantiated view objects.
	 * @param ViewToShow the name of the view objects to show next.
	 */
	public void changeView(String ViewToShow)
	{
		CardLayout cardLayout = (CardLayout) wrapperPanel.getLayout();
		cardLayout.show(wrapperPanel, ViewToShow);
		
		wrapperPanel.repaint();
	}

	public void createNameSelectionView()
	{
        NameSelectionController.resetPlayers();
	    nameView = new NameSelectionView();

        //adds a card to the wrapper panel for the name selection view
        wrapperPanel.add(nameView, "nameView");

        wrapperPanel.repaint();	
	}
	
	/**
	 * creates the army selection view after we have player names
	 * @param playerOne the info on player one.
	 * @param playerTwo the info on player two.
	 * @param gameState the current game state.
	 */
	public void createArmySelectionView(Player playerOne, Player playerTwo, GameState gameState)
	{
	    //First match of the program
	    if(!gameState.getPlayerOneArmySelection())
	        gameState.setPlayerOneArmySelection(true);

	    armySelectView = new ArmySelectionView(playerOne, playerTwo, gameState);
		System.out.println("army select view created");
		
		//adds a card to the wrapper panel for the army selection view
		wrapperPanel.add(armySelectView, "armySelect");

		wrapperPanel.repaint();
	}
	
	public void createMatchView(Player playerOne, Player playerTwo, GameState gameState)
	{
		matchView = new MatchView(playerOne, playerTwo);
		
		//adds a card to the wrapper panel for the match view
		wrapperPanel.add(matchView, "matchView");
		
		wrapperPanel.repaint();
	}

    public void createLeaderboardView(GameState gameState)
    {
        leaderboardView = new LeaderboardView();
        
        wrapperPanel.add(leaderboardView, "leaderboardView");
        
        wrapperPanel.repaint();
    }
}