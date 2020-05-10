package logic.data.shipmodels.officers;

import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.WeaponSystem;

public class WeaponOfficer extends Officer {
    private WeaponSystem weaponSystem;
    public WeaponOfficer(WeaponSystem weaponSystem){
        this.positionInShip = 4;
        this.weaponSystem = weaponSystem;
    }

    @Override
    public void disableSystem(){
        this.weaponSystem.setAvailable(false);
    }

    @Override
    public void enableSystem(){
        this.weaponSystem.setAvailable(true);
    }
}
