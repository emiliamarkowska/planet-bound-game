package logic.data.movables;

import logic.Randomizer;

public enum AlienTypes {
    BLACK_ALIEN(1, 2),
    BLUE_ALIEN(3, 3),
    GREEN_ALIEN(2, 3),
    RED_ALIEN(2, 2);

    private int attackChance;
    private int deathChance;

    AlienTypes(int attackChance, int deathChance) {
        this.attackChance = attackChance;
        this.deathChance = deathChance;
    }

    public int getAttackChance() {
        return this.attackChance;
    }

    public int getDeathChance() {
        return this.deathChance;
    }

    public static AlienTypes getRandomAlienType(){
        int random = Randomizer.randomInt(1,4);
        switch (random){
            case 1:
                return BLACK_ALIEN;
            case 2:
                return BLUE_ALIEN;
            case 3:
                return GREEN_ALIEN;
            case 4:
                return RED_ALIEN;
        }
        return null;
    }
}
