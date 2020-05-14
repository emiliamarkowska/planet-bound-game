package logic.data.factories;

import logic.Logs;
import logic.data.geometry.Point;
import logic.Randomizer;
import logic.data.movables.Alien;
import logic.data.movables.AlienTypes;

public class AlienFactory {
    public static Alien createAlien(AlienTypes alienType, Logs logs) {
        int x = Randomizer.randomInt(1, 6);
        int y = Randomizer.randomInt(1, 6);
        logs.putLog("Alien of type " + alienType + " created at (" + x + ", " + y + ")" );
        return new Alien(new Point(x, y), alienType, logs);
    }
}
