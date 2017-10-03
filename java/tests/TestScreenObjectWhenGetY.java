package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::getY()
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class TestScreenObjectWhenGetY {

	/**
	 * Testing getY() without decimal
	 */
	@Test
	public void testNoDecimal() {
		ScreenObject item = new ScreenObject(25, 25, true);
		assertEquals(item.getY(), 25.0, 0.01);
	}

	/**
	 * Testing getY() with decimal
	 */
	@Test
	public void testWithDecimal() {
		ScreenObject item = new ScreenObject(25, 25.3453157, true);
		assertEquals(item.getY(), 25.3, 0.01);
	}

}
