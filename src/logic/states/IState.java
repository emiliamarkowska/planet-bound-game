package logic.states;

import logic.data.exceptions.CrewFullException;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.exceptions.SystemDisabledException;
import logic.data.exceptions.UpgradeMaxException;
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
    IState repairShip();
    IState repairDrone();
    IState convertToShipResources(UsableResourceType type, int amount) throws NotEnoughResourcesException;

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
