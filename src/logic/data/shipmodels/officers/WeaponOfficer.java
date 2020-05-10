package logic.data.shipmodels.officers;

import logic.Logs;
import logic.data.shipmodels.systems.WeaponSystem;

public class WeaponOfficer extends Officer {
    private WeaponSystem weaponSystem;
    public WeaponOfficer(WeaponSystem weaponSystem){
        this.positionInShip = 4;
        this.weaponSystem = weaponSystem;
    }

    @Override
    public void disableSystem(){
        this.weaponSystem.setEnabled(false);
        Logs.putLog("Weapon system disabled");
    }

    @Override
    public void enableSystem(){
        this.weaponSystem.setEnabled(true);
        Logs.putLog("Weapon system enabled");
    }
}
