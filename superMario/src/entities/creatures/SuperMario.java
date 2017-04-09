package entities.creatures;

import game.Game;
import graphics.Assets;
import java.awt.*;

public class SuperMario extends Creature {

    private Game game;

    public SuperMario(Game game, float x, float y) {
        super(x, y, Creature.DEFAULT_MARIO_WIDTH, Creature.DEFAULT_MARIO_HEIGHT);
        this.game = game;

    }

    @Override
    public void tick() {
        getInput();
        move();
    }

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
    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.marioRightNormal, (int) x, (int) y, width, height, null);
    }

}
