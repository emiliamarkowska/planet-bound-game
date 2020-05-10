package logic.data.shipmodels;


import logic.Logs;
import logic.data.exceptions.CrewFullException;
import logic.data.geometry.Point;
import logic.data.factories.OfficerFactory;
import logic.data.movables.Drone;
import logic.data.shipmodels.officers.*;
import logic.data.shipmodels.systems.CargoSystem;
import logic.data.shipmodels.systems.FuelSystem;
import logic.data.shipmodels.systems.ShieldSystem;
import logic.data.shipmodels.systems.System;
import logic.data.shipmodels.systems.WeaponSystem;

import java.util.ArrayList;

public class Ship {
    private CargoSystem cargoSystem;
    private FuelSystem fuelSystem;
    private ShieldSystem shieldSystem;
    private WeaponSystem weaponSystem;
    private ArrayList<Officer> officers;
    private Drone drone;

    public Ship(CargoSystem cargoSystem, FuelSystem fuelSystem, ShieldSystem shieldSystem, WeaponSystem weaponSystem) {
        this.cargoSystem = cargoSystem;
        this.fuelSystem = fuelSystem;
        this.shieldSystem = shieldSystem;
        this.weaponSystem = weaponSystem;

        this.officers = new ArrayList<>();
        officers.add(new Captain());
        officers.add(new NaviagtionOfficer());
        officers.add(new ExplorationOfficer());
        officers.add(new ShieldOfficer(this.shieldSystem));
        officers.add(new WeaponOfficer(this.weaponSystem));
        officers.add(new CargoOfficer(this.cargoSystem));

        drone = new Drone(new Point(0, 0));
    }

    public CargoSystem getCargoSystem() {
        return this.cargoSystem;
    }
    public FuelSystem getFuelSystem() {
        return this.fuelSystem;
    }
    public ShieldSystem getShieldSystem() {
        return this.shieldSystem;
    }
    public WeaponSystem getWeaponSystem() {
        return this.weaponSystem;
    }


    public void killOneCrewMember() {
        officers.get(officers.size() - 1).disableSystem();
        officers.remove(officers.size() - 1);
        Logs.putLog("Crew member killed");
    }

    public void hireOneCrewMember() throws CrewFullException {
        int position = officers.size();
        if(position >= 6) {
            String errorMessage = "Crew full - can't hire new members";
            Logs.putLog(errorMessage);
            throw new CrewFullException(errorMessage);
        }
        System system = null;
        switch(position){
            case 3:
                system = this.shieldSystem;
                break;
            case 4:
                system = this.weaponSystem;
                break;
            case 5:
                system = this.cargoSystem;
                break;
        }
        officers.add(OfficerFactory.hireOfficer(position, system));
        Logs.putLog("Crew member hired");
    }

    public Drone getDrone() {
        return drone;
    }

    public boolean isOfficerAvailable(String officer) {
        for(Officer o : officers){
            if(o.getClass().getSimpleName().equals(officer)) return true;
        }
        return false;
    }

    public void setDrone(Drone drone){
        this.drone = new Drone(new Point(0, 0));
    }

}
