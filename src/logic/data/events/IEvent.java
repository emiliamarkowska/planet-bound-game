package logic.data.events;

import logic.data.shipmodels.Ship;

public interface IEvent {
    public void run(Ship ship);
}
