package entities;

import game.Handler;

import javax.swing.text.html.parser.*;

public abstract class StaticEntity extends Entity{

    public StaticEntity(Handler handler, float x, float y, int width, int height){
        super(handler, x, y, width, height);
    }
}
