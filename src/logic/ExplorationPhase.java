package logic;

import logic.data.movables.Alien;
import logic.data.movables.Drone;
import logic.data.movables.Resource;
import logic.data.planetmodels.Planet;

public class ExplorationPhase {
    private Planet planet;
    private Alien alien;
    private Resource resource;
    private Drone drone;
    private Point droneInitialPosition;

    ExplorationPhase(Drone drone) {
        this.drone = drone;
        droneInitialPosition = new Point(Randomizer.randomInt(1, 6), Randomizer.randomInt(1, 6));
        drone.setPosition(droneInitialPosition);

    }
}
