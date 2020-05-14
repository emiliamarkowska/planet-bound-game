package logic.states;

import logic.data.exceptions.*;
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
    IState upgradeCargo() throws SystemDisabledException, UpgradeMaxException, NotEnoughResourcesException;
    IState exchangeResource(ResourceType from, ResourceType to) throws NotEnoughResourcesException;
    IState addCrewMember() throws NotEnoughResourcesException, CrewFullException;
    IState upgradeWeapon() throws NotEnoughResourcesException, UpgradeMaxException;
    IState repairShip() throws NotEnoughResourcesException;
    IState repairDrone() throws NotEnoughResourcesException;
    IState convertToShipResources(UsableResourceType type, int amount) throws NotEnoughResourcesException;

    //AVAILABLE FROM AwaitFinishExplorationState
    IState goUp() throws NotAllowedMoveException;
    IState goDown() throws NotAllowedMoveException;
    IState goLeft() throws NotAllowedMoveException;
    IState goRight() throws NotAllowedMoveException;

    //AVAILABLE FROM AwaitBuyState, AwaitFinishExplorationState
    IState exploreSpace();

    //AVAILABLE FROM GameOverState
    IState restartGame();

}
