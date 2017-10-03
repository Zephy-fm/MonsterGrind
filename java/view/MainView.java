package view;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * MainView handles all graphics control for the game
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class MainView {
	private Stage mainStage;
	
	/**
	 * Creates a MainView class and sets the main stage
	 * 	to display content on
	 * @param mainStage	Stage the program resides on
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	primary stage == mainStage
	 */
	public MainView(Stage mainStage) {
		this.mainStage = mainStage;
	}
	
	/**
	 * Runs the visual methods behind the game
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	none
	 */
	public void start() {
		this.mainStage.setTitle("Monster Grind");
		this.mainStage.setWidth(1080);
		this.mainStage.setHeight(720);
		this.mainStage.show();
		System.out.println("Hello world!");
		
		Group root = new Group();
		Scene theScene = new Scene(root);
		this.mainStage.setScene(theScene);
		
		Canvas canvas = new Canvas(400, 200);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
		gc.setFont(theFont);
		gc.fillText("Hello, World!", 100, 100);
		gc.strokeText("Hello, World!", 100, 100);
		
		//Image icon = new Image("resources/icon.png");
		//gc.drawImage(icon, 200, 200);
		
		this.mainStage.show();
	}

}
