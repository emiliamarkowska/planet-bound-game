package logic.data.shipmodels;

public class MilitaryShip extends Ship {
    public MilitaryShip() {

        super(new FuelSystem(true), new CargoSystem(true), new WeaponSystem(true), new ShieldSystem(true));
    }


}
