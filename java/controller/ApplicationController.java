package controller;

import model.JSONDataController;
import model.Player;

/**
 * ApplicationController controls the flow of the application
 * 
 * @author frankminyon
 *
 * @version 10/24/17
 */
public class ApplicationController {
	public static final JSONDataController GAMEDATA = new JSONDataController();
	private Player thePlayer;

	/**
	 * Constructs the ApplicationController and prepares its
	 * 	data fields for use.
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	data fields != null
	 */
	public ApplicationController() {
		this.thePlayer = ApplicationController.GAMEDATA.loadPlayer();
		this.thePlayer.setup();
		System.out.println(this.thePlayer.toString());
		//this.thePlayer.setup();
		//System.out.println(this.jsonDataController.get));
	}
	
	/**
	 * Starts the application's functionality
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	none
	 */
	public void run() {
		System.out.println(ApplicationController.GAMEDATA);
		System.out.println("\n\nLets test our ability to add, equip, and unequip objects!");
		
		System.out.println("\nEquipping a accessory2 with the id of acc4!");
		System.out.println(ApplicationController.GAMEDATA.getAccessory("acc4"));
		this.thePlayer.equipAccessory2("acc4");
		System.out.println("\nPlayer's new stats:");
		System.out.println(this.thePlayer);
		System.out.println("\nUnequipping the Player's accessory1:");
		this.thePlayer.unequipAccessory2();
		System.out.println(this.thePlayer);
	}
	
}
