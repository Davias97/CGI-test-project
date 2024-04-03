package models;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Circle {

    private Point circleCentre;
    private double radius;

    public Circle (Point centre, double radius) {
        this.circleCentre = centre;
        this.radius = radius;
    }

    public boolean isInside(Point point) {
        double distanceX = point.getX() - circleCentre.getX();
        double distanceY = point.getY() - circleCentre.getY();
        return Math.sqrt(distanceX * distanceX + distanceY * distanceY) <= radius;
    }

}
