package de.lupo3742.rectangles.service;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class IntPoints {

    private final List<IntPoint> points;

    public IntPoints(@JsonProperty("points") List<IntPoint> points) {
        this.points = points;
    }

    public List<IntPoint> getPoints() {
        return points;
    }

    @Override
    public String toString() {
        return "IntPoints [points=" + points + "]";
    }
    
}
