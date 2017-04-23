package entities.creatures;

import handler.Game;
import graphics.Assets;
import handler.Handler;

import java.awt.*;

public class SuperMario extends Creature {

    public SuperMario(Handler handler, float x, float y) {
        super(handler, x, y, Creature.DEFAULT_MARIO_WIDTH, Creature.DEFAULT_MARIO_HEIGHT);
    }

    @Override
    public void tick() {
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
        g.drawImage(Assets.marioRightNormal, (int) (x - handler.getGameCamera().getxOffset()), (int) (y), width, height, null);
    }

}
