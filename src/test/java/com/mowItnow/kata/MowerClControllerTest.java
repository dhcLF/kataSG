package com.mowItnow.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import com.mowItnow.model.LawnClass;
import com.mowItnow.model.MowerClController;
import com.mowItnow.model.MowerClass;



public class MowerClControllerTest {
	
    private LawnClass lawn;

    @Before
    public void setUp() {
        lawn = new LawnClass(5, 5);
    }

    @Test
    public void testTurnLeft() {
        MowerClass mower = new MowerClass(1, 2, 'N');
        MowerClController controller = new MowerClController(mower, lawn);
        controller.executeInstructions("G");
        assertEquals('W', mower.getOrientation());

        controller.executeInstructions("G");
        assertEquals('S', mower.getOrientation());

        controller.executeInstructions("G");
        assertEquals('E', mower.getOrientation());

        controller.executeInstructions("G");
        assertEquals('N', mower.getOrientation());
    }

    @Test
    public void testTurnRight() {
        MowerClass mower = new MowerClass(1, 2, 'N');
        MowerClController controller = new MowerClController(mower, lawn);
        controller.executeInstructions("D");
        assertEquals('E', mower.getOrientation());

        controller.executeInstructions("D");
        assertEquals('S', mower.getOrientation());

        controller.executeInstructions("D");
        assertEquals('W', mower.getOrientation());

        controller.executeInstructions("D");
        assertEquals('N', mower.getOrientation());
    }

    @Test
    public void testAdvance() {
        MowerClass mower = new MowerClass(1, 2, 'N');
        MowerClController controller = new MowerClController(mower, lawn);
        controller.executeInstructions("A");
        assertEquals(1, mower.getX());
        assertEquals(3, mower.getY());

        controller.executeInstructions("DADA");
        assertEquals(2, mower.getX());
        assertEquals(3, mower.getY());
    }

    @Test
    public void testExecuteInstructions() {
        MowerClass mower = new MowerClass(1, 2, 'N');
        MowerClController controller = new MowerClController(mower, lawn);
        controller.executeInstructions("GAGAGAGAA");
        assertEquals(1, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals('N', mower.getOrientation());

        mower = new MowerClass(3, 3, 'E');
        controller = new MowerClController(mower, lawn);
        controller.executeInstructions("AADAADADDA");
        assertEquals(5, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals('E', mower.getOrientation());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInvalidInstruction() {
        MowerClass mower = new MowerClass(1, 2, 'N');
        MowerClController controller = new MowerClController(mower, lawn);
        controller.executeInstructions("X");
    }


}
