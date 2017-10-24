package driver;

import view.TUIView;

/**
 * Driver contains the main() method and runs the TUIView
 * 
 * @author frankminyon
 *
 * @version 10/19/17
 */
public class Driver {
	
	/**
	 * First method that is run at the start of the game
	 * 
	 * @param args		String array to accept startup arguments
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	none
	 */
	public static void main(String[] args) {
		TUIView tui = new TUIView();
		tui.run();
	}
	
}
