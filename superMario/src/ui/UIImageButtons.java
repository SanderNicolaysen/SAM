package ui;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by PålTømte on 30.04.2017.
 */
public class UIImageButtons extends UIObject {

    private BufferedImage[] play, quit;
    private ClickListener clicker;

    public UIImageButtons(float x, float y, int width, int heigth, BufferedImage[] play, ClickListener clicker){
        super(x,y,width,heigth);
        this.play = play;
        this.clicker = clicker;

    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {

        if(hovering){
            g.drawImage(play[0],(int) x, (int) y, width,height,null);
        }
        else{
            g.drawImage(play[1],(int) x, (int) y, width,height,null);
        }
    }

    @Override
    public void onClick() {
        clicker.onClick();
    }
}
