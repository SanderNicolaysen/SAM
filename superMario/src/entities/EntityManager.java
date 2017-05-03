package entities;

import entities.creatures.Mario;
import game.Handler;

import javax.swing.text.html.parser.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

public class EntityManager {

    private Handler handler;
    private Mario mario;
    private ArrayList<Entity> entities;
    /*
    private Comparator<Entity> renderSorter = new Comparator<Entity>() {
        @Override
        public int compare(Entity a, Entity b) {
            if(a.getY() + a.getHeight() < b.getY() + b.getHeight())
                return -1;
            return 1;
        }
    };
    */
    public EntityManager(Handler handler, Mario mario){
        this.handler = handler;
        this.mario = mario;
        entities = new ArrayList<Entity>();
        addEntity(mario);
    }

    public void tick(){
        for (int i = 0; i < entities.size(); i++)
        {
            Entity e = entities.get(i);
            e.tick();
            if (!e.isActive())
            {
                entities.remove(e);
            }
        }
    }

    public void render(Graphics g){
        for(Entity e : entities){
            e.render(g);
        }
    }

    public void addEntity(Entity e){
        entities.add(e);
    }

    public void removeEntity(Entity e) {
        entities.remove(e);
    }


    //GETTERS AND SETTERS

    public Handler getHandler() {
        return handler;
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }

    public Mario getMario() {
        return mario;
    }

    public void setMario(Mario mario) {
        this.mario = mario;
    }

    public ArrayList<Entity> getEntities() {
        return entities;
    }

    public void setEntities(ArrayList<Entity> entities) {
        this.entities = entities;
    }
}
