package game;

import gui.Display;

/**
 * The main class for our game. Holds all the base code.
 */
public class Game
{
    private Display display;

    public int width, height;

    /**
     * Constructor that starts the game.
     * @param title the title of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public Game(String title, int width, int height)
    {
        this.width = width;
        this.height = height;
        display = new Display(title, width, height);
    }
}
