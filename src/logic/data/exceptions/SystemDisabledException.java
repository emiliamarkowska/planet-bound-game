package logic.data.exceptions;

public class SystemDisabledException extends Exception {
    public SystemDisabledException(String errorMessage){
        super(errorMessage);
    }
}
