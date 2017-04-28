package entities.creatures;
import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;


public class Goomba extends Creature{

    private Animation animGoombaMovement, animGoombaDeath, animGoombaJumpDeath;

    public Goomba(Handler handler, float x, float y){
        super(handler, x, y, Creature.DEFAULT_16x16_WIDTH, Creature.DEFAULT_16x16_HEIGHT);
        //Animations
        animGoombaMovement = new Animation(300, Assets.goombaMovement);
        bounds.x = 0;
        bounds.y = 0;
        bounds.width = 0;
        bounds.height = 0;
    }

    @Override
    public void tick() {
        //Animations
        animGoombaMovement.tick();

        //Movements
        getInput();
        move();
    }

    private void getInput() {
        xMove =+ 4;
    }
    @Override
    public void render(Graphics g) {

    }
    private BufferedImage getCurrentGoombaAnimationFrame(){
        if (xMove > 0 || xMove < 0){
            return animGoombaMovement.getCurrentFrame();
        }
        else if (xMove == 0) {
            return Assets.goombaJumpDeath;
        }
        else{
            return Assets.goombaDeath;
        }
    }
}
