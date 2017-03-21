package gui;

import javax.swing.*;

public class Display extends JFrame
{
    private String title;
    private int width, height;

    /**
     * Constructor that displays the frame.
     * @param title the title of the frame
     * @param width the width of the frame
     * @param height the height of the frame
     */
    public Display(String title, int width, int height)
    {
        this.title = title;
        this.width = width;
        this.height = height;

        createDisplay();
    }

    /**
     * Function that creates the frame.
     */
    private void createDisplay()
    {
        this.setTitle("Super Mario");
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
