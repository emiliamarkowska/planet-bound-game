package logic.states;

import logic.PlanetBoundData;
import logic.data.exceptions.CrewFullException;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.exceptions.SystemDisabledException;
import logic.data.exceptions.UpgradeMaxException;
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
    public IState upgradeCargo() throws SystemDisabledException, UpgradeMaxException, NotEnoughResourcesException {
        spaceStation.upgradeCargo();
        return this;
    }

    @Override
    public IState exchangeResource(ResourceType from, ResourceType to) throws NotEnoughResourcesException {
        spaceStation.convertResource(from, to);
        return this;
    }

    @Override
    public IState addCrewMember() throws NotEnoughResourcesException, CrewFullException {
        spaceStation.hireCrew();
        return this;
    }

    @Override
    public IState upgradeWeapon() throws NotEnoughResourcesException, UpgradeMaxException {
        spaceStation.upgradeWeaponSystem();
        return this;
    }

    @Override
    public IState repairShip() throws NotEnoughResourcesException {
        spaceStation.fillShield();
        return this;
    }

    @Override
    public IState repairDrone() throws NotEnoughResourcesException {
        spaceStation.buyNewDrone();
        return this;
    }

    @Override
    public IState convertToShipResources(UsableResourceType type, int amount) throws NotEnoughResourcesException {
        spaceStation.convertToShipResources(type, amount);
        return this;
    }

    @Override
    public IState exploreSpace() {
        return prevState;
    }
}
