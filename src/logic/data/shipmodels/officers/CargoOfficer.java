package logic.data.shipmodels.officers;

import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.System;

public class CargoOfficer extends Officer {
    private CargoSystem cargoSystem;
    public CargoOfficer(CargoSystem cargoSystem){
        this.positionInShip = 5;
        this.cargoSystem = cargoSystem;
    }

    @Override
    public void disableSystem(){
        this.cargoSystem.setAvailable(false);
    }

    @Override
    public void enableSystem(){
        this.cargoSystem.setAvailable(true);
    }
}
