package de.lupo3742.rectangles.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class RectanglesCalculatorTest {

    @Test
    public void testNoPoint() {
        RectanglesCalculator calculator = new RectanglesCalculator();
        
        assertThat(calculator.getNumberRectangles()).isEqualTo(0);
    }

    @Test
    public void testTwoPoints() {
        SortableIntPoint pOne = new SortableIntPoint(1, 1);
        SortableIntPoint pTwo = new SortableIntPoint(1, 2);
        
        RectanglesCalculator calculator = new RectanglesCalculator(pOne, pTwo);
        
        assertThat(calculator.getNumberRectangles()).isEqualTo(0);
    }
    
    @Test
    public void testFourPointsNoRectangle() {
        SortableIntPoint pOne = new SortableIntPoint(1, 1);
        SortableIntPoint pTwo = new SortableIntPoint(1, 3);
        SortableIntPoint pThree = new SortableIntPoint(4, 1);
        SortableIntPoint pFour = new SortableIntPoint(2, 7);
        
        RectanglesCalculator calculator = new RectanglesCalculator(pOne, pTwo, pThree, pFour);
        
        assertThat(calculator.getNumberRectangles()).isEqualTo(0);
    }

    /**
     * Four points form one rectangle:
     * x x
     * x x
     */
    @Test
    public void testSingleRectangle() {
        SortableIntPoint pBottomLeft = new SortableIntPoint(1, 1);
        SortableIntPoint pBottomRight = new SortableIntPoint(1, 2);
        SortableIntPoint pTopLeft = new SortableIntPoint(2, 1);
        SortableIntPoint pTopRight = new SortableIntPoint(2, 2);

        RectanglesCalculator calculator = new RectanglesCalculator(
                pBottomLeft, pBottomRight, pTopLeft, pTopRight);
        
        assertThat(calculator.getNumberRectangles()).isEqualTo(1);
    }

    /**
     * Seven points form two rectangles (i.e. squares):
     * x x
     * x x x
     *   x x
     */
    @Test
    public void testTwoRectangles() {
        SortableIntPoint pBottomMiddle = new SortableIntPoint(2, 1);
        SortableIntPoint pBottomRight = new SortableIntPoint(3, 1);

        SortableIntPoint pMiddleLeft = new SortableIntPoint(1, 2);
        SortableIntPoint pMiddleMiddle = new SortableIntPoint(2, 2);
        SortableIntPoint pMiddleRight = new SortableIntPoint(3, 2);
        
        SortableIntPoint pTopLeft = new SortableIntPoint(1, 3);
        SortableIntPoint pTopMiddle = new SortableIntPoint(2, 3);
        
        RectanglesCalculator calculator = new RectanglesCalculator(
                pBottomMiddle, pBottomRight, pMiddleLeft, pMiddleMiddle, pMiddleRight, pTopLeft, pTopMiddle);
        
        assertThat(calculator.getNumberRectangles()).isEqualTo(2);
    }
    
    /**
     * Six points form three rectangles (two small squares and one large rectangle):
     * x x x
     * x x x
     */
    @Test
    public void testThreeRectangles() {
        SortableIntPoint pBottomLeft = new SortableIntPoint(1, 1);
        SortableIntPoint pBottomMiddle = new SortableIntPoint(1, 2);
        SortableIntPoint pBottomRight = new SortableIntPoint(1, 3);

        SortableIntPoint pTopLeft = new SortableIntPoint(2, 1);
        SortableIntPoint pTopMiddle = new SortableIntPoint(2, 2);
        SortableIntPoint pTopRight = new SortableIntPoint(2, 3);
        
        RectanglesCalculator calculator = new RectanglesCalculator(
                pBottomLeft, pBottomMiddle, pTopLeft, pTopMiddle, pBottomRight, pTopRight);

        assertThat(calculator.getNumberRectangles()).isEqualTo(3);
    }
    
    /**
     * Nine points form nine rectangles (four small squares, four rectangles, one large square):
     * x x x
     * x x x
     * x x x
     */
    @Test
    public void testNineRectangles() {
        SortableIntPoint pBottomLeft = new SortableIntPoint(1, 1);
        SortableIntPoint pBottomMiddle = new SortableIntPoint(2, 1);
        SortableIntPoint pBottomRight = new SortableIntPoint(3, 1);

        SortableIntPoint pMiddleLeft = new SortableIntPoint(1, 2);
        SortableIntPoint pMiddleMiddle = new SortableIntPoint(2, 2);
        SortableIntPoint pMiddleRight = new SortableIntPoint(3, 2);
        
        SortableIntPoint pTopLeft = new SortableIntPoint(1, 3);
        SortableIntPoint pTopMiddle = new SortableIntPoint(2, 3);
        SortableIntPoint pTopRight = new SortableIntPoint(3, 3);
        
        RectanglesCalculator calculator = new RectanglesCalculator(
                pBottomLeft, pBottomMiddle, pBottomRight, pMiddleLeft, pMiddleMiddle, pMiddleRight, pTopLeft, pTopMiddle, pTopRight);
        
        assertThat(calculator.getNumberRectangles()).isEqualTo(9);
    }
    

}
