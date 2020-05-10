package logic.data.factories;

import logic.Randomizer;
import logic.data.planetmodels.Planet;
import logic.data.planetmodels.PlanetsResourcesList;

import java.util.concurrent.ThreadLocalRandom;

public class PlanetFactory {

    public static Planet createPlanet(PlanetsResourcesList planetInfo, boolean hasSpaceStation) {
        return new Planet(planetInfo, hasSpaceStation);
    }

    public static Planet createRandomPlanet() {
        if (Randomizer.randomSuccess(30)) {
            return new Planet(PlanetsResourcesList.getRandomPlanet(), true);
        }
        return new Planet(PlanetsResourcesList.getRandomPlanet(), false);


    }
}
