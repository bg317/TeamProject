package dragonspiretournament.PlayerInformation;

import dragonspiretournament.GameObjects.Dragons.Dragon;
import java.util.Scanner;
import java.io.FileReader;
import java.io.*;

/**
 * The Class DragonInformation.
 */
public class DragonInformation {

	/** The dragon name. */
	private String dragonName;
	
	/** The icon location. */
	private String iconLocation;
	
	/** The dragon type. */
	private String dragonType;
	
	/** The dragon description. */
	private String dragonDescription;
	
	/** The dragon full art. */
	private String dragonFullArt;
	
	/** The dragon description location. */
	private String dragonDescriptionLocation;
	
	/** The dragon advantage. */
	private String dragonAdvantage;
	
	/**
	 * constructor takes info from a dragon object to show in an info box.
	 *
	 * @param dragon the dragon
	 */
	public DragonInformation(Dragon dragon)
	{
		dragonName = dragon.getName();
		iconLocation = dragon.getIcon();
		dragonType = dragon.getType();
		dragonDescriptionLocation = dragon.getDescription();
		dragonFullArt = "";
		dragonDescription = "";
		dragonAdvantage = "";
		
		try
		{
			Scanner scan = new Scanner(new FileReader(dragonDescriptionLocation));
			while(scan.hasNext())
			{
				dragonDescription += scan.nextLine();
			}
			
			scan.close();
		}
		catch (FileNotFoundException e)
		{
			
		}
		
	}
	
	/**
	 * Gets the species name of the dragon.
	 * @return a string of the species name of the dragon.
	 */
	public String getName()
	{
		return dragonName;
	}
	
	/**
	 * Gets the elemental type of the dragon.
	 * @return a string of the elemental type of the dragon.
	 */
	public String getType()
	{
		return dragonType;
	}
	
	/**
	 * Gets the flavor text paragraph about that species of dragon.
	 * @return a string of the description text.
	 */
	public String getDescription()
	{
		return dragonDescription;
	}
	
	/**
	 * Gets the icon location path.
	 * @return a string of the icon location path.
	 */
	public String getIcon()
	{
		return iconLocation;
	}
	
	/**
	 * Gets the full body art of the dragon species location.
	 * @return a string of the location of the full body art.
	 */
	public String getArt()
	{
		return dragonFullArt;
	}
	
	/**
	 * Gets the advantage.
	 *
	 * @return the advantage
	 */
	public String getAdvantage()
	{
		return dragonAdvantage;
	}
}
