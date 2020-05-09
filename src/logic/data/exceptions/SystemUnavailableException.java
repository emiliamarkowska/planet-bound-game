package logic.data.exceptions;

public class SystemUnavailableException extends GameException {

    public SystemUnavailableException() {
        super("You cannot perform this action because required system is unavailable.");
    };
    public SystemUnavailableException(String msg) {
        super(msg);
    }
}