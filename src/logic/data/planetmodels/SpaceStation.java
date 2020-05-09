package logic.data.planetmodels;

import logic.data.Resource;
import logic.data.shipmodels.Ship;

public class SpaceStation implements ISpaceStation {

    private Ship dockedShip;
    private boolean isAlreadyVisited;

    SpaceStation() {
        isAlreadyVisited = false;
    }

    public boolean isAlreadyVisited() {
        return isAlreadyVisited;
    }

    @Override
    public void upgradeCargo() {
        //TODO exception
        if(!dockedShip.isNavigationOfficerAvailable()) return;
        if(!dockedShip.getCargoSystem().isAvailable()) return;
        try {
            dockedShip.getCargoSystem().upgradeCargoSystem();

            dockedShip.getCargoSystem().payAllResources(1);
            isAlreadyVisited = true;
        } catch (Exception e) {
            //TODO: handle
        }
    }

    public void dockShip(Ship dockedShip) {
        this.dockedShip = dockedShip;
    }

    @Override
    public void convertResource(Resource from, Resource to) {
        //TODO exception
        if(!dockedShip.isNavigationOfficerAvailable()) return;
        if(!dockedShip.getCargoSystem().isAvailable()) return;
        switch(from.getResourceType()){
            case BLACK:
                dockedShip.getCargoSystem().payBlackResource(1);
                break;
            case BLUE:
                dockedShip.getCargoSystem().payBlueResource(1);
                break;
            case RED:
                dockedShip.getCargoSystem().payRedResource(1);
                break;
            case GREEN:
                dockedShip.getCargoSystem().payGreenResource(1);
                break;
        }

        switch (to.getResourceType()){
            case GREEN:
                dockedShip.getCargoSystem().addGreenResource(1);
                break;
            case RED:
                dockedShip.getCargoSystem().addRedResource(1);
                break;
            case BLUE:
                dockedShip.getCargoSystem().addBlueResource(1);
                break;
            case BLACK:
                dockedShip.getCargoSystem().addBlackResource(1);
                break;
        }
        isAlreadyVisited = true;
    }

    @Override
    public void hireCrew() {
        try {
            dockedShip.hireOneCrewMember();
            dockedShip.getCargoSystem().payAllResources(1);
            isAlreadyVisited = true;
            switch(dockedShip.getCrewAmount()){
                case 4:
                    dockedShip.getShieldSystem().setAvailable(true);
                    break;
                case 5:
                    dockedShip.getWeaponSystem().setAvailable(true);
                    break;
                case 6:
                    dockedShip.getCargoSystem().setAvailable(true);
                    break;
            }
        } catch (Exception e) {
            //TODO: handle
        }
    }

    @Override
    public void upgradeWeaponSystem() {
        if(!dockedShip.isNavigationOfficerAvailable()) return;
        try {
            dockedShip.getWeaponSystem().upgradeWeaponSystem();

            dockedShip.getCargoSystem().payAllResources(2);
            isAlreadyVisited = true;
        } catch (Exception e) {
            //TODO: handle
        }
    }

    @Override
    public void replenishArmor() {
        if(!dockedShip.isNavigationOfficerAvailable()) return;
        try {
            dockedShip.getShieldSystem().replenishArmor();

            dockedShip.getCargoSystem().payAllResources(1);
            isAlreadyVisited = true;

        } catch (Exception e) {
            //TODO: handle
        }
    }

    @Override
    public void buyNewDrone() {
        if(!dockedShip.isNavigationOfficerAvailable()) return;
        try {
            dockedShip.getDrone().repairDrone();

            dockedShip.getCargoSystem().payAllResources(3);
            isAlreadyVisited = true;

        } catch (Exception e) {
            //TODO: handle
        }
    }
}
