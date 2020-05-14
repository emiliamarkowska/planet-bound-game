package logic.data.planetmodels;

import logic.Logs;
import logic.Randomizer;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Planet {
    PlanetsResourcesList planetInfo;
    ArrayList<ResourceType> resourcesOnPlanet;
    boolean hasSpaceStation;
    ResourceType minedResource;
    private Logs logs;

    public Planet(PlanetsResourcesList planetInfo, boolean hasSpaceStation, Logs logs){
        this.planetInfo = planetInfo;
        this.resourcesOnPlanet = new ArrayList<>(Arrays.asList(planetInfo.getValue()));
        this.hasSpaceStation = hasSpaceStation;
        this.logs = logs;
    }

    public PlanetsResourcesList getPlanetInfo() {
        return planetInfo;
    }

    public ArrayList<ResourceType> getResources() {
        return resourcesOnPlanet;
    }

    public void deleteResource(ResourceType resourceType){
        for (ResourceType r : resourcesOnPlanet) {
            if(r == resourceType){
                resourcesOnPlanet.remove(r);
                logs.putLog(resourceType + " resource deleted from the planet");
            }

        }
    }

    public boolean hasSpaceStation(){
        return hasSpaceStation;
    }

    public ResourceType getResourceToBeMined() {
        int randomIndex = Randomizer.randomInt(0, resourcesOnPlanet.size() - 1);
        minedResource = resourcesOnPlanet.get(randomIndex);
        logs.putLog(minedResource + "resource is to be mined");
        return minedResource;
    }

    public void deleteMinedResource() {
        resourcesOnPlanet.remove(minedResource);
        logs.putLog(minedResource + " resource is mined and is deleted from available resources");
    }

    public boolean hasResources(){
        if(resourcesOnPlanet.size() == 0) return false;
        return true;
    }
}
