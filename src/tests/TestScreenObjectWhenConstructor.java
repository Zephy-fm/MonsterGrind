package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject constructor
 * @author frankminyon
 *
 * @version 10/3/17
 */
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
	 * Testing 3 parameter constructor without decimals
	 */
	@Test
	public void testThreeParameterConstructor() {
		ScreenObject item = new ScreenObject(25, 30, true);
		assertEquals("ScreenObject (master class: Object) [position: (25.0, 30.0), visible: true]", item.toString());
	}

	/**
	 * Testing 3 parameter constructor with decimals
	 */
	@Test
	public void testThreeParameterConstructorDecimals() {
		ScreenObject item = new ScreenObject(25.45, 30.7241346786486485, true);
		assertEquals("ScreenObject (master class: Object) [position: (25.5, 30.7), visible: true]", item.toString());
	}

	/**
	 * Testing 4 parameter constructor
	 */
	@Test
	public void testFourParameterConstructor() {
		ScreenObject item = new ScreenObject(25, 30, true);
		assertEquals("ScreenObject (master class: Object) [position: (25.0, 30.0), visible: true]", item.toString());
	}

}
