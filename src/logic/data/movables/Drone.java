package logic.data.movables;

import logic.Point;
import logic.Randomizer;

import java.awt.geom.Point2D;

public class Drone extends MovableFighting{

    public Drone(Point position) {
        super(position, 6);

    }

    @Override
    protected void fight(MovableFighting mov) {
        Alien alien = (Alien)mov;
        if (Randomizer.randomSuccessFraction(alien.getAlienType().getDeathChance(), 6)) alien.decreaseHealth();
    }


}
