package logic.data.planetmodels;

import logic.Point;
import logic.data.exceptions.InsufficientResourcesException;
import logic.data.exceptions.NoOfficerException;
import logic.data.movables.Drone;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;
import logic.data.shipmodels.UsableResourceType;

public class SpaceStation{

    private Ship shipOnStation;

    public SpaceStation(Ship shipOnStation){
        this.shipOnStation = shipOnStation;
    }

    public void upgradeCargo() {
       if(!shipOnStation.isOfficerAvailable("CargoOfficer")) return;
       shipOnStation.getCargoSystem().payAllResources(1);
       shipOnStation.getCargoSystem().upgradeCargoSystem();
    }


    public void convertResource(ResourceType toBeLost, ResourceType toBeGained) {
        shipOnStation.getCargoSystem().payResource(1, toBeLost);
        shipOnStation.getCargoSystem().addResource(1, toBeGained);
    }

    public void hireCrew(){
        shipOnStation.getCargoSystem().payAllResources(1);
        shipOnStation.hireOneCrewMember();
    }


    public void upgradeWeaponSystem() {
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
