package logic.data.shipmodels;

import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.FuelSystem;
import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.WeaponSystem;

public class MilitaryShip extends Ship {
    public MilitaryShip() {
        super(new CargoSystem(false), new FuelSystem(false), new ShieldSystem(false), new WeaponSystem(false));
    }


}
