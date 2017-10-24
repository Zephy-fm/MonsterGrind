package model;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

/**
 * JsonDataController loads and saves all data
 * 	to json files that are used for game data.
 * 
 * @author frankminyon
 *
 * @version 10/24/17
 */
public class JSONDataController {
	private Reader playerData;
	private Reader levelData;
	private Reader weaponData;
	private Reader enchantData;
	private Reader armorData;
	private Reader accessoryData;
	
	private HashMap<String, Weapon> weaponList;
	private HashMap<Integer, Level> levelList;
	private HashMap<String, Enchant> enchantList;
	private HashMap<String, Armor> armorList;
	private HashMap<String, Accessory> accessoryList;
	
	/**
	 * Prepares all data lists
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	game data lists != null
	 */
	public JSONDataController() {
		try {
			this.playerData = new FileReader("resources/data/playerData.json");
			this.weaponData = new FileReader("resources/data/weaponData.json");
			this.levelData = new FileReader("resources/data/levelData.json");
			this.enchantData = new FileReader("resources/data/enchantData.json");
			this.armorData = new FileReader("resources/data/armorData.json");
			this.accessoryData = new FileReader("resources/data/accessoryData.json");
		} catch (FileNotFoundException error) {
			error.printStackTrace();
		}
		this.weaponList = new HashMap<String, Weapon>();
		this.levelList = new HashMap<Integer, Level>();
		this.enchantList = new HashMap<String, Enchant>();
		this.armorList = new HashMap<String, Armor>();
		this.accessoryList = new HashMap<String, Accessory>();
		
		this.loadAllData();
	}
	
	/**
	 * Populates all the game data lists with
	 * 	information from the data files.
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	game data lists != empty
	 */
	public void loadAllData() {
		this.parseWeapons();
		this.parseLevels();
		this.parseEnchants();
		this.parseArmor();
		this.parseAccessory();
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
	 * Saves the character data to local files
	 * 
	 * @param thePlayer 	Player to save
	 * 
	 * @precondition 	thePlayer != null
	 * 
	 * @postcondition 	game data is saved
	 */
	public void save(Player thePlayer) {
		if (thePlayer == null) {
			throw new IllegalArgumentException("thePlayer cannot be null");
		}
		try (Writer writer = new FileWriter("resources/data/playerData.json")) {
			Gson gson = new GsonBuilder().create();
			gson.toJson(thePlayer, writer);
		} catch (IOException error) {
			error.printStackTrace();
		}
	}
	
	
	/**
	 * This method goes through the loaded Weapons data and 
	 * 	parses all the Weapons into Weapon objects
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Weapon list size > 0
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
	 * 
	 * @param theWeapon 	Weapon to verify is a valid Weapon
	 * 
	 * @precondition 	theWeapon != null
	 * 
	 * @postcondition 	Weapon list size += 1
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
	 * @postcondition 	Level list size > 0
	 */
	private void parseLevels() {
		Gson gson = new Gson();
		JsonObject levelTree = gson.fromJson(this.levelData, JsonObject.class);
		for (Map.Entry<String, JsonElement> current : levelTree.entrySet()) {
			JsonObject levelArray = current.getValue().getAsJsonObject();
			Level parsedLevel = gson.fromJson(levelArray, Level.class);
			this.addLevel(parsedLevel);
		}
	}
	
	/**
	 * Verifies a parsed Level is initiated correctly and
	 * 	adds it to the game's Level list
	 * 
	 * @param theWeapon 	Level to verify is a valid Level
	 * 
	 * @precondition 	theLevel != null
	 * 
	 * @postcondition 	Level list size += 1
	 */
	private void addLevel(Level theLevel) {
		if (theLevel == null) {
			throw new IllegalArgumentException("cannot add null levels to the game's level list");
		}
		this.levelList.put(theLevel.getLevelNumber(), theLevel);
	}
	
	/**
	 * This method goes through the loaded Enchant data and 
	 * 	parses all the Enchants into Enchant objects
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Enchant list size > 0
	 */
	private void parseEnchants() {
		Gson gson = new Gson();
		JsonObject enchantTree = gson.fromJson(this.enchantData, JsonObject.class);
		for (Map.Entry<String, JsonElement> current : enchantTree.entrySet()) {
			JsonObject enchantArray = current.getValue().getAsJsonObject();
			Enchant parsedEnchant = gson.fromJson(enchantArray, Enchant.class);
			this.addEnchant(parsedEnchant);
		}
	}
	
	/**
	 * Verifies a parsed Enchant is initiated correctly and
	 * 	adds it to the game's Enchant list
	 * 
	 * @param theEnchant	Enchant to verify is a valid Enchant
	 * 
	 * @precondition 	theEnchant != null
	 * 
	 * @postcondition 	Enchant list size += 1
	 */
	private void addEnchant(Enchant theEnchant) {
		if (theEnchant == null) {
			throw new IllegalArgumentException("Cannot add null enchants to the game's enchant list");
		}
		this.enchantList.put(theEnchant.getId(), theEnchant);
	}
	
	/**
	 * This method goes through the loaded Armor data and 
	 * 	parses all the Armors into Armor objects
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Armor list size > 0
	 */
	private void parseArmor() {
		Gson gson = new Gson();
		JsonObject armorTree = gson.fromJson(this.armorData, JsonObject.class);
		for (Map.Entry<String, JsonElement> current : armorTree.entrySet()) {
			JsonObject armorArray = current.getValue().getAsJsonObject();
			Armor parsedArmor = gson.fromJson(armorArray, Armor.class);
			this.addArmor(parsedArmor);
		}
	}
	
	/**
	 * Verifies a parsed Armor is initiated correctly and
	 * 	adds it to the game's Armor list
	 * 
	 * @param theArmor	Armor to verify is a valid Armor
	 * 
	 * @precondition 	theArmor != null
	 * 
	 * @postcondition 	Armor list size += 1
	 */
	private void addArmor(Armor theArmor) {
		if (theArmor == null) {
			throw new IllegalArgumentException("Cannot add null armor to the game's armor list");
		}
		this.armorList.put(theArmor.getId(), theArmor);
	}
	
	/**
	 * This method goes through the loaded Accessory data and 
	 * 	parses all the Accessories into Accessory objects
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Accessory list size > 0
	 */
	private void parseAccessory() {
		Gson gson = new Gson();
		JsonObject accessoryTree = gson.fromJson(this.accessoryData, JsonObject.class);
		for (Map.Entry<String, JsonElement> current : accessoryTree.entrySet()) {
			JsonObject accessoryArray = current.getValue().getAsJsonObject();
			Accessory parsedAccessory = gson.fromJson(accessoryArray, Accessory.class);
			this.addAccessory(parsedAccessory);
		}
	}
	
	/**
	 * Verifies a parsed Accessory is initiated correctly and
	 * 	adds it to the game's Accessory list
	 * 
	 * @param theAccessory	Accessory to verify is a valid Armor
	 * 
	 * @precondition 	theAccessory != null
	 * 
	 * @postcondition 	Accessory list size += 1
	 */
	private void addAccessory(Accessory theAccessory) {
		if (theAccessory == null) {
			throw new IllegalArgumentException("Cannot add null accessory to the game's accessory list");
		}
		this.accessoryList.put(theAccessory.getId(), theAccessory);
	}

	/**
	 * Gets a Level based on the Level number specified
	 * 
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
		Level fetchedLevel = this.levelList.get(levelNumber);
		if (fetchedLevel == null) {
			throw new NullPointerException("the provided levelNumber could not find a corresponding Level object."
					+ "\nPlease check the following levelNumber and ensure it is correct: " + levelNumber);
		}
		return fetchedLevel;
	}

	/**
	 * Gets a Weapon based on the Weapon id specified
	 * 
	 * @param weaponID 		String containing Weapon id
	 * 
	 * @precondition 		weaponID != null
	 * 
	 * @return 				Weapon with specified Weapon id
	 */
	public Weapon getWeapon(String weaponID) {
		if (weaponID == null) {
			throw new IllegalArgumentException("weaponID cannot be null");
		}
		Weapon fetchedWeapon = this.weaponList.get(weaponID);
		if (fetchedWeapon == null) {
			throw new NullPointerException("the provided weaponID could not find a corresponding Weapon object."
					+ "\nPlease check the following weaponID and ensure it is correct: " + weaponID);
		}
		return fetchedWeapon;
	}

	/**
	 * Gets an Enchant based on the Enchant id specified
	 * 
	 * @param enchantID 		String containing Enchant id
	 * 
	 * @precondition 		enchantID != null
	 * 
	 * @return 				Enchant with specified Enchant id
	 */
	public Enchant getEnchant(String enchantID) {
		if (enchantID == null) {
			throw new IllegalArgumentException("enchantID cannot be null");
		}
		Enchant fetchedEnchant = this.enchantList.get(enchantID);
		if (fetchedEnchant == null) {
			throw new NullPointerException("the provided enchantID could not find a corresponding Enchant object."
					+ "\nPlease check the following enchantID and ensure it is correct: " + enchantID);
		}
		return fetchedEnchant;
	}

	/**
	 * Gets an Armor based on the Armor id specified
	 * 
	 * @param armorID 		String containing Armor id
	 * 
	 * @precondition 		armorID != null
	 * 
	 * @return 				Armor with specified Armor id
	 */
	public Armor getArmor(String armorID) {
		if (armorID == null) {
			throw new IllegalArgumentException("armorID cannot be null");
		}
		Armor fetchedArmor = this.armorList.get(armorID);
		if (fetchedArmor == null) {
			throw new NullPointerException("the provided armorID could not find a corresponding Armor object."
					+ "\nPlease check the following armorID and ensure it is correct: " + armorID);
		}
		return fetchedArmor;
	}

	/**
	 * Gets an Accessory based on the Accessory id specified
	 * 
	 * @param accessoryID 		String containing Accessory id
	 * 
	 * @precondition 		accessoryID != null
	 * 
	 * @return 				Accessory with specified Accessory id
	 */
	public Accessory getAccessory(String accessoryID) {
		if (accessoryID == null) {
			throw new IllegalArgumentException("accessoryID cannot be null");
		}
		Accessory fetchedAccessory = this.accessoryList.get(accessoryID);
		if (fetchedAccessory == null) {
			throw new NullPointerException("the provided accessoryID could not find a corresponding Accessory object."
					+ "\nPlease check the following accessoryID and ensure it is correct: " + accessoryID);
		}
		return fetchedAccessory;
	}
	
	/**
	 * Generates a description of the current JSONDataController and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing description of JSONDataController
	 */
	public String toString() {
		return "JSONDataController:"
				+ "\n->weapon list size: " + this.weaponList.size()
				+ "\n->level list size: " + this.levelList.size()
				+ "\n->armor list size: " + this.armorList.size()
				+ "\n->enchant list size: " + this.enchantList.size()
				+ "\n->accessory list size: " + this.accessoryList.size();
	}
	
}
