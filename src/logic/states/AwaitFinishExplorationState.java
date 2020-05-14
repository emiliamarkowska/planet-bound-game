package logic.states;

import logic.ExplorationPhase;
import logic.PlanetBoundData;
import logic.Randomizer;
import logic.data.exceptions.NotAllowedMoveException;

public class AwaitFinishExplorationState extends StateAdapter {

    private ExplorationPhase explorationPhase;
    private IState prevState;

    public AwaitFinishExplorationState(PlanetBoundData planetBoundData, IState prevState) {
        super(planetBoundData);
        this.prevState = prevState;

        explorationPhase = new ExplorationPhase(getPlanetBoundData().getShip().getDrone(), getPlanetBoundData().getPlanet(), getPlanetBoundData().getLogs());
    }

    @Override
    public IState goUp() throws NotAllowedMoveException {
        explorationPhase.goUp();
        if (isBack()) {
            gatherResource();
            return prevState;
        }
        return this;
    }

    @Override
    public IState goDown() throws NotAllowedMoveException {
        explorationPhase.goDown();
        if (isBack()) {
            gatherResource();
            return prevState;
        }
        return this;
    }

    @Override
    public IState goLeft() throws NotAllowedMoveException {
        explorationPhase.goLeft();
        if (isBack()) {
            gatherResource();
            return prevState;
        }
        return this;
    }

    @Override
    public IState goRight() throws NotAllowedMoveException {
        explorationPhase.goRight();
        if (isBack()) {
            gatherResource();
            return prevState;
        }
        return this;
    }

    private boolean isBack() {
        return explorationPhase.isResourceFollows() && explorationPhase.isBackToStartingPoint();
    }

    private void gatherResource() {
        getPlanetBoundData().getShip().getCargoSystem().addResource(Randomizer.randomInt(1, 6), explorationPhase.getResource().getResourceType());
        getPlanetBoundData().getPlanet().deleteMinedResource();
    }
}
