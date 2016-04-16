package dragonspiretournament.GameObjects;

import java.util.ArrayList;
import dragonspiretournament.GameObjects.Dragons.*;

/**
 * Class to create a library to store data on all dragons available.
 *
 * @author Team 29 (LA)
 * @version Apr 10, 2016
 */

public class DragonLibrary {
	
	/** The dragon library. */
	private ArrayList<Dragon> dragonLibrary;

	/**
	 * Creates a dragon library containing one of each dragon.
	 */

	public DragonLibrary() {
	    dragonLibrary = new ArrayList<Dragon>();
	    Dragon tmp;

	    tmp = new Dragon("Igneagnus", "Lava", "Flora", "src/dragons/icons/Igneagnus.png", "src/dragons/descr/Igneagnus.txt");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Tenebret", "Ice", "Lava", "src/dragons/icons/Tenebret.png", "src/dragons/descr/Tenebret.txt");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Arinial", "Metal", "Ice", "src/dragons/icons/Arinial.png", "src/dragons/descr/Arinial.txt");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Skenna", "Goo", "Storm", "src/dragons/icons/Skenna.png", "src/dragons/descr/Skenna.txt");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Fladoen", "Solar", "Goo", "src/dragons/icons/Fladoen.png", "src/dragons/descr/Fladoen.txt");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Galthi", "Storm", "Metal", "src/dragons/icons/Galthi.png", "src/dragons/descr/Galthi.txt");
        dragonLibrary.add(tmp);

        tmp = new Dragon("Trudrake", "Flora", "Solar", "src/dragons/icons/Trudrake.png", "src/dragons/descr/Trudrake.txt");
        dragonLibrary.add(tmp);
	}

	/**
	 * Returns the Dragon located a specific position in the library.
	 *
	 * @param index the index
	 * @return Dragon located at specific index
	 */

	public Dragon getDragon(int index) {
	    return dragonLibrary.get(index);
	}

    /**
     * Returns the entire Dragon Library.
     *
     * @return ArrayList containing all dragons in the library
     */

    public ArrayList<Dragon> getLibrary() {
        return dragonLibrary;
    }

    /**
     * Returns the size of the dragon library.
     *
     * @return integer size of dragon library
     */

    public int getSize() {
        return dragonLibrary.size();
    }
}	
	
	
	
/*
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.swing.Icon;
import org.yaml.snakeyaml.Yaml;
	
 */
	
	
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