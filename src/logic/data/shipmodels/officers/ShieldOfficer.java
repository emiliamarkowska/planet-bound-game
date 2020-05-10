package logic.data.shipmodels.officers;

import logic.data.shipmodels.systems.ShieldSystem;

public class ShieldOfficer extends Officer {
    private ShieldSystem shieldSystem;
    public ShieldOfficer(ShieldSystem shieldSystem){
        this.positionInShip = 3;
        this.shieldSystem = shieldSystem;
    }

    @Override
    public void disableSystem(){
        this.shieldSystem.setEnabled(false);
    }

    public void enableSystem(){
        this.shieldSystem.setEnabled(true);
    }
}
