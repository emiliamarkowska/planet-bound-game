package logic.data.events;

import logic.Logs;
import logic.data.exceptions.NotEnoughFuelException;
import logic.data.exceptions.NotEnoughShieldException;
import logic.data.shipmodels.Ship;

public class WormholeHelper {

    private Ship ship;
    private Logs logs;
    public WormholeHelper(Ship ship, Logs logs) {
        this.ship = ship;
        this.logs = logs;
    }

    public void getThroughWormhole() throws NotEnoughShieldException, NotEnoughFuelException {
        boolean hasOfficer = ship.isOfficerAvailable("ShieldOfficer");

        if (hasOfficer && hasShields(2)) {
            ship.getShieldSystem().loseShield(2);
            ship.getFuelSystem().subtractFuel(3);
            logs.putLog("Ship passes through wormhole - 2 shields lost, 3 cells of fuel lost");
        } else if (!hasOfficer && hasShields(4)) {
            ship.getShieldSystem().loseShield(4);
            ship.getFuelSystem().subtractFuel(4);
            logs.putLog("Ship passes through wormhole without Shield Officer - 4 shields lost, 4 cells of fuel lost");
        } else if (hasOfficer && !hasShields(2)) {
            ship.getFuelSystem().subtractFuel(3);
            ship.killOneCrewMember();
            logs.putLog("Ship passes through wormhole without shields - 3 cells of fuel lost, crew member lost");
        } else if (!hasOfficer && !hasShields(4)) {
            ship.getFuelSystem().subtractFuel(4);
            ship.killOneCrewMember();
            logs.putLog("Ship passes through wormhole without shields and Shield Officer - 4 cells of fuel lost, crew member lost");
        }

    }

    private boolean hasShields(int amount) {
        if (ship.getShieldSystem().getShields() >= amount) return true;
        return false;
    }
}
