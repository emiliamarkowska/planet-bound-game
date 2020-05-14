package logic.data.factories;

import logic.Logs;
import logic.Randomizer;
import logic.data.planetmodels.Planet;
import logic.data.planetmodels.PlanetsResourcesList;

import java.util.concurrent.ThreadLocalRandom;

public class PlanetFactory {

    public static Planet createPlanet(PlanetsResourcesList planetInfo, boolean hasSpaceStation, Logs logs) {
        return new Planet(planetInfo, hasSpaceStation, logs);
    }

    public static Planet createRandomPlanet(Logs logs) {
        if (Randomizer.randomSuccess(30)) {
            logs.putLog("Planet with space station created");
            return new Planet(PlanetsResourcesList.getRandomPlanet(), true, logs);
        }
        logs.putLog("Planet without space station created");
        return new Planet(PlanetsResourcesList.getRandomPlanet(), false, logs);


    }
}
