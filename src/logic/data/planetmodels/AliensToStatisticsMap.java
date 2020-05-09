package logic.data.planetmodels;

import java.util.ArrayList;
import java.util.HashMap;

public class AliensToStatisticsMap {
    private static HashMap<AlienType, AttackDeathStatistic> alienTypeAttackDeathStatisticHashMap;
    static {
        alienTypeAttackDeathStatisticHashMap = new HashMap<>();

        // BLACK ALIEN
        ArrayList<Integer> blackAlienAttacks = new ArrayList<>();
        blackAlienAttacks.add(1);
        ArrayList<Integer> blackAlienDeaths = new ArrayList<>();
        blackAlienDeaths.add(5);
        blackAlienDeaths.add(6);
        AttackDeathStatistic blackAttackDeathStatistic = new AttackDeathStatistic(blackAlienAttacks, blackAlienDeaths);
        alienTypeAttackDeathStatisticHashMap.put(AlienType.BLACK, blackAttackDeathStatistic);

        // GREEN ALIEN
        ArrayList<Integer> greenAlienAttacks = new ArrayList<>();
        greenAlienAttacks.add(1);
        greenAlienAttacks.add(2);
        ArrayList<Integer> greenAlienDeaths = new ArrayList<>();
        greenAlienDeaths.add(4);
        greenAlienDeaths.add(5);
        greenAlienDeaths.add(6);
        AttackDeathStatistic greenAttackDeathStatistic = new AttackDeathStatistic(greenAlienAttacks, greenAlienDeaths);
        alienTypeAttackDeathStatisticHashMap.put(AlienType.GREEN, greenAttackDeathStatistic);

        // BLUE ALIEN
        ArrayList<Integer> blueAlienAttacks = new ArrayList<>();
        blueAlienAttacks.add(3);
        blueAlienAttacks.add(4);
        blueAlienAttacks.add(5);
        ArrayList<Integer> blueAlienDeaths = new ArrayList<>();
        blueAlienDeaths.add(3);
        blueAlienDeaths.add(4);
        blueAlienDeaths.add(5);
        AttackDeathStatistic blueAttackDeathStatistic = new AttackDeathStatistic(blueAlienAttacks, blueAlienDeaths);
        alienTypeAttackDeathStatisticHashMap.put(AlienType.BLUE, blueAttackDeathStatistic);

        // RED ALIEN
        ArrayList<Integer> redAlienAttacks = new ArrayList<>();
        redAlienAttacks.add(5);
        redAlienAttacks.add(6);
        ArrayList<Integer> redAlienDeaths = new ArrayList<>();
        redAlienDeaths.add(1);
        redAlienDeaths.add(2);
        AttackDeathStatistic redAttackDeathStatistic = new AttackDeathStatistic(redAlienAttacks, redAlienDeaths);
        alienTypeAttackDeathStatisticHashMap.put(AlienType.RED, redAttackDeathStatistic);
    }

    public static HashMap<AlienType, AttackDeathStatistic> getalienTypeAttackDeathStatisticHashMap(){
        return alienTypeAttackDeathStatisticHashMap;
    }

    public static AttackDeathStatistic getStatisticsForAlienType(AlienType alienType){
        return alienTypeAttackDeathStatisticHashMap.get(alienType);
    }
}
