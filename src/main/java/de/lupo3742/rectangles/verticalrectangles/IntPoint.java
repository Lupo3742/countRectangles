package de.lupo3742.rectangles.verticalrectangles;

import java.util.Comparator;
import java.util.Objects;

/**
 * Defines a point in a plane, using integer coordinates only 
 *  
 * @author Lupo3742
 */
public class IntPoint implements Comparable<IntPoint> {

    // first sort by x-values, then by y-values
    private static final Comparator<IntPoint> POINT_COMPARATOR = 
            Comparator.<IntPoint>comparingInt(IntPoint::getX).thenComparingInt(IntPoint::getY);

    private final int x;
    private final int y;
    
    private final int hash;

    public IntPoint(int x, int y) {
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
        if (!(obj instanceof IntPoint)) {
            return false;
        }
        IntPoint other = (IntPoint) obj;
        return x == other.x && y == other.y;
    }

    @Override
    public int compareTo(IntPoint o) {
        return POINT_COMPARATOR.compare(this, o);
    }

}
