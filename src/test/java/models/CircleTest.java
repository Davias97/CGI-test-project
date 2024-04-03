package models;

import com.example.cgitestproject.models.Circle;
import com.example.cgitestproject.models.Point;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {

    @Test
    void isInside() {
        // Creating a circle with center at (0,0) and radius 5
        Circle circle = new Circle(new Point(0, 0), 5);

        // Test points
        Point insidePoint = new Point(3, 4); // Inside the circle
        Point onBoundaryPoint = new Point(5, 0); // On the boundary of the circle
        Point outsidePoint = new Point(7, 0); // Outside the circle

        // Testing points
        assertTrue(circle.isInside(insidePoint), "Point inside the circle");
        assertTrue(circle.isInside(onBoundaryPoint), "Point on the boundary of the circle");
        assertFalse(circle.isInside(outsidePoint), "Point outside the circle");
    }
}