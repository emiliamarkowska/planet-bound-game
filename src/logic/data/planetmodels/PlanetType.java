package logic.data.planetmodels;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public enum PlanetType {
    GREEN,
    BLACK,
    RED,
    BLUE;

    private static final List<PlanetType> VALUES =
            Collections.unmodifiableList(Arrays.asList(values()));
    private static final int SIZE = VALUES.size();
    private static final Random RANDOM = new Random();

    public static PlanetType randomPlanetType()  {
        return VALUES.get(RANDOM.nextInt(SIZE));
    }
}
