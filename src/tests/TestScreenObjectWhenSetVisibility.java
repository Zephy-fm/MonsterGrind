package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::setVisibility()
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class TestScreenObjectWhenSetVisibility {
	private ScreenObject item;

	/**
	 * Testing setVisibiblity() when going from false to true
	 */
	@Test
	public void testTrue() {
		this.item = new ScreenObject(25, 25, false);
		this.item.setVisibility(true);
		assertEquals(true, this.item.isVisible());
	}

	/**
	 * Testing setVisibiblity() when going from true to false
	 */
	@Test
	public void testFalse() {
		this.item = new ScreenObject(25, 25, true);
		this.item.setVisibility(false);
		assertEquals(false, this.item.isVisible());
	}

}
