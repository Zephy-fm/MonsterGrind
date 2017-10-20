package view;

import model.JSONDataController;
import model.Player;
import model.Weapon;

/**
 * ApplicationController controls the flow of the application
 * @author frankminyon
 *
 * @version 10/11/17
 */
public class ApplicationController {
	public static final JSONDataController JSONDATACONTROLLER = new JSONDataController();
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
		this.thePlayer = ApplicationController.JSONDATACONTROLLER.loadPlayer();
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
		System.out.println(ApplicationController.JSONDATACONTROLLER);
		System.out.println("Equipping Weapon: Gorshalach, wepID: wep666");
		this.thePlayer.equipWeapon("wep666");
		System.out.println("Player's new stats:");
		System.out.println(this.thePlayer);
		Weapon playerWeapon = this.thePlayer.getEquipmentManager().getWeapon();
		System.out.println("Description of Player Weapon:");
		System.out.println(playerWeapon);
	}
	
}
