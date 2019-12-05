package de.lupo3742.rectangles.verticalrectangles;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class VerticalRectanglesPointPositionTest {

    @Test
    public void shouldFindNoPointAbove() {
        IntPoint referencePoint = new IntPoint(2, 4);

        // another point below the reference point
        IntPoint pBelow = new IntPoint(2, 3);
        // another points to the right of the referencePoint
        IntPoint pRight = new IntPoint(3, 4);
        // another points to the left of the referencePoint
        IntPoint pLeft = new IntPoint(-1, 4);
        // another points to somewhere else
        IntPoint pRightAbove = new IntPoint(7, 8);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(referencePoint, pBelow, pRight, pLeft, pRightAbove);
        int pointsAbove = finder.pointsAbove(referencePoint).size();
        
        assertThat(pointsAbove).isEqualTo(0);
    }
    
    @Test
    public void shouldFindSinglePointAbove() {
        IntPoint referencePoint = new IntPoint(2, 4);

        // another point above the reference point
        IntPoint pAbove = new IntPoint(2, 5);

        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(referencePoint, pAbove);
        int pointsAbove = finder.pointsAbove(referencePoint).size();
        
        assertThat(pointsAbove).isEqualTo(1);
    }

    @Test
    public void shouldFindTwoPointsAbove() {
        IntPoint referencePoint = new IntPoint(2, 4);
        
        // other points above the reference point
        IntPoint pAboveOne = new IntPoint(2, 5);
        IntPoint pAboveTwo = new IntPoint(2, 34);
        
        // other point not above the reference point
        IntPoint pNotAbove = new IntPoint(12, 14);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(referencePoint, pAboveOne, pAboveTwo, pNotAbove);
        int pointsAbove = finder.pointsAbove(referencePoint).size();
        
        assertThat(pointsAbove).isEqualTo(2);
    }
    
    @Test
    public void shouldFindNoPointToTheRight() {
        IntPoint referencePoint = new IntPoint(2, 4);

        // another point below the reference point
        IntPoint pBelow = new IntPoint(2, 3);
        // another points above of the referencePoint
        IntPoint pRight = new IntPoint(2, 5);
        // another points to the left of the referencePoint
        IntPoint pLeft = new IntPoint(-1, 4);
        // another points to somewhere else
        IntPoint pRightAbove = new IntPoint(7, 8);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(referencePoint, pBelow, pRight, pLeft, pRightAbove);
        int pointsToTheRight = finder.pointsToTheRight(referencePoint).size();
        
        assertThat(pointsToTheRight).isEqualTo(0);
    }
    
    @Test
    public void shouldFindSinglePointToTheRight() {
        IntPoint referencePoint = new IntPoint(2, 4);

        // another point to the right of the reference point
        IntPoint pAbove = new IntPoint(3, 4);

        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(referencePoint, pAbove);
        int pointsToTheRight = finder.pointsToTheRight(referencePoint).size();
        
        assertThat(pointsToTheRight).isEqualTo(1);
    }

    @Test
    public void shouldFindTwoPointsToTheRight() {
        IntPoint referencePoint = new IntPoint(2, 4);
        
        // other points to the right of the reference point
        IntPoint pAboveOne = new IntPoint(3, 4);
        IntPoint pAboveTwo = new IntPoint(42, 4);
        
        // other point not to the right of the reference point
        IntPoint pNotAbove = new IntPoint(12, 14);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(referencePoint, pAboveOne, pAboveTwo, pNotAbove);
        int pointsToTheRight = finder.pointsToTheRight(referencePoint).size();
        
        assertThat(pointsToTheRight).isEqualTo(2);
    }
    
    @Test
    public void shouldFindTopRightCorner() {
        IntPoint pTopLeft = new IntPoint(1, 2);
        IntPoint pBottomRight = new IntPoint(2, 1);

        IntPoint pTopRight = new IntPoint(2, 2);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(pTopLeft, pBottomRight, pTopRight);
        assertThat(finder.hasRectangleTopRightCorner(pTopLeft, pBottomRight)).isTrue();
    }
    
    @Test
    public void shouldNotFindTopRightCorner() {
        IntPoint pTopLeft = new IntPoint(2, 1);
        IntPoint pBottomRight = new IntPoint(1, 2);
        
        IntPoint pOther = new IntPoint(32, 42);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(pTopLeft, pBottomRight, pOther);
        assertThat(finder.hasRectangleTopRightCorner(pTopLeft, pBottomRight)).isFalse();
    }
    

}
