package de.lupo3742.rectangles.calculator;

import java.util.Comparator;
import java.util.Objects;

/**
 * Defines a point in a plane, using integer coordinates only 
 *  
 * @author Lupo3742
 */
public class SortableIntPoint implements Comparable<SortableIntPoint> {

    // first sort by x-values, then by y-values
    private static final Comparator<SortableIntPoint> POINT_COMPARATOR = 
            Comparator.<SortableIntPoint>comparingInt(SortableIntPoint::getX).thenComparingInt(SortableIntPoint::getY);

    private final int x;
    private final int y;
    
    private final int hash;

    public SortableIntPoint(int x, int y) {
        this.x = x;
        this.y = y;
        // pre-calculates hash in order to avoid auto-boxing every time hashCode is called
        this.hash = Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public int hashCode() {
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SortableIntPoint)) {
            return false;
        }
        SortableIntPoint other = (SortableIntPoint) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int compareTo(SortableIntPoint o) {
        return POINT_COMPARATOR.compare(this, o);
    }

}
