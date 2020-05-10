package logic.data.events;

import logic.data.shipmodels.Ship;

public class CrewFoundEvent implements IEvent {
    @Override
    public void run(Ship ship) {
        ship.hireOneCrewMember();
    }
}
