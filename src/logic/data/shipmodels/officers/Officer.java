package logic.data.shipmodels.officers;

import logic.data.shipmodels.systems.System;

public class Officer {
    protected int positionInShip;

    protected int getPositionInShip(){
        return this.positionInShip;
    }
    public void disableSystem(){}
    public void enableSystem(){}
}
