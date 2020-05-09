package logic.data.planetmodels;

import java.util.concurrent.ThreadLocalRandom;

public class PlanetFactory {

    public static Planet createPlanet(PlanetType planetType, boolean hasSpaceStation) {
        return new Planet(planetType, hasSpaceStation);
    }

    public static Planet createRandomPlanet() {
        int chance = ThreadLocalRandom.current().nextInt(1, 10);
        if (chance <= 3) {
            return new Planet(PlanetType.randomPlanetType(), true);
        }
        return new Planet(PlanetType.randomPlanetType(), false);


    }
}
