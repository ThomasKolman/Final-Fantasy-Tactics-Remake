package com.thomas.valkyrie.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Thomas on 2015-12-13.
 */
public class FileUtils
{

    public static String readFromFile(String name)
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
        catch (Exception e)
        {
            System.err.println("Error loading source code: " + name);
            e.printStackTrace();
        }

        return source.toString();
    }
}
