package logic.data.movables;

import logic.Logs;
import logic.data.geometry.Point;
import logic.data.shipmodels.ResourceType;

public class Resource extends Movable{
    private ResourceType type;

    public Resource(Resource copy){
        super(copy.position);
        this.type = copy.getResourceType();

    }

    public Resource(ResourceType resourceType, Point position) {
        super(position);
        this.type = resourceType;
    }

    public ResourceType getResourceType() {
        return type;
    }

    public void setResourceType(ResourceType resourceType) {
        this.type = resourceType;
    }

    public void followDrone(Drone drone) {
        position.setXY(drone.getPosition());
    }
}
