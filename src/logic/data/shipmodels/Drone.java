package logic.data.shipmodels;

public class Drone {
    private boolean isDestroyed;
    private int health;

    private int x;
    private int y;

    public Drone() {
        this.x = 0;
        this.y = 0;

        health = 6;
        isDestroyed = false;
    }

    public void deployDrone(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void returnDrone() {
        health = 6;
        this.x = 0;
        this.y = 0;
    }

    public void damageDrone() {
        health--;
        if (health == 0) destroyDrone();
    }

    public void destroyDrone() {
        isDestroyed = true;
    }

    public void repairDrone() {
        isDestroyed = false;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getHealth() {
        return health;
    }

    public boolean isDestroyed() {
        return isDestroyed;
    }

    public void setXY(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void moveUp(){
        if(this.y - 1 >= 1) this.y--;
    }

    public void moveDown(){
        if(this.y + 1 <= 6) this.y++;
    }

    public void moveLeft(){
        if(this.x - 1 >= 1) this.x--;
    }

    public void moveRight(){
        if(this.x + 1 <= 6) this.x++;
    }


}
