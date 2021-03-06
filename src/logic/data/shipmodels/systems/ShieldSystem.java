package logic.data.shipmodels.systems;

import logic.Logs;
import logic.data.exceptions.NotEnoughShieldException;

public class ShieldSystem extends System {
    private int shields;
    private Logs logs;

    public ShieldSystem(boolean isMining, Logs logs) {
        super(isMining);
        if(isMining) this.maxAmount = 18;
        else this.maxAmount = 9;
        this.shields = this.maxAmount;
        this.logs = logs;

    }

    public void loseShield(int amount) throws NotEnoughShieldException {
        if(!isShieldAvailable(amount)){
            String errorMessage = "Not enough shield cells. Can't be lost.";
            throw new NotEnoughShieldException(errorMessage);
        }
        shields -= amount;
        logs.putLog("Number of shields decreased by " + amount);
    }

    public void addShield(int amount) {
        int amountAdded = amount;
        if(shields + amount > maxAmount){
            amountAdded = maxAmount - shields;
            logs.putLog("Number of shields increased by " + amountAdded);
        }
        shields += amount;
        logs.putLog("Number of shields increased by " + amountAdded);
    }

    public void fillShield() {
        this.shields = this.maxAmount;
    }

    public int getShields() {
        return this.shields;
    }

    public boolean isShieldAvailable(int amount){
        return this.shields > amount;
    }
}
