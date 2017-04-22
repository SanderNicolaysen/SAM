package gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class will create a window.
 */
public class Display
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
        frame = new JFrame();
        frame.setTitle(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        //frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setUndecorated(true);
        frame.setVisible(true);

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setMaximumSize(new Dimension(width, height));
        canvas.setMinimumSize(new Dimension(width, height));
        canvas.setFocusable(false);

        frame.add(canvas);
        frame.pack();
    }

    public Canvas getCanvas()
    {
        return canvas;
    }

    public JFrame getFrame(){
        return frame;
    }
}
