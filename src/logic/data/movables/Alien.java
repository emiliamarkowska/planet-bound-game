package logic.data.movables;

import logic.Point;
import logic.Randomizer;
import logic.data.LogRecorder;

import java.awt.geom.Point2D;

public class Alien extends MovableFighting {

    private AlienTypes alienType;

    public Alien(Point position, AlienTypes alienType) {
        super(position, 1);

        this.alienType = alienType;
    }

    @Override
    protected void fight(MovableFighting mov) {
        Drone drone = (Drone)mov;
        if (Randomizer.randomSuccessFraction(alienType.getAttackChance(), 6)) drone.decreaseHealth();
    }

    public AlienTypes getAlienType() {
        return alienType;
    }

    public void setAlienType(AlienTypes alienType) {
        this.alienType = alienType;
    }



}
