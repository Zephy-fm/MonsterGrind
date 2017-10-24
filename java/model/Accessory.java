package model;

/**
 * Accessory includes basic stats found inside the 
 * 	Equipment superclass.
 * 
 * @author frankminyon
 *
 * @version 10/24/17
 */
public class Accessory extends Equipment {

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
				+ "\n->sell price: " + super.getSellPrice()
				+ "\n->buy price: " + super.getBuyPrice();
	}
	
}
