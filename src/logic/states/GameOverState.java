package logic.states;

import logic.PlanetBoundData;

public class GameOverState extends StateAdapter {
    public GameOverState(PlanetBoundData gameData) {
        super(gameData);
    }

    @Override
    public IState playAgain(){
        return new AwaitShipSelectionState(getGameData());
    }
}
