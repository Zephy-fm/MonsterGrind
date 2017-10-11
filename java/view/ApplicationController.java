package view;

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
		this.thePlayer = this.jsonDataController.loadPlayer();
	}
	
	/**
	 * Starts the application's functionality
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	none
	 */
	public void run() {
		System.out.println(this.thePlayer);
		System.out.println(this.jsonDataController);
	}
	
}
