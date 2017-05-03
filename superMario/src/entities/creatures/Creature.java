package entities.creatures;

import entities.Entity;
import game.Handler;
import graphics.Assets;
import sounds.Sound;
import tiles.Tile;

public abstract class Creature extends Entity
{

    public static final int DEFAULT_Mario_HEALTH = 1;
    public static final int DEFAULT_SUPERMARIO_HEALTH = 2;
    public static final int DEFAULT_FLOWER_MARIO = 3;
    public static final float DEFAULT_SPEED = 5.0f;
    public static final int DEFAULT_16x16_WIDTH = 64, DEFAULT_16x16_HEIGHT = 64, DEFAULT_32x32_WIDTH = 128, DEFAULT_32x32_HEIGHT = 128;

    protected int minHealth;
    protected int maxHealth;
    protected float speed;
    protected float xMove, yMove;
    protected boolean jumping;
    protected boolean falling;
    protected float gravity;
    protected int score;


    public Creature(Handler handler, float x, float y, int width, int height, int health){
        super(handler, x, y, width, height);
        this.health = health;
        minHealth = 0;
        maxHealth = 3;
        speed = DEFAULT_SPEED;
        xMove = 0;
        yMove = 0;
        jumping = false;
        falling = true;
        gravity = 0.0f;
        score = 0;
    }

    public void move(){
        if(!checkEntityCollisions(xMove, 0f))
            moveX();
        if(!checkEntityCollisions(0f, yMove))
            moveY();
    }

    public void moveX()
    {
        // RIGHT
        if (xMove > 0)
        {
            // Collision detection with right side of bounding box (upper left and right corner)
            int tx = (int) (x + xMove + bounds.x + bounds.width) / Tile.TILEWIDTH;
            // If tile entity collides with is solid do not increment x position.
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
            {
                x += xMove;
            }
            else
            {
                x = tx * Tile.TILEWIDTH - bounds.x - bounds.width - 1;
            }
        }
        // LEFT
        else if (xMove < 0)
        {
            // Collision detection with left side of bounding box
            int tx = (int) (x + xMove + bounds.x) / Tile.TILEWIDTH;
            if (!collisionWithTile(tx, (int) (y + bounds.y) / Tile.TILEHEIGHT) && !collisionWithTile(tx, (int) (y + bounds.y + bounds.height) / Tile.TILEHEIGHT))
            {
                x += xMove;
            }
            else
            {
                x = tx * Tile.TILEWIDTH + Tile.TILEWIDTH - bounds.x;
            }
        }
    }

    public void moveY()
    {
        // UP
        if (yMove < 0)
        {
            // Collision detection with top of bounding box
            int ty = (int) (y + yMove + bounds.y) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
            {
                y += yMove;
            }
            else
            {
                y = ty * Tile.TILEHEIGHT + Tile.TILEHEIGHT - bounds.y;
                handler.getSound().playSound(Sound.boxHitSound);

                if (jumping)
                {
                    jumping = false;
                    gravity = 0.0f;
                    falling = true;
                }
            }
        }
        // DOWN
        if (yMove > 0)
        {
            // Collision detection with bottom of bounding box
            int ty = (int) (y + yMove + bounds.y + bounds.height) / Tile.TILEHEIGHT;

            if (!collisionWithTile((int) (x + bounds.x) / Tile.TILEWIDTH, ty) &&
                    !collisionWithTile((int) (x + bounds.x + bounds.width) / Tile.TILEWIDTH, ty))
            {
                y += yMove;
            }
            else
            {
                y = ty * Tile.TILEHEIGHT - bounds.y - bounds.height - 1;

                // If collision detection stop falling
                if (falling)
                {
                    falling = false;
                }
            }
        }
        else
        {
            // If yMove == 0 set falling to true
            if (!falling && !jumping)
            {
                gravity = 0.0f;
                falling = true;
            }
        }
    }

    protected boolean collisionWithTile(int x, int y)
    {
        return handler.getWorld().getTile(x, y).isSolid();
    }


    public void playerGravity()
    {
        yMove = 0;

        if(jumping){
            gravity -= 1.0;
            yMove = (-gravity);
            if(gravity<=0.0){
                jumping = false;
                falling = true;
            }
        }
        if(falling){
            gravity += 1.0;
            yMove = gravity;
        }

        if(handler.getKeyManager().jump && !falling && !jumping) {
            jumping = true;
            falling = false;
            gravity = 25.0f;
            handler.getSound().playSound(Sound.marioJumpSound);
        }
    }

    public void bowserGravity()
    {
        yMove = 0;

        if(jumping){
            gravity -= 0.3;
            yMove = (-gravity);
            if(gravity<=0.0){
                jumping = false;
                falling = true;
            }
        }
        if(falling){
            gravity += 0.15;
            yMove = gravity;
        }

        if(!falling && !jumping) {
            jumping = true;
            falling = false;
            gravity = 9.0f;
            //handler.getSound().playSound(Sound.marioJumpSound);
        }
    }

    public void enemyGravity()
    {
        yMove = 0;

        if(falling){
            gravity += 1.0;
            yMove = gravity;
        }
    }

    //GETTERS AND SETTERS

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

    public boolean isJumping()
    {
        return jumping;
    }

    public void setJumping(boolean jumping)
    {
        this.jumping = jumping;
    }

    public boolean isFalling()
    {
        return falling;
    }

    public void setFalling(boolean falling)
    {
        this.falling = falling;
    }

    public float getGravity()
    {
        return gravity;
    }

    public void setGravity(float gravity)
    {
        this.gravity = gravity;
    }

    public int getMinHealth()
    {
        return minHealth;
    }

    public void setMinHealth(int minHealth)
    {
        this.minHealth = minHealth;
    }

    public int getMaxHealth()
    {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth)
    {
        this.maxHealth = maxHealth;
    }

    public int getScore()
    {
        return score;
    }

    public void setScore(int score)
    {
        this.score = score;
    }
}
