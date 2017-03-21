package gui;

import javax.swing.*;
import java.awt.*;

/**
 * This class will create a window.
 */
public class Display extends JFrame
{
    private JPanel panel;

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

        panel = new JPanel();
        panel.setPreferredSize(new Dimension(width, height));
        panel.setMaximumSize(new Dimension(width, height));
        panel.setMinimumSize(new Dimension(width, height));

        this.add(panel);
        this.pack();
    }
}
