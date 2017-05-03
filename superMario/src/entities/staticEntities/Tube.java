package entities.staticEntities;

import entities.StaticEntity;
import game.Handler;
import graphics.Assets;
import tiles.Tile;

import java.awt.*;

public class Tube extends StaticEntity{
    public Tube(Handler handler, float x, float y){
        super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        g.drawImage(Assets.tubeUp1, (int) (x - handler.getGameCamera().getxOffset()), (int) y, width, height, null);
    }

    @Override
    public void die()
    {

    }
}
