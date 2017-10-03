package model;

import java.awt.geom.Point2D;
import java.util.UUID;

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
	private String id;
	
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
	 * 					getID() == UUID
	 */
	public ScreenObject() {
		this.position = new Point2D.Double(0, 0);
		this.visible = false;
		this.id = UUID.randomUUID().toString();
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
	 * 					getID() == UUID
	 */
	public ScreenObject(double positionX, double positionY, boolean visible) {
		this.position = new Point2D.Double(positionX, positionY);
		this.visible = visible;
		this.id = UUID.randomUUID().toString();
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
	
	/**
	 * Gets the id of the object and returns it
	 * 
	 * @precondition 	none
	 * 
	 * @return			String containing ScreenObject's id
	 */
	public String getID() {
		return this.id;
	}
	
	/**
	 * Sets the x position
	 * @param positionX 	double containing x position
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	getX() == positionX rounded to the nearest tenth
	 */
	public void setX(double positionX) {
		double roundedX = Math.round(positionX * 10 / 10);
		this.position.setLocation(roundedX, this.position.getY());
	}
	
	/**
	 * Sets the y position
	 * @param positionY 	double containing y position
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	getY() == positionY rounded to the nearest tenth
	 */
	public void setY(double positionY) {
		double roundedY = Math.round(positionY * 10 / 10);
		this.position.setLocation(this.position.getX(), roundedY);
	}
	
	/**
	 * Sets the visibility
	 * @param visibility	boolean containing visibility
	 * 
	 * @precondition 	none
	 * 
	 * @postcondition 	getVisibility() == visibility
	 */
	public void setVisibility(boolean visibility) {
		this.visible = visibility;
	}

	/**
	 * Determines if the ScreenObjects are equal by comparing their
	 * 	coordinates and their visibility
	 * @param otherObject 	ScreenObject to compare
	 * 
	 * @precondition 		none
	 * 
	 * @return 				boolean containing comparison result
	 */
	public boolean equals(ScreenObject otherObject) {
		if (this == otherObject) {
			return true;
		}
		if (otherObject == null) {
			return false;
		}
		if (this.getClass() != otherObject.getClass()) {
			return false;
		}
		if (this.position == null && otherObject.position != null) {
			return false;
		} else if (!this.position.equals(otherObject.position)) {
			return false;
		}
		if (this.visible != otherObject.visible) {
			return false;
		}
		return true;
	}

	/**
	 * Gets a description of the ScreenObject
	 * 
	 * @precondition 	none
	 * 
	 * @return 			String containing the ScreenObject description
	 */
	@Override
	public String toString() {
		return "ScreenObject (master class: Object) ["
				+ "position: (" + this.getX()
				+ ", " + this.getY() + "), "
				+ "visible: " + this.getVisibility()
				+ "]";
	}
	
}
