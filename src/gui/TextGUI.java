package gui;

import logic.PlanetBound;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.UsableResourceType;
import logic.states.*;

import java.util.Scanner;

public class TextGUI {

    PlanetBound logic;
    boolean exit;
    public TextGUI() {
        logic = new PlanetBound();
        exit = false;
    }

    public void run() {
        while(!exit){
            if(logic.getState() instanceof AwaitShipSelectionState) awaitShipSelectionGUI();
            else if(logic.getState() instanceof AwaitMoveState) awaitMoveStateGUI();
            else if(logic.getState() instanceof AwaitFinishExplorationState) awaitFinishExplorationStateGUI();
            else if(logic.getState() instanceof AwaitBuyState) awaitBuyStateGUI();
            else if(logic.getState() instanceof GameOverState) gameOverStateGUI();
        }
    }

    private void awaitShipSelectionGUI(){
        displayLogs();
        System.out.println("Welcome in Planet Bound Game! \n");
        System.out.println("Select the ship to explore the galaxy: ");
        System.out.println("1. Military Ship");
        System.out.println("2. Mining Ship");

        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();

        switch(choice){
            case 1:
                logic.chooseShip(false);
                break;
            case 2:
                logic.chooseShip(true);
                break;
        }
    }
    private void awaitMoveStateGUI(){
        displayLogs();
        Scanner scanner = new Scanner(System.in);
        if(logic.getPlanetBoundData().getPlanet().hasSpaceStation()){
            System.out.println("You have landed on planet with space station, following actions are allowed: ");
            System.out.println("1. Explore planet");
            System.out.println("2. Visit space station");
            System.out.println("3. Go to another planet");
            System.out.println("4. Get ship state");

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    logic.explorePlanet();
                    break;
                case 2:
                    logic.exploreSpaceStation();
                    break;
                case 3:
                    logic.lookForAnotherPlanet();
                    break;
                case 4:
                    getShipState();
                    break;
            }
        }
        else{
            System.out.println("You have landed on planet without space station, following actions are allowed: ");
            System.out.println("1. Explore planet");
            System.out.println("2. Go to another planet");
            System.out.println("3. Get ship state");

            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    logic.explorePlanet();
                    break;
                case 2:
                    logic.lookForAnotherPlanet();
                    break;
                case 3:
                    getShipState();
                    break;
            }
        }


    }

    private void awaitFinishExplorationStateGUI(){
        displayLogs();
        System.out.println("Planet exploration phase begins");
        System.out.println(" W - to move up");
        System.out.println(" A - to move left");
        System.out.println(" S - to move down");
        System.out.println(" D - to move right");

        Scanner scanner = new Scanner(System.in);
        char move = scanner.next().charAt(0);

        switch(move){
            case 'w':
                logic.goUp();
                break;
            case 'a':
                logic.goLeft();
                break;
            case 's':
                logic.goDown();
                break;
            case 'd':
                logic.goRight();
                break;
        }

    }

    private void awaitBuyStateGUI(){
        displayLogs();
        System.out.println("Space station visited, chose action to perform: ");
        System.out.println("1. Upgrade cargo ");
        System.out.println("2. Convert resource ");
        System.out.println("3. Hire crew ");
        System.out.println("4. Upgrade weapon system ");
        System.out.println("5. Fill shield ");
        System.out.println("6. Buy new drone");
        System.out.println("7. Convert to ship resources");
        System.out.println("8. Back to orbit");

        Scanner scanner = new Scanner(System.in);

        int option = scanner.nextInt();

        switch (option){
            case 1:
                logic.upgradeCargo();
                break;
            case 2:
                System.out.println("From resource: 1. BLACK, 2. BLUE, 3. RED, 4. GREEN");
                int from = scanner.nextInt();
                ResourceType fromResourceType;
                switch (from){
                    case 1:
                        fromResourceType = ResourceType.BLACK;
                        break;
                    case 2:
                        fromResourceType = ResourceType.BLUE;
                        break;
                    case 3:
                        fromResourceType = ResourceType.RED;
                        break;
                    case 4:
                        fromResourceType = ResourceType.GREEN;
                        break;
                        default:
                            fromResourceType = ResourceType.GREEN;
                            break;
                }
                System.out.println("To resource: 1. BLACK, 2. BLUE, 3. RED, 4. GREEN");
                int to = scanner.nextInt();
                ResourceType toResourceType;

                switch (to){
                    case 1:
                        toResourceType = ResourceType.BLACK;
                        break;
                    case 2:
                        toResourceType = ResourceType.BLUE;
                        break;
                    case 3:
                        toResourceType = ResourceType.RED;
                        break;
                    case 4:
                        toResourceType = ResourceType.GREEN;
                        break;
                    default:
                        toResourceType = ResourceType.GREEN;
                        break;
                }
                logic.exchangeResource(fromResourceType, toResourceType);
                break;
            case 3:
                logic.addCrewMember();
                break;
            case 4:
                logic.upgradeWeapon();
                break;
            case 5:
                logic.repairShip();
                break;
            case 6:
                logic.repairDrone();
                break;
            case 7:
                System.out.println("Which ship resource you want to produce: 1. Fuel 2. Shield 3. Ammo");
                int resource = scanner.nextInt();
                UsableResourceType toResource;

                switch (resource){
                    case 1:
                        toResource = UsableResourceType.FUEL;
                        break;
                    case 2:
                        toResource = UsableResourceType.SHIELD;
                        break;
                    case 3:
                        toResource = UsableResourceType.AMMO;
                        break;
                        default:
                            toResource = UsableResourceType.FUEL;
                            break;
                }

                System.out.println("How much of resource you want to produce? ");
                int amount = scanner.nextInt();
                logic.convertToShipResources(toResource, amount);
                break;
            case 8:
                logic.exploreSpace();
                break;
        }

    }

    private void gameOverStateGUI(){
        displayLogs();
        Scanner scanner = new Scanner(System.in);
        if(((GameOverState)logic.getState()).isHasWon())
            System.out.println("You have won the game");
        else System.out.println("You have lost the game");

        System.out.println("Do you want to play again? y/n");
        char option = scanner.next().charAt(0);

        switch(option){
            case 'y':
                logic.restartGame();
                break;
            case 'n':
                    exit = true;
                    break;
        }

    }

    public void displayLogs(){
        for (String s : logic.getPlanetBoundData().getLogs().currentLogs())
            System.out.println(s);
    }

    private void getShipState() {
        System.out.println("Ship state: ");
        System.out.println("Black resource: " + logic.getPlanetBoundData().getShip().getCargoSystem().getBlackAmount() +
                " out of " +logic.getPlanetBoundData().getShip().getCargoSystem().getMaxAmount());
        System.out.println("Red resource: " + logic.getPlanetBoundData().getShip().getCargoSystem().getRedAmount() +
                " out of " +logic.getPlanetBoundData().getShip().getCargoSystem().getMaxAmount());
        System.out.println("Blue resource: " + logic.getPlanetBoundData().getShip().getCargoSystem().getBlueAmount() +
                " out of " +logic.getPlanetBoundData().getShip().getCargoSystem().getMaxAmount());
        System.out.println("Green resource: " + logic.getPlanetBoundData().getShip().getCargoSystem().getGreenAmount() +
                " out of " +logic.getPlanetBoundData().getShip().getCargoSystem().getMaxAmount());
        System.out.println("Artifacts: "  + logic.getPlanetBoundData().getShip().getCargoSystem().getArtifacts());
        System.out.println("Ammo: " + logic.getPlanetBoundData().getShip().getWeaponSystem().getAmmo() +
                " out of " + logic.getPlanetBoundData().getShip().getWeaponSystem().getMaxAmount());
        System.out.println("Shields: "+ logic.getPlanetBoundData().getShip().getShieldSystem().getShields() +
                " out of " + logic.getPlanetBoundData().getShip().getShieldSystem().getMaxAmount());
        System.out.println("Fuel: " + logic.getPlanetBoundData().getShip().getFuelSystem().getFuel() +
                " out of " + logic.getPlanetBoundData().getShip().getFuelSystem().getMaxAmount());
        System.out.println("Crew: " + logic.getPlanetBoundData().getShip().getOfficers().size() +
                " out of 6");
        System.out.println("Is drone available: " + !logic.getPlanetBoundData().getShip().getDrone().isDead());

    }



}
