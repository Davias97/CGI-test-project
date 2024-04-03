package com.example.cgitestproject.models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle {

    private Point centre;
    private double radius;

    public Circle (Point centre, double radius) {
        this.centre = centre;
        this.radius = radius;
    }

    public boolean isInside(Point point) {
        // Instead of an "oneliner" I used a more readable approach
        double distanceX = point.getX() - centre.getX();
        double distanceY = point.getY() - centre.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY) <= radius;
    }
}
