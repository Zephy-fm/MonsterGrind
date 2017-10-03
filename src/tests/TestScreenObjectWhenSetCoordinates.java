package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::setCoordinates()
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class TestScreenObjectWhenSetCoordinates {
	private ScreenObject item;

	@Before
	public void setUp() throws Exception {
		this.item = new ScreenObject(25, 30, true);
	}

	/**
	 * Testing setCoordinates() without decimal
	 */
	@Test
	public void testNoDecimal() {
		this.item.setCoordinates(50, 75);
		assertEquals(this.item.getX(), 50.0, 0.01);
		assertEquals(this.item.getY(), 75.0, 0.01);
	}

	/**
	 * Testing setCoordinates() with decimal
	 */
	@Test
	public void testWithDecimal() {
		this.item.setCoordinates(50.45, 75.123456);
		assertEquals(this.item.getX(), 50.5, 0.01);
		assertEquals(this.item.getY(), 75.1, 0.01);
	}

}
