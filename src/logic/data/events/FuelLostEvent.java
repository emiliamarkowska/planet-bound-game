package logic.data.events;

import logic.data.shipmodels.Ship;

public class FuelLostEvent implements IEvent {
    @Override
    public void run(Ship ship) {
        ship.getFuelSystem().subtractFuel(1);
    }
}
