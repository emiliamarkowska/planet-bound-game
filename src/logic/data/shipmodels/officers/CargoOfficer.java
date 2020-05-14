package logic.data.shipmodels.officers;

import logic.Logs;
import logic.data.shipmodels.systems.CargoSystem;

public class CargoOfficer extends Officer {
    private CargoSystem cargoSystem;
    public CargoOfficer(CargoSystem cargoSystem, Logs logs){
        super(logs);
        this.positionInShip = 5;
        this.cargoSystem = cargoSystem;
    }

    @Override
    public void disableSystem(){
        this.cargoSystem.setEnabled(false);
        logs.putLog("Cargo system disabled");
    }

    @Override
    public void enableSystem(){
        this.cargoSystem.setEnabled(true);
        logs.putLog("Cargo system enabled");
    }
}
