package logic.data.exceptions;

public class NotEnoughShieldException extends Exception {
    public NotEnoughShieldException(String errorMessage){
        super(errorMessage);
    }
}
