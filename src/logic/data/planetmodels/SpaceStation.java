package logic.data.planetmodels;

import logic.data.exceptions.CrewFullException;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.exceptions.SystemDisabledException;
import logic.data.exceptions.UpgradeMaxException;
import logic.data.geometry.Point;
import logic.data.movables.Drone;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;
import logic.data.shipmodels.UsableResourceType;

public class SpaceStation{

    private Ship shipOnStation;

    public SpaceStation(Ship shipOnStation){
        this.shipOnStation = shipOnStation;
    }

    public void upgradeCargo() throws NotEnoughResourcesException, SystemDisabledException, UpgradeMaxException {
        try{
           shipOnStation.getCargoSystem().upgradeCargoSystem();
           shipOnStation.getCargoSystem().payAllResources(1);
        }catch(SystemDisabledException e){

        }

    }


    public void convertResource(ResourceType toBeLost, ResourceType toBeGained) throws NotEnoughResourcesException {
        shipOnStation.getCargoSystem().payResource(1, toBeLost);
        shipOnStation.getCargoSystem().addResource(1, toBeGained);
    }

    public void hireCrew() throws NotEnoughResourcesException, CrewFullException {
        shipOnStation.getCargoSystem().payAllResources(1);
        shipOnStation.hireOneCrewMember();
    }


    public void upgradeWeaponSystem() throws NotEnoughResourcesException, UpgradeMaxException {
        shipOnStation.getCargoSystem().payAllResources(3);
        shipOnStation.getWeaponSystem().upgradeWeaponSystem();
    }

    public void fillShield() {
        //TODO: płatność
        shipOnStation.getShieldSystem().fillShield();
    }

    public void buyNewDrone() {
        //TODO: płatność
        shipOnStation.setDrone(new Drone(new Point(0,0)));
    }

    public void convertToShipResources(UsableResourceType type, int amount) {

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

}
