package logic.data.planetmodels;

import logic.data.LogRecorder;

public class Alien {

    private AlienType alienType;
    private AttackDeathStatistic attackDeathStatistic;

    private boolean isDestroyed;

    private int x;
    private int y;

    public Alien(AlienType alienType, int x, int y) {
        this.alienType = alienType;
        this.attackDeathStatistic = AliensToStatisticsMap.getStatisticsForAlienType(alienType);

        this.x = x;
        this.y = y;

        isDestroyed = false;
    }

    public void destroy() {
        isDestroyed = true;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public AlienType getAlienType() {
        return alienType;
    }

    public void setAlienType(AlienType alienType) {
        this.alienType = alienType;
    }

    public AttackDeathStatistic getAttackDeathStatistic() {
        return attackDeathStatistic;
    }

    public void setAttackDeathStatistic(AttackDeathStatistic attackDeathStatistic) {
        this.attackDeathStatistic = attackDeathStatistic;
    }

    public boolean isAlienDead(int thrownValue, LogRecorder logRecorder){
        String deathStats = "";
        for (int stats : getAttackDeathStatistic().getDeaths())
            deathStats += " " + stats;


        if(getAttackDeathStatistic().getDeaths().contains(thrownValue)) {
            logRecorder.addLog("Drone KILLS the alien throwing " + thrownValue + ". [required " + deathStats + "]");
            return true;
        }
        logRecorder.addLog("Drone MISSES the alien throwing " + thrownValue + ". [required " + deathStats + "]");
        return false;
    }

    public boolean isDroneAttacked(int thrownValue, LogRecorder logRecorder){
        String attackStats = "";
        for (int stats : getAttackDeathStatistic().getAttacks())
            attackStats += " " + stats;

        if(getAttackDeathStatistic().getAttacks().contains(thrownValue)) {
            logRecorder.addLog("Alien ATTACKS the drone throwing " + thrownValue + ". [required " + attackStats + "]");
            return true;
        }
        logRecorder.addLog("Alien MISSES the drone throwing " + thrownValue + ". [required " + attackStats + "]");
        return false;
    }

}
