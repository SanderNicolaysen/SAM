package entities.creatures;


import entities.Entity;
import game.Handler;
import graphics.Animation;
import graphics.Assets;

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
    public void tick() {
        //Animations
        animMarioRight.tick();
        animMarioLeft.tick();

        //Movements
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    private void getInput() {
        xMove = 0;
        yMove = 0;

        if(jumping){
            gravity -= 0.1;
            setyMove((int) -gravity);
            if(gravity<=0.0){
                jumping = false;
                falling = true;
            }
        }
        if(falling){
            gravity += 0.1;
            setyMove((int) gravity);
        }

        if(handler.getKeyManager().jump) {
                jumping = true;
                gravity = 10.0;
        }
        else {
            falling = true;
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
        if(jumping && xMove >= 0){
                return Assets.marioRightJump;
        }
        // left jump movement
        else if(jumping && xMove <= 0){
                return Assets.marioLeftJump;
        }
        // right movement
        else if (xMove > 0){
            return animMarioRight.getCurrentFrame();
        }
        // left movement
        else if (xMove < 0) {
            return animMarioLeft.getCurrentFrame();
        }
        else if (xMove > 0 && yMove == 0){
            return animMarioRight.getCurrentFrame();
        }
        else if (xMove < 0 && yMove == 0) {
            return animMarioLeft.getCurrentFrame();
        }
        else {
            return Assets.marioRightNormal;
        }
    }
}
