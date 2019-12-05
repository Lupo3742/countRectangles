package de.lupo3742.rectangles.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RectanglesCalculatorHelperMethodsTest {

	// ----- tests for method pointsAbove
	
    @Test
    public void shouldFindNoPointAbove() {
        SortableIntPoint referencePoint = new SortableIntPoint(2, 4);

        // another point below the reference point
        SortableIntPoint pBelow = new SortableIntPoint(2, 3);
        // another points to the right of the referencePoint
        SortableIntPoint pRight = new SortableIntPoint(3, 4);
        // another points to the left of the referencePoint
        SortableIntPoint pLeft = new SortableIntPoint(-1, 4);
        // another points to somewhere else
        SortableIntPoint pRightAbove = new SortableIntPoint(7, 8);
        
        RectanglesCalculator calculator = new RectanglesCalculator(referencePoint, pBelow, pRight, pLeft, pRightAbove);
        int pointsAbove = calculator.pointsAbove(referencePoint).size();
        
        assertThat(pointsAbove).isEqualTo(0);
    }
    
    @Test
    public void shouldFindSinglePointAbove() {
        SortableIntPoint referencePoint = new SortableIntPoint(2, 4);

        // another point above the reference point
        SortableIntPoint pAbove = new SortableIntPoint(2, 5);

        RectanglesCalculator calculator = new RectanglesCalculator(referencePoint, pAbove);
        int pointsAbove = calculator.pointsAbove(referencePoint).size();
        
        assertThat(pointsAbove).isEqualTo(1);
    }

    @Test
    public void shouldFindTwoPointsAbove() {
        SortableIntPoint referencePoint = new SortableIntPoint(2, 4);
        
        // other points above the reference point
        SortableIntPoint pAboveOne = new SortableIntPoint(2, 5);
        SortableIntPoint pAboveTwo = new SortableIntPoint(2, 34);
        
        // other point not above the reference point
        SortableIntPoint pNotAbove = new SortableIntPoint(12, 14);
        
        RectanglesCalculator calculator = new RectanglesCalculator(referencePoint, pAboveOne, pAboveTwo, pNotAbove);
        int pointsAbove = calculator.pointsAbove(referencePoint).size();
        
        assertThat(pointsAbove).isEqualTo(2);
    }
    
	// ----- tests for method pointsToTheRight

    @Test
    public void shouldFindNoPointToTheRight() {
        SortableIntPoint referencePoint = new SortableIntPoint(2, 4);

        // another point below the reference point
        SortableIntPoint pBelow = new SortableIntPoint(2, 3);
        // another points above of the referencePoint
        SortableIntPoint pRight = new SortableIntPoint(2, 5);
        // another points to the left of the referencePoint
        SortableIntPoint pLeft = new SortableIntPoint(-1, 4);
        // another points to somewhere else
        SortableIntPoint pRightAbove = new SortableIntPoint(7, 8);
        
        RectanglesCalculator calculator = new RectanglesCalculator(referencePoint, pBelow, pRight, pLeft, pRightAbove);
        int pointsToTheRight = calculator.pointsToTheRight(referencePoint).size();
        
        assertThat(pointsToTheRight).isEqualTo(0);
    }
    
    @Test
    public void shouldFindSinglePointToTheRight() {
        SortableIntPoint referencePoint = new SortableIntPoint(2, 4);

        // another point to the right of the reference point
        SortableIntPoint pAbove = new SortableIntPoint(3, 4);

        RectanglesCalculator calculator = new RectanglesCalculator(referencePoint, pAbove);
        int pointsToTheRight = calculator.pointsToTheRight(referencePoint).size();
        
        assertThat(pointsToTheRight).isEqualTo(1);
    }

    @Test
    public void shouldFindTwoPointsToTheRight() {
        SortableIntPoint referencePoint = new SortableIntPoint(2, 4);
        
        // other points to the right of the reference point
        SortableIntPoint pAboveOne = new SortableIntPoint(3, 4);
        SortableIntPoint pAboveTwo = new SortableIntPoint(42, 4);
        
        // other point not to the right of the reference point
        SortableIntPoint pNotAbove = new SortableIntPoint(12, 14);
        
        RectanglesCalculator calculator = new RectanglesCalculator(referencePoint, pAboveOne, pAboveTwo, pNotAbove);
        int pointsToTheRight = calculator.pointsToTheRight(referencePoint).size();
        
        assertThat(pointsToTheRight).isEqualTo(2);
    }
    
	// ----- tests for method hasRectangleTopRightCorner

    @Test
    public void shouldFindTopRightCorner() {
        SortableIntPoint pTopLeft = new SortableIntPoint(1, 2);
        SortableIntPoint pBottomRight = new SortableIntPoint(2, 1);

        SortableIntPoint pTopRight = new SortableIntPoint(2, 2);
        
        RectanglesCalculator calculator = new RectanglesCalculator(pTopLeft, pBottomRight, pTopRight);
        assertThat(calculator.hasRectangleTopRightCorner(pTopLeft, pBottomRight)).isTrue();
    }
    
    @Test
    public void shouldNotFindTopRightCorner() {
        SortableIntPoint pTopLeft = new SortableIntPoint(2, 1);
        SortableIntPoint pBottomRight = new SortableIntPoint(1, 2);
        
        SortableIntPoint pOther = new SortableIntPoint(32, 42);
        
        RectanglesCalculator calculator = new RectanglesCalculator(pTopLeft, pBottomRight, pOther);
        assertThat(calculator.hasRectangleTopRightCorner(pTopLeft, pBottomRight)).isFalse();
    }
    

}
