package logic.data.planetmodels;

import java.util.List;

public class AttackDeathStatistic {
    private List<Integer> attacks;
    private List<Integer> deaths;

    public AttackDeathStatistic(List<Integer> attacks, List<Integer> deaths){
        this.attacks = attacks;
        this.deaths = deaths;
    }

    public List<Integer> getAttacks() {
        return attacks;
    }

    public void setAttacks(List<Integer> attacks) {
        this.attacks = attacks;
    }

    public List<Integer> getDeaths() {
        return deaths;
    }

    public void setDeaths(List<Integer> deaths) {
        this.deaths = deaths;
    }
}
