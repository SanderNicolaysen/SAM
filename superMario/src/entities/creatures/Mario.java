package entities.creatures;


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
        super(handler, x, y, Creature.DEFAULT_MARIO_WIDTH, Creature.DEFAULT_MARIO_HEIGHT);

        animMarioRight = new Animation(70, Assets.marioRightMove);
        animMarioLeft = new Animation(70, Assets.marioLeftMove);
        bounds.x = 4;
        bounds.y = 0;
        bounds.width = 60;
        bounds.height = 64;
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

        if(handler.getKeyManager().jump) {
            yMove = -speed * 3;
        }
        else {
            yMove += 8;
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
        if(handler.getKeyManager().crouch){
            yMove = speed;
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
        if(yMove < 0 && xMove >= 0){
            return Assets.marioRightJump;
        }
        // left jump movement
        else if(yMove < 0 && xMove <= 0){
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
        else
        {
            return Assets.marioRightNormal;
        }
    }
}
