package logic.data.exceptions;

public class NotEnoughResourcesException extends Exception {
    public NotEnoughResourcesException(String errorMessage){
        super(errorMessage);
    }
}
