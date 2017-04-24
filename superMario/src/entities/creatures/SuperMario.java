package entities.creatures;

import graphics.Animation;
import graphics.Assets;
import game.Handler;

import java.awt.*;
import java.awt.image.BufferedImage;

public class SuperMario extends Creature {

    //Animations

    private Animation animMarioRight, animMarioLeft, animSuperMarioRight, animSuperMarioLeft;

    public SuperMario(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_MARIO_WIDTH, Creature.DEFAULT_MARIO_HEIGHT);

        //Animations
        animMarioRight = new Animation(70, Assets.marioRightMove);
        animMarioLeft = new Animation(70, Assets.marioLeftMove);
        animSuperMarioRight = new Animation(70, Assets.superMarioRightMove);
        animSuperMarioLeft = new Animation(70, Assets.superMarioLeftMove);
    }

    @Override
    public void tick() {
        //Animations
        animMarioRight.tick();
        animMarioLeft.tick();
        animSuperMarioRight.tick();
        animSuperMarioLeft.tick();

        //Movements
        getInput();
        move();
        handler.getGameCamera().centerOnEntity(this);
    }

    //double temp = 0;
    private void getInput() {
        xMove = 0;
        yMove = 0;

        // If jump == true do this
        if(handler.getKeyManager().jump) {
            yMove = -speed;
            //Pål, do your thing...
        }
        if(handler.getKeyManager().right){
            xMove = speed;
        }
        if(handler.getKeyManager().left){
            xMove = -speed;
        }
        if(handler.getKeyManager().run && handler.getKeyManager().right){
            xMove = speed*2;
        }
        if(handler.getKeyManager().run && handler.getKeyManager().left){
            xMove = -speed*2;
        }
        if(handler.getKeyManager().crouch){
            yMove = speed;
        }

        //temp += 3.14/60;
        //yMove = (float)Math.sin(temp) * 10;
        //xMove = (float)Math.cos(temp) * 10;

    }

    @Override
    public void render(Graphics g) {
        // Super Mario stay's in the same place.
        g.drawImage(getCurrentMarioAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), width, height, null);
    }

    private BufferedImage getCurrentMarioAnimationFrame() {
        // right jump movement
        if(yMove < 0 && xMove >= 0){
            return Assets.marioRightJump;
        }
        // left jump movement
        if(yMove < 0 && xMove <= 0){
            return Assets.marioLeftJump;
        }
        // right movement
        if (xMove > 0){
            return animMarioRight.getCurrentFrame();
        }
        // left movement
        if (xMove < 0) {
            return animMarioLeft.getCurrentFrame();
        }
        // Mario default right
        else
        {
            return Assets.marioRightNormal;
        }
    }
    //private BufferedImage getCurrentSuperMarioAnimationFrame(){}
    //private BufferedImage getCurrentFireMarioAnimationFrame(){}
}
