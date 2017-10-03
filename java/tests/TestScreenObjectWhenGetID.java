package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::getID()
 * @author frankminyon
 * 
 * @version 10/2/17
 */
public class TestScreenObjectWhenGetID {

	/**
	 * Testing id when automatically set
	 */
	@Test
	public void testAutomatic() {
		ScreenObject item = new ScreenObject(25, 25, true);
		String temporaryStr = new String();
		assertEquals(temporaryStr.getClass(), item.getID().getClass());
	}

	/**
	 * Testing id when manually set
	 */
	@Test
	public void testManual() {
		ScreenObject item = new ScreenObject(25, 25, true, "f6s981avaaf81");
		assertEquals("f6s981avaaf81", item.getID());
	}

}
