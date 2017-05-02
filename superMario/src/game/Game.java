package game;

import entities.EntityManager;
import graphics.Assets;
import graphics.GameCamera;
import gui.Display;
import input.KeyManager;
import input.MouseManager;
import javafx.scene.transform.Scale;
import sounds.Sound;
import states.*;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.io.File;
import java.io.IOException;


/**
 * The main class for the game. Holds all the base code.
 */
public class Game implements Runnable
{
    //GUI
    private Display display;

    // Game
    private int width, height;
    private String title;
    public boolean running = false;
    private Thread thread;

    // Graphics
    private BufferStrategy bs;
    private Graphics g;

    // States
    public State gameState = null;
    public State menuState = null;
    //public State settingsState = null;
    //public State gameOver = null;
    //public State pauseState = null;


    // Input
    private KeyManager keyManager;
    private MouseManager mouseManager;

    // Camera
    private GameCamera gameCamera;

    // Handler
    private Handler handler;

    // Sounds
    private Sound sound;

    public void resetGame()
    {
        if (gameState == null)
        {
            gameState = new GameState(handler);
            handler.getWorld().initEntities();
            System.out.println("New game");
        }

        // Clear and init all entities
        handler.getWorld().getEntityManager().getEntities().clear();
        handler.getWorld().initEntities();

    }

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
        keyManager = new KeyManager(handler);
        mouseManager = new MouseManager();
        sound = new Sound(handler);
    }

    /**
     * Initialize the game.
     * Run the constructor of display class so that the window will appear.
     * Initialize Assets.
     *
     */
    public void init()
    {
        display = new Display(title, width, height);
        display.getFrame().addKeyListener(keyManager);

        display.getFrame().addMouseListener(mouseManager);
        display.getFrame().addMouseMotionListener(mouseManager);
        display.getCanvas().addMouseListener(mouseManager);
        display.getCanvas().addMouseMotionListener(mouseManager);
        Assets.init();
        Sound.init();
        //sound.playSound(Sound.overWorldTheme);
        //sound.close();

        handler = new Handler(this);
        gameCamera = new GameCamera(handler, 0);

        // Initialization of states
        //gameState = new GameState(handler);
        menuState = new MenuState(handler);
        //settingsState = new SettingsState(handler);
        //gameOver = new GameOver(handler);
        //pauseState = new PauseState(handler);

        // Set the current state of the game to gameState.
        State.setState(menuState);
    }

    /**
     * This method will make things move.
     */
    private void tick()
    {
        //Makes the key inputs work
        keyManager.tick();

        // If currentState != null, which means we have a state,
        // call the tick method of the current state
        if (State.getState() != null)
        {
            State.getState().tick();
        }
    }

    /**
     * Render(draw) the graphics of the game
     */
    private void render()
    {
        // BufferStrategy
        bs = display.getCanvas().getBufferStrategy();
        if (bs == null)
        {
            display.getCanvas().createBufferStrategy(3);
            return;
        }

        g = bs.getDrawGraphics(); // Initialize graphics object for the buffer
        // Clear screen
        g.clearRect(0, 0, width, height);

        // If currentState != null, which means we have a state,
        // call the render method of the current state
        if (State.getState() != null)
        {
            State.getState().render(g);
        }

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

    // Return keyManager object so other classes can access it.
    public KeyManager getKeyManager(){
        return keyManager;
    }

    public MouseManager getMouseManager(){ return mouseManager; }

    public GameCamera getGameCamera()
    {
        return gameCamera;
    }

    public Sound getSound()
    {
        return sound;
    }

    public int getWidth()
    {
        return width;
    }

    public int getHeight()
    {
        return height;
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
