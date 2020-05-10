package logic.data.shipmodels.systems;

public class WeaponSystem extends System {
    private int ammo;

    public WeaponSystem(boolean isMining) {
        super(isMining);
        this.maxAmount = 9;
        this.ammo = this.maxAmount;
    }

    public void addAmmo(int amount){
        ammo += amount;
    }

    public void loseAmmo(int amount) {
        amount -= amount;
    }

    public void upgradeWeaponSystem() {
        if (!isMiningShip && this.maxAmount == 18) return;
        if (isMiningShip) return;
        this.maxAmount += 9;
        this.ammo = this.maxAmount;
    }

    public int getAmmo() {
        return this.ammo;
    }

}
