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

    public void moveUp() {
        if (position.getY() == 1) return;
        position.setXY(position.getX(), position.getY() - 1);
    }

    public void moveDown() {
        if (position.getY() == 6) return;
        position.setXY(position.getX(), position.getY() + 1);
    }

    public void moveLeft() {
        if (position.getX() == 1) return;
        position.setXY(position.getX() - 1, position.getY());
    }

    public void moveRight() {
        if (position.getX() == 6) return;
        position.setXY(position.getX() + 1, position.getY());
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point point) { this.position = point; }
}
