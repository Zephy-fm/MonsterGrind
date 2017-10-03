package view;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

/**
 * View manages the window that is used by the game.
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class GameView {
	public static final String GAME_WINDOW_TITLE = "Monster Grind";
	
	private JFrame gameWindow;
	
	/**
	 * Creates a GameView with default dimensions (1080, 720)
	 * 	and a window title of {@value #GAME_WINDOW_TITLE}
	 * 
	 * @precondition		none
	 * 
	 * @postcondition 	GameView dimensions == (1080, 720)
	 * 					GameView title == {@value #GAME_WINDOW_TITLE}
	 * 					GameView visible == false
	 * 					GameView DefaultCloseOperation == Exit on close
	 */
	public GameView() {
		this.gameWindow = new JFrame(GAME_WINDOW_TITLE);
		this.gameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.gameWindow.setIconImage(new ImageIcon("images/icon.png").getImage());
		this.gameWindow.setSize(1080, 720);
		this.gameWindow.setLocationRelativeTo(null);
		this.gameWindow.setResizable(false);
	}
	
	public void paintComponent(Graphics g) {
		this.gameWindow.paintComponents(g);
		
	}
	
	public void drawDonut(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.drawRect(100, 100, 100, 100);
	}
	
	/**
	 * Creats a GameView with the dimensions (width, height)
	 * 	and a window title of {@value #GAME_WINDOW_TITLE}
	 * @param width 		int with width of the GameView
	 * @param height		int with height of the GameView
	 * 
	 * @precondition 	width > 0
	 * 					height > 0
	 * 
	 * @postcondition 	GameView dimensions == (width, height)
	 * 					GameView title == {@value #GAME_WINDOW_TITLE}
	 * 					GameView visible == false
	 * 					GameView DefaultCloseOperation == Exit on close
	 */
	public GameView(int width, int height) {
		this();
		if (width < 1) {
			throw new IllegalArgumentException("GameView width cannot be less than 1");
		}
		if (height < 1) {
			throw new IllegalArgumentException("GameView height cannot be less than 1");
		}
		this.gameWindow.setVisible(false);
		this.gameWindow.setSize(width, height);
	}
	
	/**
	 * Presents the GameView
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	GameView is being shown
	 */
	public void show() {
		this.gameWindow.setVisible(true);
	}
	
	/**
	 * Hides the GameView
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	GameView is being hidden
	 */
	public void hide() {
		this.gameWindow.setVisible(false);
	}
	
	/**
	 * Gets the width of the GameWindow and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			int containing GameWindow's width
	 */
	public int getWidth() {
		return this.gameWindow.getWidth();
	}
	
	/**
	 * Gets the height of the GameWindow and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			int containing GameWindow's height
	 */
	public int getHeight() {
		return this.gameWindow.getHeight();
	}
	
	/**
	 * Sets the width of the GameWindow
	 * @param width 		int with the new width
	 * 
	 * @precondition 	width > 0
	 * 
	 * @postcondition 	getWidth() == width
	 */
	public void setWidth(int width) {
		if (width < 1) {
			throw new IllegalArgumentException("GameView width cannot be less than 1");
		}
		this.gameWindow.setSize(width, this.gameWindow.getHeight());
	}
	
	/**
	 * Sets the height of the GameWindow
	 * @param height 	int with the new height
	 * 
	 * @precondition 	height > 0
	 * 
	 * @postcondition 	getHeight() == height
	 */
	public void setHeight(int height) {
		if (height < 1) {
			throw new IllegalArgumentException("GameView height cannot be less than 1");
		}
		this.gameWindow.setSize(this.gameWindow.getWidth(), height);
	}

}
