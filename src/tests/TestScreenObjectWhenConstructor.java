package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

public class TestScreenObjectWhenConstructor {

	/**
	 * Testing 0 parameter constructor
	 */
	@Test
	public void testNoParameterConstructor() {
		ScreenObject item = new ScreenObject();
		assertEquals("ScreenObject (master class: Object) [position: (0.0, 0.0), visible: false]", item.toString());
	}

	/**
	 * Testing 2 parameter constructor
	 */
	@Test
	public void testThreeParameterConstructor() {
		ScreenObject item = new ScreenObject(25, 30, true);
		assertEquals("ScreenObject (master class: Object) [position: (25.0, 30.0), visible: true]", item.toString());
	}

}
