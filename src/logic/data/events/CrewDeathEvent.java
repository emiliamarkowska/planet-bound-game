package logic.data.events;

import logic.data.shipmodels.Ship;

public class CrewDeathEvent implements IEvent {
    @Override
    public void run(Ship ship) {
        ship.killOneCrewMember();
    }
}
