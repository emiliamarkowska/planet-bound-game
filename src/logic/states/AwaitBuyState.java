package logic.states;

import logic.PlanetBoundData;
import logic.data.movables.Resource;
import logic.data.exceptions.GameException;
import logic.data.planetmodels.SpaceStation;

public class AwaitBuyState extends StateAdapter {
    private final SpaceStation spaceStation;

    public AwaitBuyState(PlanetBoundData gameData) {
        super(gameData);

        spaceStation = gameData.getPlanet().getSpaceStation();
    }

    @Override
    public IState goToSpaceTravel(){
        return new AwaitMoveState(getGameData());
    }

    @Override
    public IState upgradeCargo() {
        try {
            spaceStation.upgradeCargo();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState convertResource(Resource from, Resource to) {
        try {
            spaceStation.convertResource(from, to);
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState addCrewMember() {
        try {
            spaceStation.hireCrew();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState upgradeWeapon() {
        try {
            spaceStation.upgradeWeaponSystem();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState fillAmmo() {
        try {
            spaceStation.replenishArmor();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState repairDrone() {
        try {
            spaceStation.buyNewDrone();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }
}
