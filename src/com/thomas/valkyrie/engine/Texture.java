package com.thomas.valkyrie.engine;

import com.thomas.valkyrie.utils.BufferUtils;

import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.opengl.GL13.*;

import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * Loads and renders textures in the /res folder, and handles
 * disposal of textures
 *
 * <p> Code is heavily copied and cited from various sources </p>
 *
 * @author Thomas Kolman
 * @since 2015-12-18
 */
public class Texture
{
    private int texture;
    private static List<Integer> allTextures = new ArrayList<Integer>();

    /**
     * Loads texture through specified path and returns relevant
     * ID associated with texture
     *
     * @param path
     */
    public Texture(String path)
    {
        texture = load(path);
    }

    /**
     * Loads texture and changes format to suit OpenGL texturing
     *
     * <p> All images must be 2^ in size (dividable by 4) </p>
     *
     * <p> CITED CODE : https://www.youtube.com/watch?v=9XpYo6UTMZ4&feature=youtu.be </p>
     *
     * @param path takes in path of image to be loaded
     * @return
     */
    private int load(String path)
    {
        int pixels[] = null;
        int width = 0;
        int height = 0;

        try
        {
            BufferedImage image = ImageIO.read(new FileInputStream("res/" + path));
            width = image.getWidth();
            height = image.getHeight();
            pixels = new int[width * height];
            image.getRGB(0, 0, width, height, pixels, 0, width);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }

        int[] data = new int[width * height];

        for (int i = 0; i < width * height; i++)
        {
            int a = (pixels[i] & 0xff000000) >> 24;
            int r = (pixels[i] & 0xff0000) >> 16;
            int g = (pixels[i] & 0xff00) >> 8;
            int b = (pixels[i] & 0xff);

            data[i] = a << 24 | b << 16 | g << 8 | r;
        }

        int result = glGenTextures();
        allTextures.add(result);

        glBindTexture(GL_TEXTURE_2D, result);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_NEAREST);
        glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_NEAREST);
        glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, width, height, 0, GL_RGBA, GL_UNSIGNED_BYTE, BufferUtils.createIntBuffer(data));
        glActiveTexture(GL_TEXTURE0);
        glBindTexture(GL_TEXTURE_2D, 0);
        return result;
    }

    /**
     * Binds relevant texture to OpenGL
     */
    public void bind()
    {
        glBindTexture(GL_TEXTURE_2D, texture);
    }

    /**
     * Unbinds relevant texture to OpenGL
     */
    public void unbind()
    {
        glBindTexture(GL_TEXTURE_2D, 0);
    }

    /**
     * Disposes of all texture IDs. Used to free driver memory
     * after program termination.
     *
     * @see com.thomas.valkyrie.main.Main disposal method
     */
    public static void dispose()
    {
        for (int texture:allTextures)
        {
            glDeleteTextures(texture);
        }
    }
}