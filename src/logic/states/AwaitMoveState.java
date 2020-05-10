package logic.states;

import logic.Randomizer;
import logic.PlanetBoundData;
import logic.data.events.IEvent;
import logic.data.events.WormholeHelper;
import logic.data.factories.EventFactory;

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
            WormholeHelper helper = new WormholeHelper(getPlanetBoundData().getShip());
            helper.getThroughWormhole();
        }
        IEvent event = EventFactory.getRandomEvent();
        event.run(getPlanetBoundData().getShip());

        getPlanetBoundData().getShip().getFuelSystem().subtractFuel(1);

        return new AwaitMoveState(getPlanetBoundData());
    }
}
