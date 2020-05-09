package logic.states;

import logic.GameData;

public class GameWonState extends StateAdapter {
    public GameWonState(GameData gameData) {
        super(gameData);
    }

    @Override
    public IState playAgain(){
        return new ShipSelectionState(getGameData());
    }
}
