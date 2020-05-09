package logic.data.planetmodels;

import logic.data.Resource;
import logic.data.exceptions.InsufficientResourcesException;
import logic.data.exceptions.MaximumCapacityReachedException;
import logic.data.exceptions.NoOfficerException;
import logic.data.exceptions.SystemUnavailableException;
import logic.data.shipmodels.Ship;

public interface ISpaceStation {

    void upgradeCargo() throws NoOfficerException, SystemUnavailableException, MaximumCapacityReachedException, InsufficientResourcesException;
    void convertResource(Resource from, Resource to) throws NoOfficerException, SystemUnavailableException, InsufficientResourcesException;
    void hireCrew() throws InsufficientResourcesException;
    void upgradeWeaponSystem() throws NoOfficerException, InsufficientResourcesException;
    void replenishArmor() throws NoOfficerException,  InsufficientResourcesException;
    void buyNewDrone() throws NoOfficerException, InsufficientResourcesException;

}
