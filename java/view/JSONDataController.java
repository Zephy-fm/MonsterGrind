package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import model.Level;
import model.Player;
import model.Weapon;

/**
 * JsonDataController loads and saves all data
 * 	to json files that are used for game data.
 * @author frankminyon
 *
 * @version 10/11/17
 */
public class JSONDataController {
	private Reader playerData;
	private Reader levelData;
	private Reader weaponData;
	
	private HashMap<String, Weapon> weaponList;
	private HashMap<Integer, Level> levelList;
	
	/**
	 * Reads all data files and stores them.
	 * 	Prepares all game data lists.
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	game data != empty
	 */
	public JSONDataController() {
		this.weaponList = new HashMap<String, Weapon>();
		this.levelList = new HashMap<Integer, Level>();
		try {
			this.playerData = new FileReader("resources/data/playerData.json");
			this.weaponData = new FileReader("resources/data/weaponData.json");
			this.levelData = new FileReader("resources/data/levelData.json");
		} catch (FileNotFoundException error) {
			error.printStackTrace();
		}
		this.parseWeapons();
		this.parseLevels();
	}
	
	/**
	 * Loads a Player from the initiated Player file
	 * 
	 * @precondition 	none
	 * 
	 * @return			Player from data files
	 */
	public Player loadPlayer() {
		Gson gson = new Gson();
		return gson.fromJson(this.playerData, Player.class);
	}
	
	/**
	 * This method goes through the loaded Weapons data and 
	 * 	parses all the Weapons into Weapon objects
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	weapon list size > 0
	 */
	private void parseWeapons() {
		Gson gson = new Gson();
		JsonObject weaponTree = gson.fromJson(this.weaponData, JsonObject.class);
		for (Map.Entry<String, JsonElement> current : weaponTree.entrySet()) {
			JsonObject weaponArray = current.getValue().getAsJsonObject();
			Weapon parsedWeapon = gson.fromJson(weaponArray, Weapon.class);
			this.addWeapon(parsedWeapon);
		}
	}

	/**
	 * Verifies a parsed Weapon is initiated correctly and
	 * 	adds it to the game's Weapon list
	 * @param theWeapon 	Weapon to verify is a valid Weapon
	 * 
	 * @precondition 	theWeapon != null
	 * 
	 * @postcondition 	weapon list size += 1
	 */
	private void addWeapon(Weapon theWeapon) {
		if (theWeapon == null) {
			throw new IllegalArgumentException("cannot add null weapons to the game's weapon list");
		}
		this.weaponList.put(theWeapon.getId(), theWeapon);
	}
	
	/**
	 * This method goes through the loaded Level data and 
	 * 	parses all the Levels into Level objects
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	level list size > 0
	 */
	private void parseLevels() {
		Gson gson = new Gson();
		JsonObject levelTree = gson.fromJson(this.levelData, JsonObject.class);
		for (Map.Entry<String, JsonElement> current : levelTree.entrySet()) {
			JsonObject levelArray = current.getValue().getAsJsonObject();
			Level parsedLevel = gson.fromJson(levelArray, Level.class);
			addLevel(parsedLevel);
		}
	}
	
	/**
	 * Verifies a parsed Level is initiated correctly and
	 * 	adds it to the game's Level list
	 * @param theWeapon 	Level to verify is a valid Level
	 * 
	 * @precondition 	theLevel != null
	 * 
	 * @postcondition 	level list size += 1
	 */
	private void addLevel(Level theLevel) {
		if (theLevel == null) {
			throw new IllegalArgumentException("cannot add null levels to the game's level list");
		}
		this.levelList.put(theLevel.getLevelNumber(), theLevel);
	}

	/**
	 * Gets a Level based on the Level number specified
	 * @param levelNumber 	int containing Level number
	 * 
	 * @precondition 		levelNumber >= 0 && levelNumber <= 100
	 * 
	 * @return 				Level with specified Level number
	 */
	public Level getLevel(int levelNumber) {
		if (levelNumber < 0) {
			throw new IllegalArgumentException("levelNumber must not be negative");
		}
		if (levelNumber > 100) {
			throw new IllegalArgumentException("levelNumber must not be over 100");
		}
		return this.levelList.get(levelNumber);
	}
	
	/**
	 * Static method call that loads a specific level directly
	 * 	from the level data files.
	 * @param levelNumber 	int containing Level number
	 * 
	 * @precondition 		levelNumber >= 0 && levelNumber <= 100
	 * 
	 * @return				Level with specified Level number
	 */
	public static Level getLevelGlobal(int levelNumber) {
		if (levelNumber < 0) {
			throw new IllegalArgumentException("levelNumber must not be negative");
		}
		if (levelNumber > 100) {
			throw new IllegalArgumentException("levelNumber must not be over 100");
		}
		try {
			Gson gson = new Gson();
			Reader levelData = new FileReader("resources/data/levelData.json");
			JsonObject levelObject = gson.toJsonTree(levelData).getAsJsonObject();
			JsonArray levelArray = levelObject.get("" + levelNumber).getAsJsonArray();
			return gson.fromJson(levelArray, Level.class);
		} catch (FileNotFoundException error) {
			error.getStackTrace();
			return null;
		}
	}
	
	/*
	public Level loadLevel(int level) {
		JsonObject levelTree = this.gson.fromJson(this.levelData, JsonObject.class);
		JsonObject specifiedLevelJsonObject = levelTree.get("" + level).getAsJsonObject();
		return this.gson.fromJson(specifiedLevelJsonObject, Level.class);
	}
	*/
}
