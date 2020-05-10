package logic.data.movables;

import logic.Logs;
import logic.data.geometry.Point;

public class MovableFighting extends Movable {

    protected int health;
    protected boolean isDead;

    protected MovableFighting(Point position, int health) {
        super(position);

        this.health = health;
        isDead = false;
    }

    protected void fight(MovableFighting mov) { }

    protected void decreaseHealth() {
        if(isDead) return;
        health--;
        Logs.putLog("Health decreased to " + health);
        if (health == 0) {
            Logs.putLog("Object is dead");
            isDead = true;
        }
    }

    public int getHealth() {
        return health;
    }

    public boolean isDead() {
        return isDead;
    }
}
