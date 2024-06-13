package com.mowItnow.model;

/**
 * The Lawn class represents the lawn with its dimensions.
 */
public class LawnClass {
	

    private int maxX;
    private int maxY;

    public LawnClass(int maxX, int maxY) {
        this.maxX = maxX;
        this.maxY = maxY;
    }

    public int getMaxX() {
        return maxX;
    }

    public int getMaxY() {
        return maxY;
    }

    /**
     * Checks if the given coordinates are within the bounds of the lawn.
     */
    public boolean isWithinBounds(int x, int y) {
        return x >= 0 && x <= maxX && y >= 0 && y <= maxY;
    }


}
