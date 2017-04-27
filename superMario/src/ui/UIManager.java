package ui;

import game.Handler;

import java.awt.*;
import java.util.ArrayList;

public class UIManager
{
    private Handler handler;
    private ArrayList<UIObject> objects;

    public UIManager(Handler handler)
    {
        this.handler = handler;
        objects = new ArrayList<UIObject>();
    }

    public void tick()
    {
        // Tick every UIObject in objects arrayList
        for (UIObject o : objects)
        {
            o.tick();
        }
    }

    public void render(Graphics g)
    {
        // Render every UIObject in objects arrayList
        for (UIObject o : objects)
        {
            o.render(g);
        }

    }

    public void addObject(UIObject o)
    {
        objects.add(o);
    }

    public void removeObject(UIObject o)
    {
        objects.remove(o);
    }


}
