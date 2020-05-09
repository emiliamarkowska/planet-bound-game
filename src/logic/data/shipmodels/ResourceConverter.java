package logic.data.shipmodels;

import logic.data.Resource;

public class ResourceConverter {

    private Ship ship;

    public ResourceConverter(Ship ship) {
        this.ship = ship;
    }

    public void produceShield(int amount){
        //TODO exception
        if(!ship.getCargoSystem().isAvailable()) return;
        if(ship.getCargoSystem().getBlackResourceAmount() < amount || ship.getCargoSystem().getGreenResourceAmount() < amount ||ship. getCargoSystem().getBlueResourceAmount() < amount) return;
        if(ship.getShieldSystem().getShieldsAmount() + amount <= ship.getShieldSystem().getMaxShieldsAmount()){
            ship.getCargoSystem().payBlackResource(amount);
            ship.getCargoSystem().payGreenResource(amount);
            ship.getCargoSystem().payBlueResource(amount);
            ship.getShieldSystem().addShield(amount);
        }
    }

    public void produceAmmo(int amount){
        //TODO exception
        if(ship.getCargoSystem().isAvailable()) return;
        if(ship.getCargoSystem().getBlackResourceAmount() < amount || ship.getCargoSystem().getBlueResourceAmount() < amount) return;
        if(ship.getWeaponSystem().getWeapons() + amount <= ship.getWeaponSystem().getMaxWeapons()){
            ship.getCargoSystem().payBlackResource(amount);
            ship.getCargoSystem().payBlueResource(amount);
            ship.getWeaponSystem().addAmmo(amount);
        }
    }

    public void produceFuel( int amount){
        //TODO exception
        if(!ship.getCargoSystem().isAvailable()) return;
        if(ship.getCargoSystem().getBlackResourceAmount() < amount || ship.getCargoSystem().getRedResourceAmount() < amount || ship.getCargoSystem().getGreenResourceAmount() < amount ) return;
        if(ship.getFuelSystem().getFuelAmount() + amount <= ship.getFuelSystem().getMaxFuelAmount()){
            ship.getCargoSystem().payBlackResource(amount);
            ship.getCargoSystem().payRedResource(amount);
            ship.getCargoSystem().payGreenResource(amount);
            ship.getFuelSystem().addFuel(amount);
        }
    }

}
