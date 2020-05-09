package logic.data;

import logic.data.shipmodels.ResourceType;

public class Resource {
    private ResourceType resourceType;

    public Resource(Resource clone){
        this.resourceType = clone.getResourceType();
    }

    public Resource(ResourceType resourceType) {
        this.resourceType = resourceType;
    }

    public ResourceType getResourceType() {
        return resourceType;
    }

    public void setResourceType(ResourceType resourceType) {
        this.resourceType = resourceType;
    }
}
