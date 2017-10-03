package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::getX()
 * @author frankminyon
 *
 * @version 10/2/17
 */
public class TestScreenObjectWhenGetX {

	/**
	 * Testing getX() without decimal
	 */
	@Test
	public void testNoDecimal() {
		ScreenObject item = new ScreenObject(25, 25, true);
		assertEquals(item.getX(), 25.0, 0.01);
	}

	/**
	 * Testing getX() with decimal
	 */
	@Test
	public void testWithDecimal() {
		ScreenObject item = new ScreenObject(25.3453157, 25, true);
		assertEquals(item.getX(), 25.3, 0.01);
	}

}
