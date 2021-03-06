package de.lupo3742.rectangles.calculator;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * This class finds the number of vertical or horizontal rectangles from a list of points in a plane.
 * Other tilt angles will not be considered.
 *  
 * @author Lupo3742
 *
 */
public class RectanglesCalculator {

    private final SortedIntPoints points;

    public RectanglesCalculator(Stream<SortableIntPoint> points) {
        this.points = new SortedIntPoints(points);
    }
    
    public RectanglesCalculator(SortableIntPoint... points) {
        this.points = new SortedIntPoints(points);
    }
    
    /**
     * Calculates the number of rectangles found.
     * Since points is sorted in ascending order by x and y, it is sufficient to look for 
     * matching points above and to the right of x, and finally for a potential top right corner of the rectangle.
     * By this procedure duplicate findings will be avoided. 
     * 
     * @return the number of vertical or horizontal rectangles found.
     */
    public int getNumberRectangles() {
        int numRectangles = 0;
        for (SortableIntPoint point : points) {
            for (SortableIntPoint pointAbove : pointsAbove(point)) {
                for (SortableIntPoint pointToTheRight : pointsToTheRight(point)) {
                    if (hasRectangleTopRightCorner(pointAbove, pointToTheRight)) {
                        numRectangles++;
                    }
                }
            }
        }
        return numRectangles;
    }

    /**
     * Returns all points above the reference point, i.e. same x-value but larger y-values 
     * @param reference point
     * @return all points above the reference
     */
    Collection<SortableIntPoint> pointsAbove(SortableIntPoint reference) {
        return points.stream()
                .filter(p -> isAbove(reference, p))
                .collect(Collectors.toList());
    }

    private static boolean isAbove(SortableIntPoint pRef, SortableIntPoint p) {
        return (p.getX() == pRef.getX()) 
                && (p.getY() > pRef.getY());
    }

    /**
     * Returns all points to the right of the reference point, i.e. same y-value but larger x-values 
     * @param reference point
     * @return all points to the right of the reference
     */
    Collection<SortableIntPoint> pointsToTheRight(SortableIntPoint reference) {
        return points.stream()
                .filter(p -> isToTheRight(reference, p))
                .collect(Collectors.toList());
    }
    
    private static boolean isToTheRight(SortableIntPoint pRef, SortableIntPoint p) {
        return (p.getX() > pRef.getX()) 
                && (p.getY() == pRef.getY());
    }
    
    /**
     * Input is the top-left and bottom-right point, tests if a corresponding top-right point exists.
     * The bottom-left point of the potential rectangle is not needed. 
     * @param topLeft point
     * @param bottomRight point
     * @return true if top-right is present
     */
    boolean hasRectangleTopRightCorner(SortableIntPoint topLeft, SortableIntPoint bottomRight) {
        return points.stream()
                .anyMatch(p -> isTopLeftCorner(topLeft, bottomRight, p));
    }

    private static boolean isTopLeftCorner(SortableIntPoint topLeft, SortableIntPoint bottomRight, SortableIntPoint topLeftCandicate) {
        return topLeft.getY() == topLeftCandicate.getY() 
                && bottomRight.getX() == topLeftCandicate.getX();
    }

}
