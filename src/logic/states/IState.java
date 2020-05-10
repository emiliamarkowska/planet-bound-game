package logic.states;

import logic.data.movables.Resource;

public interface IState {
    IState selectShip(boolean isMilitary);
    IState goToSpaceStation();
    IState goToSpaceTravel();
    IState goToPlanet();
    IState gameStatusCheck(int artifactNumber, int fuelAmount, int crewMembersAmount);
    IState repeat();
    IState playAgain();
    IState upgradeCargo();
    IState convertResource(Resource from, Resource to);
    IState hireCrew();
    IState upgradeWeaponSystem();
    IState replenishArmor();
    IState buyNewDrone();
    IState goUp();
    IState goDown();
    IState goLeft();
    IState goRight();
    IState acceptReturn();
    IState declineReturn();
    IState goToNextRegion();
    IState produce(String type, int amount);
}
