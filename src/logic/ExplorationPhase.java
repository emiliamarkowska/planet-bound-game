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
    private Logs logs;
    int waitForNewAlienCounter;

    public ExplorationPhase(Drone drone, Planet planet, Logs logs) {
        this.drone = drone;
        this.planet = planet;
        resourceFollows = false;
        droneDead = false;
        backToStartingPoint = false;
        droneInitialPosition = new Point(Randomizer.randomInt(1, 6), Randomizer.randomInt(1, 6));
        drone.setPosition(new Point(droneInitialPosition.getX(), droneInitialPosition.getY()));
        this.logs = logs;
        this.waitForNewAlienCounter = -1;
        do {
            alien = AlienFactory.createAlien(AlienTypes.getRandomAlienType(), logs);
            resource = ResourceFactory.createResource(planet.getResourceToBeMined(), new Point(Randomizer.randomInt(1, 6), Randomizer.randomInt(1, 6)), logs);
        } while (drone.isWithingRange(alien) || drone.isWithingRange(resource) || alien.isWithingRange(resource));

        draw();
    }

    public void goUp() throws NotAllowedMoveException {
        drone.moveUp();
        if (waitForNewAlienCounter == -1)
            alien.chaseDrone(drone);
        else if (waitForNewAlienCounter == 0) {
            alien = AlienFactory.createAlien(AlienTypes.getRandomAlienType(), logs);
            waitForNewAlienCounter = -1;
        }
        else waitForNewAlienCounter --;
        checkForEvents();
    }

    public void goDown() throws NotAllowedMoveException {
        drone.moveDown();
        if (waitForNewAlienCounter == -1)
            alien.chaseDrone(drone);
        else if (waitForNewAlienCounter == 0){
            alien = AlienFactory.createAlien(AlienTypes.getRandomAlienType(), logs);
            waitForNewAlienCounter = -1;
        }
        else waitForNewAlienCounter --;
        checkForEvents();
    }

    public void goLeft() throws NotAllowedMoveException {
        drone.moveLeft();
        if (waitForNewAlienCounter == -1)
            alien.chaseDrone(drone);
        else if (waitForNewAlienCounter == 0){
            alien = AlienFactory.createAlien(AlienTypes.getRandomAlienType(), logs);
            waitForNewAlienCounter = -1;
        }
        else waitForNewAlienCounter --;
        checkForEvents();
    }

    public void goRight() throws NotAllowedMoveException {
        drone.moveRight();
        if (waitForNewAlienCounter == -1)
            alien.chaseDrone(drone);
        else if (waitForNewAlienCounter == 0){
            alien = AlienFactory.createAlien(AlienTypes.getRandomAlienType(), logs);
            waitForNewAlienCounter = -1;
        }

        else waitForNewAlienCounter --;
        checkForEvents();
    }

    private void checkForEvents() {
        if (resourceFollows) resource.followDrone(drone);
        if (drone.isWithingRange(alien)) startCombat();
        if (drone.didMeet(resource)) pickUpResource();
        if (drone.getPosition().equals(droneInitialPosition)) backToStartingPoint = true;
        if (drone.isDead()) droneDead = true;
        draw();
    }

    private void pickUpResource() {
        resourceFollows = true;
    }

    private void startCombat() {
        boolean droneStarts = Randomizer.randomSuccess(50);
        if(droneStarts) drone.fight(alien);
        if (alien.isDead()) alienDead();
        while(!drone.isDead() && !alien.isDead()) {
            alien.fight(drone);
            if (drone.isDead()) break;
            drone.fight(alien);
            if (alien.isDead()) alienDead();
        }
    }

    private void alienDead() {
        this.waitForNewAlienCounter = Randomizer.randomInt(1, 6);
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


    //TODO: deleted
    private void draw() {
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (drone.getPosition().equals(new Point(j, i))) System.out.print('d');
                else if (alien != null && alien.getPosition().equals(new Point(j, i))) System.out.print('a');
                else if (resource.getPosition().equals(new Point(j, i))) System.out.print('r');
                else System.out.print('o');
            }
            System.out.print("\n");
        }
    }


}
