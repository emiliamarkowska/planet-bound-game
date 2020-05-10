package logic.states;

import logic.PlanetBoundData;
import logic.data.movables.Resource;
import logic.data.planetmodels.SpaceStation;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.UsableResourceType;

public class AwaitBuyState extends StateAdapter {
    private final SpaceStation spaceStation;
    private IState prevState;

    public AwaitBuyState(PlanetBoundData planetBoundData, AwaitMoveState prevState) {
        super(planetBoundData);

        this.prevState = prevState;
        this.spaceStation = planetBoundData.getSpaceStation();
    }

    @Override
    public IState upgradeCargo() {
        spaceStation.upgradeCargo();
        return this;
    }

    @Override
    public IState exchangeResource(ResourceType from, ResourceType to) {
        spaceStation.convertResource(from, to);
        return this;
    }

    @Override
    public IState addCrewMember() {
        spaceStation.hireCrew();
        return this;
    }

    @Override
    public IState upgradeWeapon() {
        spaceStation.upgradeWeaponSystem();
        return this;
    }

    @Override
    public IState repairShip() {
        spaceStation.fillShield();
        return this;
    }

    @Override
    public IState repairDrone() {
        spaceStation.buyNewDrone();
        return this;
    }

    @Override
    public IState convertToShipResources(UsableResourceType type, int amount) {
        spaceStation.convertToShipResources(type, amount);
        return this;
    }

    @Override
    public IState exploreSpace() {
        return prevState;
    }
}
