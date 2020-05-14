package logic;

import logic.data.exceptions.CrewFullException;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.exceptions.SystemDisabledException;
import logic.data.exceptions.UpgradeMaxException;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.UsableResourceType;
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

    private void setState(IState state) {
        this.state = state;
    }

    public PlanetBoundData getPlanetBoundData() {
        return planetBoundData;
    }

    //AVAILABLE FROM AwaitShipSelectionState

    public void chooseShip(boolean isMiningShip) {
        this.setState(this.state.chooseShip(isMiningShip));
    }

    //AVAILABLE FROM AwaitMoveState

    public void exploreSpaceStation() {
        this.setState(this.state.exploreSpaceStation());
    }

    public void explorePlanet() {
        this.setState(this.state.explorePlanet());
    }

    public void lookForAnotherPlanet() {
        this.setState(this.state.lookForAnotherPlanet());
    }

    //AVAILABLE FROM AwaitBuyState

    public void upgradeCargo() {
        try{
            this.setState(this.state.upgradeCargo());
        } catch (UpgradeMaxException e) {
            Logs.putLog(e.getMessage());
        } catch (NotEnoughResourcesException e) {
            Logs.putLog(e.getMessage());
        } catch (SystemDisabledException e) {
            Logs.putLog(e.getMessage());
        }
    }

    public void exchangeResource(ResourceType from, ResourceType to) throws NotEnoughResourcesException {
        try{
            this.setState(this.state.exchangeResource(from, to));
        } catch (NotEnoughResourcesException e) {
            Logs.putLog(e.getMessage());
        }
    }

    public void addCrewMember() throws NotEnoughResourcesException, CrewFullException {
        try{
            this.setState(this.state.addCrewMember());
        } catch (NotEnoughResourcesException e) {
            Logs.putLog(e.getMessage());
        } catch (CrewFullException e) {
            Logs.putLog(e.getMessage());
        }
    }

    public void upgradeWeapon() {
        this.setState(this.state.upgradeWeapon());
    }

    public void repairShip() {
        this.setState(this.state.repairShip());
    }

    public void repairDrone() {
        this.setState(this.state.repairDrone());
    }

    public void convertToShipResources(UsableResourceType type, int amount) {
        this.setState(this.state.convertToShipResources(type, amount));
    }

    //AVAILABLE FROM AwaitFinishExplorationState

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

    //AVAILABLE FROM AwaitBuyState, AwaitFinishExplorationState

    public void exploreSpace() {
        this.setState(this.state.exploreSpace());
    }

    //AVAILABLE FROM GameOverState

    public void restartGame() {
        this.setState(this.state.restartGame());
    }


}
