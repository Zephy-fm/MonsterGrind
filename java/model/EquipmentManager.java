package model;

/**
 * EquipmentManager handles the stats and effects
 * 	found within equipment
 * @author FrankMinyon
 *
 * @version 10/12/17
 */
public class EquipmentManager {
	private JSONDataController jsonDataController;
	private Weapon weapon;
	private Weapon armor;
	private Weapon accessory1;
	private Weapon accessory2;
	
	public EquipmentManager(JSONDataController jsonDataController, String weaponID, String armorID, String accessory1ID, String accessory2ID) {
		this.jsonDataController = jsonDataController;
		this.weapon = this.jsonDataController.getWeapon(weaponID);
		this.armor = this.jsonDataController.getWeapon(weaponID);
		this.accessory1 = this.jsonDataController.getWeapon(weaponID);
		this.accessory2 = this.jsonDataController.getWeapon(weaponID);
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
	
	public void equipWeapon(String weaponID) {
		if (weaponID == null) {
			throw new IllegalArgumentException("weaponID cannot be null");
		}
		this.weapon = this.jsonDataController.getWeapon(weaponID);
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
