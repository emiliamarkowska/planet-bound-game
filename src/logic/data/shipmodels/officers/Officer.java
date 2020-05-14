package logic.data.shipmodels.officers;

import logic.Logs;
import logic.data.shipmodels.systems.System;

public class Officer {
    protected int positionInShip;
    protected Logs logs;

    public Officer(Logs logs){
        this.logs = logs;
    }
    protected int getPositionInShip(){
        return this.positionInShip;
    }
    public void disableSystem(){}
    public void enableSystem(){}
}
