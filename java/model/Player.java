package model;

import java.util.Map;

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

	public Player(Map<String, String> playerMap) {
		
	}
	
	public Player() {
	}
	
	public String toString() {
		return "Player object with the following attributes:"
				+ "\nname: " + this.name
				+ "\nlevel: " + this.level
				+ "\nhp: " + this.hp
				+ "\nmp: " + this.mp
				+ "\nstrength: " + this.strength
				+ "\ndexterity: " + this.dexterity
				+ "\nintellect: " + this.intellect
				+ "\ndefense: " + this.defense
				+ "\nluck: " + this.luck
				+ "\nexperience: " + this.experience
				+ "\nexperienceToLevelUp: " + this.experienceToLevelUp
				+ "\nweapon: " + this.weapon
				+ "\narmor: " + this.armor
				+ "\naccessory1: " + this.accessory1
				+ "\naccessory2: " + this.accessory2;
	}
	
}
