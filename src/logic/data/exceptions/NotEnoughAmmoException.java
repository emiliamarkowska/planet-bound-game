package logic.data.exceptions;

public class NotEnoughAmmoException extends Exception {
    public NotEnoughAmmoException(String errorMessage){
        super(errorMessage);
    }
}
