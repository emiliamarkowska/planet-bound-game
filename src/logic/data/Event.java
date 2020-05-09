package logic.data;

import logic.Dice;
import logic.data.shipmodels.ResourceType;
import logic.data.shipmodels.Ship;

import java.util.concurrent.ThreadLocalRandom;

public class Event {

    EventTypes eventType;
    LogRecorder logRecorder;

    public Event(EventTypes eventType, LogRecorder logRecorder) {
        this.eventType = eventType;
        this.logRecorder = logRecorder;
    }

    public Event(LogRecorder logRecorder) {
        this.eventType = EventTypes.randomEvent();
        this.logRecorder = logRecorder;
    }

    public void runSpecificEvent(Ship ship) {
        switch(this.eventType) {

            case CREW_DEATH:
                ship.killOneCrewMember();
                logRecorder.addLog("A crew member has died due to a system malfunction.");
                break;
            case SALVAGE_SHIP:
                int amount = Dice.throwd6();
                ResourceType rt = ship.getCargoSystem().addRandomResource(amount);
                logRecorder.addLog("Your ship came across an abandoned ship and found " + amount + " " + rt + " resource.");
                break;
            case CARGO_LOSS:
                int rand = ThreadLocalRandom.current().nextInt(0, 3);
                int amount2 = Dice.throwd3();
                switch (rand) {
                    case 0:
                        ship.getCargoSystem().loseBlackResource(amount2);
                        logRecorder.addLog("A cargo mishap caused you to lose " + amount2 + " of " + ResourceType.BLACK + " resource.");
                        break;
                    case 1:
                        ship.getCargoSystem().loseBlueResource(amount2);
                        logRecorder.addLog("A cargo mishap caused you to lose " + amount2 + " of " + ResourceType.BLUE + " resource.");
                        break;
                    case 2:
                        ship.getCargoSystem().loseRedResource(amount2);
                        logRecorder.addLog("A cargo mishap caused you to lose " + amount2 + " of " + ResourceType.RED + " resource.");
                        break;
                    case 3:
                        ship.getCargoSystem().loseGreenResource(amount2);
                        logRecorder.addLog("A cargo mishap caused you to lose " + amount2 + " of " + ResourceType.GREEN + " resource.");
                        break;
                }
                break;
            case FUEL_LOSS:
                ship.getFuelSystem().spendFuel(1);
                logRecorder.addLog("You accidentally used too much fuel in a test run and lost one additional fuel cell.");
                break;
            case NO_EVENT:
                break;
            case CREW_RESCUE:
                ship.hireOneCrewMember();
                logRecorder.addLog("You have found a ship in distress with a lone crew member.");
                switch(ship.getCrewAmount()){
                    case 4:
                        ship.getShieldSystem().setAvailable(true);
                        break;
                    case 5:
                        ship.getWeaponSystem().setAvailable(true);
                        break;
                    case 6:
                        ship.getCargoSystem().setAvailable(true);
                        break;
                }
                break;
        }
    }

}
