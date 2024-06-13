package com.mowItnow.model;

/**
 * The Mower class represents a mower with its position and orientation.
 */

public class MowerClass {
	
    private int x;
    private int y;
    private char orientation;

    public MowerClass(int x, int y, char orientation) {
        this.x = x;
        this.y = y;
        this.orientation = orientation;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getOrientation() {
        return orientation;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setOrientation(char orientation) {
        this.orientation = orientation;
    }

    @Override
    public String toString() {
        return x + " " + y + " " + orientation;
    }


}
