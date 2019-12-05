package de.lupo3742.rectangles.verticalrectangles;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import de.lupo3742.rectangles.verticalrectangles.IntPoint;
import de.lupo3742.rectangles.verticalrectangles.SortedIntPoints;

public class SortedIntPointsTest {

    @Test
    public void shouldIgnoreDuplicatePoints() {
        IntPoint pOne = new IntPoint(1, 2); 
        IntPoint pTwo = new IntPoint(1, 2);

        SortedIntPoints sortedPoints = new SortedIntPoints(pOne, pTwo);
        Iterator<IntPoint> iterator = sortedPoints.iterator();

        assertEquals(pOne, iterator.next());
        assertFalse(iterator.hasNext(), "Second element found in list");
    }
    
    @Test
    public void shouldSortByAscendingX() {
        IntPoint smallX = new IntPoint(1, 2); 
        IntPoint largeX = new IntPoint(2, 2);
        
        // the sortedPoints shall be independent of the order the Points are provided,
        // therefore verify if the result is independent of the ordering provided in the constructor
        SortedIntPoints sortedPointsSmallXFirst = new SortedIntPoints(smallX, largeX);
        verifyFirstSortedElement(sortedPointsSmallXFirst, smallX);

        SortedIntPoints sortedPointsLargeXFirst = new SortedIntPoints(largeX, smallX);
        verifyFirstSortedElement(sortedPointsLargeXFirst, smallX);
    }

    @Test
    public void shouldSortByAscendingY() {
        IntPoint smallY = new IntPoint(1, 1); 
        IntPoint largeY = new IntPoint(1, 2);
        
        SortedIntPoints sortedPointsSmallXFirst = new SortedIntPoints(smallY, largeY);
        verifyFirstSortedElement(sortedPointsSmallXFirst, smallY);
        
        SortedIntPoints sortedPointsLargeXFirst = new SortedIntPoints(largeY, smallY);
        verifyFirstSortedElement(sortedPointsLargeXFirst, smallY);
    }
    
    private static void verifyFirstSortedElement(SortedIntPoints sortedPointsSmallXFirst, IntPoint shouldBeFirstElement) {
        assertEquals(shouldBeFirstElement, sortedPointsSmallXFirst.iterator().next(), "First element in sorted list differs");
    }

    @Test
    public void shouldSortFirstXThenY() {
        IntPoint pOne = new IntPoint(1, 1); 
        IntPoint pTwo = new IntPoint(1, 2);
        IntPoint pThree = new IntPoint(2, 1);
        IntPoint pFour = new IntPoint(2, 2);
        
        // provide points in random order
        SortedIntPoints sortedPoints = new SortedIntPoints(pThree, pOne, pFour, pTwo);
        Iterator<IntPoint> iterator = sortedPoints.iterator();
        assertEquals(pOne, iterator.next(), "First element in sorted list differs");
        assertEquals(pTwo, iterator.next(), "Second element in sorted list differs");
        assertEquals(pThree, iterator.next(), "Third element in sorted list differs");
        assertEquals(pFour, iterator.next(), "Fourth element in sorted list differs");
        
        assertFalse(iterator.hasNext(), "Fifth element found in list");
    }
    
}
