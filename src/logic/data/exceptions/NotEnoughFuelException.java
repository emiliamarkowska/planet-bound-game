package logic.data.exceptions;

public class NotEnoughFuelException extends Exception {
    public NotEnoughFuelException(String errorMessage){
        super(errorMessage);
    }
}
