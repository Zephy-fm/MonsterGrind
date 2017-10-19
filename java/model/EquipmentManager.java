package model;

import view.ApplicationController;

/**
 * EquipmentManager handles the stats and effects
 * 	found within equipment
 * @author FrankMinyon
 *
 * @version 10/12/17
 */
public class EquipmentManager {
	private Weapon weapon;
	private Weapon armor;
	private Weapon accessory1;
	private Weapon accessory2;
	
	public EquipmentManager(String weaponID, String armorID, String accessory1ID, String accessory2ID) {
		this.weapon = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
		this.armor = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
		this.accessory1 = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
		this.accessory2 = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public void equipWeapon(String weaponID) {
		if (weaponID == null) {
			throw new IllegalArgumentException("weaponID cannot be null");
		}
		this.weapon = ApplicationController.JSONDATACONTROLLER.getWeapon(weaponID);
	}
	
	public void equipWeapon(Weapon theWeapon) {
		if (theWeapon == null) {
			throw new IllegalArgumentException("theWeapon cannot be null");
		}
		this.weapon = theWeapon;
	}
	
	public int getAttackPower() {
		int attackDamageCalc = this.weapon.getAttackPower();
		attackDamageCalc += this.armor.getAttackPower();
		attackDamageCalc += this.accessory1.getAttackPower();
		return attackDamageCalc + this.accessory2.getAttackPower();
	}
	
	public int getMagicPower() {
		int magicDamageCalc = this.weapon.getMagicPower();
		magicDamageCalc += this.armor.getMagicPower();
		magicDamageCalc += this.accessory1.getMagicPower();
		return magicDamageCalc + this.accessory2.getMagicPower();
	}
}
