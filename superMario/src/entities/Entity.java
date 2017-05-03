package entities;

import entities.creatures.Bowser;
import entities.creatures.Goomba;
import entities.creatures.GreenKoopaTroopa;
import entities.creatures.Mario;
import game.Handler;
import sounds.Sound;
import states.State;
import utils.Utils;

import java.awt.*;

public abstract class Entity {

    // x and y is the position on the screen
    protected Handler handler;
    protected float x, y;
    protected int width, height;
    protected Rectangle bounds;
    protected int health;
    protected boolean active = true;

    public Entity(Handler handler, float x, float y, int width, int height){
        this.handler = handler;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        bounds = new Rectangle(0, 0, width, height);
    }

    public abstract void tick();
    public abstract void render(Graphics g);

    public abstract void die();

    public void hurt(int amount){
        health -= amount;
        if(health <= 0){
            active = false;
        }
        die();
    }


    public boolean checkEntityCollisions(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;

            // Check if entities collision bounds intersect with where mario's future collision bounds.
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
            {
                //handler.getWorld().getEntityManager().getMario().setHealth(handler.getWorld().getEntityManager().getMario().getHealth() - 1);
                //handler.getWorld().getEntityManager().getEntities().add(0, handler.getWorld().getEntityManager().getEntities().size());

                //handler.getWorld().getEntityManager().getEntities().remove(e);

                // Save score
                Utils.writeFile("res/worlds/savefile.txt", Integer.toString(handler.getWorld().getEntityManager().getMario().getScore()));
                handler.getSound().playSound(Sound.marioDieSound);
                try {
                    Thread.sleep(3000);
                } catch(InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
                handler.getKeyManager().pause = true;
                State.setState(handler.getGame().menuState);
                //handler.getWorld().getEntityManager().addEntity
                //       (new Mario(handler, e.getX() + 70, e.getY(), 1));
                //handler.getWorld().getEntityManager().getEntities().
                //      set(0, handler.getWorld().getEntityManager().getEntities().get(handler.getWorld().getEntityManager().getEntities().size() - 1));

                //System.out.println(handler.getWorld().getEntityManager().getEntities().size());


                return true;

            }
        }
        return false;
    }

    public boolean checkEntityCollisionPlayer(float xOffset, float yOffset){
        for(Entity e : handler.getWorld().getEntityManager().getEntities())
        {
            if(e.equals(this))
                continue;
            // Check if entities collision bounds intersect with where mario's future collision bounds.
            if (e.getCollisionBounds(0f, 0f).intersects(getCollisionBounds(xOffset, yOffset)))
            {
                // Bottom collision
                if (handler.getWorld().getEntityManager().getMario().getyMove() > 0 && handler.getWorld().getEntityManager().getMario().isFalling())
                {
                    handler.getWorld().getEntityManager().getMario().setFalling(false);
                    handler.getWorld().getEntityManager().getMario().setJumping(true);
                    handler.getWorld().getEntityManager().getMario().setGravity(15.0f);
                    handler.getWorld().getEntityManager().getEntities().remove(e);

                    handler.getSound().playSound(Sound.jumpHitSound);

                    handler.getWorld().getEntityManager().getMario().setScore(handler.getWorld().getEntityManager().getMario().getScore() + 100);

                    // TODO SCORE
                    // SCORE
                    Utils.writeFile("res/worlds/savefile.txt", Integer.toString(handler.getWorld().getEntityManager().getMario().getScore()));

                    System.out.println("Collision bottom");
                }

                // Top collision
                if (handler.getWorld().getEntityManager().getMario().getyMove() < 0 && !handler.getWorld().getEntityManager().getMario().isFalling())
                {
                    handler.getWorld().getEntityManager().getMario().setJumping(false);
                    handler.getWorld().getEntityManager().getMario().setFalling(true);
                    handler.getWorld().getEntityManager().getMario().setGravity(0.0f);
                    handler.getWorld().getEntityManager().getMario().setHealth(handler.getWorld().getEntityManager().getMario().getHealth()-1);


                    // TODO SCORE
                    // Save score
                    Utils.writeFile("res/worlds/savefile.txt", Integer.toString(handler.getWorld().getEntityManager().getMario().getScore()));

                    System.out.println("collision top");
                }
                // Left collision
                else if (handler.getWorld().getEntityManager().getMario().getxMove() <= 0 && handler.getWorld().getEntityManager().getMario().isFalling())
                {
                    handler.getWorld().getEntityManager().getMario().setJumping(false);
                    handler.getWorld().getEntityManager().getMario().setFalling(true);
                    handler.getWorld().getEntityManager().getMario().setGravity(0.0f);
                    handler.getWorld().getEntityManager().getMario().setHealth(handler.getWorld().getEntityManager().getMario().getHealth()-1);
                    System.out.println("Collision left");
                }

                // Right collision
                else if (handler.getWorld().getEntityManager().getMario().getxMove() > 0 && handler.getWorld().getEntityManager().getMario().isFalling())
                {
                    handler.getWorld().getEntityManager().getMario().setJumping(false);
                    handler.getWorld().getEntityManager().getMario().setFalling(true);
                    handler.getWorld().getEntityManager().getMario().setGravity(0.0f);
                    handler.getWorld().getEntityManager().getMario().setHealth(handler.getWorld().getEntityManager().getMario().getHealth()-1);

                    System.out.println("Collision right");
                    System.out.println(handler.getWorld().getEntityManager().getMario().getHealth());
                }

                return true;
            }
        }
        return false;
    }


    public Rectangle getCollisionBounds(float xOffset, float yOffset){
        return new Rectangle((int) (x + bounds.x + xOffset), (int) (y + bounds.y + yOffset), bounds.width, bounds.height);
   }


    // Getters and Setters


    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
