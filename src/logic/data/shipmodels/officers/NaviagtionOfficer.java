package logic.data.shipmodels.officers;

import logic.Logs;

public class NaviagtionOfficer extends Officer {
    public NaviagtionOfficer(Logs logs){
        super(logs);
        this.positionInShip = 1;
    }
}
