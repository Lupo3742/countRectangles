package de.lupo3742.rectangles.verticalrectangles;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * From a list of points in a plane, this class finds the number of vertical or horizontal rectangles.
 * Other tilt angles will not be considered.
 *  
 * @author Lupo3742
 *
 */
public class VerticalRectanglesFinder {

    private final SortedIntPoints points;

    public VerticalRectanglesFinder(IntPoint... points) {
        this.points = new SortedIntPoints(points);
    }
    
    /**
     * 
     * @return the number of vertical or horizontal rectangles found.
     */
    public int getNumberRectangles() {
        int numRectangles = 0;
        for (IntPoint point : points) {
            for (IntPoint pointAbove : pointsAbove(point)) {
                for (IntPoint pointToTheRight : pointsToTheRight(point)) {
                    if (hasRectangleTopRightCorner(pointAbove, pointToTheRight)) {
                        numRectangles++;
                    }
                }
            }
        }
        return numRectangles;
    }

    Collection<IntPoint> pointsAbove(IntPoint reference) {
        return points.stream()
                .filter(p -> isAbove(reference, p))
                .collect(Collectors.toList());
    }

    private static boolean isAbove(IntPoint pRef, IntPoint p) {
        return (p.getX() == pRef.getX()) 
                && (p.getY() > pRef.getY());
    }

    Collection<IntPoint> pointsToTheRight(IntPoint reference) {
        return points.stream()
                .filter(p -> isToTheRight(reference, p))
                .collect(Collectors.toList());
    }
    
    private static boolean isToTheRight(IntPoint pRef, IntPoint p) {
        return (p.getX() > pRef.getX()) 
                && (p.getY() == pRef.getY());
    }
    
    boolean hasRectangleTopRightCorner(IntPoint topLeft, IntPoint bottomRight) {
        return points.stream()
                .anyMatch(p -> isTopLeftCorner(topLeft, bottomRight, p));
    }

    private static boolean isTopLeftCorner(IntPoint topLeft, IntPoint bottomRight, IntPoint topLeftCandicate) {
        return topLeft.getY() == topLeftCandicate.getY() 
                && bottomRight.getX() == topLeftCandicate.getX();
    }

}
