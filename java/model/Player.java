package model;

import view.JSONDataController;

/**
 * Player keeps track of all Player data.
 * 	Players should be created from existing data.
 * @author frankminyon
 *
 * @version 10/11/17
 */
public class Player {
	private String name;
	private int level;
	private int hp;
	private int mp;
	private int strength;
	private int dexterity;
	private int intellect;
	private int defense;
	private int luck;
	private int experience;
	private int experienceToLevelUp;
	private String weapon;
	private String armor;
	private String accessory1;
	private String accessory2;
	
	/**
	 * Initializes a Player with default values
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	name == null
	 * 					all stats == 0
	 * 					equipment == null
	 */
	public Player() {
		return;
	}
	
	/**
	 * Find's what the Player's next level is and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			int player level + 1
	 */
	public int getNextLevel() {
		return this.level + 1;
	}
	
	/**
	 * Gives the Player the stats associated with the given Level
	 * 	parameter and resets the Player's experience to 0. The
	 * 	experience needed to level up is also updated.
	 * @param levelInformation 	Level containing information about the level up
	 * 
	 * @precondition 			levelInformation != null
	 * 
	 * @postcondition 			Player stats updated with next Level information
	 * 							Player experience will be 0
	 * 							Player's needed experience to next is updated
	 */
	public void levelUp(Level levelInformation) {
		if (levelInformation == null) {
			throw new IllegalArgumentException("levelInformation cannot be null");
		}
		this.level++;
		this.hp += levelInformation.getHp();
		this.mp += levelInformation.getMp();
		this.strength += levelInformation.getStrength();
		this.dexterity += levelInformation.getDexterity();
		this.intellect += levelInformation.getIntellect();
		this.defense += levelInformation.getDefense();
		this.luck += levelInformation.getLuck();
		this.experienceToLevelUp = levelInformation.getExperienceToLevelUp();
		this.experience = 0;
	}
	
	/**
	 * Gives a Player a specified amount of experience. The Player
	 * 	will level up if the Player's collective experience is greater
	 * 	than the experience needed to level up.
	 * @param awardedExperience 	int containing experience to award
	 * 
	 * @precondition 			awardedExperience >= 0
	 * 
	 * @postcondition 			Player experience += awardedExperience
	 * 							Level up if collective experience is high enough
	 */
	public void giveExperience(int awardedExperience) {
		if (awardedExperience < 0) {
			throw new IllegalArgumentException("Cannot award negative experience");
		}
		int totalExperience = this.experience + awardedExperience;
		if (totalExperience > this.experienceToLevelUp) {
			int remainingExperience = totalExperience - this.experienceToLevelUp;
			Level nextLevel = JSONDataController.getLevelGlobal(this.level);
			this.levelUp(nextLevel);
			this.giveExperience(remainingExperience);
		} else {
			this.experience += awardedExperience;
		}
	}
	
	/**
	 * Gathers the Player information and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing Player description
	 */
	public String toString() {
		return "Player object with the following attributes:"
				+ "\n->name: " + this.name
				+ "\n->level: " + this.level
				+ "\n->hp: " + this.hp
				+ "\n->mp: " + this.mp
				+ "\n->strength: " + this.strength
				+ "\n->dexterity: " + this.dexterity
				+ "\n->intellect: " + this.intellect
				+ "\n->defense: " + this.defense
				+ "\n->luck: " + this.luck
				+ "\n->experience: " + this.experience
				+ "\n->experienceToLevelUp: " + this.experienceToLevelUp
				+ "\n->weapon: " + this.weapon
				+ "\n->armor: " + this.armor
				+ "\n->accessory1: " + this.accessory1
				+ "\n->accessory2: " + this.accessory2;
	}
	
}
