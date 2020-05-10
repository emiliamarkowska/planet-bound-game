package logic.data.events;

import logic.Logs;
import logic.data.exceptions.CrewFullException;
import logic.data.shipmodels.Ship;

public class CrewFoundEvent implements IEvent {
    @Override
    public void run(Ship ship) throws CrewFullException {
        Logs.putLog("Event - “You find a ship in destress with a lone crew member. This crew member joins your crew.");
        ship.hireOneCrewMember();
    }
}
