package logic.states;

import logic.GameData;
import logic.data.Resource;
import logic.data.planetmodels.SpaceStation;

public class AtSpaceStationState extends StateAdapter {
    private final SpaceStation spaceStation;

    public AtSpaceStationState(GameData gameData) {
        super(gameData);

        spaceStation = gameData.getPlanet().getSpaceStation();
    }

    @Override
    public IState goToSpaceTravel(){
        return new SpaceTravelState(getGameData());
    }

    @Override
    public IState upgradeCargo() {
        spaceStation.upgradeCargo();
        return goToSpaceTravel();
    }

    @Override
    public IState convertResource(Resource from, Resource to) {
        spaceStation.convertResource(from, to);
        return goToSpaceTravel();
    }

    @Override
    public IState hireCrew() {
        spaceStation.hireCrew();
        return goToSpaceTravel();
    }

    @Override
    public IState upgradeWeaponSystem() {
        spaceStation.upgradeWeaponSystem();
        return goToSpaceTravel();
    }

    @Override
    public IState replenishArmor() {
        spaceStation.replenishArmor();
        return goToSpaceTravel();
    }

    @Override
    public IState buyNewDrone() {
        spaceStation.buyNewDrone();
        return goToSpaceTravel();
    }
}
