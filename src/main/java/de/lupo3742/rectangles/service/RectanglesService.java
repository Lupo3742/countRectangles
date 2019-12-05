package de.lupo3742.rectangles.service;

import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import de.lupo3742.rectangles.calculator.RectanglesCalculator;
import de.lupo3742.rectangles.calculator.SortableIntPoint;

@Service
public class RectanglesService {

    static final Logger LOG = LoggerFactory.getLogger(RectanglesService.class);
    
    int getNumberRectangles(IntPoints points) {
        LOG.info("Calculate rectangles for {}", points);
        
        Stream<SortableIntPoint> pointsStream = points.getPoints().stream()
                .map(p -> new SortableIntPoint(p.getX(), p.getY()));
        
        RectanglesCalculator calculator = new RectanglesCalculator(pointsStream);
        int numberRectangles = calculator.getNumberRectangles();
        
        LOG.info("Number of rectangles: {}", numberRectangles);
        return numberRectangles;
    }
}
