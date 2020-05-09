package logic.data.exceptions;

public class InsufficientResourcesException extends GameException {

    public InsufficientResourcesException() {
        super("You do not have enough resources to perform that action.");
    };
    public InsufficientResourcesException(String msg) {
        super(msg);
    }
}