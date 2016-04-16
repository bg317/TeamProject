package dragonspiretournament.nameselection;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import dragonspiretournament.GameObjects.Player;

/**
 * The Class NameSelectionView.
 */
public class NameSelectionView {
	
	/** The name frame. */
	//not sure if we want a frame here, but this is for testing purposes
	private JFrame nameFrame;
	
	/** The total panel. */
	//all components to be added to the JPanel totalPanel, and totalPanel will be added to the frame
	private JPanel totalPanel;
	
	/** The instruction label. */
	private JLabel instructionLabel;
	
	/** The name entry. */
	private JTextField nameEntry;
	
	/** The submit button. */
	private JButton submitButton;
	
	/** The entry and submit. */
	private JPanel entryAndSubmit;
	
	/** The instruction text. */
	//variables to hold text that changes
	private String instructionText;
	
	/** The current player. */
	private String currentPlayer;
	
	/** The player two. */
	private Player playerTwo;
	
	/** The player one. */
	private Player playerOne;
	
	
	/**
	 * Instantiates a new name selection view.
	 *
	 * @param playerOne the player one
	 * @param playerTwo the player two
	 */
	//constructor
	public NameSelectionView( Player playerOne, Player playerTwo )
	{
		
		NameSelectionController.setPlayerOne( playerOne );
		NameSelectionController.setPlayerTwo( playerTwo );
		//preparing the text that changes before sending it to the elements
		//the text we want will be found by the controller

		//current player is assumed to be player 1 until we are told otherwise
		currentPlayer = NameSelectionController.getPlayer();
		
		instructionText = currentPlayer + " enter your name: ";
		
		//creating a frame
		nameFrame = new JFrame("Dragonspire Tournament--Name Selection");
		
		//initializing the J elements
		totalPanel = new JPanel(new GridLayout(2,1));
		entryAndSubmit = new JPanel();
		//swing constants center centers the text across 
		instructionLabel = new JLabel(instructionText, SwingConstants.CENTER);
		//setting the default value of the name entry field
		nameEntry = new JTextField(currentPlayer);
		submitButton = new JButton("Submit");
		
		//adding the J elements to the total panel
		totalPanel.add(instructionLabel);
		entryAndSubmit.add(nameEntry);
		entryAndSubmit.add(submitButton);
		totalPanel.add(entryAndSubmit);
		
		//adds functionality to the button
		submitButton.addActionListener((ActionListener) new ButtonListener());
		
		
		//frame stuff
		nameFrame.getContentPane().add(totalPanel);
		nameFrame.setSize(500, 500);
		
		nameFrame.setVisible(true);
	}
	
	/**
	 * The listener interface for receiving button events.
	 * The class that is interested in processing a button
	 * event implements this interface, and the object created
	 * with that class is registered with a component using the
	 * component's <code>addButtonListener<code> method. When
	 * the button event occurs, that object's appropriate
	 * method is invoked.
	 *
	 * @see ButtonEvent
	 */
	//for determining whether we are going to get the second player input or move to start the game
	 private class ButtonListener implements ActionListener
	   {
		 
		 /**
 		 * when the button is pressed.
 		 *
 		 * @param e the e
 		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			
			//set the name based on what the user entered
			NameSelectionController.setName(nameEntry.getText());
			
			//then moving on to the game if we're on player 2
			if (NameSelectionController.goToNextFrame() == true)
			{
				//start game
			}
			//go to player 2 if on player 1
			else
			{
				
				//we do it all again for player 2
				currentPlayer = NameSelectionController.getPlayer();
				instructionText = currentPlayer + " enter your name: ";
				instructionLabel.setText(instructionText);
				//setting the default value of the name entry field
				nameEntry.setText(currentPlayer);
				
			}
		}
	}
	
}
