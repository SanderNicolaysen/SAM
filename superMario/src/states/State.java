package states;

import game.Handler;

import java.awt.*;

    /**
     * Abstract class for State
     * Every class that extends this class must have a
     * tick and render method.
     */
public abstract class State {

    //Here is the gameState manager and are storing the state we want to use
    /**
     * currentState will hold the state we want to
     * tick and render.
     */
    private static State currentState = null;
    /**
     * Set method so we can set the current state of our game
     * The state we send in, will be the new state that we will tick
     * and render.
     * @param state the state we want to render and tick
     */
    public static void setState(State state){
        currentState = state;
    }
    /**
     *
     * @return the current state
     */
    public static State getState(){
        return currentState;
    }


    //Class
    protected Handler handler;

    public State(Handler handler){
        this.handler = handler;
    }

    // Abstract methods that every state must have
    public abstract void tick();

    public abstract void render(Graphics g);

}
