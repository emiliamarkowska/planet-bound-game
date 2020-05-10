package logic.data.planetmodels;

import logic.Randomizer;
import logic.data.shipmodels.ResourceType;

public enum PlanetsResourcesList {
    BLACK(ResourceType.BLUE, ResourceType.BLACK),
    GREEN(ResourceType.GREEN, ResourceType.RED),
    RED(ResourceType.RED, ResourceType.BLUE),
    BLUE(ResourceType.GREEN, ResourceType.BLACK, ResourceType.BLUE, ResourceType.PINK);

    private ResourceType[] value;

    PlanetsResourcesList(ResourceType... value) {
        this.value = value;
    }

    public ResourceType[] getValue() {
        return this.value;
    }

    @Override
    public String toString() {
        String s = "";
        for (ResourceType r : value) {
            s += r + " ";
        }
        return s;
    }

    public static PlanetsResourcesList getRandomPlanet(){
        int option = Randomizer.randomInt(1, 4);
        switch(option){
            case 1:
                return BLACK;
            case 2:
                return GREEN;
            case 3:
                return RED;
            case 4:
                return BLUE;
        }
        return null;
    }
}
