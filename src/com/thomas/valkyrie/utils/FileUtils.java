package com.thomas.valkyrie.utils;

import java.io.*;

/**
 * Created by Thomas on 2015-12-13.
 */
public class FileUtils
{

    public static String loadAsString(String name)
    {
        StringBuilder source = new StringBuilder();
        try
        {
            BufferedReader reader = new BufferedReader(new InputStreamReader(ShaderUtils.class.getClassLoader().getResourceAsStream(name)));

            String line;

            while ((line = reader.readLine()) != null)
            {
                source.append(line).append("\n");
            }

            reader.close();
        }
        catch (FileNotFoundException ex)
        {
            System.err.println("File does not exist: " + name);
            ex.printStackTrace();
        }
        catch (IOException ex)
        {
            System.err.println("Error loading source code: " + name);
            ex.printStackTrace();
        }

        return source.toString();
    }
}
