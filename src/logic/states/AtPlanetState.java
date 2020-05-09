package logic.states;

import logic.GameData;
import logic.PlanetExplorationLogic;

public class AtPlanetState extends StateAdapter {

    PlanetExplorationLogic logic;

    public AtPlanetState(GameData gameData) {
        super(gameData);

        gameData.setExLogic(new PlanetExplorationLogic(gameData.getShip(), gameData.getPlanet().getRandomResource(), gameData.getLogRecorder()));
        logic = gameData.getExLogic();
    }

    @Override
    public IState goUp() {
        logic.moveDrone("up");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new SpaceTravelState(getGameData());
        return this;
    }

    @Override
    public IState goDown() {
        logic.moveDrone("down");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new SpaceTravelState(getGameData());
        return this;
    }

    @Override
    public IState goLeft() {
        logic.moveDrone("left");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new SpaceTravelState(getGameData());
        return this;
    }

    @Override
    public IState goRight() {
        logic.moveDrone("right");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new SpaceTravelState(getGameData());
        return this;
    }


}
