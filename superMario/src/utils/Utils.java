package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Utilities
 * A bunch of help functions
 */
public class Utils
{
    /**
     * Read text file.
     * @param path the file we want to read
     * @return a string
     */
    public static String loadFileAssString(String path)
    {
        // Makes it easier to add characters to a string.
        StringBuilder builder = new StringBuilder();

        try
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String currentLine;

            while ((currentLine = br.readLine()) != null)
            {
                builder.append(currentLine + "\r\n");
            }

            // Close fileStream
            br.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }

        // Convert builder into a string and return it.
        return builder.toString();
    }

    // convert a string to an int.
    public static int parseInt(String number)
    {
        try
        {
            return Integer.parseInt(number);
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
            return 0;
        }
    }
}
