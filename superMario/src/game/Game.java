package game;

import gui.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;

/**
 * The main class for the game. Holds all the base code.
 */
public class Game implements Runnable
{
    private Display display;

    public int width, height;
    public String title;

    private boolean running = false;
    private Thread thread;

    private BufferStrategy bs;
    private Graphics g;

    /**
     * Constructor that sets width, height and title of game.
     * @param title the title of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        this.title = title;
    }

    /**
     * Initialize the game.
     * Run the constructor of display class so that the window will appear.
     */
    private void init()
    {
        display = new Display(title, width, height);
    }

    /**
     * This method will make things move.
     */
    private void tick()
    {

    }

    /**
     * Render(draw) the graphics of the game
     */
    private void render()
    {

    }

    /**
     * The Game loop.
     * Updates all variables, position of objects etc.
     * Will then render(draw) everything to the screen.
     */
    @Override
    public void run()
    {
        init();

        while(running)
        {
            tick();
            render();
        }

        stop();
    }

    /**
     * Initialize and start the thread.
     * This method will make the run method start.
     * This method will only run if running = false.
     */
    public synchronized void start()
    {
        // If running is true do nothing (jump out of method).
        if (running)
            return;

        running = true;
        thread = new Thread(this);
        thread.start();
    }

    /**
     * Stop the thread.
     * This method will only run if running = true.
     */
    public synchronized void stop()
    {
        // If running is false do nothing (jump out of method).
        if (!running)
            return;

        running = false;

        try
        {
            thread.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

    }
}
