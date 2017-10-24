package model;

import controller.ApplicationController;

/**
 * Player keeps track of all Player data.
 * 	Players should be created from existing data.
 * 
 * @author frankminyon
 *
 * @version 10/24/17
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
	private int attackPower;
	private int magicPower;
	private int criticalChance;
	private int experience;
	private int experienceToLevelUp;
	private String weaponID;
	private String armorID;
	private String accessory1ID;
	private String accessory2ID;
	private EquipmentManager equipmentManager;
	
	/**
	 * Initializes a Player with default values
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	stats == 0
	 * 					name == null
	 * 					equipment == null
	 */
	public Player() {
		return;
	}
	
	/**
	 * Prepares the Player for game interaction
	 * 
	 * @precondition 	Player weapon id != null
	 * 					Player armor id != null
	 * 					Player accessory 1 id != null
	 * 					Player accessory 2 id != null
	 * 
	 * @postcondition 	Player is ready for game interaction
	 */
	public void setup() {
		if (this.weaponID == null) {
			throw new IllegalArgumentException("weapon id cannot be null");
		}
		if (this.armorID == null) {
			throw new IllegalArgumentException("armor id cannot be null");
		}
		if (this.accessory1ID == null) {
			throw new IllegalArgumentException("accessory 1 id cannot be null");
		}
		if (this.accessory2ID == null) {
			throw new IllegalArgumentException("accessory 2 id cannot be null");
		}
		this.equipmentManager = new EquipmentManager(this.weaponID, 
				this.armorID, this.accessory1ID, this.accessory2ID);
		this.update();
	}
	
	/**
	 * Updates the Player's attack power, 
	 * 	magic power, and critical chance. This
	 * 	method is used whenever new equipment is equipped
	 *  or the player has leveled up.
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Player's offensive power is updated
	 */
	public void update() {
		this.updateAttackPower();
		this.updateMagicPower();
		this.updateCriticalChance();
	}
	
	/**
	 * Updates the attack power of the Player
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	attack power is current
	 */
	private void updateAttackPower() {
		int calculation = (int) Math.round(this.strength * 0.7);
		calculation += (int) Math.round(this.dexterity * 0.4);
		calculation += this.equipmentManager.getAttackPower();
		this.attackPower = calculation;
	}

	/**
	 * Updates the magic power of the Player
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	magic power is current
	 */
	private void updateMagicPower() {
		int calculation = this.intellect;
		calculation += this.equipmentManager.getMagicPower();
		this.magicPower = calculation;
	}

	/**
	 * Updates the critical chance of the Player
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	critical chance is current
	 */
	private void updateCriticalChance() {
		int calculation = (int) Math.round(this.dexterity * 0.5);
		calculation += (int) Math.round(this.luck * 0.5);
		calculation += this.equipmentManager.getCriticalChance();
		this.criticalChance = calculation;
	}

	/**
	 * Gives a Player a specified amount of experience. The Player
	 * 	will level up if the Player's collective experience is greater
	 * 	than the experience needed to level up.
	 * 
	 * @param awardedExperience 	int containing experience to award
	 * 
	 * @precondition 			awardedExperience >= 0
	 * 
	 * @postcondition 			Player experience += awardedExperience
	 * 							Level up if collective experience is high enough
	 * 							current experience == excess experience from Level up
	 */
	public void giveExperience(int awardedExperience) {
		if (awardedExperience < 0) {
			throw new IllegalArgumentException("Cannot award negative experience");
		}
		int totalExperience = this.experience + awardedExperience;
		if (totalExperience > this.experienceToLevelUp) {
			int remainingExperience = totalExperience - this.experienceToLevelUp;
			this.levelUp();
			this.giveExperience(remainingExperience);
		} else {
			this.experience += awardedExperience;
		}
	}

	/**
	 * Gives the Player the stats associated with their given Level
	 * 	and resets the Player's experience to 0. The
	 * 	experience needed to level up is also updated.
	 *
	 * @precondition 			data for the next level must be in the data files
	 * 
	 * @postcondition 			Player stats updated with next Level information
	 * 							Player experience will be 0
	 * 							Player's needed experience to next is updated
	 */
	public void levelUp() {
		Level levelInformation = ApplicationController.GAMEDATA.getLevel(this.level);
		if (levelInformation == null) {
			throw new IllegalArgumentException("Could not retrieve level data for levelup from Level" + this.level);
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
		this.update();
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
	 * Equips a specified Weapon through Weapon ID
	 * 
	 * @param weaponID 	String containing Weapon ID
	 * 
	 * @precondition 	weaponID != null
	 * 
	 * @postcondition 	Weapon and stats are updated
	 */
	public void equipWeapon(String weaponID) {
		if (weaponID == null) {
			throw new IllegalArgumentException("weaponID cannot be null");
		}
		this.subtractEquipmentStats(this.equipmentManager.getWeapon());
		this.equipmentManager.equipWeapon(weaponID);
		this.addEquipmentStats(this.equipmentManager.getWeapon());
		this.update();
	}
	
	/**
	 * Unequips the Player's Weapon
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Weapon and stats are updated
	 */
	public void unequipWeapon() {
		this.weaponID = "wep0";
		this.subtractEquipmentStats(this.equipmentManager.getWeapon());
		this.equipmentManager.equipWeapon("wep0");
		this.update();
	}

	/**
	 * Equips a specified Armor through Armor ID
	 * 
	 * @param armorID 	String containing Armor ID
	 * 
	 * @precondition 	armorID != null
	 * 
	 * @postcondition 	Armor and stats are updated
	 */
	public void equipArmor(String armorID) {
		if (armorID == null) {
			throw new IllegalArgumentException("armorID cannot be null");
		}
		this.subtractEquipmentStats(this.equipmentManager.getArmor());
		this.equipmentManager.equipArmor(armorID);
		this.addEquipmentStats(this.equipmentManager.getArmor());
		this.update();
	}
	
	/**
	 * Unequips the Player's Armor
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Armor and stats are updated
	 */
	public void unequipArmor() {
		this.armorID = "arm0";
		this.subtractEquipmentStats(this.equipmentManager.getArmor());
		this.equipmentManager.equipArmor("arm0");
		this.update();
	}

	/**
	 * Equips a specified Accessory through Accessory ID
	 * 	(equips to Accessory1)
	 * 
	 * @param accessoryID 	String containing Armor ID
	 * 
	 * @precondition 		accessoryID != null
	 * 
	 * @postcondition 		Accessory1 and stats are updated
	 */
	public void equipAccessory1(String accessoryID) {
		if (accessoryID == null) {
			throw new IllegalArgumentException("accessoryID cannot be null");
		}
		this.subtractEquipmentStats(this.equipmentManager.getAccessory1());
		this.equipmentManager.equipAccessory1(accessoryID);
		this.addEquipmentStats(this.equipmentManager.getAccessory1());
		this.update();
	}
	
	/**
	 * Unequips the Player's Accessory
	 * 	(from Accessory1)
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Accessory1 and stats are updated
	 */
	public void unequipAccessory1() {
		this.accessory1ID = "acc0";
		this.subtractEquipmentStats(this.equipmentManager.getAccessory1());
		this.equipmentManager.equipAccessory1("acc0");
		this.update();
	}

	/**
	 * Equips a specified Accessory through Accessory ID
	 * 	(equips to Accessory2)
	 * 
	 * @param accessoryID 	String containing Armor ID
	 * 
	 * @precondition 		accessoryID != null
	 * 
	 * @postcondition 		Accessory2 and stats are updated
	 */
	public void equipAccessory2(String accessoryID) {
		if (accessoryID == null) {
			throw new IllegalArgumentException("accessoryID cannot be null");
		}
		this.subtractEquipmentStats(this.equipmentManager.getAccessory2());
		this.equipmentManager.equipAccessory2(accessoryID);
		this.addEquipmentStats(this.equipmentManager.getAccessory2());
		this.update();
	}
	
	/**
	 * Unequips the Player's Accessory
	 * 	(from Accessory2)
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Accessory2 and stats are updated
	 */
	public void unequipAccessory2() {
		this.accessory2ID = "acc0";
		this.subtractEquipmentStats(this.equipmentManager.getAccessory2());
		this.equipmentManager.equipAccessory2("acc0");
		this.update();
	}
	
	/**
	 * Helper method that subtracts the stats of the given
	 * 	Equipment object to the player.
	 * 
	 * @param theEquipment	Equipment to gather stats from
	 * 
	 * @precondition 		theEquipment != null
	 * 
	 * @postcondition 		Player stats are altered from the Equipment
	 */
	private void subtractEquipmentStats(Equipment theEquipment) {
		if (theEquipment == null) {
			throw new IllegalArgumentException("theEquipment cannot be null."
					+ "\nThis exception usually means that the the equipment trying to be"
					+ "\nreferenced had a bad ID during the data retrieval phase but somehow wasn't caught.");
		}
		this.hp -= theEquipment.getHp();
		this.mp -= theEquipment.getMp();
		this.strength -= theEquipment.getStrength();
		this.dexterity -= theEquipment.getDexterity();
		this.intellect -= theEquipment.getIntellect();
		this.defense -= theEquipment.getDefense();
		this.luck -= theEquipment.getLuck();
	}

	/**
	 * Helper method that adds the stats of the given
	 * 	Equipment object to the player.
	 * 
	 * @param theEquipment 	Equipment to gather stats from
	 * 
	 * @precondition 		theEquipment != null
	 * 
	 * @postcondition 		Player stats are altered from the Equipment
	 */
	private void addEquipmentStats(Equipment theEquipment) {
		if (theEquipment == null) {
			throw new IllegalArgumentException("theEquipment cannot be null."
					+ "\nThis exception usually means that the the equipment trying to be"
					+ "\nreferenced had a bad ID during the data retrieval phase but somehow wasn't caught.");
		}
		this.hp += theEquipment.getHp();
		this.mp += theEquipment.getMp();
		this.strength += theEquipment.getStrength();
		this.dexterity += theEquipment.getDexterity();
		this.intellect += theEquipment.getIntellect();
		this.defense += theEquipment.getDefense();
		this.luck += theEquipment.getLuck();
	}
	
	/**
	 * Gets the Player's EquipmentManager and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			EquipmentManager of the Player
	 */
	public EquipmentManager getEquipmentManager() {
		return this.equipmentManager;
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
				+ "\n->attack power: " + this.attackPower
				+ "\n->magic power: " + this.magicPower
				+ "\n->critical chance: " + this.criticalChance
				+ "\n->experience: " + this.experience
				+ "\n->experienceToLevelUp: " + this.experienceToLevelUp
				+ "\n->weapon: " + this.weaponID
				+ "\n->armor: " + this.armorID
				+ "\n->accessory1: " + this.accessory1ID
				+ "\n->accessory2: " + this.accessory2ID;
	}
	
}
