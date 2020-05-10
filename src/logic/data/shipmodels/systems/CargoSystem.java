package logic.data.shipmodels.systems;

import logic.data.shipmodels.ResourceType;

public class CargoSystem extends System {

    private int redAmount;
    private int blueAmount;
    private int greenAmount;
    private int blackAmount;
    private int artifacts;

    public CargoSystem(boolean isMining) {
        super(isMining);

        this.maxAmount = 6;

        this.redAmount = 0;
        this.blueAmount = 0;
        this.greenAmount = 0;
        this.blackAmount = 0;

        this.artifacts = 0;
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


    public void payResource(int amount, ResourceType resourceType) {
        //TODO: a co jak nie ma tyle zasobów?
        switch (resourceType){
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
    }


    public void payAllResources (int amount) {
    //TODO: exception if insufficient amount of resources
        payResource(amount, ResourceType.RED);
        payResource(amount, ResourceType.BLUE);
        payResource(amount, ResourceType.GREEN);
        payResource(amount, ResourceType.BLACK);

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
        }
    }

    /*public ResourceType addRandomResource(int amount) {
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
    }*/

    public void loseBlackResource(int amount, ResourceType resourceType) {
        switch (resourceType){
            case RED:
                if (redAmount - amount < 0) redAmount = 0;
                else redAmount -= amount;
                break;
            case BLUE:
                if (blueAmount - amount < 0) blueAmount = 0;
                else blueAmount -= amount;
                break;
            case GREEN:
                if (greenAmount - amount < 0) greenAmount = 0;
                else greenAmount -= amount;
                break;
            case BLACK:
                if (blackAmount - amount < 0) blackAmount = 0;
                else blackAmount -= amount;
                break;
        }
    }


    public void upgradeCargoSystem() {
        if(!isAvailable) return;
        if (!isMining && maxAmount == 12) return;
        if (isMining && maxAmount == 24) return;
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

}
