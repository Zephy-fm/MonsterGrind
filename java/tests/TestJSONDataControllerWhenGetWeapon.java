package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.JSONDataController;
import model.Level;
import model.Weapon;

public class TestJSONDataControllerWhenGetWeapon {
	private JSONDataController controller;

	@Before
	public void setUp() throws Exception {
		this.controller = new JSONDataController();
		this.controller.loadAllData();
	}

	@Test
	public void testGetWeapon() {
		Weapon fetchedWeapon = this.controller.getWeapon("wep1");
		assertEquals("Weapon object with the following attributes:\n"
				+ "->id: wep1\n"
				+ "->name: Dull Sword\n"
				+ "->description: A plain, dull sword. Could possible be a large butterknife.\n" 
				+ "->hp: 0\n"
				+ "->mp: 0\n"
				+ "->strength: 0\n"
				+ "->dexterity: 0\n"
				+ "->intellect: 0\n"
				+ "->defense: 0\n"
				+ "->luck: 0\n"
				+ "->special: none\n"
				+ "->sell price: 1\n"
				+ "->buy price: 5\n"
				+ "->attack damage: 1\n"
				+ "->spell damage: 0\n"
				+ "->attack type: physical\n"
				+ "->attack method: null", fetchedWeapon.toString());
	}

}
