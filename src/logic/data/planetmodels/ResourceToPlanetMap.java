package logic.data.planetmodels;

import logic.data.Resource;
import logic.data.shipmodels.ResourceType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResourceToPlanetMap {

     private static HashMap<PlanetType, ArrayList<Resource>> planetTypesAndResources;

     static {
         planetTypesAndResources = new HashMap<>();
         // GREEN PLANET
         ArrayList<Resource> greenPlanetResources = new ArrayList<>();
         Resource r1 = new Resource(ResourceType.RED);
         Resource r2 = new Resource(ResourceType.GREEN);
         greenPlanetResources.add(r1);
         greenPlanetResources.add(r2);

         // BLACK PLANET
         ArrayList<Resource> blackPlanetResources = new ArrayList<>();
         Resource r3 = new Resource(ResourceType.BLACK);
         Resource r4 = new Resource(ResourceType.BLUE);
         blackPlanetResources.add(r3);
         blackPlanetResources.add(r4);

         // RED PLANET
         ArrayList<Resource> redPlanetResources = new ArrayList<>();
         Resource r5 = new Resource(ResourceType.RED);
         Resource r6= new Resource(ResourceType.BLUE);
         redPlanetResources.add(r3);
         redPlanetResources.add(r4);

         // BLUE PLANET
         ArrayList<Resource> bluePlanetResources = new ArrayList<>();
         Resource r7 = new Resource(ResourceType.BLACK);
         Resource r8= new Resource(ResourceType.GREEN);
         Resource r9= new Resource(ResourceType.BLUE);
         Resource r10= new Resource(ResourceType.PINK);
         bluePlanetResources.add(r7);
         bluePlanetResources.add(r8);
         bluePlanetResources.add(r9);
         bluePlanetResources.add(r10);


         // filling the member list
         planetTypesAndResources.put(PlanetType.GREEN, greenPlanetResources);
         planetTypesAndResources.put(PlanetType.BLACK, blackPlanetResources);
         planetTypesAndResources.put(PlanetType.RED, redPlanetResources);
         planetTypesAndResources.put(PlanetType.BLUE, bluePlanetResources);
     }

    public static HashMap<PlanetType, ArrayList<Resource>> getPlanetTypesAndResources() {
        return planetTypesAndResources;
    }

    public static ArrayList<Resource> getResourcesForPlanetType(PlanetType planetType){
         ArrayList<Resource> resources = new ArrayList<>();
         for(Resource r : getPlanetTypesAndResources().get(planetType)){
             resources.add(new Resource(r));
         }
         return resources;
    }

}
