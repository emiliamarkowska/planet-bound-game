package logic.data.shipmodels.officers;

import logic.Logs;

public class NavigationOfficer extends Officer {
    public NavigationOfficer(Logs logs){
        super(logs);
        this.positionInShip = 1;
    }
}
