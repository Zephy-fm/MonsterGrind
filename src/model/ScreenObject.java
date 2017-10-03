package model;

import java.awt.geom.Point2D;

/**
 * ScreenObject is the superclass for all objects that will
 * 	appear on the screen during the game. It contains details
 * 	on where the object's coordinates and visibility.
 * @author frankminyon
 *
 * @version 10/2/17
 */
public class ScreenObject {
	private Point2D.Double position;
	private boolean visible;
	
	/**
	 * Default constructor for a ScreenObject.
	 * 	This constructor will create the ScreenObject and
	 * 	make the object's position (0, 0) and the visibility
	 * 	of the object will be false.
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	getX() == 0.0
	 * 					getY() == 0.0
	 * 					getVisibility() == 0.0
	 */
	public ScreenObject() {
		this.position = new Point2D.Double(0, 0);
		this.visible = false;
	}
	
	/**
	 * Default constructor for a ScreenObject.
	 * 	This constructor will create the ScreenObject and
	 * 	make the object's position (0, 0) and the visibility
	 * 	of the object will be false.
	 * @param positionX 	double containing x position
	 * @param positionY	double containing y position
	 * @param visible 	boolean determining if object is visible
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	getX() == 0.0
	 * 					getY() == 0.0
	 * 					getVisibility() == 0.0
	 */
	public ScreenObject(double positionX, double positionY, boolean visible) {
		this.position = new Point2D.Double(positionX, positionY);
		this.visible = visible;
	}
	
	/**
	 * Gets the x position of the object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing ScreenObject's x position
	 */
	public double getX() {
		return this.position.getX();
	}
	
	/**
	 * Gets the y position of the object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			double containing ScreenObject's y position
	 */
	public double getY() {
		return this.position.getY();
	}
	
	/**
	 * Gets the position of the object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			Point2D.Double containing ScreenObject's position
	 */
	public Point2D.Double getPosition() {
		return this.position;
	}
	
	/**
	 * Gets the visibility of the object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			boolean containing ScreenObject's visibility
	 */
	public boolean getVisibility() {
		return this.visible;
	}
	
	/**
	 * Gets the visibility of the object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			boolean containing ScreenObject's visibility
	 */
	public boolean isVisible() {
		return this.visible;
	}
	
}
