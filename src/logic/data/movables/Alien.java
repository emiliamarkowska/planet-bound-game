package logic.data.movables;

import logic.Point;
import logic.Randomizer;
import logic.Vector;
import logic.data.LogRecorder;

import java.awt.geom.Point2D;

public class Alien extends MovableFighting {

    private AlienTypes alienType;

    public Alien(Point position, AlienTypes alienType) {
        super(position, 1);

        this.alienType = alienType;
    }

    @Override
    public void fight(MovableFighting mov) {
        Drone drone = (Drone)mov;
        if (Randomizer.randomSuccessFraction(alienType.getAttackChance(), 6)) drone.decreaseHealth();
    }

    public AlienTypes getAlienType() {
        return alienType;
    }

    public void setAlienType(AlienTypes alienType) {
        this.alienType = alienType;
    }

    public void chaseDrone(Drone drone) {
        Vector vectorTowardsAlien = new Vector(position, drone.position);
        if (vectorTowardsAlien.isLengthXLonger()) {
            if (vectorTowardsAlien.getLengthX() < 0) moveLeft();
            else moveRight();
        }
        else {
            if (vectorTowardsAlien.getLengthY() < 0) moveDown();
            else moveUp();
        }
    }



}
