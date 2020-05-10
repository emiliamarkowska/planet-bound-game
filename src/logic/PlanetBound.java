package logic;

import logic.data.movables.Resource;
import logic.states.IState;
import logic.states.AwaitShipSelectionState;

public class PlanetBound {

    private IState state;
    private PlanetBoundData planetBoundData;

    public PlanetBound() {
        planetBoundData = new PlanetBoundData();
        state = new AwaitShipSelectionState(planetBoundData);

    }

    public IState getState() {
        return this.state;
    }

    public void setState(IState state) {
        this.state = state;
    }

    public void chooseShip(boolean isMilitary) {
        this.setState(this.state.chooseShip(isMilitary));
    }

    public boolean isSpaceStationAvailable() {
        return planetBoundData.getPlanet().hasSpaceStation();
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
        this.setState(this.state.addCrewMember());
    }

    public void upgradeWeaponSystem() {
        this.setState(this.state.upgradeWeapon());
    }

    public void replenishArmor() {
        this.setState(this.state.repairShip());
    }

    public void buyNewDrone() {
        this.setState(this.state.repairDrone());
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
        this.setState(this.state.lookForAnotherPlanet());
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


    public PlanetBoundData getPlanetBoundData() {
        return planetBoundData;
    }


}
