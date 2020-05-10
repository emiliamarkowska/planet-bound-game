package gui;

import logic.PlanetBound;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;
import logic.states.*;

import java.util.Scanner;

public class TextGUI {

    PlanetBound gl;
    boolean exit;
    public TextGUI() {
        gl = new PlanetBound();
        exit = false;
    }

    public void run() {
        while(!exit){
            if(gl.getState() instanceof AwaitShipSelectionState) shipSelectionGUI();
            else if(gl.getState() instanceof AwaitMoveState) spaceTravelGUI();
            else if(gl.getState() instanceof AwaitFinishExplorationState) atPlanetGUI();
            else if(gl.getState() instanceof AwaitBuyState) atSpaceStationGUI();
            else if(gl.getState() instanceof WaitingForReturnConfirmationState) waitingForReturnConfirmationGUI();
            else if(gl.getState() instanceof GameOverState) gameWonGUI();
            else if(gl.getState() instanceof GameLostState) gameLostGUI();
        }
    }

    private void shipSelectionGUI(){
        printLastLogs();
        Scanner s = new Scanner(System.in);
        System.out.println("Welcome to Planet Bound!\n");
        System.out.println("Select type of your ship:");
        System.out.println("1. Military");
        System.out.println("2. Mining");
        System.out.println("0. Exit");

        int selection = clearBufforAndGetInput(s);
        switch(selection) {
            case 1:
                gl.chooseShip(true);
                break;
            case 2:
                gl.chooseShip(false);
                break;
            case 0:
                exit = true;
                break;
        }
    }
    private void spaceTravelGUI(){
        printLastLogs();
        Scanner s = new Scanner(System.in);
        System.out.println("You are in space.");
        System.out.println("Planet type " + gl.getPlanetBoundData().getPlanet().getPlanetType() + " underneath you has the following resources left: " + showResources());
        if (gl.getPlanetBoundData().getPlanet().hasSpaceStation()) System.out.println("There is a space station here.");
        else System.out.println("There is no space station here.");
        showStatus();
        System.out.println("\n");
        System.out.println("1. Explore planet");
        System.out.println("2. Travel to next region");
        System.out.println("3. Produce");
        if (gl.getPlanetBoundData().getPlanet().hasSpaceStation()) System.out.println("4. Go to Space Station");
        System.out.println("0. Exit");

        int selection = clearBufforAndGetInput(s);
        switch(selection) {
            case 1:
                gl.explorePlanet();
                break;
            case 2:
                gl.goToNextRegion();
                break;
            case 3:
                System.out.println("Which resource you want to produce? a - ammo [BLACK, BLUE], f - fuel [BLACK, RED, GREEN], s - shield [BLACK, GREEN, BLUE]");
                Scanner s1 = new Scanner(System.in);
                char choice = s1.next().charAt(0);
                System.out.println("How much of resource you want to produce?");
                int amount = clearBufforAndGetInput(s);
                switch (choice){
                    case 'a':
                      gl.produceAmmo(amount);
                      break;
                    case 'f':
                        gl.produceFuel(amount);
                        break;
                    case 's':
                        gl.produceShield(amount);
                        break;
                }
                break;
            case 4:
                if (gl.getPlanetBoundData().getPlanet().hasSpaceStation()) gl.goToSpaceStation();
                break;
            case 0:
                exit = true;
                break;
        }
    }
    private void atPlanetGUI(){
        printLastLogs();
        Scanner s = new Scanner(System.in);
        System.out.println("You are at the planet surface.");
        System.out.println("Planet has resource type " + gl.getPlanetBoundData().getExLogic().getResource().getResourceType() + "\n");

        System.out.print("\n");
        gl.getPlanetBoundData().getExLogic().drawGrid();
        System.out.print("\n");

        System.out.println("w - Move up");
        System.out.println("a - Move left");
        System.out.println("s - Move down");
        System.out.println("d - Move right");
        System.out.println("0. Exit");

        char selection = s.next().charAt(0);
        switch(selection) {
            case 'w':
                gl.goUp();
                printLastLogs();
                break;
            case 'a':
                gl.goLeft();
                printLastLogs();
                break;
            case 's':
                gl.goDown();
                printLastLogs();
                break;
            case 'd':
                gl.goRight();
                printLastLogs();
                break;
            case '0':
                exit = true;
                break;
        }

    }

    private void atSpaceStationGUI(){
        printLastLogs();
        Scanner s = new Scanner(System.in);
        showStatus();
        System.out.println("\n");
        System.out.println("You are at Space Station. You can perfom one action:\n");
        System.out.println("1. Upgrade cargo [RED, BLUE, BLACK, GREEN]");
        System.out.println("2. Convert resource");
        System.out.println("3. Hire new crew member [RED, BLUE, BLACK, GREEN]");
        System.out.println("4. Upgrade weapon system [3 RED, 3 BLUE, 3 BLACK, 3 GREEN]");
        System.out.println("5. Replenish armor [RED, BLUE, BLACK, GREEN]");
        System.out.println("6. Buy a new drone [3 RED, 3 BLUE, 3 BLACK, 3 GREEN]");
        System.out.println("0. Exit");

        int selection = clearBufforAndGetInput(s);
        switch(selection) {
            case 1:
                gl.upgradeCargo();
                break;
            case 2:
                System.out.println("From resource:");
                Resource r1 = getResources();
                System.out.println("To resource:");
                Resource r2 = getResources();
                gl.convertResource(r1, r2);
                break;
            case 3:
                gl.hireCrew();
                break;
            case 4:
                gl.upgradeWeaponSystem();
                break;
            case 5:
                gl.replenishArmor();
                break;
            case 6:
                gl.buyNewDrone();
                break;
            case 0:
                exit = true;
                break;
        }
    }
    private void waitingForReturnConfirmationGUI(){
        printLastLogs();
        System.out.println("Are you sure you want to return?");
        if (gl.getPlanetBoundData().getExLogic().isResourceInDrone())
            System.out.println("You have gathered resources\n");
        else System.out.println("You have not gathered any resources\n");

        Scanner s = new Scanner(System.in);
        System.out.println("1. Stay on the planet");
        System.out.println("2. Return to the ship");
        System.out.println("0. Exit");

        int selection = clearBufforAndGetInput(s);
        switch(selection) {
            case 1:
                gl.declineReturn();
                break;
            case 2:
                gl.acceptReturn();
                break;
            case 0:
                exit = true;
                break;
        }
    }
    private void gameWonGUI(){
        printLastLogs();
        System.out.println("You have won the game!:\n");
        gameOverGUI();
    }
    private void gameLostGUI(){
        printLastLogs();
        System.out.println("You have lost the game.:\n");
        gameOverGUI();
    }

    private void gameOverGUI() {
        Scanner s = new Scanner(System.in);
        System.out.println("1. Play again");
        System.out.println("0. Exit");

        int selection = clearBufforAndGetInput(s);
        switch(selection) {
            case 1:
                gl.playAgain();
                break;
            case 0:
                exit = true;
                break;
        }
    }

    private int clearBufforAndGetInput(Scanner s) {
        while (!s.hasNextInt()) {
            s.next();
        }
        return s.nextInt();
    }

    private Resource getResources() {
        System.out.println("Available resources: 1. BLACK, 2. BLUE, 3. RED, 4.GREEN");
        Scanner s = new Scanner(System.in);
        int selection = clearBufforAndGetInput(s);
        switch(selection) {
            case 1:
                return new Resource(ResourceType.BLACK);
            case 2:
                return new Resource(ResourceType.BLUE);
            case 3:
                return new Resource(ResourceType.RED);
            case 4:
                return new Resource(ResourceType.GREEN);
            default:
                return new Resource(ResourceType.BLACK);

        }
    }

    private void showStatus() {
        int maxResource = gl.getPlanetBoundData().getShip().getCargoSystem().getCurrentMaxResourceAmount();
        int currentFuel = gl.getPlanetBoundData().getShip().getFuelSystem().getFuelAmount();
        int maxFuel = gl.getPlanetBoundData().getShip().getFuelSystem().getMaxFuelAmount();
        int currentShield = gl.getPlanetBoundData().getShip().getShieldSystem().getShieldsAmount();
        int maxShield = gl.getPlanetBoundData().getShip().getShieldSystem().getMaxShieldsAmount();
        int currentWeapon = gl.getPlanetBoundData().getShip().getWeaponSystem().getWeapons();
        int maxWeapon = gl.getPlanetBoundData().getShip().getWeaponSystem().getMaxWeapons();

        System.out.println("Resources: BLACK " + gl.getPlanetBoundData().getShip().getCargoSystem().getBlackResourceAmount() + "/" + maxResource +
        " BLUE " + gl.getPlanetBoundData().getShip().getCargoSystem().getBlueResourceAmount() + "/" + maxResource +
        " RED " + gl.getPlanetBoundData().getShip().getCargoSystem().getRedResourceAmount() + "/" + maxResource +
        " GREEN " + gl.getPlanetBoundData().getShip().getCargoSystem().getGreenResourceAmount() + "/" + maxResource +
                " Crew: " + gl.getPlanetBoundData().getShip().getCrewAmount() +
                " Artifacts: " + gl.getPlanetBoundData().getShip().getAmountOfArtifacts() +
                " Fuel: " + currentFuel + "/" + maxFuel +
                " Shield: " + currentShield + "/" + maxShield +
                " Weapon: " + currentWeapon + "/" + maxWeapon +
                " Drone: " + isDroneAvailable()
        );
    }

    private void printLastLogs() {
        for (Log log : gl.getPlanetBoundData().getLogRecorder().getUnreadLogs()) {
            System.out.println(log);
        }
    }

    private String isDroneAvailable() {
        if (gl.getPlanetBoundData().getShip().getDrone().isDestroyed()) return "no";
        return "yes";
    }

    private String showResources() {
        String resString = "";
        for (Resource r : gl.getPlanetBoundData().getPlanet().getResources()) {
            resString += r.getResourceType() + " ";
        }
        return resString;
    }

}
