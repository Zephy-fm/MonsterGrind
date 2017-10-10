package controller;

import javafx.application.Application;
import javafx.stage.Stage;
import view.GameController;

/**
 * Driver contains the main() method and runs the GameController
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class Driver extends Application {
	
	/**
	 * First method that is run at the start of the game
	 * @param args		String array to accept startup arguments
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	none
	 */
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * Method is called after main() and starts up the controllers
	 * @param mainStage 	Stage created at program launch
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	none
	 */
	public void start(Stage mainStage) {
		GameController controller = new GameController(mainStage);
		controller.run();
	}
	
}
