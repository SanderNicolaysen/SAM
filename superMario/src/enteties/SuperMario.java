package enteties;

import game.Game;
import graphics.Assets;

import java.awt.*;

public class SuperMario extends Entity{

    protected int health;
    private Game game;

    public SuperMario(Game game, float x, float y){
        super(x, y);
        this.game = game;
        health = 1;
    }
    @Override
    public void tick(){
        //Inserts if-statements for the different key inputs
        if(game.getKeyManager().right)
            x += 3;
        if(game.getKeyManager().left)
            x -= 3;
        if(game.getKeyManager().jump)

        //Pål, do your thing -->

        if(game.getKeyManager().run && game.getKeyManager().right)
            x += 6;
        if(game.getKeyManager().run && game.getKeyManager().left)
            x -= 6;
        if(game.getKeyManager().crouch);


    }

    @Override
    public void render(Graphics g){
        g.drawImage(Assets.marioRightNormal, (int) x, (int) y, null);
    }

}
