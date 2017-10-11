package view;

import model.Player;

public class ApplicationController {
	private JSONDataController jsonDataController;
	private Player thePlayer;

	public ApplicationController() {
		this.jsonDataController = new JSONDataController();
		this.thePlayer = this.jsonDataController.loadPlayer();
	}
	
	public void run() {
		
	}
	
}
