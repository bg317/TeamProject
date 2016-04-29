package dragonspiretournament.PlayerInformation;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * The Class PlayerChangeNotification.
 */
public class PlayerChangeNotification extends JDialog implements ActionListener{

	/**  Unique ID for the action Listener. */
	private static final long serialVersionUID = 4000;
	//I think this number identifies the event caller so you don't have to 
	// parse String[] el =  e.getSource().toString().split("text="); 

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		setVisible(false); 
	    dispose(); 
		
	}
	
	/**
	 *  Default Constructor
	 *  Indicates to the player it is his opponents turn.
	 */
	public PlayerChangeNotification(){
		JOptionPane.showMessageDialog( null, "Please Change Players");
	}
	
	
	/**
	 *  Overloaded Constructor
	 *  Can display custom title and message and is aware of parent frames location and size
	 *  
	 *  @param parent the JFrame that calls this dialog
	 *  @param title the text that will appear in the title bar of this dialog
	 *  @param message the message that will appear in this dialog
	 */
	//Create a JDialog box for notifying players will be switching on construction
	 public PlayerChangeNotification(JFrame parent, String title, String message) {
		    super(parent, title, true);
		    
		    if (parent != null) {
		      Dimension parentSize = parent.getSize(); 
		      Point p = parent.getLocation(); 
		      setLocation(p.x + parentSize.width / 4, p.y + parentSize.height / 4);
		    }
		    
		    JPanel messagePane = new JPanel();
		    messagePane.add(new JLabel(message));
		    getContentPane().add(messagePane);
		    JPanel buttonPane = new JPanel();
		    JButton button = new JButton("OK"); 
		    buttonPane.add(button); 
		    button.addActionListener(this);
		    getContentPane().add(buttonPane, BorderLayout.SOUTH);
		    setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		    pack(); 
		    setVisible(true);
	 }
	 
	 
	
}
