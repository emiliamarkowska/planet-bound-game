package logic.data.movables;

import logic.Logs;
import logic.data.exceptions.NotAllowedMoveException;
import logic.data.geometry.Point;

public class Movable {

    protected Point position;
    protected Logs logs;

    protected Movable(Point position, Logs logs) {
        this.position = position;
        this.logs = logs;
    }


    public boolean isWithingRange(Movable mov) {
        return Math.pow((position.getX() - mov.position.getX()), 2) + Math.pow((position.getY() - mov.position.getY()), 2) <= 1;
    }

    public boolean didMeet(Movable mov) {
        return position.equals(mov.position);
    }

    public void moveUp() throws NotAllowedMoveException {
        if (position.getY() == 1) {
            String errorMessage = "Can't move up.";
            throw new NotAllowedMoveException(errorMessage);
        }
        position.setXY(position.getX(), position.getY() - 1);
        logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public void moveDown() throws NotAllowedMoveException {
        if (position.getY() == 6) {
                String errorMessage = "Can't move down.";
                throw new NotAllowedMoveException(errorMessage);
            }
        position.setXY(position.getX(), position.getY() + 1);
        logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public void moveLeft() throws NotAllowedMoveException {
        if (position.getX() == 1) {
            String errorMessage = "Can't move left.";
            throw new NotAllowedMoveException(errorMessage);
        }
        position.setXY(position.getX() - 1, position.getY());
        logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public void moveRight() throws NotAllowedMoveException {
        if (position.getX() == 6) {
            String errorMessage = "Can't move right.";
            throw new NotAllowedMoveException(errorMessage);
        }
        position.setXY(position.getX() + 1, position.getY());
        logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point point) { this.position = point; }
}
