package gui;

import logic.PlanetBound;
import logic.data.Log;
import logic.data.movables.Resource;
import logic.data.shipmodels.ResourceType;
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

    }
    private void awaitMoveStateGUI(){

    }
    private void awaitFinishExplorationStateGUI(){

    }

    private void awaitBuyStateGUI(){

    }
    private void waitingForReturnConfirmationGUI(){

    }
    private void gameOverStateGUI(){

    }
    private void gameLostGUI(){

    }

    private void gameOverGUI() {

    }



}
