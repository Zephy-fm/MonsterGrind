package view;

import model.JSONDataController;
import model.Player;

/**
 * ApplicationController controls the flow of the application
 * @author frankminyon
 *
 * @version 10/11/17
 */
public class ApplicationController {
	private JSONDataController jsonDataController;
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
		this.jsonDataController = new JSONDataController();
		this.jsonDataController.loadAllData();
		this.thePlayer = this.jsonDataController.loadPlayer();
		System.out.println("Before Player::setup()\n" + this.thePlayer);
		this.thePlayer.setup(this.jsonDataController);
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
		System.out.println("After Player::setup()\n" + this.thePlayer);
		System.out.println(this.jsonDataController);
	}
	
}
