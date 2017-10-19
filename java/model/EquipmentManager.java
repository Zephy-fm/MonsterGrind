package model;

import view.ApplicationController;

/**
 * EquipmentManager handles the stats and effects
 * 	found within equipment
 * 
 * @author FrankMinyon
 *
 * @version 10/19/17
 */
public class EquipmentManager {
	private Weapon weapon;
	private Weapon armor;
	private Weapon accessory1;
	private Weapon accessory2;
	
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
		this.weapon = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
		this.armor = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
		this.accessory1 = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
		this.accessory2 = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
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
	 * Equips a weapon provided from the Weapon ID
	 * 
	 * @param weaponID 	String containing the Weapon ID
	 * 
	 * @precondition 	weaponID != null
	 * 
	 * @postcondition 	getWeapon() == weapon from weaponID
	 */
	public void equipWeapon(String weaponID) {
		if (weaponID == null) {
			throw new IllegalArgumentException("weaponID cannot be null");
		}
		this.weapon = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
	}
	
	/**
	 * Equips a Weapon provided in the parameters
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
	 * Calculates the total attack power provided from
	 * 	all of the Equipment in the EquipmentManager
	 * 
	 * @precondition 	none
	 * 
	 * @return			int containing total attack power
	 */
	public int getAttackPower() {
		int attackDamageCalc = this.weapon.getAttackPower();
		attackDamageCalc += this.armor.getAttackPower();
		attackDamageCalc += this.accessory1.getAttackPower();
		return attackDamageCalc + this.accessory2.getAttackPower();
	}
	
	/**
	 * Calculates the total magic power provided from
	 * 	all of the Equipment in the EquipmentManager
	 * 
	 * @precondtion 	none
	 * 
	 * @return		int containing total magic power
	 */
	public int getMagicPower() {
		int magicDamageCalc = this.weapon.getMagicPower();
		magicDamageCalc += this.armor.getMagicPower();
		magicDamageCalc += this.accessory1.getMagicPower();
		return magicDamageCalc + this.accessory2.getMagicPower();
	}
}
