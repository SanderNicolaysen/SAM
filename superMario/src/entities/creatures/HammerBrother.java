package entities.creatures;

import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class HammerBrother extends Creature {

    //Animations
    private Animation animHammerBrotherRight, animHammerBrotherLeft;

    public HammerBrother(Handler handler, float x, float y, int health){
        super(handler, x, y, Creature.DEFAULT_32x32_WIDTH, Creature.DEFAULT_32x32_HEIGHT, health);
        animHammerBrotherRight = new Animation(200, Assets.hammerBrotherRight);
        animHammerBrotherLeft = new Animation(200, Assets.hammerBrotherLeft);
        bounds.x = 40;
        bounds.y = 80;
        bounds.width = 48;
        bounds.height = 48;
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

    @Override
    public void render(Graphics g) {
        //g.setColor(Color.yellow);
        //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
        g.drawImage(getCurrentHammerBrotherAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_32x32_WIDTH, DEFAULT_32x32_HEIGHT, null);
    }

    private BufferedImage getCurrentHammerBrotherAnimationFrame(){
        if (checkEntityCollisions(0f, yMove))
        {
            return animHammerBrotherRight.getCurrentFrame();
        }
        else
        {
            return animHammerBrotherLeft.getCurrentFrame();
        }
    }
    private void getInput(){
        xMove = 0;
        enemyGravity();

        xMove = -speed + 2;
    }

}
