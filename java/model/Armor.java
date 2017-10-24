package model;

import view.ApplicationController;

/**
 * Armor includes basic stats found inside the
 * 	Equipment superclass.
 * 
 * @author frankminyon
 *
 * @version 10/24/17
 */
public class Armor extends Equipment {
	
	/**
	 * Creates Armor with default values
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	stats == 0
	 * 					name == null
	 * 					description == null
	 */
	public Armor() {
		return;
	}
	
	/**
	 * Generates a description of the Armor and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing Armor description
	 */
	public String toString() {
		return "Armor object with the following attributes:"
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
				+ "\n->buy price: " + super.getBuyPrice();
	}

}
