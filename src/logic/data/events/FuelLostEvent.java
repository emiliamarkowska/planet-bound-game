package logic.data.events;

import logic.Logs;
import logic.data.exceptions.NotEnoughFuelException;
import logic.data.shipmodels.Ship;

public class FuelLostEvent implements IEvent {
    @Override
    public void run(Ship ship, Logs logs) throws NotEnoughFuelException {
        logs.putLog("Event - You accidentally use too much fuel in a test run. Remove 1 fuel cell.");
        ship.getFuelSystem().subtractFuel(1);
    }
}
