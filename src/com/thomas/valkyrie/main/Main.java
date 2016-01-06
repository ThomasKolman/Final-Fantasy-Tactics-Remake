package com.thomas.valkyrie.main;

import com.thomas.valkyrie.engine.VertexArray;
import com.thomas.valkyrie.graphics.Grid;
import com.thomas.valkyrie.input.Input;
import org.lwjgl.opengl.GL;

import java.awt.*;

import static org.lwjgl.glfw.GLFW.*;
import static org.lwjgl.opengl.GL11.*;
import static org.lwjgl.system.MemoryUtil.NULL;

public class Main
{
    private long windowID;
    private Input input = new Input();

    private void start()
    {
        float now, last, delta;
        last = 0;

        init();

        Grid grid = new Grid();
        grid.generateGrid();

        while (glfwWindowShouldClose(windowID) != GL_TRUE)
        {
            // Get the time
            now = (float) glfwGetTime();
            delta = now - last;
            last = now;

            // Update and render
            update(delta);
            render(delta, grid);

            // Poll the events and swap the buffers
            glfwPollEvents();
            glfwSwapBuffers(windowID);
        }

        end();
    }

    public void end()
    {
        // Dispose the game
        new VertexArray().dispose();

        // Destroy the window
        glfwDestroyWindow(windowID);
        glfwTerminate();

        System.exit(0);
    }

    private void update(float delta) {
        if (Input.isKeyDown(GLFW_KEY_SPACE))
        {
            System.out.println(delta);
        }
        else if (Input.isKeyDown(GLFW_KEY_ESCAPE))
        {
            end();
        }
    }

    private void render(float delta, Grid grid)
    {
        grid.render();
    }

    private void dispose()
    {
        // TODO Auto-generated method stub

    }

    private void init()
    {
        Dimension resolution = Toolkit.getDefaultToolkit().getScreenSize();
        int height = (int) resolution.getHeight();
        int width = (int) resolution.getWidth();

        if (glfwInit() != GL_TRUE)
        {
            System.err.println("Error initializing GLFW");
            System.exit(1);
        }

        glfwWindowHint(GLFW_RESIZABLE, GL_FALSE);

        windowID = glfwCreateWindow(width, height, "", glfwGetPrimaryMonitor(), NULL);

        if (windowID == NULL)
        {
            System.err.println("Error creating a window");
            System.exit(1);
        }

        glfwSetKeyCallback(windowID, input);

        glfwMakeContextCurrent(windowID);
        GL.createCapabilities();
        glfwSwapInterval(1);
    }

    public static void main(String[] args)
    {
        System.out.println("GAME");
        new Main().start();
    }
}

