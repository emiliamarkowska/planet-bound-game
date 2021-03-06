package logic.data.events;

import logic.Logs;
import logic.data.exceptions.CrewFullException;
import logic.data.exceptions.NotEnoughFuelException;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.shipmodels.Ship;

public interface IEvent {
    public void run(Ship ship, Logs logs) throws CrewFullException, NotEnoughFuelException, NotEnoughResourcesException;
}
