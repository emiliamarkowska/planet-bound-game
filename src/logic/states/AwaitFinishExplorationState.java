package logic.states;

import logic.PlanetBoundData;

public class AwaitFinishExplorationState extends StateAdapter {

    PlanetExplorationLogic logic;

    public AwaitFinishExplorationState(PlanetBoundData gameData) {
        super(gameData);

        gameData.setExLogic(new PlanetExplorationLogic(gameData.getShip(), gameData.getPlanet().getRandomResource(), gameData.getLogRecorder()));
        logic = gameData.getExLogic();
    }

    @Override
    public IState goUp() {
        logic.moveDrone("up");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new AwaitMoveState(getGameData());
        return this;
    }

    @Override
    public IState goDown() {
        logic.moveDrone("down");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new AwaitMoveState(getGameData());
        return this;
    }

    @Override
    public IState goLeft() {
        logic.moveDrone("left");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new AwaitMoveState(getGameData());
        return this;
    }

    @Override
    public IState goRight() {
        logic.moveDrone("right");
        if (logic.isDroneBackInShip()) return new WaitingForReturnConfirmationState(getGameData(), this);
        if (logic.isDroneDestroyed()) return new AwaitMoveState(getGameData());
        return this;
    }


}
