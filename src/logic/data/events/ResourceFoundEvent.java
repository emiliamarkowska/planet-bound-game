package logic.data.events;

import logic.Logs;
import logic.Randomizer;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;

public class ResourceFoundEvent implements IEvent {
    @Override
    public void run(Ship ship, Logs logs) {
        logs.putLog("Event - “You ship comes across an abandoned ship and you find a random resource. Roll the d6 for that resource and add it to your cargo.");
        ResourceType resourceType = ResourceType.getRandomResource();
        int amount = Randomizer.randomInt(1, 6);
        ship.getCargoSystem().addResource(amount, resourceType);
    }
}
