package logic.data.movables;

import logic.Logs;
import logic.data.exceptions.NotAllowedMoveException;
import logic.data.geometry.Point;
import logic.Randomizer;
import logic.data.geometry.Vector;

public class Alien extends MovableFighting {

    private AlienTypes alienType;

    public Alien(Point position, AlienTypes alienType) {
        super(position, 1);

        this.alienType = alienType;
    }

    @Override
    public void fight(MovableFighting mov) {
        Drone drone = (Drone)mov;
        if (Randomizer.randomSuccessFraction(alienType.getAttackChance(), 6)) {
            Logs.putLog("Alien shot - drone suffered");
            drone.decreaseHealth();
        }
        else Logs.putLog("Alien shot - missed");
    }

    public AlienTypes getAlienType() {
        return alienType;
    }

    public void setAlienType(AlienTypes alienType) {
        this.alienType = alienType;
    }

    public void chaseDrone(Drone drone) throws NotAllowedMoveException {
        Logs.putLog("Alien's move: ");
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
