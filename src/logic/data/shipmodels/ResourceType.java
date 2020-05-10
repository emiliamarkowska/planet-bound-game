package logic.data.shipmodels;

import logic.Randomizer;

public enum ResourceType {
    RED,
    GREEN,
    BLACK,
    BLUE,
    PINK;

    public static ResourceType getRandomResource(){
        int random = Randomizer.randomInt(1, 4);
        switch(random){
            case 1:
                return RED;
            case 2:
                return GREEN;
            case 3:
                return BLACK;
            case 4:
                return BLUE;
        }
        return null;
    }
}
