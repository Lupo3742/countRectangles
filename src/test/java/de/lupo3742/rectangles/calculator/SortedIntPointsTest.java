package de.lupo3742.rectangles.calculator;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

import de.lupo3742.rectangles.calculator.SortableIntPoint;
import de.lupo3742.rectangles.calculator.SortedIntPoints;

public class SortedIntPointsTest {

    @Test
    public void shouldIgnoreDuplicatePoints() {
        SortableIntPoint pOne = new SortableIntPoint(1, 2); 
        SortableIntPoint pTwo = new SortableIntPoint(1, 2);

        SortedIntPoints sortedPoints = new SortedIntPoints(pOne, pTwo);
        Iterator<SortableIntPoint> iterator = sortedPoints.iterator();

        assertEquals(pOne, iterator.next());
        assertFalse(iterator.hasNext(), "Second element found in list");
    }
    
    @Test
    public void shouldSortByAscendingX() {
        SortableIntPoint smallX = new SortableIntPoint(1, 2); 
        SortableIntPoint largeX = new SortableIntPoint(2, 2);
        
        // the sortedPoints shall be independent of the order the Points are provided,
        // therefore verify if the result is independent of the ordering provided in the constructor
        SortedIntPoints sortedPointsSmallXFirst = new SortedIntPoints(smallX, largeX);
        verifyFirstSortedElement(sortedPointsSmallXFirst, smallX);

        SortedIntPoints sortedPointsLargeXFirst = new SortedIntPoints(largeX, smallX);
        verifyFirstSortedElement(sortedPointsLargeXFirst, smallX);
    }

    @Test
    public void shouldSortByAscendingY() {
        SortableIntPoint smallY = new SortableIntPoint(1, 1); 
        SortableIntPoint largeY = new SortableIntPoint(1, 2);
        
        SortedIntPoints sortedPointsSmallXFirst = new SortedIntPoints(smallY, largeY);
        verifyFirstSortedElement(sortedPointsSmallXFirst, smallY);
        
        SortedIntPoints sortedPointsLargeXFirst = new SortedIntPoints(largeY, smallY);
        verifyFirstSortedElement(sortedPointsLargeXFirst, smallY);
    }
    
    private static void verifyFirstSortedElement(SortedIntPoints sortedPointsSmallXFirst, SortableIntPoint shouldBeFirstElement) {
        assertEquals(shouldBeFirstElement, sortedPointsSmallXFirst.iterator().next(), "First element in sorted list differs");
    }

    @Test
    public void shouldSortFirstXThenY() {
        SortableIntPoint pOne = new SortableIntPoint(1, 1); 
        SortableIntPoint pTwo = new SortableIntPoint(1, 2);
        SortableIntPoint pThree = new SortableIntPoint(2, 1);
        SortableIntPoint pFour = new SortableIntPoint(2, 2);
        
        // provide points in random order
        SortedIntPoints sortedPoints = new SortedIntPoints(pThree, pOne, pFour, pTwo);
        Iterator<SortableIntPoint> iterator = sortedPoints.iterator();
        assertEquals(pOne, iterator.next(), "First element in sorted list differs");
        assertEquals(pTwo, iterator.next(), "Second element in sorted list differs");
        assertEquals(pThree, iterator.next(), "Third element in sorted list differs");
        assertEquals(pFour, iterator.next(), "Fourth element in sorted list differs");
        
        assertFalse(iterator.hasNext(), "Fifth element found in list");
    }
    
}
