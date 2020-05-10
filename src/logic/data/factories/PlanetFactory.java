package logic.data.factories;

import logic.Logs;
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
            Logs.putLog("Planet with space station created");
            return new Planet(PlanetsResourcesList.getRandomPlanet(), true);
        }
        Logs.putLog("Planet without space station created");
        return new Planet(PlanetsResourcesList.getRandomPlanet(), false);


    }
}
