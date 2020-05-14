package logic.data.shipmodels.systems;

import logic.Logs;
import logic.data.exceptions.NotEnoughFuelException;

public class FuelSystem extends System {
    private int fuel;
    private Logs logs;

    public FuelSystem(boolean isMining, Logs logs) {
        super(isMining);
        if(isMining) this.maxAmount =45;
        else this.maxAmount = 27;
        this.fuel = this.maxAmount;
        this.logs = logs;
    }

    public void subtractFuel(int amount) throws NotEnoughFuelException {
        if (fuel - amount <= 0) {
            String errorMessage = "Fuel can't be spend - not enough fuel";
            throw new NotEnoughFuelException(errorMessage);
        }
        fuel -= amount;
    }

    public void addFuel(int amount){
        int amountAdded = amount;
        if(this.fuel + amount > this.maxAmount) {
            amountAdded = maxAmount - this.fuel;
            this.fuel = maxAmount;
            logs.putLog(amountAdded + "fuel cells added");
            return;
        }
        this.fuel += amount;
        logs.putLog(amountAdded + "fuel cells added");
    }

    public int getFuel() {
        return this.fuel;
    }
}
