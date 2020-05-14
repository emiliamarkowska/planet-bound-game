package logic;

import logic.data.planetmodels.Planet;
import logic.data.factories.PlanetFactory;
import logic.data.planetmodels.SpaceStation;
import logic.data.shipmodels.Ship;

public class PlanetBoundData {

    private Ship ship;
    private Planet planet;
    private SpaceStation spaceStation;
    private Logs logs;

    PlanetBoundData() {
        ship = null;
        logs = new Logs();
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        spaceStation = new SpaceStation(ship, getLogs());
    }

    public Planet getPlanet() {
        return planet;
    }

    public void generateNextPlanet() {
        planet = PlanetFactory.createRandomPlanet(logs);
    }

    public SpaceStation getSpaceStation() {
        return spaceStation;
    }

    public Logs getLogs() {
        return logs;
    }
}
