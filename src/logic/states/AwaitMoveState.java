package logic.states;

import logic.Logs;
import logic.Randomizer;
import logic.PlanetBoundData;
import logic.data.events.IEvent;
import logic.data.events.WormholeHelper;
import logic.data.exceptions.CrewFullException;
import logic.data.exceptions.NotEnoughFuelException;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.exceptions.NotEnoughShieldException;
import logic.data.factories.EventFactory;

import java.util.Locale;

public class AwaitMoveState extends StateAdapter {
    public AwaitMoveState(PlanetBoundData planetBoundData) {
        super(planetBoundData);
        getPlanetBoundData().generateNextPlanet();
    }

    @Override
    public IState exploreSpaceStation() {
        if(!getPlanetBoundData().getPlanet().hasSpaceStation()) return this;
        return new AwaitBuyState(getPlanetBoundData(), this);
    }

    @Override
    public IState explorePlanet() {
        if(!getPlanetBoundData().getPlanet().hasResources()) return this;
        return new AwaitFinishExplorationState(getPlanetBoundData(), this);
    }

    @Override
    public IState lookForAnotherPlanet() {
        if(getPlanetBoundData().getShip().getCargoSystem().getArtifacts() > 4) return new GameOverState(getPlanetBoundData(), true);
        if (Randomizer.randomSuccessFraction(1, 8)) {
            WormholeHelper helper = new WormholeHelper(getPlanetBoundData().getShip(), getPlanetBoundData().getLogs());
            try {
                helper.getThroughWormhole();
            } catch (NotEnoughShieldException e) {
                getPlanetBoundData().getLogs().putLog(e.getMessage());
            } catch (NotEnoughFuelException e) {
                getPlanetBoundData().getLogs().putLog(e.getMessage());
                return new GameOverState(getPlanetBoundData(), false);
            }
        }
        IEvent event = EventFactory.getRandomEvent();
        try {
            event.run(getPlanetBoundData().getShip(), getPlanetBoundData().getLogs());
        } catch (CrewFullException e) {
            getPlanetBoundData().getLogs().putLog(e.getMessage());
        } catch (NotEnoughFuelException e) {
            getPlanetBoundData().getLogs().putLog(e.getMessage());
            return new GameOverState(getPlanetBoundData(), false);
        } catch (NotEnoughResourcesException e) {
            getPlanetBoundData().getLogs().putLog(e.getMessage());
        }

        try {
            getPlanetBoundData().getShip().getFuelSystem().subtractFuel(1);
        } catch (NotEnoughFuelException e) {
            getPlanetBoundData().getLogs().putLog(e.getMessage());
            return new GameOverState(getPlanetBoundData(), false);
        }

        return new AwaitMoveState(getPlanetBoundData());
    }
}
