# countRectangles
This is just a small coding exercise.
Given is a number of points in a plane, as coordinates only integer numbers are allowed for simplicity. 
The program calculates the number of horizontal and vertical rectangles that can be formed by using the points as corners.
For examples please refer to RectanglesCalculatorTest.java.

In addition a small REST service listening on port 8080 provides an interface to submit points 
and get the number of rectangles in return.
The points can be submitted in the JSON formatted body of a POST message with mapping "/rectangles" like the following:
```
{
	"points": [
		{"x": 1, "y": 1},
		{"x": 1, "y": 2},
		{"x": 2, "y": 1},
		{"x": 2, "y": 2}
	]
}
```
The response body to the example above will be as follows:
```
{
    "numberRectangles": 1
}
```
