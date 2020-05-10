package logic.data.shipmodels.systems;

public class System {
    protected boolean isAvailable;
    protected boolean isMining;
    protected int maxAmount;

    protected System(boolean isMining){
        this.isAvailable = true;
        this.isMining = isMining;
    }

    public boolean isAvailable(){
        return this.isAvailable;
    }
    public void setAvailable(boolean available){ this.isAvailable = available; }
    public int getMaxAmount(){
        return this.maxAmount;
    }
}
