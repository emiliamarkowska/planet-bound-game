package logic.data.movables;

import logic.Logs;
import logic.data.geometry.Point;
import logic.Randomizer;

public class Drone extends MovableFighting{

    public Drone(Point position, Logs logs) {
        super(position, 6, logs);

    }

    @Override
    public void fight(MovableFighting mov) {
        Alien alien = (Alien)mov;
        if (Randomizer.randomSuccessFraction(alien.getAlienType().getDeathChance(), 6)){
            logs.putLog("Drone shot - alien killed");
            alien.decreaseHealth();
        }
        else logs.putLog("Drone shot - missed");
    }


}
