package logic.data.planetmodels;

import logic.Dice;

import java.util.concurrent.ThreadLocalRandom;

public class AlienFactory {

    public static Alien createAlien(AlienType alienType, int x, int y) {
        return new Alien(alienType, x, y);
    }

    public static Alien createRandomAlien(int x, int y) {
        return new Alien(AlienType.randomAlienType(), x, y);
    }

    public static Alien createAlienWithRandomCoordinates(AlienType alienType) {
        int x = Dice.throwd6();
        int y = Dice.throwd6();

        return new Alien(alienType, x, y);
    }

    public static Alien createRandomAlienWithRandomCoordinates(){
        return createAlienWithRandomCoordinates(AlienType.randomAlienType());
    }


}
