package view;

import controller.ApplicationController;

/**
 * Textual User interface that the players
 * 	will interact with to play the game.
 * 
 * @author frankminyon
 *
 * @version 10/24/17
 */
public class TUIView {
	private ApplicationController appControl;
	
	/**
	 * Creates the TUIView and instantiates the Application Controller
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	Application Controller ready
	 */
	public TUIView() {
		this.appControl = new ApplicationController();
	}

	/**
	 * Runs the program
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	game is running
	 */
	public void run() {
		parse("Welcome to Monster Grind!");
	}

	private void parse(String message) {
		System.out.println(this.appControl.parse(message));
	}

}
