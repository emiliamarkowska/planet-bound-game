package logic.states;

import logic.GameData;
import logic.data.movables.Resource;

public class StateAdapter implements IState {

    private GameData gameData;

    public StateAdapter(GameData gameData) {
        this.gameData = gameData;
    }

    public GameData getGameData() {
        return gameData;
    }

    @Override
    public IState selectShip(boolean isMilitary) {
        return this;
    }

    @Override
    public IState goToSpaceStation() {
        return this;
    }

    @Override
    public IState goToSpaceTravel() {
        return this;
    }

    @Override
    public IState goToPlanet() {
        return this;
    }

    @Override
    public IState gameStatusCheck(int artifactNumber, int fuelAmount, int crewMembersAmount) {
        return this;
    }

    @Override
    public IState repeat() {
        return this;
    }

    @Override
    public IState playAgain() {
        return this;
    }

    @Override
    public IState upgradeCargo() {
        return this;
    }

    @Override
    public IState convertResource(Resource from, Resource to) {
        return this;
    }

    @Override
    public IState hireCrew() {
        return this;
    }

    @Override
    public IState upgradeWeaponSystem() {
        return this;
    }

    @Override
    public IState replenishArmor() {
        return this;
    }

    @Override
    public IState buyNewDrone() {
        return this;
    }

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

    @Override
    public IState acceptReturn() {
        return this;
    }

    @Override
    public IState declineReturn() {
        return this;
    }

    @Override
    public IState goToNextRegion() {
        return this;
    }

    @Override
    public IState produce(String type, int amount) {
        return this;
    }

}
