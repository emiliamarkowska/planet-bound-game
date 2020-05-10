package logic;

import logic.data.exceptions.NotAllowedMoveException;
import logic.data.factories.AlienFactory;
import logic.data.factories.ResourceFactory;
import logic.data.geometry.Point;
import logic.data.movables.Alien;
import logic.data.movables.AlienTypes;
import logic.data.movables.Drone;
import logic.data.movables.Resource;
import logic.data.planetmodels.Planet;

public class ExplorationPhase {
    private Planet planet;
    private Alien alien;
    private Resource resource;
    private Drone drone;
    private Point droneInitialPosition;
    private boolean resourceFollows;
    private boolean backToStartingPoint;
    private boolean droneDead;

    public ExplorationPhase(Drone drone, Planet planet) {
        this.drone = drone;
        this.planet = planet;
        resourceFollows = false;
        droneDead = false;
        backToStartingPoint = false;
        droneInitialPosition = new Point(Randomizer.randomInt(1, 6), Randomizer.randomInt(1, 6));
        drone.setPosition(droneInitialPosition);
        do {
            alien = AlienFactory.createAlien(AlienTypes.getRandomAlienType());
            resource = ResourceFactory.createResource(planet.getResourceToBeMined(), new Point(Randomizer.randomInt(1, 6), Randomizer.randomInt(1, 6)));
        } while (drone.isWithingRange(alien) || drone.isWithingRange(resource) || alien.isWithingRange(resource));


    }

    public void goUp() throws NotAllowedMoveException {
        drone.moveUp();
        checkForEvents();
    }

    public void goDown() throws NotAllowedMoveException {
        drone.moveDown();
        checkForEvents();
    }

    public void goLeft() throws NotAllowedMoveException {
        drone.moveLeft();
        checkForEvents();
    }

    public void goRight() throws NotAllowedMoveException {
        drone.moveRight();
        checkForEvents();
    }

    private void checkForEvents() {
        if (resourceFollows) resource.followDrone(drone);
        if (drone.isWithingRange(alien)) startCombat();
        if (drone.didMeet(resource)) pickUpResource();
        if (drone.getPosition().equals(droneInitialPosition)) backToStartingPoint = true;
        if (drone.isDead()) droneDead = true;
    }

    private void pickUpResource() {
        resourceFollows = true;
    }

    private void startCombat() {
        boolean droneStarts = Randomizer.randomSuccess(50);
        if(droneStarts) drone.fight(alien);
        while(!drone.isDead() && !alien.isDead()) {
            alien.fight(drone);
            if (drone.isDead()) break;
            drone.fight(alien);
        }
    }

    public boolean isResourceFollows() {
        return resourceFollows;
    }

    public boolean isBackToStartingPoint() {
        return backToStartingPoint;
    }

    public boolean isDroneDead() {
        return droneDead;
    }

    public Resource getResource() {
        return resource;
    }
}
