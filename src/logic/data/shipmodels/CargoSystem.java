package logic.data.shipmodels;

import logic.data.exceptions.InsufficientResourcesException;
import logic.data.exceptions.MaximumCapacityReachedException;
import logic.data.exceptions.SystemUnavailableException;

import java.util.concurrent.ThreadLocalRandom;

public class CargoSystem implements ShipSystem {
    private boolean isAvailable;
    private boolean isMilitary;
    private int currentMaxResourceAmount;

    private int blackResourceAmount;
    private int redResourceAmount;
    private int blueResourceAmount;
    private int greenResourceAmount;

    public CargoSystem(boolean isMilitary) {
        this.isMilitary = isMilitary;
        isAvailable = true;
        currentMaxResourceAmount = 6;

        blackResourceAmount = 0;
        redResourceAmount = 0;
        blueResourceAmount = 0;
        greenResourceAmount = 0;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public int getCurrentMaxResourceAmount() {
        return currentMaxResourceAmount;
    }

    public int getBlackResourceAmount() {
        return blackResourceAmount;
    }

    public int getRedResourceAmount() {
        return redResourceAmount;
    }

    public int getBlueResourceAmount() {
        return blueResourceAmount;
    }

    public int getGreenResourceAmount() {
        return greenResourceAmount;
    }

    public void payBlackResource(int amount) throws InsufficientResourcesException {
        if (blackResourceAmount - amount < 0) throw new InsufficientResourcesException();
        blackResourceAmount -= amount;
    }

    public void payRedResource(int amount) throws InsufficientResourcesException  {
        if (redResourceAmount - amount < 0) throw new InsufficientResourcesException();
        redResourceAmount -= amount;
    }

    public void payBlueResource(int amount) throws InsufficientResourcesException  {
        if (blueResourceAmount - amount < 0) throw new InsufficientResourcesException();
        blueResourceAmount -= amount;
    }

    public void payGreenResource(int amount) throws InsufficientResourcesException  {
        if (greenResourceAmount - amount < 0) throw new InsufficientResourcesException();
        greenResourceAmount -= amount;
    }

    public void payAllResources (int amount) throws InsufficientResourcesException  {
        if (
                greenResourceAmount - amount < 0 ||
                blueResourceAmount - amount < 0 ||
                redResourceAmount - amount < 0 ||
                blackResourceAmount - amount < 0
        ) throw new InsufficientResourcesException();
        greenResourceAmount -= amount;
        blueResourceAmount -= amount;
        redResourceAmount -= amount;
        blackResourceAmount -= amount;

    }

    public void addGreenResource(int amount) {
        greenResourceAmount += amount;
        if (greenResourceAmount > currentMaxResourceAmount) greenResourceAmount = currentMaxResourceAmount;
    }

    public void addBlueResource(int amount) {
        blueResourceAmount += amount;
        if (blueResourceAmount > currentMaxResourceAmount) blueResourceAmount = currentMaxResourceAmount;
    }

    public void addRedResource(int amount) {
        redResourceAmount += amount;
        if (redResourceAmount > currentMaxResourceAmount) redResourceAmount = currentMaxResourceAmount;
    }

    public void addBlackResource(int amount) {
        blackResourceAmount += amount;
        if (blackResourceAmount > currentMaxResourceAmount) blackResourceAmount = currentMaxResourceAmount;
    }

    public ResourceType addRandomResource(int amount) {
        int rand = ThreadLocalRandom.current().nextInt(0, 3);

        switch (rand) {
            case 0:
                addBlackResource(amount);
                return ResourceType.BLACK;
            case 1:
                addBlueResource(amount);
                return ResourceType.BLUE;
            case 2:
                addGreenResource(amount);
                return ResourceType.GREEN;
            case 3:
                addRedResource(amount);
                return ResourceType.RED;
            default:
                return ResourceType.RED;
        }
    }

    public void loseBlackResource(int amount) {
        blackResourceAmount -= amount;
        if (blackResourceAmount < 0) blackResourceAmount = 0;
    }

    public void loseRedResource(int amount) {
        redResourceAmount -= amount;
        if (redResourceAmount < 0) redResourceAmount = 0;
    }

    public void loseBlueResource(int amount) {
        blueResourceAmount -= amount;
        if (blueResourceAmount < 0) blueResourceAmount = 0;
    }

    public void loseGreenResource(int amount) {
        greenResourceAmount -= amount;
        if (greenResourceAmount < 0) greenResourceAmount = 0;
    }


    public void upgradeCargoSystem() throws SystemUnavailableException, MaximumCapacityReachedException {
        if(!isAvailable) throw new SystemUnavailableException();
        if (isMilitary && currentMaxResourceAmount == 12) throw new MaximumCapacityReachedException();
        if (!isMilitary && currentMaxResourceAmount == 24) throw new MaximumCapacityReachedException();

        currentMaxResourceAmount *= 2;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

}
