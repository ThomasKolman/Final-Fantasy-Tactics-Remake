package com.thomas.valkyrie.utils;

import java.io.*;

/**
 * Created by Thomas on 2015-12-13.
 */
public class FileUtils
{

    /**
     * Loads a GLSL program as a single string
     *
     * Cited code
     *
     * @param name takes in the program name
     * @return the string of the program
     */
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

    /**
     *
     */
    public static int[] getStartupData()
    {
        // Builds the path to the downloads direction
        String home = System.getProperty("user.home");
        File directory = new File(home + "/Downloads");

        // Adds known files to directory path
        File target = new File(directory + "/final-fantasy-tactics-advance-remastered-data/character-data.txt");
        System.out.println(target);

        int chosenCharacters[] = new int[4];

        try
        {
            FileInputStream fileInputStream = new FileInputStream(target);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            int index = 0;

            while (bufferedReader.ready())
            {
                chosenCharacters[index] = Integer.parseInt(bufferedReader.readLine());
                System.out.println(chosenCharacters[index]);
                index += 1;
            }
        }
        catch (IOException ex)
        {
            System.out.println("The program could not find the file specified");
            System.out.println("The program will use the default party instead of the custom party selected");

            for (int i = 0; i < 4; i++)
            {
                chosenCharacters[i] = i;
            }

            ex.printStackTrace();
        }

        return chosenCharacters;
    }
}
