package de.lupo3742.rectangles.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntPoint {

    private final int x;
    private final int y;
    
    public IntPoint(
            @JsonProperty("x") int x, 
            @JsonProperty("y") int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "IntPoint [x=" + x + ", y=" + y + "]";
    }
    
}
