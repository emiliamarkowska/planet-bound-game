package logic;

import logic.data.exceptions.*;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.UsableResourceType;
import logic.states.IState;
import logic.states.AwaitShipSelectionState;

public class PlanetBound {

    private IState state;
    private PlanetBoundData planetBoundData;
    private Logs logs;

    public PlanetBound() {
        planetBoundData = new PlanetBoundData();
        state = new AwaitShipSelectionState(planetBoundData);
        logs = planetBoundData.getLogs();
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
            logs.putLog(e.getMessage());
        } catch (NotEnoughResourcesException e) {
            logs.putLog(e.getMessage());
        } catch (SystemDisabledException e) {
            logs.putLog(e.getMessage());
        }
    }

    public void exchangeResource(ResourceType from, ResourceType to){
        try{
            this.setState(this.state.exchangeResource(from, to));
        } catch (NotEnoughResourcesException e) {
            logs.putLog(e.getMessage());
        }
    }

    public void addCrewMember(){
        try{
            this.setState(this.state.addCrewMember());
        } catch (NotEnoughResourcesException e) {
            logs.putLog(e.getMessage());
        } catch (CrewFullException e) {
            logs.putLog(e.getMessage());
        }
    }

    public void upgradeWeapon(){
        try{
            this.setState(this.state.upgradeWeapon());
        } catch (NotEnoughResourcesException e) {
            logs.putLog(e.getMessage());
        } catch (UpgradeMaxException e) {
            logs.putLog(e.getMessage());
        }


    }

    public void repairShip(){
        try{
            this.setState(this.state.repairShip());
        } catch (NotEnoughResourcesException e) {
            logs.putLog(e.getMessage());
        }
    }

    public void repairDrone(){
        try {
            this.setState(this.state.repairDrone());
        } catch (NotEnoughResourcesException e) {
            logs.putLog(e.getMessage());
        }

    }

    public void convertToShipResources(UsableResourceType type, int amount) {
        try {
            this.setState(this.state.convertToShipResources(type, amount));
        } catch (NotEnoughResourcesException e) {
            logs.putLog(e.getMessage());
        }
    }

    //AVAILABLE FROM AwaitFinishExplorationState

    public void goUp() {
        try {
            this.setState(this.state.goUp());
        } catch (NotAllowedMoveException e) {
            logs.putLog(e.getMessage());
        }
    }

    public void goDown() {
        try {
            this.setState(this.state.goDown());
        } catch (NotAllowedMoveException e) {
            logs.putLog(e.getMessage());
        }
    }

    public void goLeft() {
        try {
            this.setState(this.state.goLeft());
        } catch (NotAllowedMoveException e) {
            logs.putLog(e.getMessage());
        }
    }

    public void goRight() {
        try {
            this.setState(this.state.goRight());
        } catch (NotAllowedMoveException e) {
            logs.putLog(e.getMessage());
        }
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
