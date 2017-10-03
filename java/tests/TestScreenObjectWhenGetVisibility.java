package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::getVisibility()
 * @author frankminyon
 * 
 * @version 10/3/17
 */
public class TestScreenObjectWhenGetVisibility {

	/**
	 * Testing getVisibility() when true
	 */
	@Test
	public void testTrue() {
		ScreenObject item = new ScreenObject(25, 25, true);
		assertEquals(true, item.getVisibility());
	}

	/**
	 * Testing getVisibility() when false
	 */
	@Test
	public void testFalse() {
		ScreenObject item = new ScreenObject(25, 25, false);
		assertEquals(false, item.getVisibility());
	}

}
