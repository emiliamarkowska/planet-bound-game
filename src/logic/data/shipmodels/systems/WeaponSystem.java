package logic.data.shipmodels.systems;

import logic.Logs;
import logic.data.exceptions.NotEnoughAmmoException;
import logic.data.exceptions.UpgradeMaxException;

public class WeaponSystem extends System {
    private int ammo;
    private Logs logs;

    public WeaponSystem(boolean isMining, Logs logs) {
        super(isMining);
        this.maxAmount = 9;
        this.ammo = this.maxAmount;
        this.logs = logs;
    }

    public void addAmmo(int amount){
        int amountAdded = amount;
        if(maxAmount - ammo < amount) amount = maxAmount - amount;
        ammo += amountAdded;
        logs.putLog(amountAdded + "ammo cells added");
    }

    public void loseAmmo(int amount) throws NotEnoughAmmoException {
        if(!isAmmoEnough(amount)){
            String errorMessage = "Not enough ammo - can't be used.";
            logs.putLog(errorMessage);
            throw new NotEnoughAmmoException(errorMessage);
        }
        ammo -= amount;
        logs.putLog("Ammo in amount of " + amount + " lost");
    }

    public void upgradeWeaponSystem() throws UpgradeMaxException {
        if (!isMiningShip && this.maxAmount == 18) {
            String errorMessage = "Military ship max weapon upgrade reached - can't upgrade";
            logs.putLog(errorMessage);
            throw new UpgradeMaxException(errorMessage);
        }
        if (isMiningShip) {
            String errorMessage = "Mining ship can't have weapon system upgraded.";
            logs.putLog(errorMessage);
            throw new UpgradeMaxException(errorMessage);
        }
        this.maxAmount += 9;
        this.ammo = this.maxAmount;
        logs.putLog("Weapon system upgraded and full");
    }

    public int getAmmo() {
        return this.ammo;
    }

    public boolean isAmmoEnough(int amount){
        return ammo > amount;
    }

}
