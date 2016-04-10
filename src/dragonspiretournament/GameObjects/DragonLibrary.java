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

	    tmp = new Dragon("Igneagnus", "Lava", "Flora", "src/dragons/icons/Igneagnus.png");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Tenebret", "Ice", "Lava", "src/dragons/icons/Tenebret.png");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Arinial", "Metal", "Ice", "src/dragons/icons/Arinial.png");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Skenna", "Goo", "Storm", "src/dragons/icons/Skenna.png");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Fladoen", "Solar", "Goo", "src/dragons/icons/Fladoen.png");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Galthi", "Storm", "Metal", "src/dragons/icons/Galthi.png");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Trudrake", "Flora", "Solar", "src/dragons/icons/Trudrake.png");
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

    /**
     * Returns the entire Dragon Library
     * 
     * @param  none
     * 
     * @return ArrayList containing all dragons in the library
     */

    public ArrayList<Dragon> getLibrary() {
        return dragonLibrary;
    }

    /**
     * Returns the size of the dragon library
     * 
     * @param  none
     * 
     * @return integer size of dragon library
     */

    public int getSize() {
        return dragonLibrary.size();
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