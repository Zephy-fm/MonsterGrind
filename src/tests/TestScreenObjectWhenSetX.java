package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::SetX()
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class TestScreenObjectWhenSetX {
	private ScreenObject item;

	@Before
	public void setUp() throws Exception {
		this.item = new ScreenObject(25, 30, true);
	}

	/**
	 * Testing setX() without decimal
	 */
	@Test
	public void testNoDecimal() {
		this.item.setX(50);
		assertEquals(this.item.getX(), 50.0, 0.01);
	}

	/**
	 * Testing setX() with decimal
	 */
	@Test
	public void testWithDecimal() {
		this.item.setX(50.123456789);
		assertEquals(this.item.getX(), 50.1, 0.01);
	}

}
