package de.lupo3742.rectangles.verticalrectangles;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class VerticalRectanglesFinderTest {

    @Test
    public void testNoPoint() {
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder();
        
        assertThat(finder.getNumberRectangles()).isEqualTo(0);
    }

    @Test
    public void testTwoPoints() {
        IntPoint pOne = new IntPoint(1, 1);
        IntPoint pTwo = new IntPoint(1, 2);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(pOne, pTwo);
        
        assertThat(finder.getNumberRectangles()).isEqualTo(0);
    }
    
    @Test
    public void testFourPointsNoRectangle() {
        IntPoint pOne = new IntPoint(1, 1);
        IntPoint pTwo = new IntPoint(1, 3);
        IntPoint pThree = new IntPoint(4, 1);
        IntPoint pFour = new IntPoint(2, 7);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(pOne, pTwo, pThree, pFour);
        
        assertThat(finder.getNumberRectangles()).isEqualTo(0);
    }

    /**
     * Points form one rectangle:
     * x x
     * x x
     */
    @Test
    public void testSingleRectangle() {
        IntPoint pBottomLeft = new IntPoint(1, 1);
        IntPoint pBottomRight = new IntPoint(1, 2);
        IntPoint pTopLeft = new IntPoint(2, 1);
        IntPoint pTopRight = new IntPoint(2, 2);

        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(
                pBottomLeft, pBottomRight, pTopLeft, pTopRight);
        
        assertThat(finder.getNumberRectangles()).isEqualTo(1);
    }

    /**
     * Points form two rectangles (two squares):
     * x x
     * x x x
     *   x x
     */
    @Test
    public void testTwoRectangles() {
        IntPoint pBottomMiddle = new IntPoint(2, 1);
        IntPoint pBottomRight = new IntPoint(3, 1);

        IntPoint pMiddleLeft = new IntPoint(1, 2);
        IntPoint pMiddleMiddle = new IntPoint(2, 2);
        IntPoint pMiddleRight = new IntPoint(3, 2);
        
        IntPoint pTopLeft = new IntPoint(1, 3);
        IntPoint pTopMiddle = new IntPoint(2, 3);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(
                pBottomMiddle, pBottomRight, pMiddleLeft, pMiddleMiddle, pMiddleRight, pTopLeft, pTopMiddle);
        
        assertThat(finder.getNumberRectangles()).isEqualTo(2);
    }
    
    /**
     * Points form three rectangles (two small squares and one large rectangle):
     * x x x
     * x x x
     */
    @Test
    public void testThreeRectangles() {
        IntPoint pBottomLeft = new IntPoint(1, 1);
        IntPoint pBottomMiddle = new IntPoint(1, 2);
        IntPoint pBottomRight = new IntPoint(1, 3);

        IntPoint pTopLeft = new IntPoint(2, 1);
        IntPoint pTopMiddle = new IntPoint(2, 2);
        IntPoint pTopRight = new IntPoint(2, 3);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(
                pBottomLeft, pBottomMiddle, pTopLeft, pTopMiddle, pBottomRight, pTopRight);

        assertThat(finder.getNumberRectangles()).isEqualTo(3);
    }
    
    /**
     * Points form nine rectangles (four small squares, four rectangles, one large square):
     * x x x
     * x x x
     * x x x
     */
    @Test
    public void testNineRectangles() {
        IntPoint pBottomLeft = new IntPoint(1, 1);
        IntPoint pBottomMiddle = new IntPoint(2, 1);
        IntPoint pBottomRight = new IntPoint(3, 1);

        IntPoint pMiddleLeft = new IntPoint(1, 2);
        IntPoint pMiddleMiddle = new IntPoint(2, 2);
        IntPoint pMiddleRight = new IntPoint(3, 2);
        
        IntPoint pTopLeft = new IntPoint(1, 3);
        IntPoint pTopMiddle = new IntPoint(2, 3);
        IntPoint pTopRight = new IntPoint(3, 3);
        
        VerticalRectanglesFinder finder = new VerticalRectanglesFinder(
                pBottomLeft, pBottomMiddle, pBottomRight, pMiddleLeft, pMiddleMiddle, pMiddleRight, pTopLeft, pTopMiddle, pTopRight);
        
        assertThat(finder.getNumberRectangles()).isEqualTo(9);
    }
    

}
