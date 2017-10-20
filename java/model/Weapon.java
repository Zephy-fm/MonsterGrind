package model;

import view.ApplicationController;

/**
 * Weapons include bonus addition stats, such as
 * 	attack damage and spell damage.
 * 
 * @author frankminyon
 *
 * @version 10/19/17
 */
public class Weapon extends Equipment {
	private int attackPower;
	private int magicPower;
	private String attackType;
	private String attackMethod;
	
	/**
	 * Creates a weapon with default values
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	stats == 0
	 * 					name == null 
	 * 					description == null
	 */
	public Weapon() {
		return;
	}
	
	/**
	 * Gets the Weapon's attack power and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			int containing Weapon's attack power
	 */
	public int getAttackPower() {
		return this.attackPower;
	}
	
	/**
	 * Gets the Weapon's magic power and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			int containing Weapon's magic power
	 */
	public int getMagicPower() {
		return this.magicPower;
	}
	
	/**
	 * Gets the Weapon's attack type and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing Weapon's attack type
	 */
	public String getAttackType() {
		return this.attackType;
	}
	
	/**
	 * Gets the Weapon's attack method and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing Weapon's attack method
	 */
	public String getAttackMethod() {
		return this.attackMethod;
	}
	
	/**
	 * Generates a description of the weapon and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing description of the Weapon
	 */
	public String toString() {
		return "Weapon object with the following attributes:"
				+ "\n->id: " + super.getId()
				+ "\n->name: " + super.getName()
				+ "\n->description: " + super.getDescription()
				+ "\n->hp: " + super.getHp()
				+ "\n->mp: " + super.getMp()
				+ "\n->strength: " + super.getStrength()
				+ "\n->dexterity: " + super.getDexterity()
				+ "\n->intellect: " + super.getIntellect()
				+ "\n->defense: " + super.getDefense()
				+ "\n->luck: " + super.getLuck()
				+ "\n->enchant: " + super.getEnchantID()
				+ "\n->->enchant name: " + ApplicationController.JSONDATACONTROLLER.getEnchant(super.getEnchantID()).getName()
				+ "\n->->enchant description: " + ApplicationController.JSONDATACONTROLLER.getEnchant(super.getEnchantID()).getDescription()
				+ "\n->sell price: " + super.getSellPrice()
				+ "\n->buy price: " + super.getBuyPrice()
				+ "\n->attack damage: " + this.attackPower
				+ "\n->spell damage: " + this.magicPower
				+ "\n->attack type: " + this.attackType
				+ "\n->attack method: " + this.attackMethod;
	}

}
