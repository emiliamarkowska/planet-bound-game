package logic.data.movables;

import logic.Point;

import java.awt.geom.Point2D;

public class Movable {

    protected Point position;

    protected Movable(Point position) {
        this.position = position;
    }


    public boolean isWithingRange(Movable mov) {
        return Math.pow((position.getX() - mov.position.getX()), 2) + Math.pow((position.getY() - mov.position.getY()), 2) <= 1;
    }

    public boolean didMeet(Movable mov) {
        return position.equals(mov.position);
    }

    protected void moveUp() {
        position.setXY(position.getX(), position.getY() - 1);
    }

    protected void moveDown() {
        position.setXY(position.getX(), position.getY() + 1);
    }

    protected void moveLeft() {
        position.setXY(position.getX() - 1, position.getY());
    }

    protected void moveRight() {
        position.setXY(position.getX() + 1, position.getY());
    }

    public Point getPosition() {
        return position;
    }
}
