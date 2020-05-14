package logic.data.shipmodels;

import logic.Logs;
import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.FuelSystem;
import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.WeaponSystem;

public class MilitaryShip extends Ship {
    public MilitaryShip(Logs logs) {
        super(new CargoSystem(false, logs), new FuelSystem(false, logs),
                new ShieldSystem(false, logs), new WeaponSystem(false, logs), logs);
    }


}
