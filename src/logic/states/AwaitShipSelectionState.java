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
        if (isMiningShip)getPlanetBoundData().setShip(new MilitaryShip());
        else getPlanetBoundData().setShip(new MilitaryShip());
        return new AwaitMoveState(getPlanetBoundData());
    }


}
