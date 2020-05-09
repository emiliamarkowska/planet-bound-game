package logic.states;

import logic.Dice;
import logic.GameData;
import logic.data.exceptions.NoFuelException;
import logic.data.shipmodels.ResourceType;

public class WaitingForReturnConfirmationState extends StateAdapter {
    private IState previousState;

    public WaitingForReturnConfirmationState(GameData gameData, IState previousState) {
        super(gameData);
        this.previousState = previousState;
    }

    @Override
    public IState acceptReturn() {
        try {
            getGameData().getShip().getFuelSystem().spendFuel(1);
        } catch (NoFuelException e) {
            getGameData().getLogRecorder().addLog(e.getMessage());
            return new GameLostState(getGameData());
        }
        if(!getGameData().getExLogic().isResourceInDrone()) return new SpaceTravelState(getGameData());

        if(getGameData().getExLogic().getResource().getResourceType() != ResourceType.PINK){
                int amountOfResource = Dice.throwd6();
            switch (getGameData().getExLogic().getResource().getResourceType()) {
                case BLACK:
                    getGameData().getShip().getCargoSystem().addBlackResource(amountOfResource);
                    getGameData().getLogRecorder().addLog("You have gathered " + amountOfResource + " " + ResourceType.BLACK + " resource");
                    break;
                case BLUE:
                    getGameData().getShip().getCargoSystem().addBlueResource(amountOfResource);
                    getGameData().getLogRecorder().addLog("You have gathered " + amountOfResource + " " + ResourceType.BLUE + " resource");
                    break;
                case GREEN:
                    getGameData().getShip().getCargoSystem().addGreenResource(amountOfResource);
                    getGameData().getLogRecorder().addLog("You have gathered " + amountOfResource + " " + ResourceType.GREEN + " resource");
                    break;
                case RED:
                    getGameData().getShip().getCargoSystem().addRedResource(amountOfResource);
                    getGameData().getLogRecorder().addLog("You have gathered " + amountOfResource + " " + ResourceType.RED + " resource");
                    break;
            }

        }
        else {
            getGameData().getShip().addArtifact();
            getGameData().getLogRecorder().addLog("You have found an Artifact!");
        }
        getGameData().getPlanet().deleteRandomResource();
        return new SpaceTravelState(getGameData());
    }

    @Override
    public IState declineReturn() {
        return previousState;
    }

}
