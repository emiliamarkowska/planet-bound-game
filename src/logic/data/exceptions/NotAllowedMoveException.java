package logic.data.exceptions;

public class NotAllowedMoveException extends Exception {
    public NotAllowedMoveException(String errorMessage){
        super(errorMessage);
    }
}
