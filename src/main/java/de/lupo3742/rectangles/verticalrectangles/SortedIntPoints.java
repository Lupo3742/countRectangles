package de.lupo3742.rectangles.verticalrectangles;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Holds a set of IntPoint, sorted in ascending order first by x, then by Y.
 * 
 * @author Lupo3742
 *
 */
class SortedIntPoints implements Iterable<IntPoint> {

    // TreeSet enforces an ordering as defined in Point
    private final TreeSet<IntPoint> sortedPoints;

    public SortedIntPoints(IntPoint ... points) {
        sortedPoints = new TreeSet<>(Arrays.asList(points));
    }
    
    /**
     * @return points in ascending order
     */
    @Override
    public Iterator<IntPoint> iterator() {
        return sortedPoints.iterator();
    }
    
    public Stream<IntPoint> stream() {
        return sortedPoints.stream();
    }
    
}
