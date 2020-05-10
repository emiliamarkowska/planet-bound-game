package logic.data.events;

import logic.Logs;
import logic.data.shipmodels.Ship;

public class NoEvent implements IEvent {
    @Override
    public void run(Ship ship) {
        Logs.putLog("Event - nothing happens");
    }
}
