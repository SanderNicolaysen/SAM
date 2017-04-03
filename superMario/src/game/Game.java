package game;

import graphics.Assets;
import graphics.ImageLoader;
import graphics.SpriteSheet;
import gui.Display;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

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
        Assets.init();
    }


    int x = 0;
    /**
     * This method will make things move.
     */
    private void tick()
    {
        x++;
    }

    /**
     * Render(draw) the graphics of the game
     */
    private void render()
    {
        bs = display.getcanvas().getBufferStrategy();
        if (bs == null)
        {
            display.getcanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics(); // Initialize graphics object for the buffer
        // Clear screen
        g.clearRect(0, 0, width, height);
        // Draw here

        g.drawImage(Assets.ground, x, 10, null);


        // End drawing
        bs.show(); // Make the BufferStrategy visible
        g.dispose(); // Remove the graphics after added to prevent duplication
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

        // How many times we want the tick and render method to run per second
        int fps = 60;
        // Nano: 10^(-9), Billion: 10^(9)
        // There is 1 billion (10^9) nanoseconds in 1 second.
        // More accurate to measure time in nanoseconds than seconds.
        // timePerTick = Max amount of time we can run tick and render methods.
        double timePerTick = 1000000000 / fps;
        double delta = 0;
        long now;
        // Current time of computer in nanoseconds
        long lastTime = System.nanoTime();
        long timer = 0;
        int ticks = 0;


        while(running)
        {
            // Current time of our computer
            now = System.nanoTime();
            //delta = how much time before we have to run tick and render methods
            // If change in nanoseconds is less than timePerTick the value will be less than 1.
            // If change in nanoseconds is greater than timePerTick the value is larger than 1
            // which means the computer has waited long enough and can run tick and render method.
            delta += (now - lastTime) / timePerTick;
            timer += now - lastTime;
            lastTime = now;

            if (delta >= 1)
            {
                tick();
                render();
                ticks++;
                delta--;
            }

            // Total change in time after 1 second is >= 1 billion nanoseconds
            // This will therefor run each time 1 second has passed
            if (timer >= 1000000000)
            {
                System.out.println("Ticks and Frames: " + ticks);
                ticks = 0;
                timer = 0;
            }
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
