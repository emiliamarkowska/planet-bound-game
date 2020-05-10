package logic.states;

import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.UsableResourceType;

public interface IState {
    //AVAILABLE FROM AwaitShipSelectionState
    IState chooseShip(boolean isMiningShip);

    //AVAILABLE FROM AwaitMoveState
    IState exploreSpaceStation();
    IState explorePlanet();
    IState lookForAnotherPlanet();

    //AVAILABLE FROM AwaitBuyState
    IState upgradeCargo();
    IState exchangeResource(ResourceType from, ResourceType to);
    IState addCrewMember();
    IState upgradeWeapon();
    IState repairShip();
    IState repairDrone();
    IState convertToShipResources(UsableResourceType type, int amount);

    //AVAILABLE FROM AwaitFinishExplorationState
    IState goUp();
    IState goDown();
    IState goLeft();
    IState goRight();

    //AVAILABLE FROM AwaitBuyState, AwaitFinishExplorationState
    IState exploreSpace();

    //AVAILABLE FROM GameOverState
    IState restartGame();

}
