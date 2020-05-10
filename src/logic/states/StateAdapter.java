package logic.states;

import logic.PlanetBoundData;
import logic.data.shipmodels.ResourceType;

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
    public IState upgradeCargo() {
        return this;
    }

    @Override
    public IState exchangeResource(ResourceType from, ResourceType to) {
        return this;
    }

    @Override
    public IState addCrewMember() {
        return this;
    }

    @Override
    public IState upgradeWeapon() {
        return this;
    }

    @Override
    public IState fillAmmo() {
        return this;
    }

    @Override
    public IState repairDrone() {
        return this;
    }

    @Override
    public IState convertToShipResources(String type, int amount) {
        return this;
    }

    //AVAILABLE FROM AwaitFinishExplorationState
    @Override
    public IState goUp() {
        return this;
    }

    @Override
    public IState goDown() {
        return this;
    }

    @Override
    public IState goLeft() {
        return this;
    }

    @Override
    public IState goRight() {
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
