package dragonspiretournament.GameObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;

import org.yaml.snakeyaml.Yaml;

import dragonspiretournament.GameObjects.Dragons.*;

/**
 * Class to create a library to store data on all dragons available
 *
 * @author Team 29 (LA)
 * 
 * @version Apr 9, 2016
 */

public class DragonLibrary {
	
	private ArrayList<Dragon> dragonLibrary;

	/**
	 * Creates a dragon library containing one of each dragon
	 * 
	 * @param none
	 */

	public DragonLibrary() {
	    dragonLibrary = new ArrayList<Dragon>();
	    Dragon tmp;

	    tmp = new Dragon("Igneagnus", "Fire", "Ice", "images/Igneagnus.jpg");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Tenebret", "Ice", "Wind", "images/Tenebret.jpg");
        dragonLibrary.add(tmp);

        tmp = new Dragon("WindDragon", "Wind", "Earth", "images/WindDragon.jpg");
        dragonLibrary.add(tmp);

        tmp = new Dragon("EarthDragon", "Earth", "Electricity", "images/EarthDragon.jpg");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Galthi", "Electricity", "Water", "images/Galthi.jpg");
        dragonLibrary.add(tmp);

        tmp = new Dragon("WaterDragon", "Water", "Fire", "images/WaterDragon.jpg");
        dragonLibrary.add(tmp);
	}

	/**
	 * Returns the Dragon located a specific position in the library
	 * 
	 * @param  index Library index
	 * 
	 * @return Dragon located at specific index
	 */

	public Dragon getDragon(int index) {
	    return dragonLibrary.get(index);
	}
}	
	
	
	
	
	
	
/* YAML Section commented out
	@SuppressWarnings("unused")
	private Map<String, Object> dragons;
	
	/**
	 * All dragons are pulled in from an external yaml file 
	 * located in src/dragons/dragons.yaml
	 * @throws FileNotFoundException 
	 *
	@SuppressWarnings("unchecked")
	public DragonLibrary() throws FileNotFoundException {
		Yaml yaml = new Yaml();
		InputStream input = new FileInputStream(new File("src/dragons/Dragons.yaml"));
		dragonLibrary = (ArrayList<String>) yaml.load(input);
		System.out.println( dragonLibrary );
	}
}
*/