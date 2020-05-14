package logic.states;

import logic.PlanetBoundData;
import logic.data.exceptions.*;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.UsableResourceType;

public class StateAdapter implements IState {

    private PlanetBoundData planetBoundData;

    public StateAdapter(PlanetBoundData planetBoundData){
        this.planetBoundData = planetBoundData;
    }

    //AVAILABLE FROM AwaitShipSelectionState
    @Override
    public IState chooseShip(boolean isMiningShip) {
        return this;
    }

    //AVAILABLE FROM AwaitMoveState
    @Override
    public IState exploreSpaceStation() {
        return this;
    }

    @Override
    public IState explorePlanet() {
        return this;
    }

    @Override
    public IState lookForAnotherPlanet() {
        return this;
    }

    //AVAILABLE FROM AwaitBuyState
    @Override
    public IState upgradeCargo() throws SystemDisabledException, UpgradeMaxException, NotEnoughResourcesException {
        return this;
    }

    @Override
    public IState exchangeResource(ResourceType from, ResourceType to) throws NotEnoughResourcesException {
        return this;
    }

    @Override
    public IState addCrewMember() throws NotEnoughResourcesException, CrewFullException {
        return this;
    }

    @Override
    public IState upgradeWeapon() throws NotEnoughResourcesException, UpgradeMaxException {
        return this;
    }

    @Override
    public IState repairShip() throws NotEnoughResourcesException {
        return this;
    }

    @Override
    public IState repairDrone() throws NotEnoughResourcesException {
        return this;
    }

    @Override
    public IState convertToShipResources(UsableResourceType type, int amount) throws NotEnoughResourcesException {
        return this;
    }

    //AVAILABLE FROM AwaitFinishExplorationState
    @Override
    public IState goUp() throws NotAllowedMoveException {
        return this;
    }

    @Override
    public IState goDown() throws NotAllowedMoveException {
        return this;
    }

    @Override
    public IState goLeft() throws NotAllowedMoveException {
        return this;
    }

    @Override
    public IState goRight() throws NotAllowedMoveException {
        return this;
    }

    //AVAILABLE FROM AwaitBuyState, AwaitFinishExplorationState
    @Override
    public IState exploreSpace() {
        return this;
    }

    //AVAILABLE FROM GameOverState
    @Override
    public IState restartGame() {
        return this;
    }

    public PlanetBoundData getPlanetBoundData() {
        return planetBoundData;
    }
}
