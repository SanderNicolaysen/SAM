package entities.items;

import game.Handler;
import graphics.Animation;
import graphics.Assets;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Item {

    //Handler

    public static Item[] items = new Item[3];
    public static Item Mushroom = new Item(Assets.mushroomPowerUp, "Mushroom", 0);
    //public static Item Coin = new Item(Assets.coin, "Coin", 1);
    //public static Item FireFlower = new Item(Animation(), "FireFlower", 2);

    //Class
    public static final int ITEMWIDTH = 64, ITEMHEIGHT = 64, STEPT_ON = -1;
    protected Handler handler;
    protected BufferedImage texture;
    protected String name;
    protected final int id;
    protected Rectangle bounds;

    protected  int x,y,count;

    public Item(BufferedImage texture,String name,int id){
        this.texture = texture;
        this.name = name;
        this.id = id;
        count = 1;

        bounds = new Rectangle(x,y, ITEMWIDTH,ITEMHEIGHT);

        items[id] = this;

    }
    public void tick(){
        if (handler.getWorld().getEntityManager().getMario().getCollisionBounds(0f,0f).intersects(bounds)){
            count = STEPT_ON;
        }
    }

    public void render(Graphics g){
        if (handler == null)
            return;

        render(g,(int) (x - handler.getGameCamera().getxOffset()),(int)(y - handler.getGameCamera().getyOffset()));
    }

    public void render(Graphics g, int x, int y){

        g.drawImage(texture,x,y,ITEMWIDTH,ITEMHEIGHT,null);
    }

    public Item creatNew(int x, int y){
        Item i = new Item(texture,name,id);
        i.setPosition(x,y);
        return i;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
        bounds.x = x;
        bounds.y = y;
    }

    //GETTERS AND SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public BufferedImage getTexture() {
        return texture;
    }

    public void setTexture(BufferedImage texture) {
        this.texture = texture;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}

