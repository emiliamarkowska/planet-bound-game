package logic.data.planetmodels;

import logic.data.Resource;
import logic.data.shipmodels.ResourceType;

import java.util.ArrayList;

public class Planet {
    PlanetType planetType;
    ArrayList<Resource> resources;
    SpaceStation spaceStation;
    Resource availableResource;

    public Planet(PlanetType planetType, boolean hasSpaceStation){
        this.planetType = planetType;
        this.resources = ResourceToPlanetMap.getResourcesForPlanetType(planetType);
        if(hasSpaceStation) this.spaceStation = new SpaceStation();
        else this.spaceStation = null;
    }

    public PlanetType getPlanetType() {
        return planetType;
    }

    public ArrayList<Resource> getResources() {
        return resources;
    }

    public void deleteResource(ResourceType resourceType){
        for (Resource r : resources) {
            if(r.getResourceType() == resourceType)
                resources.remove(r);
        }
    }

    public boolean hasSpaceStation(){
        if(spaceStation == null) return false;
        return true;
    }

    public SpaceStation getSpaceStation() {
        return spaceStation;
    }

    public Resource getRandomResource() {
        int randomIndex = (int) (Math.random() * resources.size());
        availableResource = resources.get(randomIndex);
        return availableResource;
    }

    public void deleteRandomResource() {
        resources.remove(availableResource);
    }

    public boolean hasResources(){
        if(resources.size() == 0) return false;
        return true;
    }
}
