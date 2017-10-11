package view;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import model.Player;

public class JSONDataController {
	Gson gson = new Gson();
	
	private Reader playerData;
	private Reader levelData;
	
	/**
	 * Reads all the necessary data files
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	game data != null
	 */
	public JSONDataController() {
		try {
			this.playerData = new FileReader("resources/data/playerData.json");
			this.levelData = new FileReader("resources/data/levelData.json");
		} catch (FileNotFoundException error) {
			error.printStackTrace();
		}
	}
	
	public Player loadPlayer() {
		return gson.fromJson(playerData, Player.class);
	}
	
	public 

}
