package view;

import javafx.stage.Stage;

/**
 * GameController controls the gameplay. It will generate
 * 	the view and process the main flow of the game.
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class GameController {
	private MainView gameWindow;
	//private ArrayList<ScreenObject> screenObjectList;
	
	/**
	 * Initializes the GameController
	 * 	and prepares the lists to accept objects.
	 * @param mainStage	Stage that the program resides on
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	object lists != null
	 */
	public GameController(Stage mainStage) {
		//this.screenObjectList = new ArrayList<ScreenObject>();
		this.gameWindow = new MainView(mainStage);
	}
	
	/**
	 * This method controls the flow of the game
	 * 
	 * @precondition 		none
	 * 
	 * @postcondition 		none
	 */
	public void run() {
		this.gameWindow.start();
	}

}
