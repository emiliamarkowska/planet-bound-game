package logic;

import java.util.concurrent.ThreadLocalRandom;

public class Randomizer {

    public static int randomInt(int min, int max){
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static boolean randomSuccess(int successPercentage) {
        return randomInt(1, 100) <= successPercentage;
    }

    public static boolean randomSuccessFraction(int howMany, int outOf) {
        return randomInt(1, outOf) <= howMany;
    }
}
