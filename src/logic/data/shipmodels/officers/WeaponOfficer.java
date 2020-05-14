package logic.data.shipmodels.officers;

import logic.Logs;
import logic.data.shipmodels.systems.WeaponSystem;

public class WeaponOfficer extends Officer {
    private WeaponSystem weaponSystem;
    public WeaponOfficer(WeaponSystem weaponSystem, Logs logs){
        super(logs);
        this.positionInShip = 4;
        this.weaponSystem = weaponSystem;
    }

    @Override
    public void disableSystem(){
        this.weaponSystem.setEnabled(false);
        logs.putLog("Weapon system disabled");
    }

    @Override
    public void enableSystem(){
        this.weaponSystem.setEnabled(true);
        logs.putLog("Weapon system enabled");
    }
}
