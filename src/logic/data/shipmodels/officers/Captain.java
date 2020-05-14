package logic.data.shipmodels.officers;

import logic.Logs;

public class Captain extends Officer{
    public Captain(Logs logs){
        super(logs);
        this.positionInShip = 0;
    }
}
