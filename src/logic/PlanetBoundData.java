package logic;

import logic.data.planetmodels.Planet;
import logic.data.factories.PlanetFactory;
import logic.data.planetmodels.SpaceStation;
import logic.data.shipmodels.Ship;

public class PlanetBoundData {

    private Ship ship;
    private Planet planet;
    private SpaceStation spaceStation;
    private ExplorationPhase exLogic;
    private LogRecorder logRecorder;

    PlanetBoundData() {
        ship = null;
        generateNextPlanet();
        exLogic = null;
        logRecorder = new LogRecorder();
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
        spaceStation = new SpaceStation(ship);
    }

    public ExplorationPhase getExLogic() {
        return exLogic;
    }

    public void setExLogic(ExplorationPhase exLogic) {
        this.exLogic = exLogic;
    }

    public Planet getPlanet() {
        return planet;
    }

    public LogRecorder getLogRecorder() {
        return logRecorder;
    }

    public void generateNextPlanet() {
        planet = PlanetFactory.createRandomPlanet();
    }

    public SpaceStation getSpaceStation() {
        return spaceStation;
    }
}
