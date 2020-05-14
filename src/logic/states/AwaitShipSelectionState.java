package logic.states;

import logic.PlanetBoundData;
import logic.data.shipmodels.MilitaryShip;
import logic.data.shipmodels.MiningShip;

public class AwaitShipSelectionState extends StateAdapter {


    public AwaitShipSelectionState(PlanetBoundData planetBoundData) {
        super(planetBoundData);
    }

    @Override
    public IState chooseShip(boolean isMiningShip){
        if (isMiningShip)getPlanetBoundData().setShip(new MilitaryShip(getPlanetBoundData().getLogs()));
        else getPlanetBoundData().setShip(new MilitaryShip(getPlanetBoundData().getLogs()));
        return new AwaitMoveState(getPlanetBoundData());
    }


}
