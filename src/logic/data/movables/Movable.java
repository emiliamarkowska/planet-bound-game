package logic.data.movables;

import logic.Logs;
import logic.data.exceptions.NotAllowedMoveException;
import logic.data.geometry.Point;

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

    public void moveUp() throws NotAllowedMoveException {
        if (position.getY() == 1) {
            String errorMessage = "Can't move up.";
            Logs.putLog(errorMessage);
            throw new NotAllowedMoveException(errorMessage);
        }
        position.setXY(position.getX(), position.getY() - 1);
        Logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public void moveDown() throws NotAllowedMoveException {
        if (position.getY() == 6) {
            if (position.getY() == 1) {
                String errorMessage = "Can't move down.";
                Logs.putLog(errorMessage);
                throw new NotAllowedMoveException(errorMessage);
            }
        }
        position.setXY(position.getX(), position.getY() + 1);
        Logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public void moveLeft() throws NotAllowedMoveException {
        if (position.getX() == 1) {
            String errorMessage = "Can't move left.";
            Logs.putLog(errorMessage);
            throw new NotAllowedMoveException(errorMessage);
        }
        position.setXY(position.getX() - 1, position.getY());
        Logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public void moveRight() throws NotAllowedMoveException {
        if (position.getX() == 6) {
            String errorMessage = "Can't move right.";
            Logs.putLog(errorMessage);
            throw new NotAllowedMoveException(errorMessage);
        }
        position.setXY(position.getX() + 1, position.getY());
        Logs.putLog("Position changed to: (" + position.getX() + ", " + position.getY() +")" );
    }

    public Point getPosition() {
        return position;
    }

    public void setPosition(Point point) { this.position = point; }
}
