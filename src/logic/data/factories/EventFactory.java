package logic.data.factories;

import logic.Randomizer;
import logic.data.events.*;

public class EventFactory {

    public static IEvent getRandomEvent() {
        int randomEventNumber = Randomizer.randomInt(1, 6);
        return getEvent(randomEventNumber);
    }

    public static IEvent getEvent(int eventNumber) {
        switch(eventNumber) {
            case 1:
                return new CrewDeathEvent();
            case 2:
                return new ResourceFoundEvent();
            case 3:
                return new ResourceLostEvent();
            case 4:
                return new FuelLostEvent();
            case 5:
                return new NoEvent();
            case 6:
                return new CrewFoundEvent();

        }
        return new NoEvent();
    }
}
