package logic.data.planetmodels;

import logic.Logs;
import logic.data.exceptions.*;
import logic.data.geometry.Point;
import logic.data.movables.Drone;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;
import logic.data.shipmodels.UsableResourceType;

public class SpaceStation{

    private Ship shipOnStation;
    private Logs logs;

    public SpaceStation(Ship shipOnStation, Logs logs){
        this.shipOnStation = shipOnStation;
        this.logs = logs;
    }

    public void upgradeCargo() throws NotEnoughResourcesException, SystemDisabledException, UpgradeMaxException, OfficerUnavailableException {
            isNavigationOfficerAvailable();
           shipOnStation.getCargoSystem().upgradeCargoSystem();
           shipOnStation.getCargoSystem().payAllResources(1);
    }


    public void convertResource(ResourceType toBeLost, ResourceType toBeGained) throws NotEnoughResourcesException, SystemDisabledException, OfficerUnavailableException {
        isNavigationOfficerAvailable();
        String message = "Can't convert - cargo system is disabled";
        if (!shipOnStation.getCargoSystem().isEnabled()) throw new SystemDisabledException(message);

        shipOnStation.getCargoSystem().payResource(1, toBeLost);
        shipOnStation.getCargoSystem().addResource(1, toBeGained);
    }

    public void hireCrew() throws NotEnoughResourcesException, CrewFullException {
        shipOnStation.getCargoSystem().payAllResources(1);
        shipOnStation.hireOneCrewMember();
    }


    public void upgradeWeaponSystem() throws NotEnoughResourcesException, UpgradeMaxException, OfficerUnavailableException {
        isNavigationOfficerAvailable();
        shipOnStation.getCargoSystem().payAllResources(3);
        shipOnStation.getWeaponSystem().upgradeWeaponSystem();
    }

    public void fillShield() throws NotEnoughResourcesException, OfficerUnavailableException {
        isNavigationOfficerAvailable();
        shipOnStation.getCargoSystem().payAllResources(1);
        shipOnStation.getShieldSystem().fillShield();
    }

    public void buyNewDrone() throws NotEnoughResourcesException, OfficerUnavailableException {
        isNavigationOfficerAvailable();
        shipOnStation.getCargoSystem().payAllResources(3);
        shipOnStation.setDrone(new Drone(new Point(0,0), logs));
    }

    public void convertToShipResources(UsableResourceType type, int amount) throws NotEnoughResourcesException, SystemDisabledException, OfficerUnavailableException {
        isNavigationOfficerAvailable();
        String message = "Can't convert - cargo system is disabled";
        if (!shipOnStation.getCargoSystem().isEnabled()) throw new SystemDisabledException(message);

        switch(type) {
            case AMMO:
                shipOnStation.getCargoSystem().payResource(1, ResourceType.BLACK);
                shipOnStation.getCargoSystem().payResource(1, ResourceType.BLUE);
                shipOnStation.getWeaponSystem().addAmmo(1);
                break;
            case SHIELD:
                shipOnStation.getCargoSystem().payResource(1, ResourceType.BLACK);
                shipOnStation.getCargoSystem().payResource(1, ResourceType.BLUE);
                shipOnStation.getCargoSystem().payResource(1, ResourceType.GREEN);
                shipOnStation.getShieldSystem().addShield(1);
                break;
            case FUEL:
                shipOnStation.getCargoSystem().payResource(1, ResourceType.BLACK);
                shipOnStation.getCargoSystem().payResource(1, ResourceType.RED);
                shipOnStation.getCargoSystem().payResource(1, ResourceType.GREEN);
                shipOnStation.getFuelSystem().addFuel(1);
                break;
        }
    }

    private void isNavigationOfficerAvailable() throws OfficerUnavailableException {
        String message = "Navigation Officer unavailable - the only action you can perform is hiring new Officer.";
        if(!shipOnStation.isOfficerAvailable("NavigationOfficer")) throw new OfficerUnavailableException(message);
    }

}
