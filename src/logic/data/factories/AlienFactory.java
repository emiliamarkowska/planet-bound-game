package logic.data.factories;

import logic.Point;
import logic.Randomizer;
import logic.data.movables.Alien;
import logic.data.movables.AlienTypes;

import java.awt.geom.Point2D;

public class AlienFactory {

    public static Alien createAlien(AlienTypes alienType, int x, int y) {
        return new Alien(new Point(x, y), alienType);
    }

    public static Alien createRandomAlien(int x, int y) {
        return new Alien(new Point(x, y), AlienTypes.getRandomAlienType());
    }

    public static Alien createAlienWithRandomCoordinates(AlienTypes alienType) {
        int x = Randomizer.randomInt(1, 6);
        int y = Randomizer.randomInt(1, 6);

        return new Alien(new Point(x, y), alienType);
    }
}
