package model;

/**
 * Armor includes basic stats found inside the
 * 	Equipment superclass.
 * 
 * @author frankminyon
 *
 * @version 10/19/17
 */
public class Armor extends Equipment {
	
	/**
	 * Creats Armor with default values
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
				+ "\n->sell price: " + super.getSellPrice()
				+ "\n->buy price: " + super.getBuyPrice();
	}

}
