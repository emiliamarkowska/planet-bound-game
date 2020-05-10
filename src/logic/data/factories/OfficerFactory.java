package logic.data.factories;

import logic.data.shipmodels.officers.*;
import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.System;
import logic.data.shipmodels.systems.WeaponSystem;

public class OfficerFactory {
    public static Officer hireOfficer(int position, System system){
        switch (position){
            case 1:
                return new NaviagtionOfficer();
            case 2:
                return new ExplorationOfficer();
            case 3:
                return new ShieldOfficer((ShieldSystem)system);
            case 4:
                return new WeaponOfficer((WeaponSystem)system);
            case 5:
                return new CargoOfficer((CargoSystem)system);
        }
        return new Officer();
    }
}
