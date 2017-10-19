package model;

/**
 * Equipment is an abstract class that acts as the
 * 	superclass for all equip-able items.
 * 
 * @author frankminyon
 *
 * @version 10/19/17
 */
public abstract class Equipment {
	private String id;
	private String name;
	private String description;
	private int hp;
	private int mp;
	private int strength;
	private int dexterity;
	private int intellect;
	private int defense;
	private int luck;
	private String special;
	private int sellPrice;
	private int buyPrice;
	
	/**
	 * Gets the Equipment's id and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's id
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * Gets the Equipment's name and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the Equipment's description and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the Equipment's hp and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's hp
	 */
	public int getHp() {
		return this.hp;
	}

	/**
	 * Gets the Equipment's mp and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's mp
	 */
	public int getMp() {
		return this.mp;
	}

	/**
	 * Gets the Equipment's strength and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's strength
	 */
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Gets the Equipment's dexterity and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's dexterity
	 */
	public int getDexterity() {
		return this.dexterity;
	}

	/**
	 * Gets the Equipment's intellect and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's intellect
	 */
	public int getIntellect() {
		return this.intellect;
	}

	/**
	 * Gets the Equipment's defense and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's defense
	 */
	public int getDefense() {
		return this.defense;
	}

	/**
	 * Gets the Equipment's luck and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's luck
	 */
	public int getLuck() {
		return this.luck;
	}

	/**
	 * Gets the Equipment's special and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's special
	 */
	public String getSpecial() {
		return this.special;
	}

	/**
	 * Gets the Equipment's sell price and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's sell price
	 */
	public int getSellPrice() {
		return this.sellPrice;
	}

	/**
	 * Gets the Equipment's buy price and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the Equipment's buy price
	 */
	public int getBuyPrice() {
		return this.buyPrice;
	}

	/**
	 * Generates a description of the Equipment object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String with Equipment object description
	 */
	@Override
	public String toString() {
		return "Equipment [id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", hp=" + this.hp + ", "
				+ "mp=" + this.mp + ", strength=" + this.strength + ", dexterity=" + this.dexterity + ", intellect=" 
				+ this.intellect + ", defense=" + this.defense + ", luck=" + this.luck + ", special=" + this.special + ", sellPrice=" 
				+ this.sellPrice + ", buyPrice=" + this.buyPrice + "]";
	}
}
