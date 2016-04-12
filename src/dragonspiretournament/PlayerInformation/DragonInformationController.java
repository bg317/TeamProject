package dragonspiretournament.PlayerInformation;
import dragonspiretournament.GameObjects.Dragons.Dragon;

import javax.swing.ImageIcon;

import dragonspiretournament.GameObjects.Dragons.Dragon;

public class DragonInformationController {
	
	static DragonInformation dragonInfo;
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
	
	public static String getArt()
	{
		if(dragonSet == true)
		{
		return dragonInfo.getArt();
		}
		else
		{
			return "src/dragons/art/PlaceholderL.png";
		}
	}
	
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
	
	/** Returns an ImageIcon, or null if the path was invalid. */
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
