package logic.data.factories;

import logic.Logs;
import logic.data.geometry.Point;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;

public class ResourceFactory {

    public static Resource createResource(ResourceType resourceType, Point point, Logs logs) {
        logs.putLog(resourceType + "resource is at (" + point.getX() + ", " + point.getY() +")");
        return new Resource(resourceType, point, logs);
    }
}
