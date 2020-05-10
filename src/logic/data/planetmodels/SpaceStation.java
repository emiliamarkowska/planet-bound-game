package logic.data.planetmodels;

import logic.Point;
import logic.data.exceptions.InsufficientResourcesException;
import logic.data.exceptions.NoOfficerException;
import logic.data.movables.Drone;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;

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

}
