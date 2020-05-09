package logic.data.exceptions;

public class NoFuelException extends GameException {

    public NoFuelException() {
        super("You have no fuel left.");
    };
    public NoFuelException(String msg) {
        super(msg);
    }
}