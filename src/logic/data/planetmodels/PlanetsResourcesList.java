package logic.data.planetmodels;

import logic.data.Resource;
import logic.data.shipmodels.ResourceType;

import java.util.Arrays;
import java.util.List;

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
}
