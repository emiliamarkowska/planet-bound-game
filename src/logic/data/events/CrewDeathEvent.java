package logic.data.events;

import logic.Logs;
import logic.data.shipmodels.Ship;

public class CrewDeathEvent implements IEvent {
    @Override
    public void run(Ship ship) {
        Logs.putLog("Event - A crew member is injured due to a system malfunction, move the ship crew die to the right one space");
        ship.killOneCrewMember();
    }
}
