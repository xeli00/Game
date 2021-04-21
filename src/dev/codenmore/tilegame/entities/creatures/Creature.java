package dev.codenmore.tilegame.entities.creatures;

import dev.codenmore.tilegame.entities.Entity;

public abstract class Creature extends Entity{
    
    public static final int DEFAULT_HEALTH = 10;
    public static final int DEFAULT_SPEED = 5;
    public static final int DEFAULT_CREATURE_WIDTH = 64;
    public static final int DEFAULT_CREATURE_HEIGHT = 64;
    
    protected int health;
    protected float speed;
    protected float xMove,yMove;

    public float getxMove() {
        return xMove;
    }

    public void setxMove(double d) {
        this.xMove = (float) d;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(double d) {
        this.yMove = (float) d;
    }

    public Creature(float x, float y, int width, int height) {
        super(x, y, width, height);
        health=this.DEFAULT_HEALTH;
        speed=this.DEFAULT_SPEED;
        xMove=0;
        yMove=y;
    }
    
    public void move() {
        x += xMove;
        y += yMove;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
