package logic.data.factories;

import logic.Logs;
import logic.data.shipmodels.officers.*;
import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.System;
import logic.data.shipmodels.systems.WeaponSystem;

public class OfficerFactory {
    public static Officer hireOfficer(int position, System system){
        switch (position){
            case 1:
                Logs.putLog("Navigation Officer added");
                return new NaviagtionOfficer();
            case 2:
                Logs.putLog("Exploration Officer added");
                return new ExplorationOfficer();
            case 3:
                Logs.putLog("Shield Officer added");
                return new ShieldOfficer((ShieldSystem)system);
            case 4:
                Logs.putLog("Weapon Officer added");
                return new WeaponOfficer((WeaponSystem)system);
            case 5:
                Logs.putLog("Cargo Officer added");
                return new CargoOfficer((CargoSystem)system);
        }
        return new Officer();
    }
}
