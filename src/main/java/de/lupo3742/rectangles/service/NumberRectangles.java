package de.lupo3742.rectangles.service;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NumberRectangles {

    private final int numberRectangles;

    public NumberRectangles(@JsonProperty("numberRectangles") int numberRectangles) {
        this.numberRectangles = numberRectangles;
    }

    public int getNumberRectangles() {
        return numberRectangles;
    }

    @Override
    public String toString() {
        return "NumberRectangles [numberRectangles=" + numberRectangles + "]";
    }
    
}
