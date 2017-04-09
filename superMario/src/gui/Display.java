package gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class will create a window.
 */
public class Display extends JFrame
{
    private Canvas canvas;
    private JFrame frame;
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
     * Method that creates the frame.
     */
    private void createDisplay()
    {
        this.setTitle(title);
        this.setSize(width, height);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        this.add(canvas);
        this.pack();
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
