package view;

import java.io.File;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
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
	private int width;
	private int height;
	
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
		this.width = 1080;
		this.height = 720;
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
		this.mainStage.setWidth(this.width);
		this.mainStage.setHeight(this.height);
		this.mainStage.show();
		System.out.println("Hello world!");
		
		Group root = new Group();
		Scene theScene = new Scene(root);
		this.mainStage.setScene(theScene);
		
		Canvas canvas = new Canvas(this.width, this.height);
		root.getChildren().add(canvas);
		
		GraphicsContext gc = canvas.getGraphicsContext2D();
		gc.setFill(Color.RED);
		gc.setStroke(Color.BLACK);
		gc.setLineWidth(2);
		Font theFont = Font.font("Times New Roman", FontWeight.BOLD, 48);
		gc.setFont(theFont);
		gc.fillText("Nick's a cutie!", 100, 100);
		gc.strokeText("Nick's a cutie!", 100, 100);
		
		final Image icon = new Image(new File("resources/images/icon.png").toURI().toString());
		gc.drawImage(icon, 200, 200, 100, 100);
		
		 
		final long startNanoTime = System.nanoTime();
		 
	    new AnimationTimer()
	    {
	        public void handle(long currentNanoTime)
	        {
	            double t = (currentNanoTime - startNanoTime) / 1000000000.0; 
	 
	            double x = 232 + 128 * Math.cos(t);
	            double y = 232 + 128 * Math.sin(t);
	 
	            
	            // background image clears canvas
	            gc.drawImage( icon, x, y );
	        }
	    }.start();
	    
		this.mainStage.show();
	}
	
	

}
