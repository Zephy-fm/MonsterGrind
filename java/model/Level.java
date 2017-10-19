package model;

/**
 * Level class describes what stats are gained upon reaching
 * 	a level, including the experience needed for the next level up.
 * 	Levels should be created from data files.
 * 
 * @author frankminyon
 *
 * @version 10/19/17
 */
public class Level {
	private int levelNumber;
	private int hp;
	private int mp;
	private int strength;
	private int dexterity;
	private int intellect;
	private int defense;
	private int luck;
	private int experienceToLevelUp;
	
	/**
	 * Initializes all fields with default values
	 *
	 * @precondition 	none
	 * 
	 * @postcondition 	level data is empty
	 */
	public Level() {
		return;
	}

	/**
	 * Gets the Level's level number
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's level number 
	 */
	public int getLevelNumber() {
		return this.levelNumber;
	}

	/**
	 * Gets the Level's hp increase
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's hp increase
	 */
	public int getHp() {
		return this.hp;
	}

	/**
	 * Gets the Level's mp increase
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's mp increase
	 */
	public int getMp() {
		return this.mp;
	}

	/**
	 * Gets the Level's strength increase
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's strength increase
	 */
	public int getStrength() {
		return this.strength;
	}

	/**
	 * Gets the Level's dexterity increase
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's dexterity increase
	 */
	public int getDexterity() {
		return this.dexterity;
	}

	/**
	 * Gets the Level's intellect increase
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's intellect increase
	 */
	public int getIntellect() {
		return this.intellect;
	}

	/**
	 * Gets the Level's defense increase
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's defense increase
	 */
	public int getDefense() {
		return this.defense;
	}

	/**
	 * Gets the Level's luck increase
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's luck increase
	 */
	public int getLuck() {
		return this.luck;
	}

	/**
	 * Gets the Level's experience to level up
	 * 
	 * @postcondition 	none
	 * 
	 * @return			int with Level's experience to level up
	 */
	public int getExperienceToLevelUp() {
		return this.experienceToLevelUp;
	}

	/**
	 * Generates a description of the Level object
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing Level description
	 */
	@Override
	public String toString() {
		return "Level [level number=" + this.levelNumber + ", hp=" + this.hp + ", mp=" + this.mp + ", strength=" + this.strength + ", dexterity=" + this.dexterity + ", intellect="
				+ this.intellect + ", defense=" + this.defense + ", luck=" + this.luck + ", experienceToLevelUp=" + this.experienceToLevelUp
				+ "]";
	}

}
