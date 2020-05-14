package logic.data.shipmodels.systems;

import logic.Logs;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.exceptions.SystemDisabledException;
import logic.data.exceptions.UpgradeMaxException;
import logic.Logs;
import logic.data.exceptions.NotEnoughResourcesException;
import logic.data.shipmodels.ResourceType;

public class CargoSystem extends System {

    private int redAmount;
    private int blueAmount;
    private int greenAmount;
    private int blackAmount;
    private int artifacts;
    private Logs logs;

    public CargoSystem(boolean isMining, Logs logs) {
        super(isMining);

        this.maxAmount = 6;

        this.redAmount = 0;
        this.blueAmount = 0;
        this.greenAmount = 0;
        this.blackAmount = 0;

        this.artifacts = 0;
        this.logs = logs;
    }

    public int getRedAmount() {
        return this.redAmount;
    }

    public int getBlueAmount() { return this.blueAmount; }

    public int getGreenAmount() {
        return this.greenAmount;
    }

    public int getBlackAmount() {
        return this.blackAmount;
    }

    public int getArtifacts() {return  this.artifacts; }

    public int getAmount(ResourceType resourceType){
        switch(resourceType){
            case RED:
                return getRedAmount();
            case BLUE:
                return getBlueAmount();
            case GREEN:
                return getGreenAmount();
            case BLACK:
                return getBlackAmount();
        }
        return -1;
    }
    public void payResource(int amount, ResourceType resourceType) throws NotEnoughResourcesException {
        if (!canBeResourcePaid(resourceType, amount)) {
            String errorMessage = "Not enough amount of " + resourceType.toString() + " resource to pay. Tried to pay " + amount +
                    " having only " + getAmount(resourceType) + ".";
            throw new NotEnoughResourcesException(errorMessage);
        }
        switch (resourceType) {
            case RED:
                redAmount -= amount;
                break;
            case BLUE:
                blueAmount -= amount;
                break;
            case GREEN:
                greenAmount -= amount;
                break;
            case BLACK:
                greenAmount -= amount;
                break;
        }
        logs.putLog(resourceType + " resource spend in amount of: " + amount);
    }
    public void payAllResources (int amount) throws NotEnoughResourcesException {
        if(!canBeResourcePaid(ResourceType.RED, amount) || !canBeResourcePaid(ResourceType.BLUE, amount)
                || !canBeResourcePaid(ResourceType.GREEN, amount) || !canBeResourcePaid(ResourceType.BLACK  , amount)) {
            String errorMessage = "Can't pay all resources, because some is missing";
            throw new NotEnoughResourcesException(errorMessage);
        }
        payResource(amount, ResourceType.RED);
        payResource(amount, ResourceType.BLUE);
        payResource(amount, ResourceType.GREEN);
        payResource(amount, ResourceType.BLACK);
        logs.putLog("All resources paid in amount: " + amount + " of each resource");
    }

    public void addResource(int amount, ResourceType resourceType) {
        switch (resourceType){
            case RED:
                if(amount > getMaxAmount() - getRedAmount()) redAmount = maxAmount;
                else redAmount += amount;
                break;
            case BLUE:
                if(amount > getMaxAmount() - getBlueAmount()) blueAmount = maxAmount;
                else blueAmount += amount;
                break;
            case GREEN:
                if(amount > getMaxAmount() - getGreenAmount()) greenAmount = maxAmount;
                else greenAmount += amount;
                break;
            case BLACK:
                if(amount > getMaxAmount() - getBlackAmount()) greenAmount = maxAmount;
                else blackAmount += amount;
                break;
            case PINK:
                artifacts += 1;
                break;
        }
        logs.putLog(resourceType + " resource added in amount of: " + amount);
    }


    public void loseBlackResource(int amount, ResourceType resourceType) {
        int amountLost = amount;
        switch (resourceType){
            case RED:
                if (redAmount - amount < 0) {
                    amountLost = redAmount - amount;
                    redAmount = 0;
                }
                else redAmount -= amount;
                break;
            case BLUE:
                if (blueAmount - amount < 0) {
                    amountLost = blueAmount - amount;
                    blueAmount = 0;
                }
                else blueAmount -= amount;
                break;
            case GREEN:
                if (greenAmount - amount < 0) {
                    amountLost = greenAmount - amount;
                    greenAmount = 0;
                }
                else greenAmount -= amount;
                break;
            case BLACK:
                if (blackAmount - amount < 0) {
                    amountLost = blackAmount - amount;
                    blackAmount = 0;
                }
                else blackAmount -= amount;
                break;
        }
        logs.putLog(resourceType + "resource lost in amount of: " + amount);
    }


    public void upgradeCargoSystem() throws SystemDisabledException, UpgradeMaxException {
        if(!isEnabled) {
            String errorMessage = "Can't upgrade - cargo system is disabled";
            logs.putLog(errorMessage);
            throw new SystemDisabledException(errorMessage);
        }
        if (!isMiningShip && maxAmount == 12) {
            String errorMessage = "Military ship upgrade max reached - can't upgrade";
            logs.putLog(errorMessage);
            throw new UpgradeMaxException(errorMessage);
        }
        if (isMiningShip && maxAmount == 24) {
            String errorMessage = "Mining ship upgrade max reached - can't upgrade";
            logs.putLog(errorMessage);
            throw new UpgradeMaxException(errorMessage);
        }
        maxAmount += 6;
    }

    public boolean isResourceAvailable(ResourceType resourceType){
        switch(resourceType){
            case BLACK:
                return getBlackAmount() > 0;
            case GREEN:
                return getGreenAmount() > 0;
            case BLUE:
                return getBlueAmount() > 0;
            case RED:
                return getRedAmount() > 0;
        }
        return false;
    }

    public boolean isCargoFull(ResourceType resourceType){
        switch(resourceType){
            case BLACK:
                return getMaxAmount() - getBlackAmount() <= 0;
            case GREEN:
                return getMaxAmount() - getGreenAmount() <= 0;
            case BLUE:
                return getMaxAmount() - getBlueAmount() <= 0;
            case RED:
                return getMaxAmount() - getRedAmount() <= 0;
        }
        return true;
    }

    public boolean canBeResourcePaid(ResourceType resourceType, int amount){
        return getAmount(resourceType) - amount >= 0;
    }

}
