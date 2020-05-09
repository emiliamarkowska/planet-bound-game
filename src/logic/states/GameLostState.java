package logic.states;

import logic.GameData;

public class GameLostState extends StateAdapter{
    public GameLostState(GameData gameData) {
        super(gameData);
    }

    @Override
    public IState playAgain(){
        return new ShipSelectionState(getGameData());
    }
}
