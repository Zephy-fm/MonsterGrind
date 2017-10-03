package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::setID()
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class TestScreenObjectWhenSetID {
	private ScreenObject item;

	@Before
	public void setUp() throws Exception {
		this.item = new ScreenObject(25, 25, true);
	}

	/**
	 * Testing setID() with satisfactory String
	 */
	@Test
	public void testSatisfactoryID() {
		this.item.setID("ga6e5r1g69");
		assertEquals("ga6e5r1g69", this.item.getID());
	}

	/**
	 * Testing setID() with empty String
	 */
	@Test
	public void testEmptyID() {
		this.item.setID("");
		assertEquals("", this.item.getID());
	}

}
