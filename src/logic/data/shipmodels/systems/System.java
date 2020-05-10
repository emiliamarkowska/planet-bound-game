package logic.data.shipmodels.systems;

public class System {
    protected boolean isEnabled;
    protected boolean isMiningShip;
    protected int maxAmount;

    protected System(boolean isMiningShip){
        this.isEnabled = true;
        this.isMiningShip = isMiningShip;
    }

    public boolean isEnabled(){
        return this.isEnabled;
    }
    public void setEnabled(boolean enabled){ this.isEnabled = enabled; }
    public int getMaxAmount(){
        return this.maxAmount;
    }
}
