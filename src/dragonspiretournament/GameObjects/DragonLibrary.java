package dragonspiretournament.GameObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

import dragonspiretournament.GameObjects.Dragons.*;

public class DragonLibrary {
	
	private ArrayList<String> dragonLibrary;
	private Map<String, Object> dragons;
	
	/**
	 * All dragons are pulled in from an external yaml file 
	 * located in src/dragons/dragons.yaml
	 * @throws FileNotFoundException 
	 */
	public DragonLibrary() throws FileNotFoundException {
		Yaml yaml = new Yaml();
		InputStream input = new FileInputStream(new File("src/dragons/Dragons.yaml"));
		dragonLibrary = (ArrayList<String>) yaml.load(input);
		System.out.println( dragonLibrary );
	}
	
	
	

}
