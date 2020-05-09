package logic.data.exceptions;

public class MaximumCapacityReachedException extends GameException {

    public MaximumCapacityReachedException() {
        super("Maximum depth reached for that ship type.");
    };
    public MaximumCapacityReachedException(String msg) {
        super(msg);
    }
}