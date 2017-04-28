package entities.creatures;

import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HammerBrother extends Creature {

    //Animations
    private Animation animHammerBrotherRight, animHammerBrotherLeft;

    public HammerBrother(Handler handler, float x, float y){
        super(handler, x, y, Creature.DEFAULT_32x32_WIDTH, Creature.DEFAULT_32x32_HEIGHT);
        animHammerBrotherRight = new Animation(200, Assets.hammerBrotherRight);
        animHammerBrotherLeft = new Animation(200, Assets.hammerBrotherLeft);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 64;
        bounds.height = 64;
    }

    @Override
    public void tick() {
        //Animations
        animHammerBrotherRight.tick();
        animHammerBrotherLeft.tick();

        //Movements
        getInput();
        move();
    }

    private void getInput(){
        xMove = 0;
    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.yellow);
        g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        g.drawImage(getCurrentHammerBrotherAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_32x32_WIDTH, DEFAULT_16x16_HEIGHT, null);
    }

    private BufferedImage getCurrentHammerBrotherAnimationFrame(){
        if(xMove <= 0){
            return animHammerBrotherLeft.getCurrentFrame();
        }
        else if (xMove >= 0){
            return animHammerBrotherRight.getCurrentFrame();
        }
        else{
            return animHammerBrotherLeft.getCurrentFrame();
        }
    }
}
