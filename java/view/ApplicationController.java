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
	}
	
}
