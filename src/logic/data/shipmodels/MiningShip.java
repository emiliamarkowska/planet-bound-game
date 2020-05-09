package logic.data.shipmodels;

public class MiningShip extends Ship {
    public MiningShip() {

        super(new FuelSystem(false), new CargoSystem(false), new WeaponSystem(false), new ShieldSystem(false));
    }
}
