package entities.items;
import entities.creatures.Creature;
import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class FireFlowerPowerUp extends Creature{

    private Animation animFireFlower;
    private boolean spawned = false;

    public FireFlowerPowerUp(Handler handler, float x, float y, int health) {
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT, health);

        animFireFlower = new Animation(300, Assets.fireFlower);
        bounds.x = 8;
        bounds.y = 16;
        bounds.width = 56;
        bounds.height = 48;
    }

    @Override
    public void tick() {
        // If mario is at middle of screen tick enemy
        if (handler.getGameCamera().getxOffset() > 0 || spawned)
        {
        }
        //Movements
        getInput();
        move();

        spawned = true;
    }

    @Override
    public void render(Graphics g) {
        if (handler.getGameCamera().getxOffset() > 0 || spawned)
        {
            //g.setColor(Color.RED);
            //g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()), (int) (y + bounds.y), bounds.width, bounds.height);
            g.drawImage(getCurrentAnimationFrame(), (int) (x - handler.getGameCamera().getxOffset()), (int) (y), DEFAULT_16x16_WIDTH, DEFAULT_16x16_HEIGHT, null);
        }
    }

    @Override
    public void die() {

    }

    private BufferedImage getCurrentAnimationFrame()
    {
        if (checkEntityCollisions(0f, yMove))
        {
            return animFireFlower.getCurrentFrame();
        }
        else{
            return animFireFlower.getCurrentFrame();
        }
    }

    private void getInput()
    {
        xMove = 0;
        enemyGravity();
    }
}
