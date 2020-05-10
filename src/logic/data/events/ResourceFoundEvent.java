package logic.data.events;

import logic.Randomizer;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;

public class ResourceFoundEvent implements IEvent {
    @Override
    public void run(Ship ship) {
        ResourceType resourceType = ResourceType.getRandomResource();
        int amount = Randomizer.randomInt(1, 6);
        ship.getCargoSystem().addResource(amount, resourceType);
    }
}
