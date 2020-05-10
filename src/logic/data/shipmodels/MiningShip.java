package logic.data.shipmodels;

import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.FuelSystem;
import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.WeaponSystem;

public class MiningShip extends Ship {
    public MiningShip() {
        super(new CargoSystem(false), new FuelSystem(false), new ShieldSystem(false), new WeaponSystem(false));
    }
}
