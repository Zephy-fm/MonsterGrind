package tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import model.ScreenObject;

/**
 * Testing ScreenObject::equals()
 * @author frankminyon
 *
 * @version 10/3/17
 */
public class TestScreenObjectWhenEquals {
	
	/**
	 * Testing with 0 parameter constructor
	 */
	@Test
	public void testDefaultTrue() {
		ScreenObject item = new ScreenObject();
		ScreenObject otherItem = new ScreenObject();
		assertEquals(true, item.equals(otherItem));
	}

	/**
	 * Testing with 3 parameter constructor
	 * 	all values equal eachother
	 * 	true
	 */
	@Test
	public void test3ParamTrue() {
		ScreenObject item = new ScreenObject(25, 25, true);
		ScreenObject otherItem = new ScreenObject(25, 25, true);
		assertEquals(true, item.equals(otherItem));
	}

	/**
	 * Testing with 3 parameter constructor
	 * 	different x coordinate
	 * 	false
	 */
	@Test
	public void testDifferentXFalse() {
		ScreenObject item = new ScreenObject(25, 25, true);
		ScreenObject otherItem = new ScreenObject(20, 25, true);
		assertEquals(false, item.equals(otherItem));
	}

	/**
	 * Testing with 3 parameter constructor
	 * 	different y coordinate
	 * 	false
	 */
	@Test
	public void testDifferentYFalse() {
		ScreenObject item = new ScreenObject(25, 25, true);
		ScreenObject otherItem = new ScreenObject(25, 20, true);
		assertEquals(false, item.equals(otherItem));
	}

	/**
	 * Testing with 3 parameter constructor
	 * 	different visibility
	 * 	false
	 */
	@Test
	public void testDifferentVisibilityFalse() {
		ScreenObject item = new ScreenObject(25, 25, true);
		ScreenObject otherItem = new ScreenObject(25, 25, false);
		assertEquals(false, item.equals(otherItem));
	}
	
}
