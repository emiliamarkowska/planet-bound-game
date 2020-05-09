package logic;

import logic.data.Log;
import logic.data.LogRecorder;
import logic.data.Resource;
import logic.data.planetmodels.Alien;
import logic.data.planetmodels.AlienFactory;
import logic.data.planetmodels.Planet;
import logic.data.shipmodels.Drone;
import logic.data.shipmodels.Ship;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class PlanetExplorationLogic {
    private Ship ship;
    private Drone drone;
    private Alien alien;
    private int resourcePositionX;
    private int resourcePositionY;
    private Resource resource;
    private int alienWaitingCounter;
    private int droneInitialPositionX;
    private int droneInitialPositionY;
    private boolean hasResource;
    private boolean droneDestroyed;
    private LogRecorder logRecorder;

    public PlanetExplorationLogic(Ship ship, Resource resource, LogRecorder logRecorder){
        this.logRecorder = logRecorder;
        this.ship = ship;
        this.drone = ship.getDrone();
        this.resource = resource;
        initiateCoordinates();
        this.droneInitialPositionX = drone.getX();
        this.droneInitialPositionY = drone.getY();
        this.hasResource = false;
        alienWaitingCounter = 0;
        droneDestroyed = false;

        logRecorder.addLog("Drone landed on a planet with " + resource.getResourceType() + " resource type.");
    }

    private void initiateCoordinates(){
        int droneX = Dice.throwd6();
        int droneY = Dice.throwd6();
        this.drone.deployDrone(droneX, droneY);

        int alienX;
        int alienY;

        do{
            alienX = Dice.throwd6();
            alienY = Dice.throwd6();
        } while(!checkIfTheCoordinatesAreOutsideRange(alienX, alienY, droneX, droneY));

        this.alien = AlienFactory.createRandomAlien(alienX, alienY);

        int resourceX;
        int resourceY;

        do{
            resourceX = Dice.throwd6();
            resourceY = Dice.throwd6();
        } while (!checkIfTheCoordinatesAreOutsideRange(resourceX, resourceY, droneX, droneY) || !checkIfTheCoordinatesAreOutsideRange(resourceX, resourceY, alienX, alienY));

        this.resourcePositionX = resourceX;
        this.resourcePositionY = resourceY;
    }

    private boolean checkIfTheCoordinatesAreOutsideRange(int x, int y, int excX, int excY){
        if(x == excX && y == excY) return false;
        else if(x == excX - 1 && y == excY) return false;
        else if(x == excX + 1 && y == excY) return false;
        else if(x == excX && y == excY - 1) return false;
        else if(x == excX && y == excY + 1) return false;
        else return true;
    }

    private void moveAlien(){
        int xDifference = (int) Math.signum(drone.getX() - alien.getX());
        int yDifference = (int) Math.signum(drone.getY() - alien.getY());

        if (xDifference != 0 && yDifference != 0) {
            int rand = Dice.throwd2();
            if(rand == 1) alien.setX(alien.getX() + xDifference);
            else alien.setY(alien.getY() + yDifference);
        }
        else if(xDifference == 0) alien.setY(alien.getY() + yDifference);
        else if(yDifference == 0) alien.setX(alien.getX() + xDifference);

    }

    public void moveDrone(String dir) {
        if (drone.isDestroyed() || droneDestroyed) return;
        switch(dir) {
            case "up":
                drone.moveUp();
                break;
            case "down":
                drone.moveDown();
                break;
            case "left":
                drone.moveLeft();
                break;
            case "right":
                drone.moveRight();
                break;
        }
        if(isResourceReached(drone.getX(), drone.getY())) {
            logRecorder.addLog("Drone has picked up the resource.");
        }

        if (alien != null) {

            if (!checkIfTheCoordinatesAreOutsideRange(drone.getX(), drone.getY(), alien.getX(), alien.getY()))
                initiateFight(true);
            if (alien != null) {
                moveAlien();
                if (!checkIfTheCoordinatesAreOutsideRange(alien.getX(), alien.getY(), drone.getX(), drone.getY()))
                    initiateFight(false);
            }
        }
        if (alien == null ){
            alienWaitingCounter--;
            if (alienWaitingCounter == 0) createNewAlien();
        }
    }

    private void createNewAlien() {
        int alienX;
        int alienY;

        do{
            alienX = Dice.throwd6();
            alienY = Dice.throwd6();
        } while(!checkIfTheCoordinatesAreOutsideRange(alienX, alienY, drone.getX(), drone.getY()) || !checkIfTheCoordinatesAreOutsideRange(resourcePositionX, resourcePositionY, alienX, alienY));

        this.alien = AlienFactory.createRandomAlien(alienX, alienY);
    }

    private void initiateFight(boolean doesDroneBeginFight) {
        if (!doesDroneBeginFight) logRecorder.addLog("Alien type " + alien.getAlienType() + " has attacked the drone first.");
        else logRecorder.addLog("Drone has attacked alien type " + alien.getAlienType() + ".");

        int thrownValue = Dice.throwd6();
        if(!doesDroneBeginFight){
            droneAttacked(thrownValue);
        }
        if (!drone.isDestroyed()) {
            while(true){
                thrownValue = Dice.throwd6();
                if(alien.isAlienDead(thrownValue, logRecorder)) {
                    if(ship.getWeaponSystem().isAvailable() || ship.getWeaponSystem().getWeapons() != 0){
                        alien.destroy();
                        alienDestroyed();
                        ship.getWeaponSystem().spendAmmo(1);
                        break;
                    } else drone.damageDrone();
                }
                thrownValue = Dice.throwd6();
                droneAttacked(thrownValue);
                if (droneDestroyed) break;

            }
        }

    }

    private void droneAttacked(int thrownValue) {
        if(alien.isDroneAttacked(thrownValue, logRecorder)){
            drone.damageDrone();
            logRecorder.addLog("Drone health has decreased to " + drone.getHealth() + ".");
            if (drone.isDestroyed()) {
                logRecorder.addLog("Drone has been destroyed.");
                droneDestroyed();
            }
        }
    }

    private void droneDestroyed() {
        droneDestroyed = true;
    }

    private void alienDestroyed() {
        alien = null;
        alienWaitingCounter = Dice.throwd6();
        logRecorder.addLog("Drone moves before next alien arrives: " + alienWaitingCounter + ".");
    }

    private boolean isResourceReached(int droneX, int droneY){
        if(droneX == resourcePositionX && droneY == resourcePositionY){
            this.hasResource = true;
            return true;
        }
        else return false;
    }

    public boolean isDroneBackInShip(){
        return drone.getX() == droneInitialPositionX && drone.getY() == droneInitialPositionY;
    }

    public boolean isResourceInDrone(){
        return hasResource;
    }


    // Test method to draw grid
    // TODO: delete when GUI implemented
    public void drawGrid() {
        System.out.println("-------------");

        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {
                if (alien != null && alien.getX() == j && alien.getY() == i) System.out.print("a");
                else if (drone.getX() == j && drone.getY() == i) System.out.print("d");
                else if (resourcePositionX == j && resourcePositionY == i) System.out.print("r");
                else System.out.print("o");
            }
            System.out.print("\n");
        }

        System.out.println("-------------\n");
    }

    public Resource getResource() {
        return resource;
    }

    public boolean isDroneDestroyed() {
        return droneDestroyed;
    }
}
