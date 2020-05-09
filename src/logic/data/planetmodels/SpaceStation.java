package logic.data.planetmodels;

import logic.data.Resource;
import logic.data.exceptions.InsufficientResourcesException;
import logic.data.exceptions.MaximumCapacityReachedException;
import logic.data.exceptions.NoOfficerException;
import logic.data.exceptions.SystemUnavailableException;
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
    public void upgradeCargo() throws NoOfficerException, SystemUnavailableException, MaximumCapacityReachedException, InsufficientResourcesException {
        checkForNavigationOfficer();
        if(!dockedShip.getCargoSystem().isAvailable()) throw new SystemUnavailableException("Action unavailable because Cargo system is inactive");
        try {
            dockedShip.getCargoSystem().upgradeCargoSystem();

            dockedShip.getCargoSystem().payAllResources(1);
            isAlreadyVisited = true;
        } catch (MaximumCapacityReachedException e) {
            throw new MaximumCapacityReachedException(e.getMessage());
        } catch (InsufficientResourcesException e) {
            throw new InsufficientResourcesException(e.getMessage());
        }
    }

    public void dockShip(Ship dockedShip) {
        this.dockedShip = dockedShip;
    }

    @Override
    public void convertResource(Resource from, Resource to) throws NoOfficerException, SystemUnavailableException, InsufficientResourcesException {
        checkForNavigationOfficer();
        if(!dockedShip.getCargoSystem().isAvailable()) throw new SystemUnavailableException("Action unavailable because Cargo system is inactive");
        try {
            switch (from.getResourceType()) {
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
        } catch (InsufficientResourcesException e) {
            throw new InsufficientResourcesException(e.getMessage());
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
    public void hireCrew() throws InsufficientResourcesException {
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
        } catch (InsufficientResourcesException e) {
            throw new InsufficientResourcesException(e.getMessage());
        }
    }

    @Override
    public void upgradeWeaponSystem() throws NoOfficerException, InsufficientResourcesException {
        checkForNavigationOfficer();
        try {
            dockedShip.getWeaponSystem().upgradeWeaponSystem();

            dockedShip.getCargoSystem().payAllResources(2);
            isAlreadyVisited = true;
        } catch (InsufficientResourcesException e) {
            throw new InsufficientResourcesException(e.getMessage());
        }
    }

    @Override
    public void replenishArmor() throws NoOfficerException, InsufficientResourcesException {
        checkForNavigationOfficer();
        try {
            dockedShip.getShieldSystem().replenishArmor();

            dockedShip.getCargoSystem().payAllResources(1);
            isAlreadyVisited = true;

        } catch (InsufficientResourcesException e) {
            throw new InsufficientResourcesException(e.getMessage());
        }
    }

    @Override
    public void buyNewDrone() throws NoOfficerException, InsufficientResourcesException {
        checkForNavigationOfficer();
        try {
            dockedShip.getDrone().repairDrone();

            dockedShip.getCargoSystem().payAllResources(3);
            isAlreadyVisited = true;

        } catch (InsufficientResourcesException e) {
            throw new InsufficientResourcesException(e.getMessage());
        }
    }

    private void checkForNavigationOfficer() throws NoOfficerException {
        if(!dockedShip.isNavigationOfficerAvailable()) throw new NoOfficerException("Action unavailable because you have no Navigation Officer");
    }
}
