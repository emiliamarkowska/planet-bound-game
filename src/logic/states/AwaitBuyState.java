package logic.states;

import logic.PlanetBoundData;
import logic.data.exceptions.*;
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
    public IState upgradeCargo() throws SystemDisabledException, UpgradeMaxException, NotEnoughResourcesException, OfficerUnavailableException {
        spaceStation.upgradeCargo();
        return this;
    }

    @Override
    public IState exchangeResource(ResourceType from, ResourceType to) throws NotEnoughResourcesException, SystemDisabledException, OfficerUnavailableException {
        spaceStation.convertResource(from, to);
        return this;
    }

    @Override
    public IState addCrewMember() throws NotEnoughResourcesException, CrewFullException {
        spaceStation.hireCrew();
        return this;
    }

    @Override
    public IState upgradeWeapon() throws NotEnoughResourcesException, UpgradeMaxException, OfficerUnavailableException {
        spaceStation.upgradeWeaponSystem();
        return this;
    }

    @Override
    public IState repairShip() throws NotEnoughResourcesException, OfficerUnavailableException {
        spaceStation.fillShield();
        return this;
    }

    @Override
    public IState repairDrone() throws NotEnoughResourcesException, OfficerUnavailableException {
        spaceStation.buyNewDrone();
        return this;
    }

    @Override
    public IState convertToShipResources(UsableResourceType type, int amount) throws NotEnoughResourcesException, SystemDisabledException, OfficerUnavailableException {
        spaceStation.convertToShipResources(type, amount);
        return this;
    }

    @Override
    public IState exploreSpace() {
        return prevState;
    }
}
