package logic.data.factories;

import logic.Point;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;

public class ResourceFactory {

    public static Resource createResource(ResourceType resourceType, Point point) {
        return new Resource(resourceType, point);
    }
}
