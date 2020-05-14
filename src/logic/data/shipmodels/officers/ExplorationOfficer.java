package logic.data.shipmodels.officers;

import logic.Logs;

public class ExplorationOfficer extends Officer{
    public ExplorationOfficer(Logs logs){
        super(logs);
        this.positionInShip = 2;
    }
}
