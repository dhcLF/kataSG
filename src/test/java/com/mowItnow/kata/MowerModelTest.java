package com.mowItnow.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.mowItnow.model.MowerClass;

/**
 * The MowerTest class contains tests for the Mower class.
 */
public class MowerModelTest {
           

    @Test
    public void testMowerInitialization() {
        MowerClass mower = new MowerClass(1, 2, 'N');
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals('N', mower.getOrientation());
    }
    
    

    @Test
    public void testMowerMovement() {
        MowerClass mower = new MowerClass(1, 2, 'N');
        mower.setPosition(3, 3);
        mower.setOrientation('E');
        assertEquals(3, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals('E', mower.getOrientation());
    }

}
