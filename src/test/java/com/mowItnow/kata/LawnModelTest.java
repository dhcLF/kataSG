package com.mowItnow.kata;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.mowItnow.model.LawnClass;


/**
 * The LawnTest class contains tests for the Lawn class.
 */
public class LawnModelTest {
               
	@Test
    public void testIsWithinBounds() {
        LawnClass lawn = new LawnClass(5, 5);
        assertTrue(lawn.isWithinBounds(0, 0));
        assertTrue(lawn.isWithinBounds(5, 5));
        assertFalse(lawn.isWithinBounds(6, 5));
        assertFalse(lawn.isWithinBounds(5, 6));
        assertFalse(lawn.isWithinBounds(-1, 0));
        assertFalse(lawn.isWithinBounds(0, -1));
    }
}
