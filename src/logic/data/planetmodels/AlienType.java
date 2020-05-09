package logic.data.planetmodels;

import logic.data.EventTypes;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum AlienType {
    BLACK,
    GREEN,
    BLUE,
    RED;



    private static final List<AlienType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static AlienType randomAlienType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
