package logic.data.geometry;

import logic.data.geometry.Point;

public class Vector {
    private Point startingPoint;
    private Point endingPoint;

    public Vector(Point startingPoint, Point endingPoint) {
        this.startingPoint = startingPoint;
        this.endingPoint = endingPoint;
    }

    public Point getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Point startingPoint) {
        this.startingPoint = startingPoint;
    }

    public Point getEndingPoint() {
        return endingPoint;
    }

    public void setEndingPoint(Point endingPoint) {
        this.endingPoint = endingPoint;
    }

    public int getLengthX() {
        return endingPoint.getX() - startingPoint.getX();
    }

    public int getLengthY() {
        return endingPoint.getY() - startingPoint.getY();
    }

    public boolean isLengthXLonger() {
        return Math.abs(getLengthX()) > Math.abs(getLengthY());
    }
}
