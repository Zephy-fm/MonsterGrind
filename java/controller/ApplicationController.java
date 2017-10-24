package controller;

import model.GameStringParser;
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
	private GameStringParser parser;

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
		this.parser = new GameStringParser(this.thePlayer);
	}
	
	/**
	 * Parses a String with the GameStringParser
	 * 
	 * @param message 	String to parse
	 * 
	 * @precondition 	message != null
	 * 
	 * @return			String post-parse
	 */
	public String parse(String message) {
		if (message == null) {
			throw new IllegalArgumentException("message cannot be null");
		}
		return this.parser.parse(message);
	}
	
	public void test() {
		this.thePlayer.equipWeapon("wep7");
		ApplicationController.GAMEDATA.save(this.thePlayer);
	}
	
}
