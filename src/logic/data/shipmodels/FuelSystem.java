package logic.data.shipmodels;

import logic.data.exceptions.NoFuelException;

public class FuelSystem implements ShipSystem {
    private boolean isAvailable;
    private boolean isMilitary;
    private int maxFuelAmount;
    private int fuelAmount;

    public FuelSystem(boolean isMilitary) {
        this.isMilitary = isMilitary;

        if (isMilitary) maxFuelAmount = 27;
        else maxFuelAmount = 45;

        fuelAmount = maxFuelAmount;
    }

    public void spendFuel(int amount) throws NoFuelException {
        fuelAmount -= amount;
        if (fuelAmount <= 0) throw new NoFuelException();
    }

    public int getFuelAmount() {
        return fuelAmount;
    }

    public int getMaxFuelAmount() {
        return maxFuelAmount;
    }

    public void addFuel(int amount){
        this.fuelAmount += amount;
    }
}
