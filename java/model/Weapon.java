package model;

/**
 * Weapons include bonus addition stats, such as
 * 	attack damage and spell damage.
 * @author frankminyon
 *
 * @version 10/11/17
 */
public class Weapon extends Equipment {
	private int attackDamage;
	private int spellDamage;
	
	/**
	 * Creates a weapon with default values
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	0 stats, no name, no description.
	 */
	public Weapon() {
		return;
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
				+ "\n->special: " + super.getSpecial()
				+ "\n->sell price: " + super.getSellPrice()
				+ "\n->buy price: " + super.getBuyPrice()
				+ "\n->attack damage: " + this.attackDamage
				+ "\n->spell damage: " + this.spellDamage;
	}

}
