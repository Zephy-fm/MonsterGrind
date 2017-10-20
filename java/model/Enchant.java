package model;

/**
 * The Enchant class is the blueprints for the
 * 	enhancements for various pieces of Equipment.
 * 	All Enchant have the same instance variables,
 * 	however, not all are used. It is up to the
 * 	EnchantManager to decipher how each Enchant
 * 	will have its effect on the battle.
 * 
 * @author frankminyon
 * 
 * @version 10/19/17
 */
public class Enchant {
	private String id;
	private String name;
	private String description;
	private double chance;
	private int bonusDamageFlat;
	private double bonusDamageMultiplier;
	private double heal;
	private double selfDamage;
	private double mpReturn;
	private double mpBurn;
	
	/**
	 * Creates a blank Enchant
	 * 	Enchants should be created from data files.
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	values == 0
	 * 					name == null
	 * 					description == null
	 */
	public Enchant() {
		return;
	}

	/**
	 * Gets the Enchant's id and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			String containing the Enchant's id
	 */
	public String getId() {
		return this.id;
	}

	/**
	 * Gets the Enchant's name and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			String containing the Enchant's name
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the Enchant's description and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			String containing the Enchant's description
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Gets the Enchant's proc chance and returns it
	 * 	double that are returned need to be parsed into percentages
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing the Enchant's chance
	 */
	public double getChance() {
		return this.chance;
	}

	/**
	 * Gets the Enchant's bonus flat damage and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			int containing the Enchant's bonus flat damage
	 */
	public int getBonusDamageFlat() {
		return this.bonusDamageFlat;
	}

	/**
	 * Gets the Enchant's damage multiplier and returns it
	 * 	double that are returned need to be parsed into percentages
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing the Enchant's damage multiplier
	 */
	public double getBonusDamageMultiplier() {
		return this.bonusDamageMultiplier;
	}

	/**
	 * Gets the Enchant's healing and returns it
	 * 	double that are returned need to be parsed into percentages
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing the Enchant's healing
	 */
	public double getHeal() {
		return this.heal;
	}

	/**
	 * Gets the Enchant's self damage and returns it
	 * 	double that are returned need to be parsed into percentages
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing the Enchant's self damage
	 */
	public double getSelfDamage() {
		return this.selfDamage;
	}

	/**
	 * Gets the Enchant's mp restore and returns it
	 * 	double that are returned need to be parsed into percentages
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing the Enchant's mp restore
	 */
	public double getMpReturn() {
		return this.mpReturn;
	}

	/**
	 * Gets the Enchant's mp burn and returns it
	 * 	double that are returned need to be parsed into percentages
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing the Enchant's mp burn
	 */
	public double getMpBurn() {
		return this.mpBurn;
	}

	/**
	 * Generates a description of the Enchant and returns it
	 * 
	 * @precondition		none
	 * 
	 * @return 			String containing Enchant description
	 */
	@Override
	public String toString() {
		return "Enchant [id=" + id + ", name=" + name + ", description=" + description + ", chance=" + chance
				+ ", bonusDamageFlat=" + bonusDamageFlat + ", bonusDamageMultiplier=" + bonusDamageMultiplier
				+ ", heal=" + heal + ", selfDamage=" + selfDamage + ", mpReturn=" + mpReturn + ", mpBurn=" + mpBurn
				+ "]";
	}
	
}
