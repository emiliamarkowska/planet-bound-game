package logic.states;

import logic.PlanetBoundData;

public class GameOverState extends StateAdapter {
    private boolean hasWon;

    public GameOverState(PlanetBoundData planetBoundData, boolean hasWon) {
        super(planetBoundData);
    }

    @Override
    public IState restartGame() {
        return new AwaitShipSelectionState(getPlanetBoundData());
    }
}
