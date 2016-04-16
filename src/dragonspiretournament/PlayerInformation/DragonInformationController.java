package dragonspiretournament.PlayerInformation;
import dragonspiretournament.GameObjects.Dragons.Dragon;

import javax.swing.ImageIcon;

import dragonspiretournament.GameObjects.Dragons.Dragon;

/**
 * The Class DragonInformationController.
 */
public class DragonInformationController {
	
	/** The dragon info. */
	static DragonInformation dragonInfo;
	 
 	/** The dragon set. */
 	//only is true once we have a valid dragon stored
	static boolean dragonSet = false;
	
	/**
	 * Determines which dragon the information window will be about based on a passed
	 * in dragon object.
	 * @param dragon the dragon whose info we want to display.
	 */
	public static void setDragon(Dragon dragon)
	{
		if (dragon != null)
		{
		dragonInfo = new DragonInformation(dragon);
		dragonSet = true;
		}
	}
	
	/**
	 * Gets the name of the dragon.
	 * @return a string name of the dragon.
	 */
	public static String getName()
	{
		if(dragonSet == true)
		{
		return dragonInfo.getName();
		}
		else
		{
			return "No Data";
		}
	}
	
	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public static String getDescription()
	{
		if(dragonSet == true)
		{
		return dragonInfo.getDescription();
		}
		else
		{
			return "No Data";
		}
	}
	
	/**
	 * Gets the art.
	 *
	 * @return the art
	 */
	public static String getArt()
	{
		if(dragonSet == true)
		{
		return "src/dragons/art/" + dragonInfo.getName() + "L.png";
		}
		else
		{
			return "src/dragons/art/PlaceholderL.png";
		}
	}
	
	/**
	 * Gets the icon.
	 *
	 * @return the icon
	 */
	public static String getIcon()
	{
		if(dragonSet == true)
		{
		return dragonInfo.getIcon();
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public static String getType()
	{
		if(dragonSet == true)
		{
		return dragonInfo.getType();
		}
		else
		{
			return "No Data";
		}
	}
	
	/**
	 * Gets the advantage.
	 *
	 * @return the advantage
	 */
	public static String getAdvantage()
	{
		if (dragonSet == true)
		{
			return dragonInfo.getAdvantage();
		}
		else
		{
			return "No Data";
		}
	}
	
	/**
	 *  Returns an ImageIcon, or null if the path was invalid.
	 *
	 * @param path the path
	 * @param altText the alt text
	 * @return the image icon
	 */
	public static ImageIcon createIcon(String path, String altText) {
	    java.net.URL imageLocation = DragonInformationView.class.getResource(path);
	    if (imageLocation != null) {
	        return new ImageIcon(imageLocation, altText);
	    } 
	    else {
	        System.out.println("file not found at: " + path);
	        return null;
	    }
	}
}
