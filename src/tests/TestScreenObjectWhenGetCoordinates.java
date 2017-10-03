package tests;

import static org.junit.Assert.assertEquals;

import java.awt.geom.Point2D;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::getCoordinates()
 * @author frankminyon
 *
 * @version 10/2/17
 */
public class TestScreenObjectWhenGetCoordinates {

	/**
	 * Testing with Point2D.Double getters
	 */
	@Test
	public void testSetters() {
		ScreenObject item = new ScreenObject(25, 30, true);
		Point2D.Double coordinates = item.getCoordinates();
		assertEquals(coordinates.getX(), 25.0, 0.01);
		assertEquals(coordinates.getY(), 30.0, 0.01);
	}

	/**
	 * Testing with Point2D.Double equals
	 */
	@Test
	public void testEquals() {
		ScreenObject item = new ScreenObject(25, 30, true);
		Point2D.Double coordinates = item.getCoordinates();
		Point2D.Double expected = new Point2D.Double(25, 30);
		assertEquals(true, coordinates.equals(expected));
	}

}
