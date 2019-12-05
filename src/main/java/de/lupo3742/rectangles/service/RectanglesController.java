package de.lupo3742.rectangles.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rectangles")
public class RectanglesController {

    private final RectanglesService rectanglesService;

    @Autowired
    public RectanglesController(RectanglesService rectanglesService) {
        this.rectanglesService = rectanglesService;
    }

    @PostMapping()
    public NumberRectangles getNumberRectangles(@RequestBody IntPoints points) {
        int rectangles = rectanglesService.getNumberRectangles(points);
        return new NumberRectangles(rectangles);
    }
}
