package entities.creatures;


import entities.Entity;
import game.Handler;
import graphics.Animation;
import graphics.Assets;
import tiles.Tile;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mario extends Creature {

    //Animations
    private Animation animMarioRight, animMarioLeft;

    public Mario(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT);
        animMarioRight = new Animation(70, Assets.marioRightMove);
        animMarioLeft = new Animation(70, Assets.marioLeftMove);
        bounds.x = 4;
        bounds.y = 4;
        bounds.width = 60;
        bounds.height = 60;
    }

    @Override
    public void tick()
    {
        //Animations
        animMarioRight.tick();
        animMarioLeft.tick();

        //Movements
        getInput();
        handler.getGameCamera().centerOnEntity(this);

       /*
        if(checkEntityCollisions(xMove, 0f))
            moveX();

        if (checkEntityCollisions(0f, yMove))
        {
            // Collision with top of entity
            if (yMove > 0)
            {
                jumping = true;
                falling = false;
                gravity = 15.0f;
            }
        }
        else
        {
            moveY();
        }
        */
        if(!checkEntityCollisionPlayer(xMove, 0f))
            moveX();
        if(!checkEntityCollisionPlayer(0f, yMove)){
            moveY();
        }
    }

    /*
    public boolean checkEntityCollision()
    {
        for (Entity e : handler.getWorld().getEntityManager().getEntities())
        {
            if (e.equals(this))
            {
                continue;
            }

            // Collision with top
            if (getBoundsTop().intersects(e.getBounds()))
            {
                yMove = 0;
                // y verdi til den vi kolliderer med + høyden slik at y verdi til mario blir rett ved siden av og ikke er stuck.
                if (jumping)
                {
                    jumping = false;
                    falling = true;
                    gravity = 0.0f;
                }
                else
                {
                    if (!falling && !jumping)
                    {
                        gravity = 0.0f;
                        falling = true;
                    }
                }
                return true;
            }
            // Bottom
            if (getBoundsBottom().intersects(e.getBounds()))
            {
                yMove = 0;
                if (falling)
                {
                    falling = false;
                }
                return true;
            }
            // Left
            if (getBoundsLeft().intersects(e.getBounds()))
            {
                xMove = 0;
                x = e.getBounds().x + e.getBounds().width;
                return true;
            }
            // Right
            if (getBoundsRight().intersects(e.getBounds()))
            {
                xMove = 0;
                x = e.getBounds().x - e.getBounds().width;
                return true;
            }
        }
        return false;
    }
    */

    private void getInput() {
        xMove = 0;
        playerGravity();

        if(handler.getKeyManager().jump && !falling && !jumping) {
                jumping = true;
                falling = false;
                gravity = 25.0f;
        }

        if(handler.getKeyManager().right){
            xMove = speed;
        }
        if(handler.getKeyManager().left && x > 0){
            xMove = -speed;
        }
        if(handler.getKeyManager().run && handler.getKeyManager().right){
            xMove = speed*2;
        }
        if(handler.getKeyManager().run && handler.getKeyManager().left && x > -2){
            xMove = -speed*2;
        }
    }

    @Override
    public void render(Graphics g) {
        // Mario stay's in the same place.
        //g.setColor(Color.yellow);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        g.drawImage(getCurrentMarioAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), width, height, null);
    }

    private BufferedImage getCurrentMarioAnimationFrame() {
        // right jump movement
        if (jumping && xMove >= 0){
            return Assets.marioRightJump;
        }
        // left jump movement
        else if (jumping && xMove <= 0){
            return Assets.marioLeftJump;
        }
        // right movement
        else if (xMove > 0)
        {
            return animMarioRight.getCurrentFrame();
        }
        // left movement
        else if (xMove < 0)
        {
            return animMarioLeft.getCurrentFrame();
        }
        else
        {
            return Assets.marioRightNormal;
        }
    }
}
