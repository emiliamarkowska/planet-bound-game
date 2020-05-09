package logic.data;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum EventTypes {
    CREW_DEATH,
    SALVAGE_SHIP,
    CARGO_LOSS,
    FUEL_LOSS,
    NO_EVENT,
    CREW_RESCUE;



    private static final List<EventTypes> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static EventTypes randomEvent()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
