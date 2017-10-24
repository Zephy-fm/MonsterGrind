package model;

import java.util.ArrayList;

import controller.ApplicationController;

/**
 * EquipmentManager handles the stats and effects
 * 	found within equipment
 * 
 * @author FrankMinyon
 *
 * @version 10/24/17
 */
public class EquipmentManager {
	private Weapon weapon;
	private Armor armor;
	private Accessory accessory1;
	private Accessory accessory2;
	
	/**
	 * Creates an EquipmentManager object with information
	 * 	given to generate details about a set of Equipment objects
	 * 
	 * @param weaponID		String containing weapon ID
	 * @param armorID		String containing armor ID
	 * @param accessory1ID	String containing accessory 1 ID
	 * @param accessory2ID	String containing accessory 2 ID
	 * 
	 * @precondition 		weaponID != null
	 * 						armorID != null
	 * 						accessory1ID != null
	 * 						accessory2ID != null
	 * 
	 * @postcondition 		all equipment item data is loaded and ready
	 */
	public EquipmentManager(String weaponID, String armorID, String accessory1ID, String accessory2ID) {
		this.weapon = ApplicationController.GAMEDATA.getWeapon(weaponID);
		this.armor = ApplicationController.GAMEDATA.getArmor(armorID);
		this.accessory1 = ApplicationController.GAMEDATA.getAccessory(accessory1ID);
		this.accessory2 = ApplicationController.GAMEDATA.getAccessory(accessory2ID);
	}
	
	/**
	 * Gets the Weapon object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			Weapon contained in the EquipmentManager
	 */
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	/**
	 * Gets the Armor object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			Armor contained in the EquipmentManager
	 */
	public Armor getArmor() {
		return this.armor;
	}
	
	/**
	 * Gets the Accessory object and returns it
	 * 	(from accessory1)
	 * 
	 * @precondition 	none
	 * 
	 * @return			Accessory contained in the EquipmentManager
	 */
	public Accessory getAccessory1() {
		return this.accessory1;
	}
	
	/**
	 * Gets the Accessory object and returns it
	 * 	(from accessory2)
	 * 
	 * @precondition 	none
	 * 
	 * @return			Accessory contained in the EquipmentManager
	 */
	public Accessory getAccessory2() {
		return this.accessory2;
	}
	
	/**
	 * Equips a Weapon provided from the Weapon ID
	 * 
	 * @param weaponID 	String containing the Weapon ID
	 * 
	 * @precondition 	weaponID != null
	 * 
	 * @postcondition 	getWeapon() == Weapon from weaponID
	 */
	public void equipWeapon(String weaponID) {
		if (weaponID == null) {
			throw new IllegalArgumentException("weaponID cannot be null");
		}
		this.weapon = ApplicationController.GAMEDATA.getWeapon(weaponID);
	}
	
	/**
	 * Equips the Weapon provided in the parameters
	 * 
	 * @param theWeapon	Weapon to equip over the current Weapon
	 * 
	 * @precondition 	theWeapon != null
	 * 
	 * @postcondition 	getWeapon() == theWeapon
	 */
	public void equipWeapon(Weapon theWeapon) {
		if (theWeapon == null) {
			throw new IllegalArgumentException("theWeapon cannot be null");
		}
		this.weapon = theWeapon;
	}
	
	/**
	 * Equips Armor provided from the Armor ID
	 * 
	 * @param armorID 	String containing the Armor ID
	 * 
	 * @precondition 	armorID != null
	 * 
	 * @postcondition 	getArmor() == Armor from armorID
	 */
	public void equipArmor(String armorID) {
		if (armorID == null) {
			throw new IllegalArgumentException("armorID cannot be null");
		}
		this.armor = ApplicationController.GAMEDATA.getArmor(armorID);
	}
	
	/**
	 * Equips the Armor provided in the parameters
	 * 
	 * @param theArmor	Armor to equip over the current Armor
	 * 
	 * @precondition 	theArmor != null
	 * 
	 * @postcondition 	getArmor() == theArmor
	 */
	public void equipArmor(Armor theArmor) {
		if (theArmor == null) {
			throw new IllegalArgumentException("theArmor cannot be null");
		}
		this.armor = theArmor;
	}
	
	/**
	 * Equips a Accessory provided from the Accessory ID
	 * 	into the Accessory1 slot
	 * 
	 * @param accessoryID 	String containing the Accessory ID
	 * 
	 * @precondition 		accessoryID != null
	 * 
	 * @postcondition 		getAccessory1() == Accessory from accessoryID
	 */
	public void equipAccessory1(String accessoryID) {
		if (accessoryID == null) {
			throw new IllegalArgumentException("accessoryID cannot be null");
		}
		this.accessory1 = ApplicationController.GAMEDATA.getAccessory(accessoryID);
	}
	
	/**
	 * Equips the Accessory provided in the parameters
	 * 	into the Accessory1 slot
	 * 
	 * @param theAccessory	Accessory to equip over the current Accessory1
	 * 
	 * @precondition 		theAccessory != null
	 * 
	 * @postcondition 		getAccessory1() == theAccessory
	 */
	public void equipAccessory1(Accessory theAccessory) {
		if (theAccessory == null) {
			throw new IllegalArgumentException("theAccessory cannot be null");
		}
		this.accessory1 = theAccessory;
	}
	
	/**
	 * Equips a Accessory provided from the Accessory ID
	 * 	into the Accessory2 slot
	 * 
	 * @param accessoryID 	String containing the Accessory ID
	 * 
	 * @precondition 		accessoryID != null
	 * 
	 * @postcondition 		getAccessory2() == Accessory from accessoryID
	 */
	public void equipAccessory2(String accessoryID) {
		if (accessoryID == null) {
			throw new IllegalArgumentException("accessoryID cannot be null");
		}
		this.accessory2 = ApplicationController.GAMEDATA.getAccessory(accessoryID);
	}
	
	/**
	 * Equips the Accessory provided in the parameters
	 * 	into the Accessory2 slot
	 * 
	 * @param theAccessory	Accessory to equip over the current Accessory2
	 * 
	 * @precondition 		theAccessory != null
	 * 
	 * @postcondition 		getAccessory2() == theAccessory
	 */
	public void equipAccessory2(Accessory theAccessory) {
		if (theAccessory == null) {
			throw new IllegalArgumentException("theAccessory cannot be null");
		}
		this.accessory2 = theAccessory;
	}
	
	/**
	 * Calculates the total attack power provided from
	 * 	all of the Equipment in the EquipmentManager
	 * 
	 * @precondition 	none
	 * 
	 * @return			int containing total attack power
	 */
	public int getAttackPower() {
		int attackDamageCalc = this.weapon.getAttackPower();
		attackDamageCalc += this.accessory1.getAttackPower();
		attackDamageCalc += this.accessory2.getAttackPower();
		return attackDamageCalc;
	}
	
	/**
	 * Calculates the total magic power provided from
	 * 	all of the Equipment in the EquipmentManager
	 * 
	 * @precondition 	none
	 * 
	 * @return			int containing total magic power
	 */
	public int getMagicPower() {
		int magicDamageCalc = this.weapon.getMagicPower();
		magicDamageCalc += this.accessory1.getMagicPower();
		magicDamageCalc += this.accessory2.getMagicPower();
		return magicDamageCalc;
	}
	
	/**
	 * Calculates the total magic power provided from stat
	 * 	all of the Equipment in the EquipmentManager
	 * 
	 * @precondition 	none
	 * 
	 * @return			int containing total magic power
	 */
	public int getCriticalChance() {
		int criticalChanceCalc = this.accessory1.getCriticalChance();
		criticalChanceCalc += this.accessory2.getCriticalChance();
		return criticalChanceCalc;
	}
	
	/**
	 * Gathers all of the Enchants from the Equipment
	 * 	and then returns them.
	 * 
	 * @precondition 	none
	 * 
	 * @return			ArrayList<Enchant> with Equipment Enchants
	 */
	public ArrayList<Enchant> getEnchants() {
		ArrayList<Enchant> enchantList = new ArrayList<Enchant>();
		
		String weaponEnchantID = this.weapon.getEnchantID();
		enchantList.add(ApplicationController.GAMEDATA.getEnchant(weaponEnchantID));
		
		String armorEnchantID = this.armor.getEnchantID();
		enchantList.add(ApplicationController.GAMEDATA.getEnchant(armorEnchantID));
		
		String accessory1EnchantID = this.accessory1.getEnchantID();
		enchantList.add(ApplicationController.GAMEDATA.getEnchant(accessory1EnchantID));
		
		String accessory2EnchantID = this.accessory2.getEnchantID();
		enchantList.add(ApplicationController.GAMEDATA.getEnchant(accessory2EnchantID));
		
		return enchantList;
	}
	
}
