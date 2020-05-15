package logic.states;

import logic.data.exceptions.*;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.UsableResourceType;

public interface IState {
    //AVAILABLE FROM AwaitShipSelectionState
    IState chooseShip(boolean isMiningShip);

    //AVAILABLE FROM AwaitMoveState
    IState exploreSpaceStation();
    IState explorePlanet() throws OfficerUnavailableException;
    IState lookForAnotherPlanet();

    //AVAILABLE FROM AwaitBuyState
    IState upgradeCargo() throws SystemDisabledException, UpgradeMaxException, NotEnoughResourcesException, OfficerUnavailableException;
    IState exchangeResource(ResourceType from, ResourceType to) throws NotEnoughResourcesException, SystemDisabledException, OfficerUnavailableException;
    IState addCrewMember() throws NotEnoughResourcesException, CrewFullException;
    IState upgradeWeapon() throws NotEnoughResourcesException, UpgradeMaxException, OfficerUnavailableException;
    IState repairShip() throws NotEnoughResourcesException, OfficerUnavailableException;
    IState repairDrone() throws NotEnoughResourcesException, OfficerUnavailableException;
    IState convertToShipResources(UsableResourceType type, int amount) throws NotEnoughResourcesException, SystemDisabledException, OfficerUnavailableException;

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
