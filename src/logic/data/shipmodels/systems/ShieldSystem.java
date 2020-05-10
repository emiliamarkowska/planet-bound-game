package logic.data.shipmodels.systems;

public class ShieldSystem extends System {
    private int shields;

    public ShieldSystem(boolean isMining) {
        super(isMining);
        if(isMining) this.maxAmount = 18;
        else this.maxAmount = 9;
        this.shields = this.maxAmount;

    }

    public void loseShield(int amount){
        shields -= amount;
    }

    public void addShield(int amount) {
        shields += amount;
    }

    public void fillShield() {
        this.shields = this.maxAmount;
    }

    public int getShields() {
        return this.shields;
    }
}
