package driver;

import controller.GameController;

/**
 * Driver contains the main() method and runs the GameController
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class Driver {
	
	/**
	 * First method that is run at the start of the game
	 * @param args		String array to accept startup arguments
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	none
	 */
	public static void main(String[] args) {
		GameController controller = new GameController();
		controller.run();
	}
	
}