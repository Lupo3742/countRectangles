package de.lupo3742.rectangles.calculator;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Stream;

/**
 * Holds a set of IntPoint, sorted in ascending order first by x, then by Y.
 * 
 * @author Lupo3742
 *
 */
class SortedIntPoints implements Iterable<SortableIntPoint> {

    // TreeSet enforces an ordering as defined in Point
    private final Set<SortableIntPoint> sortedPoints = new TreeSet<>();

    public SortedIntPoints(Stream<SortableIntPoint> points) {
        points.forEach(sortedPoints::add);
    }
    
    public SortedIntPoints(SortableIntPoint ... points) {
        sortedPoints.addAll(Arrays.asList(points));
    }
    
    /**
     * @return points in ascending order
     */
    @Override
    public Iterator<SortableIntPoint> iterator() {
        return sortedPoints.iterator();
    }
    
    public Stream<SortableIntPoint> stream() {
        return sortedPoints.stream();
    }
    
}
