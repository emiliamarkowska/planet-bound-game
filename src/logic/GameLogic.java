package logic;

import logic.data.movables.Resource;
import logic.states.IState;
import logic.states.ShipSelectionState;

public class GameLogic {

    private IState state;

    private GameData gameData;

    public GameLogic() {
        gameData = new GameData();
        state = new ShipSelectionState(gameData);

    }

    public IState getState() {
        return this.state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void chooseShip(boolean isMilitary) {
        this.setState(this.state.selectShip(isMilitary));
    }

    public boolean isSpaceStationAvailable() {
        return gameData.getPlanet().hasSpaceStation();
    }

    public void goToSpaceStation() {
        this.setState(this.state.goToSpaceStation());
    }

    public void upgradeCargo() {
        this.setState(this.state.upgradeCargo());
    }

    public void convertResource(Resource from, Resource to) {
        this.setState(this.state.convertResource(from, to));
    }

    public void hireCrew() {
        this.setState(this.state.hireCrew());
    }

    public void upgradeWeaponSystem() {
        this.setState(this.state.upgradeWeaponSystem());
    }

    public void replenishArmor() {
        this.setState(this.state.replenishArmor());
    }

    public void buyNewDrone() {
        this.setState(this.state.buyNewDrone());
    }

    public void goUp() {
        this.setState(this.state.goUp());
    }

    public void goDown() {
        this.setState(this.state.goDown());
    }

    public void goLeft() {
        this.setState(this.state.goLeft());
    }

    public void goRight() {
        this.setState(this.state.goRight());
    }

    public void acceptReturn() {
        this.setState(this.state.acceptReturn());
    }

    public void declineReturn() {
        this.setState(this.state.declineReturn());
    }

    public void goToNextRegion() {
        this.setState(this.state.goToNextRegion());
    }

    public void explorePlanet() {
        this.setState(this.state.goToPlanet());
    }

    public void playAgain() {
        this.setState(this.state.playAgain());
    }

    public void produceAmmo(int amount) {
        this.setState(this.state.produce("ammo", amount));
    }

    public void produceShield(int amount) {
        this.setState(this.state.produce("shield", amount));
    }

    public void produceFuel(int amount) {
        this.setState(this.state.produce("fuel", amount));
    }


    public GameData getGameData() {
        return gameData;
    }


}
