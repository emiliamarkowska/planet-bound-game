package logic.data.events;

import logic.data.shipmodels.Ship;

public class WormholeHelper {

    private Ship ship;
    public WormholeHelper(Ship ship) {
        this.ship = ship;
    }

    public void getThroughWormhole() {
        boolean hasOfficer = ship.isOfficerAvailable("ShieldOfficer");

        if (hasOfficer && hasShields(2)) {
            ship.getShieldSystem().loseShield(2);
            ship.getFuelSystem().subtractFuel(3);
        } else if (!hasOfficer && hasShields(4)) {
            ship.getShieldSystem().loseShield(4);
            ship.getFuelSystem().subtractFuel(4);
        } else if (hasOfficer && !hasShields(2)) {
            ship.getFuelSystem().subtractFuel(3);
            ship.killOneCrewMember();
        } else if (!hasOfficer && !hasShields(4)) {
            ship.getFuelSystem().subtractFuel(4);
            ship.killOneCrewMember();
        }

    }

    private boolean hasShields(int amount) {
        if (ship.getShieldSystem().getShields() >= amount) return true;
        return false;
    }
}
