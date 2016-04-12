package dragonspiretournament.PlayerInformation;

import dragonspiretournament.GameObjects.Dragons.Dragon;
import java.util.Scanner;
import java.io.FileReader;
import java.io.*;

public class DragonInformation {

	private String dragonName;
	private String iconLocation;
	private String dragonType;
	private String dragonDescription;
	private String dragonFullArt;
	private String dragonDescriptionLocation;
	private String dragonAdvantage;
	
	/**
	 * constructor takes info from a dragon object to show in an info box.
	 */
	DragonInformation(Dragon dragon)
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
	
	public String getAdvantage()
	{
		return dragonAdvantage;
	}
}
