package logic.data.shipmodels;

public class WeaponSystem implements ShipSystem {
    private boolean isAvailable;
    private boolean isMilitary;
    private int maxWeapons;
    private int weapons;

    public WeaponSystem(boolean isMilitary) {
        this.isMilitary = isMilitary;
        isAvailable = true;
        maxWeapons = 9;
        weapons = 9;
    }

    public void upgradeWeaponSystem() {
        if (isMilitary && maxWeapons == 18) return;
        if (!isMilitary) return;

        maxWeapons *= 2;
        weapons = maxWeapons;
    }

    public int getMaxWeapons() {
        return maxWeapons;
    }

    public int getWeapons() {
        return weapons;
    }

    public void addAmmo(int amount){
        weapons += amount;
    }

    public void spendAmmo(int amount) {
        weapons -= amount;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
