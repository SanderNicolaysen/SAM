package states;

import game.Game;

import java.awt.*;

public abstract class State {

    //Here is the gameState manager and are storing the states we want to use
    private static State currentState = null;

    public static void setState(State state){
        currentState = state;
    }
    public static State getState(){
        return currentState;
    }

    //class

    protected Game game;

    public State(Game game){
        this.game = game;
    }

    public abstract void tick();

    public abstract void render(Graphics g);
}
