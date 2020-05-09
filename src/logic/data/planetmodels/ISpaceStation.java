package logic.data.planetmodels;

import logic.data.Resource;
import logic.data.shipmodels.Ship;

public interface ISpaceStation {

    void upgradeCargo();
    void convertResource(Resource from, Resource to);
    void hireCrew();
    void upgradeWeaponSystem();
    void replenishArmor();
    void buyNewDrone();

}
