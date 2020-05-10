package logic.states;

import logic.Randomizer;
import logic.PlanetBoundData;

public class AwaitMoveState extends StateAdapter {
    public AwaitMoveState(PlanetBoundData planetBoundData) {
        super(planetBoundData);
    }

    @Override
    public IState exploreSpaceStation() {
        if(!getPlanetBoundData().getPlanet().hasSpaceStation()) return this;
        return new AwaitBuyState(getPlanetBoundData());
    }

    @Override
    public IState explorePlanet() {
        return super.explorePlanet();
    }

    @Override
    public IState goToPlanet(){
        if(!getGameData().getPlanet().hasResources()) return this;
        if(!getGameData().getShip().isExplorationOfficerAvailable()) return this;
            return new AwaitFinishExplorationState(getGameData());
    }

    @Override
    public IState lookForAnotherPlanet() {
        if (getGameData().getShip().getAmountOfArtifacts() >= 5) return new GameOverState(getGameData());
        Event event = new Event(getGameData().getLogRecorder());
        try {
            travelCost();
            event.runSpecificEvent(getGameData().getShip());
        } catch (NoFuelException e) {
            getGameData().getLogRecorder().addLog("You have no fuel left. Game over.");
            return new GameLostState(getGameData());
        }


        if (getGameData().getShip().getFuelSystem().getFuelAmount() == 0 || getGameData().getShip().getCrewAmount() == 0) return new GameLostState(getGameData());

        getGameData().generateNextPlanet();
        return new AwaitMoveState(getGameData());
    }


    @Override
    public IState produce(String type, int amount){
        if(!getGameData().getShip().getCargoSystem().isEnabled()) return this;

        switch(type) {
            case "ammo":
                try {
                    getGameData().getShip().getResourceConverter().produceAmmo(amount);
                } catch (GameException e) {
                    getGameData().getLogRecorder().addLog(e.getMessage());
                }
            case "fuel":
                try {
                    getGameData().getShip().getResourceConverter().produceFuel(amount);
                } catch (GameException e) {
                    getGameData().getLogRecorder().addLog(e.getMessage());
                }
            case "shield":
                try {
                    getGameData().getShip().getResourceConverter().produceShield(amount);
                } catch (GameException e) {
                    getGameData().getLogRecorder().addLog(e.getMessage());
                }
        }

        return this;
    }

    private void travelCost() throws NoFuelException {
        int probability = Randomizer.throwd8();
        if(probability == 1) {
            getGameData().getLogRecorder().addLog("You have entered wormhole.");
            if(!getGameData().getShip().isShieldOfficerAvailable()){
                getGameData().getShip().getFuelSystem().spendFuel(4);
                if (getGameData().getShip().getShieldSystem().getShieldsAmount() >= 4) {
                    getGameData().getShip().getShieldSystem().spendShield(4);
                    getGameData().getLogRecorder().addLog("Because you do not have Shields Officer, you have spent 4 shields and 4 fuel cells to get through wormhole.");
                } else {
                    getGameData().getLogRecorder().addLog("Because you do not have Shields Officer and have no shields, you have spent 4 fuel cells and one crew member has died to get through wormhole.");
                    getGameData().getShip().killOneCrewMember();
                }

            } else {
                getGameData().getShip().getFuelSystem().spendFuel(3);
                if (getGameData().getShip().getShieldSystem().getShieldsAmount() >= 2) {
                    getGameData().getShip().getShieldSystem().spendShield(2);
                    getGameData().getLogRecorder().addLog("You have spent 2 shields and 3 fuel cells to get through wormhole.");

                } else {
                    getGameData().getShip().killOneCrewMember();
                    getGameData().getLogRecorder().addLog("Because you do not have any shields, you have spent 3 fuel cells and one crew member has died to get through wormhole.");
                }
            }
        }
        else {
            getGameData().getLogRecorder().addLog("You have spent one fuel cell on space travel.");
            getGameData().getShip().getFuelSystem().spendFuel(1);
        }

    }


}
