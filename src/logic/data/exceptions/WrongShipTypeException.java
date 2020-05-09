package logic.data.exceptions;

public class WrongShipTypeException extends GameException {

    public WrongShipTypeException() {
        super("You cannot perform this action using your ship type.");
    };
    public WrongShipTypeException(String msg) {
        super(msg);
    }
}