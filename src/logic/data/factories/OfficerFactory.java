package logic.data.factories;

import logic.Logs;
import logic.data.shipmodels.officers.*;
import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.System;
import logic.data.shipmodels.systems.WeaponSystem;

public class OfficerFactory {
    public static Officer hireOfficer(int position, System system, Logs logs){
        switch (position){
            case 1:
                logs.putLog("Navigation Officer added");
                return new NaviagtionOfficer(logs);
            case 2:
                logs.putLog("Exploration Officer added");
                return new ExplorationOfficer(logs);
            case 3:
                logs.putLog("Shield Officer added");
                return new ShieldOfficer((ShieldSystem)system, logs);
            case 4:
                logs.putLog("Weapon Officer added");
                return new WeaponOfficer((WeaponSystem)system, logs);
            case 5:
                logs.putLog("Cargo Officer added");
                return new CargoOfficer((CargoSystem)system, logs);
        }
        return new Officer(logs);
    }
}
