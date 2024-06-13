package com.mowItnow.model;



public class MowerClController {

	
    private MowerClass mower;
    private LawnClass lawn;

    public MowerClController(MowerClass mower, LawnClass lawn) {
        this.mower = mower;
        this.lawn = lawn;
    }

    /**
     * Executes a series of instructions to move the mower.
     */
    public void executeInstructions(String instructions) {
        for (char instruction : instructions.toCharArray()) {
            executeInstruction(instruction);
        }
    }

    /**
     * Executes a single instruction to move the mower.
     */
    private void executeInstruction(char instruction) {
        switch (instruction) {
            case 'G':
                turnLeft();
                break;
            case 'D':
                turnRight();
                break;
            case 'A':
                advance();
                break;
            default:
                throw new IllegalArgumentException("Invalid instruction: " + instruction);
        }
    }

    /**
     * Turns the mower 90 degrees to the left.
     */
    private void turnLeft() {
        switch (mower.getOrientation()) {
            case 'N':
                mower.setOrientation('W');
                break;
            case 'W':
                mower.setOrientation('S');
                break;
            case 'S':
                mower.setOrientation('E');
                break;
            case 'E':
                mower.setOrientation('N');
                break;
        }
    }

    /**
     * Turns the mower 90 degrees to the right.
     */
    private void turnRight() {
        switch (mower.getOrientation()) {
            case 'N':
                mower.setOrientation('E');
                break;
            case 'E':
                mower.setOrientation('S');
                break;
            case 'S':
                mower.setOrientation('W');
                break;
            case 'W':
                mower.setOrientation('N');
                break;
        }
    }

    /**
     * Moves the mower one step forward in its current direction.
     */
    private void advance() {
        int x = mower.getX();
        int y = mower.getY();
        switch (mower.getOrientation()) {
            case 'N':
                y++;
                break;
            case 'E':
                x++;
                break;
            case 'S':
                y--;
                break;
            case 'W':
                x--;
                break;
        }
        if (lawn.isWithinBounds(x, y)) {
            mower.setPosition(x, y);
        }
    }


}
