package entities.creatures;

import game.Game;
import graphics.Assets;
import java.awt.*;

public class SuperMario extends Creature {

    public SuperMario(Game game, float x, float y) {
        super(game, x, y, Creature.DEFAULT_MARIO_WIDTH, Creature.DEFAULT_MARIO_HEIGHT);
    }

    @Override
    public void tick() {
        getInput();
        move();
        game.getGameCamera().centerOnEntity(this);
    }

    //double temp = 0;
    private void getInput() {
        xMove = 0;
        yMove = 0;

        // If jump == true do this
        if(game.getKeyManager().jump) {
            yMove = -speed;
            //Pål, do your thing...
        }
        if(game.getKeyManager().right){
            xMove = speed;
        }
        if(game.getKeyManager().left){
            xMove = -speed;
        }
        if(game.getKeyManager().run && game.getKeyManager().right){
            xMove = speed*2;
        }
        if(game.getKeyManager().run && game.getKeyManager().left){
            xMove = -speed*2;
        }
        if(game.getKeyManager().crouch){
            yMove = speed;
        }

        //temp += 3.14/60;
        //yMove = (float)Math.sin(temp) * 10;
        //xMove = (float)Math.cos(temp) * 10;

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.marioRightNormal, (int) (x - game.getGameCamera().getxOffset()), (int) (y - game.getGameCamera().getyOffset()), width, height, null);
    }

}
