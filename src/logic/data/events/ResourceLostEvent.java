package logic.data.events;

import logic.Logs;
import logic.Randomizer;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;

public class ResourceLostEvent implements IEvent {
    @Override
    public void run(Ship ship) throws NotEnoughResourcesException {
        Logs.putLog("Event - a cargo mishap causes you to lose some of your resources. ");
        ResourceType resourceType = ResourceType.getRandomResource();
        int amount = Randomizer.randomInt(1, 3);
        ship.getCargoSystem().payResource(amount,resourceType);
    }
}
