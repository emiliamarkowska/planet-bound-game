package logic.data.shipmodels.systems;

public class FuelSystem extends System {
    private int fuel;

    public FuelSystem(boolean isMining) {
        super(isMining);
        if(isMining) this.maxAmount =45;
        else this.maxAmount = 27;
        this.fuel = this.maxAmount;
    }

    public void subtractFuel(int amount) {
        if (fuel - amount <= 0) return;
        fuel -= amount;
    }

    public void addFuel(int amount){
        if(this.fuel + amount > this.maxAmount) {
            this.fuel = maxAmount;
            return;
        }
        this.fuel += amount;
    }

    public int getFuel() {
        return this.fuel;
    }
}
