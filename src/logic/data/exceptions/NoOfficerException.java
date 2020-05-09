package logic.data.exceptions;

public class NoOfficerException extends GameException {

    public NoOfficerException() {
        super("You don't have the required officer for this action");
    };
    public NoOfficerException(String msg) {
        super(msg);
    }
}
