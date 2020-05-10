package logic.data.movables;

import logic.Point;

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
        health--;
    }

}
