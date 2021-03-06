package model;

import controller.ApplicationController;

/**
 * Accessory includes basic stats found inside the 
 * 	Equipment superclass.
 * 
 * @author frankminyon
 *
 * @version 10/24/17
 */
public class Accessory extends Equipment {
	private int attackPower;
	private int magicPower;
	private int criticalChance;

	/**
	 * Creates an Accessory with default values
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	stats == 0
	 * 					name == null
	 * 					description == null
	 */
	public Accessory() {
		return;
	}
	
	/**
	 * Gets the Accessory's attack power and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			int containing Accessory's attack power
	 */
	public int getAttackPower() {
		return this.attackPower;
	}
	
	/**
	 * Gets the Accessory's magic power and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			int containing Accessory's magic power
	 */
	public int getMagicPower() {
		return this.magicPower;
	}
	
	/**
	 * Gets the Accessory's critical chance and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			int containing Accessory's critical chance
	 */
	public int getCriticalChance() {
		return this.criticalChance;
	}
	
	/**
	 * Generates a description of the Accessory and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing Accessory description
	 */
	public String toString() {
		return "Accessory object with the following attributes:"
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
				+ "\n--->enchant name: " + ApplicationController.GAMEDATA.getEnchant(super.getEnchantID()).getName()
				+ "\n--->enchant description: " + ApplicationController.GAMEDATA.getEnchant(super.getEnchantID()).getDescription()
				+ "\n->sell price: " + super.getSellPrice()
				+ "\n->buy price: " + super.getBuyPrice()
				+ "\n->attack damage: " + this.attackPower
				+ "\n->spell damage: " + this.magicPower
				+ "\n->critical chance: " + this.criticalChance;
	}
	
}
