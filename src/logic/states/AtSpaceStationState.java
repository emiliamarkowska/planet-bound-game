package logic.states;

import logic.GameData;
import logic.data.Resource;
import logic.data.exceptions.GameException;
import logic.data.exceptions.NoOfficerException;
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
    public IState hireCrew() {
        try {
            spaceStation.hireCrew();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState upgradeWeaponSystem() {
        try {
            spaceStation.upgradeWeaponSystem();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState replenishArmor() {
        try {
            spaceStation.replenishArmor();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }

    @Override
    public IState buyNewDrone() {
        try {
            spaceStation.buyNewDrone();
        } catch (GameException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
        }
        return goToSpaceTravel();
    }
}
