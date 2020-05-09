package logic.data.shipmodels;


public class Ship {
    private FuelSystem fuelSystem;
    private CargoSystem cargoSystem;
    private WeaponSystem weaponSystem;
    private ShieldSystem shieldSystem;
    private ResourceConverter resourceConverter;

    private Drone drone;

    private int amountOfArtifacts;

    private int crewAmount;


    public Ship(FuelSystem fuelSystem, CargoSystem cargoSystem, WeaponSystem weaponSystem, ShieldSystem shieldSystem) {
        this.fuelSystem = fuelSystem;
        this.cargoSystem = cargoSystem;
        this.weaponSystem = weaponSystem;
        this.shieldSystem = shieldSystem;

        amountOfArtifacts = 0;
        crewAmount = 6;

        drone = new Drone();
        resourceConverter = new ResourceConverter(this);
    }

    public FuelSystem getFuelSystem() {
        return fuelSystem;
    }

    public CargoSystem getCargoSystem() {
        return cargoSystem;
    }

    public WeaponSystem getWeaponSystem() {
        return weaponSystem;
    }

    public ShieldSystem getShieldSystem() {
        return shieldSystem;
    }

    public int getAmountOfArtifacts() {
        return amountOfArtifacts;
    }

    public int getCrewAmount() {
        return crewAmount;
    }

    public void killOneCrewMember() {
        crewAmount--;
        switch (crewAmount){
            case 5:
                getCargoSystem().setAvailable(false);
                break;
            case 4:
                getWeaponSystem().setAvailable(false);
                break;
            case 3:
                getShieldSystem().setAvailable(false);
        }
    }

    public void hireOneCrewMember() {
        if (crewAmount < 6) crewAmount++;
    }

    public Drone getDrone() {
        return drone;
    }

    public void addArtifact(){
        this.amountOfArtifacts++;
    }

    public boolean isCargoOfficerAvailable(){
        if(crewAmount > 5) return true;
        return false;
    }

    public boolean isWeaponOfficerAvailable(){
        if(crewAmount > 4)return true;
        return false;
    }

    public boolean isShieldOfficerAvailable(){
        if(crewAmount > 3) return true;
        return false;
    }

    public boolean isExplorationOfficerAvailable(){
        if(crewAmount > 2) return  true;
        return false;
    }

    public boolean isNavigationOfficerAvailable(){
        if(crewAmount > 1) return true;
        return false;
    }

    public boolean isCaptainAvailable(){
        if(crewAmount > 0) return true;
        return false;
    }

    public ResourceConverter getResourceConverter() {
        return resourceConverter;
    }
}
