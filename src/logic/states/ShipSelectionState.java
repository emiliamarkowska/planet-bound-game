package logic.states;

import logic.GameData;
import logic.data.shipmodels.MilitaryShip;
import logic.data.shipmodels.MiningShip;
import logic.data.shipmodels.Ship;

public class ShipSelectionState extends StateAdapter {


    public ShipSelectionState(GameData gameData) {
        super(gameData);
    }

    @Override
    public IState selectShip(boolean isMilitary){
        if (isMilitary)getGameData().setShip(new MilitaryShip());
        else getGameData().setShip(new MiningShip());
        return new SpaceTravelState(getGameData());
    }


}
