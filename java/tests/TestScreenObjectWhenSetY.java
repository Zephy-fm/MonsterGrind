package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::SetY()
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class TestScreenObjectWhenSetY {
	private ScreenObject item;

	@Before
	public void setUp() throws Exception {
		this.item = new ScreenObject(25, 30, true);
	}

	/**
	 * Testing setY() without decimal
	 */
	@Test
	public void testNoDecimal() {
		this.item.setY(50);
		assertEquals(this.item.getY(), 50.0, 0.01);
	}

	/**
	 * Testing setY() with decimal
	 */
	@Test
	public void testWithDecimal() {
		this.item.setY(50.123456789);
		assertEquals(this.item.getY(), 50.1, 0.01);
	}

}
