package entities.creatures;

import entities.Entity;
import handler.Game;
import handler.Handler;

public abstract class Creature extends Entity
{

    public static final int DEFAULT_HEALTH = 1;
    public static final float DEFAULT_SPEED = 3.0f;
    public static final int DEFAULT_MARIO_WIDTH = 64, DEFAULT_MARIO_HEIGHT = 64;

    protected int health;
    protected float speed;
    protected float xMove, yMove;

    public Creature(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
        health = DEFAULT_HEALTH;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
    }

    public void move(){
        x += xMove;
        y += yMove;
    }


    //GETTERS AND SETTERS

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

    public float getxMove() {
        return xMove;
    }

    public void setxMove(float xMove) {
        this.xMove = xMove;
    }

    public float getyMove() {
        return yMove;
    }

    public void setyMove(float yMove) {
        this.yMove = yMove;
    }
}
