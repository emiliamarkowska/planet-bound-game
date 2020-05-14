package logic.data.shipmodels.officers;

import logic.Logs;
import logic.data.shipmodels.systems.ShieldSystem;

public class ShieldOfficer extends Officer {
    private ShieldSystem shieldSystem;
    public ShieldOfficer(ShieldSystem shieldSystem, Logs logs){
        super(logs);
        this.positionInShip = 3;
        this.shieldSystem = shieldSystem;
    }

    @Override
    public void disableSystem(){
        this.shieldSystem.setEnabled(false);
        logs.putLog("Shield system disabled");
    }

    public void enableSystem(){
        this.shieldSystem.setEnabled(true);
        logs.putLog("Shield system enabled");
    }
}
